# Designing Instagram

- [Designing Instagram](#designing-instagram)
  - [Why Instagram](#why-instagram)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
    - [Functional Requirements](#functional-requirements)
    - [Non-Functional Requirements](#non-functional-requirements)
    - [Not in scope](#not-in-scope)
  - [Some Design Considerations](#some-design-considerations)
  - [Capacity Estimation and Constraints](#capacity-estimation-and-constraints)
  - [High Level System Design](#high-level-system-design)
    - [Scenarios](#scenarios)
    - [Storage](#storage)
  - [Database Schema](#database-schema)
    - [Tables](#tables)
      - [Photo](#photo)
      - [User](#user)
      - [UserFollow](#userfollow)
    - [Type of Database](#type-of-database)
  - [Data Size Estimation](#data-size-estimation)
    - [User Table](#user-table)
    - [Photo Table](#photo-table)
    - [UserFollow Table](#userfollow-table)
    - [Total space needed](#total-space-needed)
  - [Component Design](#component-design)
  - [Reliability and Redundancy](#reliability-and-redundancy)
  - [Data Sharding](#data-sharding)
    - [Partitioning based on UserID](#partitioning-based-on-userid)
    - [Partitioning based on PhotoID](#partitioning-based-on-photoid)
    - [Planning for Future Growth](#planning-for-future-growth)
  - [Ranking and Timeline Generation](#ranking-and-timeline-generation)
  - [News Feed Creation with Sharded Data](#news-feed-creation-with-sharded-data)
  - [Cache and Load balancing](#cache-and-load-balancing)

Similar Services: Flickr, Picasa

Difficulty Level: Medium

## Why Instagram

Design a simpler version of Instagram, where a user can share photos and can also follow other users. The 'News Feed' for each user will consist of top photos of all the people the user follows.

## Requirements and Goals of the System

### Functional Requirements

1. Users should be able to upload/download/view photos.
2. Users can perform searches based on photo/video titles.
3. Users can follow other users.
4. The system should be able to generate and display a user’s News Feed consisting of top photos from all the people the user follows.

### Non-Functional Requirements

1. Our service needs to be highly available.
2. The acceptable latency of the system is 200ms for News Feed generation.
3. Consistency can take a hit (in the interest of availability), if a user doesn’t see a photo for a while; it should be fine.
4. The system should be highly reliable; any uploaded photo or video should never be lost.

### Not in scope

Adding tags to photos, searching photos on tags, commenting on photos, tagging users to photos, who to follow, etc.

## Some Design Considerations

- Read heavy system.
- Storage management should be efficient.
- Low latency expected while viewing photos.
- Data should be 100% reliable. If a user uploads a photo, the system will guarantee that it will never be lost.

## Capacity Estimation and Constraints

```text
Total users = 500 M
DAU = 1 M
New photos every day = 2 M =>
    New photos every second = 2 M / (24 hours * 3600 seconds) = 23.
Average photo file size = 200 KB
Space required for 1 day of photos = 2 M * 200 KB = 400 GB
Space required for 10 years of photos = 400 GB * 10 years * 365 days ~= 1425 TB
```

## High Level System Design

### Scenarios

- Upload photos
- View/search photos

### Storage

- Object storage servers for photos.
- Database server for metadata information about photos

![High level design](https://raw.githubusercontent.com/tuliren/grokking-system-design/master/img/instagram-overview.png)

## Database Schema

### Tables

#### Photo

| Column         | Type         |
| -------------- | ------------ |
| PhotoID (PK)   | int          |
| UserID         | int          |
| PhotoPath      | varchar(256) |
| PhotoLatitude  | int          |
| PhotoLongitude | int          |
| UserLatitude   | int          |
| UserLongitude  | int          |
| CreationDate   | datetime     |

Index on PhotoID and CreationDate since we need to fetch recent photos first.

#### User

| Column       | Type        |
| ------------ | ----------- |
| UserID (PK)  | int         |
| Name         | varchar(20) |
| Email        | varchar(32) |
| DateOfBirth  | datetime    |
| CreationDate | datetime    |
| LastLogin    | datetime    |

#### UserFollow

| Column       | Type |
| ------------ | ---- |
| UserID1 (PK) | int  |
| UserID2 (PK) | int  |

### Type of Database

- Obvious choice is to use an RDBMS d/b, but scaling can be difficult.
- For scaling advantage of NoSQL, a distributed K-V store can be used.
  - Metadata related to photos can go to a table where key would be PhotoID and value would be an object containing rest of the items.
- Column-wide datastore like Cassandra can be used for
  - Storing relationships between users and photos.
    - UserPhoto table: key would be UserID, value would be a list of PhotoIDs the user owns, stored in different columns.
  - List of people a user follows.
    - UserFollow table: Similar as for UserPhoto table.
- K-V stores maintain replicas for reliability. Also data is marked as deleted before getting deleted permanently.
- Photos can be stored on a distributed file storage like HDFS or S3, or Azure blobs.

## Data Size Estimation

Storage estimation for 10 years.

### User Table

```text
Assumption: int and datetime is 4 bytes, each row in User's table:

UserID (4 bytes) + Name (20 bytes) + Email (32 bytes) + DateOfBirth (4 bytes) + CreationDate (4 bytes) + LastLogin (4 bytes) = 68 bytes.

Storage for 500 M users: 500 M * 68 bytes = 34 GB
```

### Photo Table

```text
PhotoID (4 bytes) + UserID (4 bytes) + PhotoPath (256 bytes) + PhotoLatitude (4 bytes) + PhotoLongitude(4 bytes) + UserLatitude (4 bytes) + UserLongitude (4 bytes) + CreationDate (4 bytes) = 284 bytes

Photos uploaded per day = 2 M
Storage needed for a day = 2M * 284 bytes ~= 0.5 GB per day
Storage needed for 10 years = 0.5 GB * 10 years * 365 days ~= 1.8 TB
```

### UserFollow Table

```text
Each row in the UserFollow table will consist of 8 bytes.
If we have 500 million users and on average each user follows 500 users, total storage needed
  = 500 M users * 500 followers * 8 bytes ~= 1.82TB
```

### Total space needed

For all tables for 10 years = 34 GB + 1.8 TB + 1.82 TB ~= 3.7 TB

## Component Design

- Writes can be slow as they have to go to the disk.
- Reads are faster as they are served from cache.
- Dedicated servers for reads and different servers for writes to ensure that uploads don’t hog the system.
- Separating photos’ read and write requests will also allow us to scale and optimize each of these operations independently.

[component design](./images/component-design_base64.md)

## Reliability and Redundancy

- Multiple replicas are needed.

![Detailed component diagram](https://raw.githubusercontent.com/tuliren/grokking-system-design/master/img/instagram-detail.png)

## Data Sharding

### Partitioning based on UserID

- We can shard based on UserID, so all photos of a user are on the same shard.
- If we have 10 shards, we can find shard number by `UserID % 10`.
- To uniquely identify any photo, we can append shard number with each PhotoID.
- How can we generate PhotoIDs:
  - Each db-shard can have its own auto-increment sequence for PhotoIDs.
  - Since we will append ShardID with each PhotoID, it will be unique throughout the system.
- Issues with this partitioning scheme
  - Would result in hot-spots.
    - What of users with many millions of followers.
    - When some users have lots of photos compared to others, storage distribution would be non-uniform.
      - Even if we distribute photos for a user into multiple shards, it may cause higher latencies.
    - Storing all photos for a user in one shard can cause issues
      - Unavailability of user data is shard is down.
      - Higher latency if it is serving high load.

### Partitioning based on PhotoID

- Generate unique PhotoIDs first and the find a shard number using `PhotoID % 10`.
- Using this mechanism we would not have to append ShardID with PhotoID, as PhotoID itself will be unique.
- Generating PhotoIDs
  - Dedicate a separate database instance to generate auto-incrementing IDs.
    - If our PhotoID can fit into 64 bits, we can define a table containing only a 64 bit ID field. So whenever we would like to add a photo in our system, we can insert a new row in this table and take that ID to be our PhotoID of the new photo.
    - Key generating d/b as a single point of failure
      - Yes
      - Workaround1: Two databases.
        - One generating even numbered IDs and other odd numbered.
        - Load balancer in front to round robin between them.
      - Workaround2: Key generation service (KGS).

### Planning for Future Growth

- Large number of logical partitions, such that in the beginning, multiple logical partitions reside on a single physical d/b server.
- Since each database server can have multiple database instances on it, we can have separate databases for each logical partition on any server.
- So when a particular database server has lot of data, we can migrate some logical partitions from it to another server.
- We can maintain a config file (or a separate database) that can map our logical partitions to database servers; this will enable us to move partitions around easily. Whenever we want to move a partition, we only have to update the config file to announce the change.

## Ranking and Timeline Generation

- Need to fetch latest, most popular and relevant photos of the people the user follows.

- Assumption: Fetch top 100 photos for a user's news feed.
- Workflow
  - Get list of people user follows.
  - Fetch metadata info of latest 100 photos from each user.
  - Submit these photos to some ML/AI algorithm to determine top 100 photos (based on likes, recency, etc.)
  - Return these 100 photos to user.
- Issues
  - High latency due to
    - Having to query multiple tables.
    - Performing sorting/merging/ranking on results.
- Pre-generating the News Feed
  - Servers that generate users' News Feeds and store them in a 'UserNewsFeed' table.
  - Servers will check last time News Feed was generated by looking at 'userNewsFeed' table. New News feed will be generated from that time onwards.
- Approaches for sending NewsFeed contents to users
  - Pull
    - Clients pull news feed data periodically or on-demand.
    - Issues
      - New data may not be shown until a new client side request comes in.
      - New pull requests may often result in empty response if there is no data.
  - Push
    - Servers push new data to users when it is available.
    - Users maintain Long Poll request to server.
    - Issues
      - User who follows lot of people, or for user who has millions of followers, server has to push frequent updates.
  - Hybrid
    - Approach 1
      - Pull model for users with high follows.
      - Push model for users with few(er) follows.
    - Approach 2
      - Server pushes updates to all users at certain max frequency.
      - Users wil lot of follows/updates pull data.

Also check Facebook Newsfeed problem.

## News Feed Creation with Sharded Data

- Fetching of latest photos from all people user follows.
- Need to sort photos based on creation time.
- We can make photo creation time part of the PhotoID.
- Primary indexing on PhotoID.
- Approach
  - Using epoch time.
  - PhotoID will have two parts
    - First part representing epoch time.
    - Second part an auto-incrementing sequence.
  - New PhotoID
    - Take current epoch time.
    - Append auto-incrementing ID from a key-generating d/b.
  - Shard number for a photo can be obtained using `PhotoID % 10`.
- Size of PhotoID

    ```text
    If epoch time starts today, required number of bits to store number of seconds for next 50 years:
    86400 sec/day * 365 days/year * 50 years = 1.6 B seconds
    Number of bits needed to store 1.6 B seconds = 31.
    Given expected photos/sec = 23, number of bits needed for storing auto-incremented sequence = 9.
    So, every second, we can store 2^9 = 512 new photos.
    Auto-incrementing sequence can be reset every second.
    ```

## Cache and Load balancing

- Globally distributed cache servers.
- Using Content Delivery Networks (CDN)
- Cache for metadata servers to cache hot d/b rows.
- Memcache to cache data and application servers before hitting d/b.
  - LRU for cache eviction policy.
- Intelligent caching
  - 80-20 rule
    - 20% of daily read volume for photos generates 80% of traffic.
    - Cache 20% of daily read volume of photos and metadata.