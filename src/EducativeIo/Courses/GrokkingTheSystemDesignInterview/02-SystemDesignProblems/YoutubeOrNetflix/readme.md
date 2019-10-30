# Designing YouTube or Netflix

1. [Why Youtube](#why-youtube)
2. [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
3. [Capacity Estimation and Constraints](#capacity-estimation-and-constraints)
    1. [Storage Estimates](#storage-estimates)
    2. [Bandwidth Estimates](#bandwidth-estimates)
4. [System APIs](#system-apis)
5. [High Level Design](#high-level-design)
6. [Database Schema](#database-schema)
    1. [Video metadata storage - MySQL](#video-metadata-storage---mysql)
    2. [User data storage - MySQL](#user-data-storage---mysql)
7. [Detailed Component Design](#detailed-component-design)
8. [Metadata Sharding](#metadata-sharding)
    1. [Sharding based on UserID](#sharding-based-on-userid)
    2. [Sharding based on VideoID](#sharding-based-on-videoid)
9. [Video Deduplication](#video-deduplication)
10. [Load Balancing](#load-balancing)
11. [Cache](#cache)
12. [Content Delivery Network (CDN)](#content-delivery-network-cdn)
13. [Fault Tolerance](#fault-tolerance)

Design a video sharing service like Youtube, where users will be able to upload/view/search videos.

Similar Services: netflix.com, vimeo.com, dailymotion.com, veoh.com

## Why Youtube

## Requirements and Goals of the System

- Functional Requirements
  1. Users should be able to upload videos.
  2. Users should be able to share and view videos.
  3. Users should be able to perform searches based on video titles.
  4. Our services should be able to record stats of videos, e.g., likes/dislikes, total number of views, etc.
  5. Users should be able to add and view comments on videos.
- Non-Functional Requirements
  1. The system should be highly reliable, any video uploaded should not be lost.
  2. The system should be highly available. Consistency can take a hit (in the interest of availability); if a user doesn’t see a video for a while, it should be fine.
  3. Users should have a real time experience while watching videos and should not feel any lag.
- Not in scope
  1. Video recommendations, most popular videos, channels, subscriptions, watch later, favorites, etc.

## Capacity Estimation and Constraints

```plaintext
Total users = 1.5 B
DAU = 800 M
If a user views 5 videos per day, total video-views
  = (800 M * 5) / 86400 sec = 46K videos/sec
If upload:views = 1:200, videos uploaded per second
  = 46 K / 200 = 230 videos/sec
```

### Storage Estimates

```plaintext
Say, in 1 minute 500 hours worth of videos are uploaded.
If on average 1 minute of video needs 50 MB of storage,
  total storage needed for videos updated in 1 minute
    = 500 hrs * 60 mins * 50 MB = 1500 GB/min = 25 GB/sec
```

Numbers are without considering video compression and replication.

### Bandwidth  Estimates

```plaintext
Video uploads per minute = 500 hours worth
If each video takes bandwidth of 10 MB/sec, uploads per minute
 = 500 hrs * 60 mins * 10 MB = 300 GB/sec = 5 GB/sec
If upload:view = 1:200, egress bandwidth needed
 = 1 TB/s
```

## System APIs

```plaintext
uploadVideo(api_dev_key, video_title, vide_description,
  tags[], category_id, default_language,
  recording_details, video_contents)

searchVideo(api_dev_key, search_query, user_location,
  maximum_videos_to_return, page_token)

streamVideo(api_dev_key, video_id, offset, codec, resolution)
```

## High Level Design

1. **Processing Queue:** Each uploaded video will be pushed to a processing queue to be de-queued later for encoding, thumbnail generation, and storage.
2. **Encoder:** To encode each uploaded video into multiple formats.
3. **Thumbnails generator:** To generate a few thumbnails for each video.
4. **Video and Thumbnail storage:** To store video and thumbnail files in some distributed file storage.
5. **User Database:** To store user’s information, e.g., name, email, address, etc.
6. **Video metadata storage:** A metadata database to store all the information about videos like title, file path in the system, uploading user, total views, likes, dislikes, etc. It will also be used to store all the video comments.

[high level design](./images/high-level-design_base64.md)

## Database Schema

### Video metadata storage - MySQL

Videos metadata can be stored in a SQL database. The following information should be stored with each video:

- VideoID
- Title
- Description
- Size
- Thumbnail
- Uploader/User
- Total number of likes
- Total number of dislikes
- Total number of views

For each video comment, we need to store following information:

- CommentID
- VideoID
- UserID
- Comment
- TimeOfCreation

### User data storage - MySQL

- UserID, Name, email, address, age, registration details etc.

## Detailed Component Design

- Read-heavy service.
- Read:write = 200:1
- Video storage
  - Distributed file storage system like HDFS or GlusterFS
- Efficiently managing read traffic
  - Separate read and write traffic.
  - Given there will be multiple (replicated) copies of each video, read traffic can be spread out across different servers.
  - For metadata
    - We can have master-slave configuration where writes first go to the master and then gets replicates to the slaves.
    - This will lead to staleness of data, in other words, weak data consistency.
    - However, given that that we may be looking at milliseconds for data replication to complete for writes to reflect in reads, it would be acceptable.
- Thumbnail storage
  - Lot more thumbnails than videos.
  - Say each video has 5 thumbnails.
  - Considerations
    - Thumbnails are small files, say maximum 5 KB each.
    - Read traffic for thumbnails will be very large compared to videos. Users will be watching one video at a time, but may be looking at a page with around 20 thumbnails of other videos.
  - Disk based storage would not be acceptable due to requiring large number of seeks on different disk locations, given large numbers of files, which is slow and will result in large latencies.
  - Bigtable is a reasonable choice as
    - It combines multiple files into one block to store on disk.
    - It is efficient in reading small amount of data.
  - Hot thumbnails can be kept in cache for improving latencies.
- Video uploads
  - Given that videos can be quite big, if while uploading connection is lost, resuming from the same point should be supported.
- Video encoding
  - Newly uploaded videos will be stored on the server.
  - New task will be added to proceeding queue to encode video into multiple formats.
  - Once encoding is done, uploaded will be notified and video will be made available for viewing/sharing.

[detailed component design](./images/detailed-component-design_base64.md)

## Metadata Sharding

### Sharding based on UserID

- All data for a user on one server.
- Pass UserID to hash function which will map user to d/b server where all metadata for that user's videos will be stored.
- To search videos by titles we will have to query all servers and each server will return a set of videos.
- A centralized server will then aggregate and rank these results before returning them to the user.
- Issues
  - User becoming popular could cause hot-spots.
  - Maintaining a uniform distribution of growing user data is difficult.
- Solutions
  - repartition/redistribute data
  - use consistent hashing to balance the load between servers.

### Sharding based on VideoID

- Hash function will map each VideoID to a random server.
- To find videos of a user we will query all servers and each server will return a set of videos.
- A centralized server will aggregate and rank these results before returning them to the user.
- Issues
  - Popular videos can cause hot-spots.
- Solutions
  - Cache to store hot videos in front of d/b servers.

## Video Deduplication

Duplicate videos often differ in aspect ratios or encodings, can contain overlays or additional borders, or can be excerpts from a longer original video.

Impact of duplicate videos:

1. Data Storage
2. Caching: Duplicate videos would result in degraded cache efficiency by taking up space that could be used for unique content.
3. Network usage
4. Energy consumption: Higher storage, inefficient cache, and network usage could result in energy wastage

For the end user, these inefficiencies will be realized in the form of duplicate search results, longer video startup times, and interrupted streaming.

- For our service, deduplication when user is uploading video is appropriate rather than post-processing to find duplication later.
- As soon as any user starts uploading a video, our service can run video matching algorithms (e.g., Block Matching, Phase Correlation, etc.) to find duplications.
- If we already have a copy of the video being uploaded, we can either stop the upload and use the existing copy or continue the upload and use the newly uploaded video if it is of higher quality.
- If the newly uploaded video is a sub-part of an existing video or, vice versa, we can intelligently divide the video into smaller chunks so that we only upload the parts that are missing.

## Load Balancing

- Consistent hashing among cache servers which will help in balancing load between cache servers.
- Issue
  - Due to static hash function mapping videos to host-names, it can cause hot-spots on logical replicas due to non-uniform popularity of videos.
  - Uneven load on logical replicas will lead to uneven load distribution on physical servers.
- Solution
  - Any busy server in one location to redirect a client to a less busy server in the same cache location.
  - Dynamic HTTP redirections can be used.
- Issue with Solution
  - Since service tries to load balance locally, can lead to multiple (cascading) redirections oif the host that receives the redirection cannot serve the video.
  - Since each redirection requires a client to make an additional HTTP request, it leads to higher delays before the video starts playing.
  - Inter-tier , or, cross data-center redirections can lead a client to a distant cache location because higher tier caches are only present at a small number of locations.

## Cache

- Videos
  - To serve globally distributed users, our service needs a massive-scale video delivery system.
  - The service should push its content closer to the user using a large number of geographically distributed video cache servers.
  - Load on cache servers should be evenly distributed.
- Metadata
  - Cache for metadata servers can also be used to cache hot d/b rows.
  - Memcache can be used to cache data.
  - Application servers will hit cache first.
  - Cache eviction policy: LRU.
- More intelligent cache
  - 80-20 rule: 20% of daily read volume for videos is generating 80% of traffic.
  - We try caching 20% of daily read volume of videos and metadata.

## Content Delivery Network (CDN)

- CDN is a system of distributed servers that deliver web content to a user based in the geographic locations of the user, the origin of the web page and a content delivery server.
- Popular videos can be moved to CDN
  - CDNs replicate content in multiple places. Videos will be closer to user and with fewer hops, videos will stream from a closer, faster network.
  - CDN machines make heavy use of caching and can mostly serve videos out of memory.

Less popular videos (1-20 views per day) that are not cached by CDNs can be served by other servers in various data centers.

## Fault Tolerance

- Consistent Hashing can be used for distribution among database servers.
- Consistent hashing will help in replacing a dead server and also in distributing load among servers.
