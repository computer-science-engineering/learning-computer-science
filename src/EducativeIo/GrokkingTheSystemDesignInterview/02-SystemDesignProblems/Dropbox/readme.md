# Designing Dropbox

- [Designing Dropbox](#designing-dropbox)
  - [Why Cloud Storage](#why-cloud-storage)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
  - [Some Design Considerations](#some-design-considerations)
  - [Capacity Estimation and Constraints](#capacity-estimation-and-constraints)
    - [Summary](#summary)
  - [High Level Design](#high-level-design)
  - [Component Design](#component-design)
    - [Client](#client)
    - [Metadata Database](#metadata-database)
    - [Synchronization Service](#synchronization-service)
    - [Message Queuing Service](#message-queuing-service)
    - [Cloud/Block Storage](#cloudblock-storage)
  - [File Processing Workflow](#file-processing-workflow)
  - [Data Deduplication](#data-deduplication)
  - [Metadata Partitioning](#metadata-partitioning)
    - [Vertical Partitioning](#vertical-partitioning)
    - [Range Based Partitioning](#range-based-partitioning)
    - [Hash-Based Partitioning](#hash-based-partitioning)
  - [Caching](#caching)
  - [Load Balancer (LB)](#load-balancer-lb)
  - [Security, Permissions and File Sharing](#security-permissions-and-file-sharing)

Similar Services: OneDrive, Google Drive
Difficulty Level: Medium

## Why Cloud Storage

- Availability
- Reliability and Durability
- Scalability

## Requirements and Goals of the System

1. Users should be able to upload and download files from any device.
2. Users should be able to share files or folders with other users.
3. Service should support automatic synchronization between devices.
4. System should support storing large files up to a GB.
5. ACID compliance is required.
6. System should support offline editing.
7. Extended requirements
   1. System should support snapshotting of data so users can go back to any version of the files.

## Some Design Considerations

- Huge read and write volumes expected.
- Read:Write ~= 1:1
- Internally, files can be stored in small chunks
  - Advantages
    - Retry operations will be for much smaller files.
    - Reduction in data transfer volume by transferring updated chunks only.
    - Removal of duplicate chunks will result in storage and bandwidth savings.
- Keeping a local copy of the metadata (file name, size, etc.) with the client can save lot of round trips to the server.
- For small changes, clients can intelligently upload the diffs instead of the whole chunk.

## Capacity Estimation and Constraints

```text
Total users = 500 M
Daily Active Users (DAU) = 100 M
Files per user = 200
Total files = 500 M * 200 = 100 000 M = 100 B
Average size per file = 100 KB
Total storage = 100 B * 100 KB = 10000 000 B bytes = 10 PB
Active connections per minute = 1 M
```

### Summary

| Item            | Value  |
| --------------- | ------ |
| Total Users     | 500 M  |
| Files per user  | 200    |
| File size (avg) | 100 KB |
|-----------------|--------|
| Total Files     | 100 B  |
| Total Storage   | 10 PB  |

## High Level Design

- User will specify a folder as the workspace on their device.
- Need to store files and their metadata information like File Name, File Size, Directory, etc., and who this file is shared with.
- Servers to help clients upload/download files to Cloud Storage.
- Servers that can facilitate updating metadata about files and users.
- Need mechanism to notify all clients when an update happens so they can synchronize their files.

![High level design](https://raw.githubusercontent.com/tuliren/grokking-system-design/master/img/dropbox-overview.png)

## Component Design

### Client

- Client application
  - Monitors workspace folder on user machine and syncs all files/folders in it with the remote Cloud Storage.
  - Works with storage servers to upload, download and modify files to backend cloud storage.
  - Interacts with the remote synchronization service to handle any file metadata updates.

Some essential operations for the client:

- Upload and download files.
- Detect file changes in the workspace folder.
- Handle conflict due to offline or concurrent updates.

How to handle file transfer efficiently:

- Break each file into small chunks (say 4 MB) so we transfer only those chunks that are modified and not the whole file.
- We can calculate optimal chunk size based on:
  - Storage devices we use in the cloud to optimize space utilization and i/o operations per second (IOPS).
  - Network bandwidth.
  - Average file size in storage.
  - etc.
- We should keep a record of each file and its chunks.

Client should keep a local copy of metadata. This will enable offline updates and save many round trips to update remote metadata.

How can clients efficiently listen to changes happening with other clients:

- Approach: Clients periodically check with the server for changes.
  - Issues:
    - There will be a delay in reflecting changes locally as client will be checking for changes periodically compared to a server notifying when there is some change.
    - Wastage of bandwidth as server will have to return empty response many times and will be busy in doing so.
    - Pulling data in this manner is not scalable.
  - Solution to issues:
    - HTTP long polling.

Division of client into four parts:

1. Internal Metadata Database
   - Will keep track of all files, chunks, their versions and location in the file system.
2. Chunker
   - Will split files into smaller pieces.
   - Will reconstruct file from its chunks.
   - Chunking algorithm will detect parts of the file that has been modified by the user and only transfer those parts to cloud storage. This will save bandwidth and synchronization time.
3. Watcher
   - Will monitor local workspace folders and notify the Indexer of any action performed by the users (create, delete, update files or folders).
   - Will listen for any changes happening on other clients that are broadcast by the Synchronization service.
4. Indexer
   - Will process the events received from the Watcher and update the internal metadata d/b with information about the chunks of modified files.
   - Once chunks are uploaded/download to/from cloud storage, Indexer will communicate with the remote Synchronization service to:
     - broadcast changes to other clients, and,
     - update the remote metadata d/b.

How will clients handling slow servers: Clients exponentially back-off if the servers is not responding.

Should mobile clients sync remote changes immediately: Mobile clients usually sync on demand to save user bandwidth and space.

[client](./images/client.base64.md)

### Metadata Database

- Maintains versioning and metadata information about files/chunks, users and workspaces.
- Can be SQL like MySQL, or NoSQL d/b service like DynamoDB.
- Synchronization service should be able to provide a consistent view of files using a d/b., specifically under conditions of concurrency.
- Since NoSQL does not support ACID properties, instead favouring scalability and performance, ACID support has to be built into Synchronization service's logic, if we opt for a NoSQL d/b.
- Using SQL will inherently allow support for ACID properties.
- Metadata d/b should store information about following objects;
  - Chunks
  - Files
  - User
  - Devices
  - Workspace (sync folders)

### Synchronization Service

- Processes file updates made by a client and applies those changes to other subscribed clients.
- Synchronizes clients' local d/b with information stored in remote metadata d/b.
- Clients communicate with Synchronization Service to:
  - either obtain updates from cloud storage,
  - or, send files and updates to cloud storage and possibly other users.
- If a client was offline, it polls the systems for new updates as soon as it comes back online.
- When the Synchronization service receives an update request,
  - It checks with the metadata d/b for consistency, the,
  - proceeds with the update.
  - Subsequently, a notification is sent to all subscribed users or devices to report the file update.
- Synchronization service should transmit less data between clients and cloud storage, for faster response times.
  - Using differencing algorithm to reduce amount of data that needs to be synchronized.
  - Transmit only difference between two versions of a file.
  - Only changed part is transmitted.
  - Break files into 4MB chunks and on modified chunks will be transmitted.
  - Servers and clients will calculate a hash (eg: SHA256) to see if a local copy of a chuck should be uploaded or not. On the server, if a chunk with similar hash already exists (even if from another user), there is no need to create another copy. Data deduplication.
- Efficient and scalable synchronization protocol needed.
  - Use communication middleware between client and synchronization service.
  - Messaging middleware should provide:
    - Scalable message queuing
    - Change notifications
    - To support:
      - high number of clients, using
        - push or
        - pull
  - This way multiple Synchronization service instances can receive requests from a global request queue and communication middleware can leverage local balancing.

### Message Queuing Service

- Messaging middleware that handles requests.
- Scalable message queuing service that supports message-based communication between client and the synchronization service.

[message queuing](./images/message-queuing.base64.md)

### Cloud/Block Storage

## File Processing Workflow

## Data Deduplication

## Metadata Partitioning

### Vertical Partitioning

### Range Based Partitioning

### Hash-Based Partitioning

## Caching

## Load Balancer (LB)

## Security, Permissions and File Sharing