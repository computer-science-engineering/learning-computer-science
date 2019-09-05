# Designing a URL Shortening service like TinyURL

1. [Why do we need URL shortening](#why-do-we-need-url-shortening)
2. [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
3. [Capacity Estimation and Constraints](#capacity-estimation-and-constraints)
   1. [Traffic Estimates](#traffic-estimates)
   2. [Storage Estimates](#storage-estimates)
   3. [Bandwidth Estimates](#bandwidth-estimates)
   4. [Memory Estimates](#memory-estimates)
   5. [High level estimates](#high-level-estimates)
4. [System APIs](#system-apis)
5. [Database Design](#database-design)
   1. [Tables](#tables)
      1. [URL](#url)
      2. [User](#user)
   2. [Type of Database](#type-of-database)
6. [Basic System Design and Algorithm](#basic-system-design-and-algorithm)
   1. [Encoding actual URL](#encoding-actual-url)
   2. [Generating keys offline](#generating-keys-offline)
7. [Data Partitioning and Replication](#data-partitioning-and-replication)
   1. [Range Based Partitioning](#range-based-partitioning)
   2. [Hash-Based Partitioning](#hash-based-partitioning)
8. [Cache](#cache)
9. [Load Balancer (LB)](#load-balancer-lb)
10. [Purging or DB cleanup](#purging-or-db-cleanup)
11. [Detailed Component Design Diagram](#detailed-component-design-diagram)
12. [Telemetry](#telemetry)
13. [Security and Permissions](#security-and-permissions)
14. [References](#references)

Design a URL shortening service like TinyURL. This service will provide short aliases redirecting to long URLs.

Similar services: bit.ly, goo.gl, qlink.me, etc.

## Why do we need URL shortening

## Requirements and Goals of the System

- Functional Requirements
  1. Given a URL, generate a shorted an unique alias.
  2. When users access short link, service should redirect user to original longer link.
  3. Users should optionally be able to provide a custom short link.
  4. Links will expire after a default time range. Users should be able to specify expiration time.
- Non-Functional Requirements
  1. The system should be highly available. This is required because, if our service is down, all the URL redirections will start failing.
  2. URL redirection should happen in real-time with minimal latency.
  3. Shortened links should not be guessable (not predictable).
- Extended Requirements
  1. Analytics; e.g., how many times a redirection happened?
  2. Our service should also be accessible through REST APIs by other services.

## Capacity Estimation and Constraints

System will be ready heavy. Say, read:write = 100:1.

### Traffic Estimates

```text
New shortenings per month = 500 M
Number of redirections = 100 * 500 M = 50 B
QPS = 500 M / (30 days * 24 hours * 3600 seconds) = ~ 200 URLs/s
With 100:1 read:write ratio, URL redirects per second
  = 100 * 200 URL/s = 20000 /s = 20 K URLs/s
```

### Storage Estimates

```text
All short links are stored for: 5 years
Given 500 M new URLs per month, total number of objects
  = 500 M * 5 years * 12 months = 30 B
Say, each object = 500 bytes
Total storage needed = 30 B * 500 bytes
  = 15 000 000 000 000 = 15 TeraBytes
```

### Bandwidth Estimates

```text
Number of new URL writes = 200 /s
Total ingress data = 200 * 500 bytes
  = 100000 bytes/s = 100 KB/s
Number of reads per second = 20 K
Total egress data = 20000 * 500 bytes
  = 10 000 000 = 10 MB/s
```

### Memory Estimates

```text
80-20 rule
RPS = 20K
Requests per day
  = 20000 * 24 hours * 3600 seconds = 1.7 B
Memory needed to cache 20%
  = 0.2 * 1.7 B * 500 bytes
  = 1.7 000 000 000 00 bytes = 170 GB
```

### High level estimates

- Assuming 500 million new URLs per month and 100:1 read:write ratio

| Category            | Calculation                                               | Estimate |
| ------------------- | --------------------------------------------------------- | -------- |
| New URLs            | `500 million / (30 days * 24 hours * 3600 seconds)`       | 200 /s   |
| URL redirections    | `500 million * 100 / (30 days * 24 hours * 3600 seconds)` | 20 K/s   |
| Incoming data       | `500 bytes/URL * 200 URL/s`                               | 100 KB/s |
| Outgoing data       | `500 bytes/URL * 19K URL/s`                               | 10 MB/s  |
| Storage for 5 years | `500 bytes/URL * 500 million * 60 months`                 | 15 TB    |
| Memory for cache    | `19K URL * 3600 seconds * 24 hours * 500 bytes * 20%`     | 170 GB   |

## System APIs

```text
createURL(api_dev_key, original_url, custom_short_link=null, expire_date=null)

Returns: short link
```

```text
deleteURL(api_dev_key, short_link)
```

- **How do we detect and prevent abuse?**
  - Limit users via their api_dev_key

## Database Design

- Some observations about the nature of the data we will store:
  1. We need to store billions of records.
  2. Each object we store is small (less than 1K).
  3. There are no relationships between records — other than storing which user created a URL.
  4. Our service is read-heavy.

### Tables

#### URL

| Column         | Type         |
| -------------- | ------------ |
| ShortLink (PK) | varchar(16)  |
| OriginalURL    | varchar(512) |
| CreationDate   | datetime     |
| ExpirationDate | datetime     |
| UserId         | int          |

#### User

| Column       | Type        |
| ------------ | ----------- |
| UserID (PK)  | int         |
| Name         | varchar(20) |
| Email        | varchar(32) |
| CreationDate | datetime    |
| LastLogin    | datetime    |

### Type of Database

Given that,

- Data model is not very relational, and
- Large numbers of rows will need to be stored (in the billions),

a NoSQL d/b would be a better choice.

## Basic System Design and Algorithm

The main functionality desired is the generation of a short and unique string for a given URL.

### Encoding actual URL

- Unique hash of the URL can be computed. Using MD5, SHA256, etc.
  - The encoding can be
    - base36 ([a-z, 0-9]), or
    - base62 ([A-Z, a-z, 0-9]), or
    - base64 ([A-Z, a-z, 0-9, -, .])
  - Length of short link, using base64
    - 6 letter long key would result in 64^6 = ~68.7 B strings
    - 8 letter long key would result in 64^8 = ~281 T strings
- Using MD5 algorithms for hashing,
  - 128-bit hash value.
  - Using base64 encoding, short link string will have > 21 characters (since each base64 character encodes 6 bits of hash value).
    - Issues
      - This is problematic since we only have space for 8 characters per short key.
        - If we take first 8 characters that could result in duplication.
      - Multiple users entering same URL can get the same short link.
      - Identical URLs but differing in URL encoding will be interpreted as different.
    - Workarounds for issues
      - Append increasing sequence number to each URL to make it unique, and then generate hash.
        - Every increasing sequence number?
        - Overflow?
        - Performance issues with doing this at real time.
      - Append unique user id to original URL.
        - If user not signed in, have to ask user to choose unique key.
          - Even then if key is not unique, have to keep generating till we get a unique one.

[Request flow for shortening of a URL](./images/request-flow-for-shortening-of-a-url_base64.md)

### Generating keys offline

- Standalone Key Generation Service.
- Generate random 6 or 8 letter keys and stores them in a database (key d/b).
- Whenever a shortening request comes in, take a key from the d/b and use it.
- What about concurrency?
  - When a key is used, we mark it in the d/b as used.
  - Use two tables for keys
    - One for unused keys and other for used.
    - When a key is used, we move it from used table to unused.
    - Some unused keys can be loaded in memory for faster performance. As soon as keys are loaded in memory, they can be moved to used keys table.
    - If application servers are multiple, KGS must lock data structure holding keys in memory to prevent concurrency issues.
- Key d/b size:
  - Base64 encoding with 6 character key, 64^6 = ~68.7 B unique keys.
  - Assuming 1 byte to store 1 alpha-numeric character, space needed to store all keys = 6 *  68.7 B = 412 GB.
- KGS as single point of failure: Mitigated by using replicas - primary and secondaries model.
- Application servers caching keys from KGS: Yes, but if app server dies before using keys, those keys are lost.
- Key lookup: Look up key in database to get original full URL. If present we return a 302 redirect, passing original URL in _Location_ field of response. If not present, we return a 404 Not Found.
- Size limit on custom short link: Yes. Say, 16 characters per custom short link.

[High level design](./images/high-level-system-design_base64.md)

## Data Partitioning and Replication

### Range Based Partitioning

- Store URLs in separate partitions based on the first letter of the URL or the hash key.
- The main problem with this approach is that it can lead to unbalanced servers.

### Hash-Based Partitioning

- Take a hash of the short URL we are storing, and calculate which partition to use based upon the hash.
- This approach can still lead to overloaded partitions, which can be solved by using Consistent Hashing.

## Cache

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

[Request flow for accessing shortened url](./images/request-flow-for-accessing-shortened-url_base64.md)

## Load Balancer (LB)

1. Between Clients and Application servers
2. Between Application Servers and database servers
3. Between Application Servers and Cache servers

- Simple round robin to start with.
  - Round robin can lead to hot-spots.
- More intelligent LB solution can be placed that periodically queries the backend server about its load and adjusts traffic based on that.

## Purging or DB cleanup

A separate Cleanup service can run periodically to remove expired links from our storage and cache.

## Detailed Component Design Diagram

[Detailed component design](./images/detailed-component-design_base64.md)

## Telemetry

Statistics about the system: how many times a short URL has been used

## Security and Permissions

- Store permission level (public/private) with each URL in the database
- We can also create a separate table to store UserIDs that have permission to see a specific URL.
- Send an error (HTTP 401) for unauthorized access.
- When using a NoSQL wide-column database like Cassandra, the key for the table storing permissions would be the 'Hash' (or the KGS generated 'key'). The columns will store the UserIDs of those users that have permissions to see the URL.

## References

1. [YT Video - Tushar Roy - System Design : Design a service like TinyUrl](https://www.youtube.com/watch?v=fMZMm_0ZhK4)
2. [Grokking the System Design Interview - Designing a URL Shortening service like TinyURL](https://www.educative.io/collection/5668639101419520/5649050225344512)
