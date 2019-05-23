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

- Client application monitors workspace folder on user machine and syncs all files/folders in it with the remote Cloud Storage.

### Metadata Database

### Synchronization Service

### Message Queuing Service

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