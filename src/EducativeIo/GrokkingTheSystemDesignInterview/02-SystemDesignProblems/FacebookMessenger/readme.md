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
    - [Managing user’s status](#managing-users-status)
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

### Managing user’s status

## Data partitioning

## Cache

## Load balancing

## Fault tolerance and Replication

## Extended Requirements

### Group chat

### Push notifications