# Designing Pastebin

- [Designing Pastebin](#designing-pastebin)
  - [What is Pastebin](#what-is-pastebin)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
  - [Some Design Considerations](#some-design-considerations)
  - [Capacity Estimation and Constraints](#capacity-estimation-and-constraints)
    - [Traffic estimates](#traffic-estimates)
    - [Storage estimates](#storage-estimates)
    - [Bandwidth estimates](#bandwidth-estimates)
    - [Memory estimates](#memory-estimates)
  - [System APIs](#system-apis)
  - [Database Design](#database-design)
    - [Observations](#observations)
    - [Schema](#schema)
      - [Paste](#paste)
      - [User](#user)
  - [High Level Design](#high-level-design)
  - [Component Design](#component-design)
    - [Application layer](#application-layer)
    - [Datastore layer](#datastore-layer)
  - [Detailed Component Design Diagram](#detailed-component-design-diagram)
  - [Purging or DB Cleanup](#purging-or-db-cleanup)
  - [Data Partitioning and Replication](#data-partitioning-and-replication)
    - [Range Based Partitioning](#range-based-partitioning)
    - [Hash-Based Partitioning](#hash-based-partitioning)
  - [Cache and Load Balancer](#cache-and-load-balancer)
    - [Cache](#cache)
    - [Load Balancers](#load-balancers)
  - [Security and Permissions](#security-and-permissions)

Design a Pastebin like web service, where users can store plain text. Users of the service will enter a piece of text and get a randomly generated URL to access it.

Similar Services: pastebin.com, pasted.co, chopapp.com

## What is Pastebin

## Requirements and Goals of the System

- Functional Requirements
  1. Users should be able to upload or paste their data and get a unique URL to access it.
  2. Users will only be able to upload text.
  3. Data and links will expire after a specific timespan automatically; users should also be able to specify expiration time.
  4. Users should optionally be able to pick a custom alias for their paste.
- Non-Functional Requirements
  1. The system should be highly reliable, any data uploaded should not be lost.
  2. The system should be highly available. This is required because if our service is down, users will not be able to access their Pastes.
  3. Users should be able to access their Pastes in real-time with minimum latency.
  4. Paste links should not be guessable (not predictable).
- Extended Requirements
  1. Analytics, e.g., how many times a paste was accessed?
  2. Our service should also be accessible through REST APIs by other services.

## Some Design Considerations

- Shares some requirements with URL Shortening service.
- Limit on the amount of text user can paste at a time: No more than 10 MB.
- Size limits on custom URLs: Reasonable.

## Capacity Estimation and Constraints

Read-heavy service. We can assume a 5:1 ratio between read and write.

### Traffic estimates

```text
1 M new pastes per day.
5 M reads per day.

New pastes per second = 1 M / (24 hours * 3600 seconds)
  ~= 12 pastes/sec
Paste reads per second = 5 M / (24 hours * 3600 seconds)
  ~= 58 reads/sec
```

### Storage estimates

```text
Each upload can be max of 10 MB.
Each paste on average contains, say, 10 KB.
Data stored per day = 1 M * 10 KB = 10 GB/day
To store this data for 10 years, total capacity needed
  = 10 GB * 10 years * 365 days  = 36 TB.

Pastes per day = 1 M
Pastes in 10 years = 1 M * 10 years * 365 days = 3.6 B

Using base64 encoding, and 6 letter strings, 64^6
  ~= 68.7 B unique strings.
If 1 character takes 1 byte, total size for 3.6 B keys
  = 3.6 B * 6 = 22 GB
To account for margin, i.e., we do not want to use more than 70% of total storage capacity, we raise storage needs to 51.4 TB
```

### Bandwidth estimates

```text
For write requests, we expect = 12 pastes/sec
Given each paste is 10 KB, ingress = 120 KB/second

For read requests, we expect = 58 pastes/sec
egress = 58 * 10 KB ~= 600 KB/sec = 0.6 MB/sec
```

### Memory estimates

```text
80-20 rule for caching: meaning 20% hot pastes generate 80% traffic.
Number of read requests = 5 M
Space needed for caching 20% of 5 M
  = 0.2 * 5 M * 10 KB ~= 10 GB
```

## System APIs

```text
addPaste(api_dev_key, paste_data, custom_url=Null, user_name=Null, paste_name=Null, expire_date=Null)

Returns: a string which represents a URL through with the paste can be accessed.
```

```text
getPaste(api_dev_key, api_paste_key)
```

```text
deletePaste(api_dev_key, api_paste_key)
```

## Database Design

### Observations

1. Need to store billions of records.
2. Each metadata object being stored would be small (< 100 bytes).
3. Each paste object can be of medium size (few MB).
4. No relationship between records, expected if we need to store which user created what Paste.
5. Service is read-heavy.

### Schema

#### Paste

| Column         | Type         |
| -------------- | ------------ |
| URLHash (PK)   | varchar(16)  |
| ContentKey     | varchar(512) |
| CreationDate   | datetime     |
| ExpirationDate | datetime     |
| UserId         | int          |

- URLHash is the link to the paste.
- ContentKey is the object key storing contents of the paste.

#### User

| Column       | Type        |
| ------------ | ----------- |
| UserId (PK)  | int         |
| Name         | varchar(20) |
| Email        | varchar(32) |
| CreationDate | datetime    |
| LastLogin    | datetime    |

## High Level Design

[High level design](./images/high-level-design_base64.md)

## Component Design

### Application layer

- Incoming and outgoing requests will process via application layer.
- App layer will talk to backend datastore.
- Handling a write request
  - Random key generation at runtime
    - App server generates a 6 letter key on receiving a write request, which is the key for the paste (if user has not provided custom key).
    - On successful write to d/b, service returns key to user.
    - Since generated key is random, if new key matches existing one, we retry until generated key is unique.
    - If user provided key is not unique we return error to user.
  - Key generation service
    - Mechanism
      - Generates 6 letter strings beforehand and stores them in a database (key d/b).
      - Provides unique pre-generated key for every write request.
      - Uses two tables for keys - used and unused.
      - When a key is given from unused table to app server, KGS moves it to used table.
      - KGS can load some keys from unused table and move it to used table.
      - If KGS dies before it can use all the loaded in-memory keys, those keys will be wasted, but it is acceptable given large numbers of keys.
    - Single-point of failure: Mitigated by using replicas.
    - Each app server can cache some keys from key d/b, for better performance. If app server dies before it can use all the loaded in-memory keys, those keys will be wasted, but it is acceptable given large numbers of keys.
    - Paste read request: app service layer contacts datastore. datastore looks for key and returns contents for that key, if found. Otherwise, error code is returned.

### Datastore layer

1. Metadata database: Either a relation d/b or a distributed k-v store like Dynamo or Cassandra.
2. Object storage: Amazon S3 or Azure blobs. When storage gets close to full capacity on content storage, it can be increased by adding more servers.

## Detailed Component Design Diagram

[Detailed component design](./images/detailed-component-design_base64.md)

## Purging or DB Cleanup

A separate Cleanup service can run periodically to remove expired links from our storage and cache.

## Data Partitioning and Replication

### Range Based Partitioning

- Store URLs in separate partitions based on the first letter of the URL or the hash key.
- The main problem with this approach is that it can lead to unbalanced servers.

### Hash-Based Partitioning

- Take a hash of the short URL we are storing, and calculate which partition to use based upon the hash.
- This approach can still lead to overloaded partitions, which can be solved by using Consistent Hashing.

## Cache and Load Balancer

### Cache

- We can use some off-the-shelf solution like Memcache, which can store full URLs with their respective hashes.
- The application servers, before hitting backend storage, can quickly check if the cache has the desired URL.
- How much cache
  - 20% of daily traffic.
  - 170 GB
- Cache eviction policy
  - LRU
  - Linked Hash Map or similar structure to store URLs and Hashes.
- Replicate caching servers to distribute load.
- Updating cache replica - Hit backend database when there is cache miss and pass new entry to all the cache replicas.

### Load Balancers

1. Between Clients and Application servers
2. Between Application Servers and database servers
3. Between Application Servers and Cache servers

- Simple round robin to start with.
  - Round robin can lead to hot-spots.
- More intelligent LB solution can be placed that periodically queries the backend server about its load and adjusts traffic based on that.

## Security and Permissions

- Store permission level (public/private) with each URL in the database
- We can also create a separate table to store UserIDs that have permission to see a specific URL.
- Send an error (HTTP 401) for unauthorized access.
- When using a NoSQL wide-column database like Cassandra, the key for the table storing permissions would be the 'Hash' (or the KGS generated 'key'). The columns will store the UserIDs of those users that have permissions to see the URL.
