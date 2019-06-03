# Designing an API Rate Limiter

- [Designing an API Rate Limiter](#designing-an-api-rate-limiter)
  - [What is a Rate Limiter](#what-is-a-rate-limiter)
  - [Why do we need API rate limiting](#why-do-we-need-api-rate-limiting)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
  - [How to do Rate Limiting](#how-to-do-rate-limiting)
  - [What are different types of throttling](#what-are-different-types-of-throttling)
  - [What are different types of algorithms used for Rate Limiting](#what-are-different-types-of-algorithms-used-for-rate-limiting)
  - [High level design for Rate Limiter](#high-level-design-for-rate-limiter)
  - [Basic System Design and Algorithm](#basic-system-design-and-algorithm)
  - [Sliding Window algorithm](#sliding-window-algorithm)
  - [Sliding Window with Counters](#sliding-window-with-counters)
  - [Data Sharding and Caching](#data-sharding-and-caching)
    - [Sharding](#sharding)
    - [Caching](#caching)
  - [Should we rate limit by IP or by user](#should-we-rate-limit-by-ip-or-by-user)

Difficulty Level: Medium

## What is a Rate Limiter

- A user can send only one message per second.
- A user is allowed only three failed credit card transactions per day.
- A single IP can only create twenty accounts per day.

In general, a rate limiter caps how many requests a sender can issue in a specific time window. It then blocks requests once the cap is reached.

## Why do we need API rate limiting

Rate Limiting helps to protect services against abusive behaviors targeting the application layer like Denial-of-service (DOS) attacks, brute-force password attempts, brute-force credit card transactions, etc.

Following is a list of scenarios that can benefit from Rate limiting by making a service (or API) more reliable:

- Misbehaving clients/scripts
- Security
- To prevent abusive behavior and bad design practices
- To keep costs and resource usage under control
- Revenue
- To eliminate spikiness in traffic

## Requirements and Goals of the System

- Functional Requirements:
  1. Limit the number of requests an entity can send to an API within a time window, e.g., 15 requests per second.
  2. The APIs are accessible through a cluster, so the rate limit should be considered across different servers. The user should get an error message whenever the defined threshold is crossed within a single server or across a combination of servers.
- Non-Functional Requirements
  1. The system should be highly available. The rate limiter should always work since it protects our service from external attacks.
  2. Our rate limiter should not introduce substantial latencies affecting the user experience.

## How to do Rate Limiting

- Rate Limiting
  - Process that is used to define the rate and speed at which consumers can access APIs.
- Throttling
  - Process of controlling the usage of the APIs by customers during a given period.
  - Can be defined at the application level and/or API level.
  - When a throttle limit is crossed, the server returns HTTP status “429 - Too many requests".

## What are different types of throttling

- Hard Throttling: The number of API requests cannot exceed the throttle limit.
- Soft Throttling: In this type, we can set the API request limit to exceed a certain percentage.
- Elastic or Dynamic Throttling: Under Elastic throttling, the number of requests can go beyond the threshold if the system has some resources available.

## What are different types of algorithms used for Rate Limiting

- Fixed Window Algorithm: The time window is considered from the start of the time-unit to the end of the time-unit.

[fixed window](./images/api-rate-limiter-window_base64.md)

- Rolling Window Algorithm:
  - The time window is considered from the fraction of the time at which the request is made plus the time window length.
  - For example, if there are two messages sent at the 300th millisecond and 400th millisecond of a second, we’ll count them as two messages from the 300th millisecond of that second up to the 300th millisecond of next second.

## High level design for Rate Limiter

Once a new request arrives, the Web Server first asks the Rate Limiter to decide if it will be served or throttled. If the request is not throttled, then it’ll be passed to the API servers.

[high level design](.images/high-level-design_base64.md)

## Basic System Design and Algorithm

- Allow 3 requests per minute per user.
- Hashtable
  - Key: userId
  - Value: count and startTime
- Procedure for each request
  - For new user
    - Create a new entry
    - count = 1
    - startTime = currentTime
    - Allow the request.
  - For existing user
    - If currentTime - startTime >= 1 min, reset count and startTime.
    - Otherwise, reject the request if count >= 3, or allow the request if count < 3 and increment count.
- Atomicity
  - In a distributed environment, the "read-and-then-write" behavior can create a race condition.
  - We can use lock, but it will slow concurrent requests from the same user, and introduce extra complexity.
- Memory usage
  - userId: 8 bytes
  - count: 2 bytes, count up to 65K
  - startTime: 4 bytes; store only the minute and second part
  - lock: 4 bytes number
  - hash overhead: 20 bytes
  - total: (16 bytes + 20 bytes) * 1M users = 36 MB
  - Can fit into one server, but should be distributed for performance reason
  - 3M QPS if the rate limit is 3 requests per user per second
- Implementation
  - Redis
  - Memcached

## Sliding Window algorithm

- Hashtable
  - Key: userId
  - Value: sorted set of timestamps
- Procedure for each request
  - Remove all timestamps from the sorted set that are older than currentTime - 1 min
  - Reject the request if the total count is greater than throttling limit
  - Otherwise allow the request, and add the current time into the sorted set
- Memory usage
  - userId: 8 bytes
  - each epoch time = 4 bytes
  - Say, we need a rate limiting of 500 requests per hour.
  - hash-table overhead: 20 bytes
  - sorted set overhead: 20 bytes
  - For one user's data, we need: 8 + (4 + 20 (sorted set overhead)) * 500 + 20 (hash-table overhead) = 12KB
  - In a sorted set, we can assume that we need at least two pointers to maintain order among elements — one pointer to the previous element and one to the next element.
  - sorted set: 4 bytes (other overhead) + 8 bytes (prev pointer) + 8 bytes (next pointer) = 20 bytes
  - If we need to track one million users at any time, total memory we would need would be: 12 KB * 1 M ~= 12 GB
  - Sliding Window Algorithm takes a lot of memory compared to the Fixed Window; this would be a scalability issue.

## Sliding Window with Counters

- Keep track of request counts for each user using multiple fixed time windows.
- For example, for an hourly rate limit, we can keep a count for each minute and - calculate the sum of all counters in the past hour.
- This will reduce memory footprint for large limits.
- For a rate limit of 500 requests per hour
  - With counters: 8 bytes user id + (4 bytes timestamp + 2 bytes count + 20 bytes hash overhead) * 60 entries + 20 bytes hashtable overhead = 1.6 KB
  - If we need to track one million users at any time, 1.6KB * 1 million ~= 1.6 GB
  - 86% less memory

## Data Sharding and Caching

### Sharding

- Shard rate limiting data by userId.
- Use consistent hashing.
- If different APIs have different limit, we can shard per user per API.

### Caching

- Application servers can quickly check if the cache has the desired record before hitting backend servers.
- Use write-back cache. The cache is persisted to persistence at fixed intervals.
- This is useful once the user has hit their max limit, and the rate limiter will only be reading data without any updates.
- Cache eviction - LRU

## Should we rate limit by IP or by user

- By IP
  - Better than no rate limit at all.
  - When multiple users share a single public IP, one bad user can cause throttling to others.
  - There are a huge number of IPv6 addresses available from even one computer.
- By User
  - Performed after user authentication.
  - What about rate limit on the login API?
- Hybrid
  - Combine per-IP and per-user rate limiting.
  - Require more memory and storage.
