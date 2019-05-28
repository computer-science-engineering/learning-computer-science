# Designing Facebook Messenger

- [Designing Facebook Messenger](#designing-facebook-messenger)
  - [What is Facebook Messenger](#what-is-facebook-messenger)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
  - [Capacity Estimation and Constraints](#capacity-estimation-and-constraints)
    - [Storage Estimation](#storage-estimation)
    - [Bandwidth Estimation](#bandwidth-estimation)
    - [High level estimates](#high-level-estimates)
  - [High Level Design](#high-level-design)
  - [Detailed Component Design](#detailed-component-design)
    - [Messages Handling](#messages-handling)
    - [Storing and retrieving the messages from the database](#storing-and-retrieving-the-messages-from-the-database)
    - [Managing user's status](#managing-users-status)
    - [Detailed component design diagram](#detailed-component-design-diagram)
  - [Data partitioning](#data-partitioning)
  - [Cache](#cache)
  - [Load balancing](#load-balancing)
  - [Fault tolerance and Replication](#fault-tolerance-and-replication)
  - [Extended Requirements](#extended-requirements)
    - [Group chat](#group-chat)
    - [Push notifications](#push-notifications)

## What is Facebook Messenger

## Requirements and Goals of the System

- Functional Requirements
  1. Messenger should support one-on-one conversations between users.
  2. Messenger should keep track of the online/offline statuses of its users.
  3. Messenger should support persistent storage of chat history.
- Non-functional Requirements
  1. Users should have real-time chat experience with minimum latency.
  2. Our system should be highly consistent; users should be able to see the same chat history on all their devices.
  3. Messenger's high availability is desirable; we can tolerate lower availability in the interest of consistency.

## Capacity Estimation and Constraints

```text
500 M DAU
Number of daily messages each user sends = 40.
Total messages per day = 500 M * 40 = 20 B
```

### Storage Estimation

```text
Average size of message = 100 bytes
Storage needed for all messages in 1 day = 20 B messages * 100 bytes = 2 TB
Storage needed for 5 years of chat history = 2 TB * 365 days * 5 years = 3.6 PB
```

- Along with chat messages, users' information, messages' metadata (ID, timestamp, etc.) will also have to be stored.
- Above calculation does not take into account data compression and replication.

### Bandwidth Estimation

```text
Data ingress per day = 2 TB
Data ingress per second = 2 TB / 86400 seconds ~= 25 MB/sec
```

Since each incoming message needs to go out to another user, we will need the same amount of bandwidth 25MB/s for both upload and download.

### High level estimates

| Total messages       | 20 billion per day |
| -------------------- | ------------------ |
| Storage for each day | 2TB                |
| Storage for 5 years  | 3.6PB              |
| Incoming data        | 25MB/s             |
| Outgoing data        | 25MB/s             |

## High Level Design

![high level design](https://raw.githubusercontent.com/tuliren/grokking-system-design/master/img/facebook-messenger-overview.png)

Workflow:

1. User-A sends a message to User-B through the chat server.
2. The server receives the message and sends an acknowledgment to User-A.
3. The server stores the message in its database and sends the message to User-B.
4. User-B receives the message and sends the acknowledgment to the server.
5. The server notifies User-A that the message has been delivered successfully to User-B.

[workflow](./images/workflow_base64.md)

## Detailed Component Design

Use cases:

1. Receive incoming messages and deliver outgoing messages.
2. Store and retrieve messages from the database.
3. Keep a record of which user is online or has gone offline, and notify all the relevant users about these status changes.

### Messages Handling

- Efficiently send/receive messages
  - Pull model: Users will periodically ask the server for new messages.
    - Server needs to keep track of messages that are waiting to be delivered.
    - When receiving user connects to ask for new messages, server can return all pending messages.
    - Issues:
      - Resource wastage due to frequent calls (to minimize latency for user) which may result in empty response.
  - Push model: Users keep an open connection and will depend on server to notification them when there are new messages.
    - Server does not need to keep track of pending messages.
    - Users will have minimum latency as messages will be delivered instantly on the opened connection.
- Clients maintaining an open connection with the server
  - HTTP long polling or WebSockets
- Server keeping track of all opened connection to redirect messages to the user
  - Server can maintain a hash table, where key would be the UserID and value would be the connection object.
- When server receives a messages for a user who has gone offline
  - Server can notify sender of delivery failure.
  - If there is a temporary disconnect (eg.: receiver's long poll request times out)
    - User will reconnect.
    - Retry logic can be baked into client, for retrying sending the message.
    - Server can store message for a while and retry sending it once the receiver reconnects.
- Number of chat servers needed
  - Assumption: Need 500 M connections at any time.
  - 1 server an handle 50K connections, so number of servers needed = 500 M / 50 K = 10 K.
- Which server holds the connection to which user
  - Using software load balancer in front of chat servers; that can map each UserID to a server to redirect the request.
- How would the server process a 'deliver message' request
  - Workflow
    - Store message in the d/b.
    - Send message to the receiver.
    - Send an acknowledgement to the sender.
- How does the messenger maintain the sequencing og the messages
  - We need to keep a sequence number with every message for each client. This sequence number will determine the exact ordering of messages for EACH user. With this solution both clients will see a different view of the message sequence, but this view will be consistent for them on all devices.

### Storing and retrieving the messages from the database

Whenever the chat server receives a new message, it needs to store it in the database. To do so, we have two options:

1. Start a separate thread, which will work with the database to store the message.
2. Send an asynchronous request to the database to store the message.

We have to keep certain things in mind while designing our database:

1. How to efficiently work with the database connection pool.
2. How to retry failed requests.
3. Where to log those requests that failed even after some retries.
4. How to retry these logged requests (that failed after the retry) when all the issues have resolved.

- Storage system to use
  - Need d/b that supports
    - High rate of small updates.
    - Quick fetching of range of records.
  - When querying user is most interested in sequentially accessing the messages.
  - RDBMS  and NoSQL databases cannot be used since writing/reading a row for every message is expensive.
    - Will result in high latency.
    - Will cause huge load on d/b.
  - Requirements can be met with a wide-column d/b like HBase.
    - HBase is a column-oriented k-v NoSQL d/b that can store multiple values against one key into multiple columns.
    - HBase is modeled after Google's BigTable and runs on HDFS.
    - HBase groups data together to store new data in a memory buffer and once buffer is full, flushes data to disk.
    - HBase also works well for storing variably sized data.
  - How should clients efficiently fetch data
    - Clients should paginate when fetching data from server.
    - Page size can be different for different clients, e.g., cell phones, vs. desktop.

### Managing user's status

- Need to track user's online/offline status and notify all relevant users when a status change happens.
- This can be easily done since we maintain connection object on server for all active users.
- However with 500 M active users, broadcasting each status change to all relevant users can be very expensive.
- Following optimization can be done.
  1. Whenever a client starts the app, it can pull the current status of all users in their friends' list.
  2. Whenever a user sends a message to another user that has gone offline, we can send a failure to the sender and update the status on the client.
  3. Whenever a user comes online, the server can always broadcast that status with a delay of a few seconds to see if the user does not go offline immediately.
  4. Client's can pull the status from the server about those users that are being shown on the user's viewport. This should not be a frequent operation, as the server is broadcasting the online status of users and we can live with the stale offline status of users for a while.
  5. Whenever the client starts a new chat with another user, we can pull the status at that time.

### Detailed component design diagram

![detailed component design](https://raw.githubusercontent.com/tuliren/grokking-system-design/master/img/facebook-messenger-detail.png)

Summary

- Clients open connection to chat server to send a message.
- Server then passes message to requested user.
- All active users keep open connection with server to receive messages.
- When a new message arrives, chat server will push it to the receiving user  on the long poll request.
- Messages can be stored in HBase, which supports quick small updates and range based queries.
- Servers can broadcast online status of a user to other relevant users.
- Clients can pull status updates for users who are visible in client's viewport on a less frequent basis.

## Data partitioning

- Storing around 3.6 PB for 5 years.
- Need to distribute data to multiple d/b servers.
- Partitioning based on UserID
  - All messages for a user on same d/b.
  - If 1 shard = 4 TB, number of shards for 5 years = 3.6 PB / 4 TB ~= 900 shards. Lets say we need 1000 shards.
  - Shard number can be found by `hash(UserID) % 1000`.
  - This scheme will be fast for retrieving chat history for any user.
  - We can start with fewer d/b servers with multiple shards residing on one physical server.
  - Since we can have multiple database instances on a server, we can easily store multiple partitions on a single server.
  - The hash function needs to understand this logical partitioning scheme so that it can map multiple logical partitions on one physical server.
  - Start with big number of logical partitions mapped to fewer physical servers, and as storage demand increases, we can add more physical servers to distribute logical partitions.
- Partitioning based on MessageID
  - Unacceptable, since fetching range of messages will be very slow if we store different messages for a user on separate d/b shards.

## Cache

- Cache few recent messages (say last 10, 15) for few recent conversations that are visible in user's viewport (say last 5).
- Since partitioning by UserID, all user messages will be on a single shard, so cache for a user should reside entirely on one machine as well.

## Load balancing

- LB in front of chat servers, that maps each UserID to a server that holds the connection for the user and then direct the request to that server.
- LB for cache servers.

## Fault tolerance and Replication

- When chat server fails
  - Need mechanism to transfer those connections to some other server.
  - Given that failover of TCO connections is non-trivial, easier approach may be to have clients automatically reconnet if the connection is lost.
- Should we store multiple copies of user messages
  - Yes.
  - Store multiple copies of data on different servers, or.
  - User techniques like Reed-Solomon encoding to distribute and replicate it.

## Extended Requirements

### Group chat

- Separate group-chat objects.
- Identified by GroupCharID and will contain a list of people who are part of that char in the object model.
- LB can direct each group chat message based on the GroupCharID and the server handling that group can iterate through all the users of the chat to find the server handling the connection of each user to deliver the message.
- In databases, we can store all the group chats in a separate table based on GroupChatID.

### Push notifications

- Each user can opt-in from their device or browser to get notifications when there is a new event.
- Need to set up dedicated notification servers.