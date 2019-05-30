# Designing YouTube or Netflix

- [Designing YouTube or Netflix](#designing-youtube-or-netflix)
  - [Why Youtube](#why-youtube)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
    - [Functional Requirements](#functional-requirements)
    - [Non-Functional Requirements](#non-functional-requirements)
    - [Not in scope](#not-in-scope)
  - [Capacity Estimation and Constraints](#capacity-estimation-and-constraints)
    - [Storage Estimates](#storage-estimates)
    - [Bandwidth Estimates](#bandwidth-estimates)
  - [System APIs](#system-apis)
  - [High Level Design](#high-level-design)
  - [Database Schema](#database-schema)
    - [Video metadata storage - MySql](#video-metadata-storage---mysql)
    - [User data storage - MySql](#user-data-storage---mysql)
  - [Detailed Component Design](#detailed-component-design)
  - [Metadata Sharding](#metadata-sharding)
    - [Sharding based on UserID](#sharding-based-on-userid)
    - [Sharding based on VideoID](#sharding-based-on-videoid)
  - [Video Deduplication](#video-deduplication)
  - [Load Balancing](#load-balancing)
  - [Cache](#cache)
  - [Content Delivery Network (CDN)](#content-delivery-network-cdn)
  - [Fault Tolerance](#fault-tolerance)

Similar Services: netflix.com, vimeo.com, dailymotion.com, veoh.com

## Why Youtube

## Requirements and Goals of the System

### Functional Requirements

1. Users should be able to upload videos.
2. Users should be able to share and view videos.
3. Users should be able to perform searches based on video titles.
4. Our services should be able to record stats of videos, e.g., likes/dislikes, total number of views, etc.
5. Users should be able to add and view comments on videos.

### Non-Functional Requirements

1. The system should be highly reliable, any video uploaded should not be lost.
2. The system should be highly available. Consistency can take a hit (in the interest of availability); if a user doesn’t see a video for a while, it should be fine.
3. Users should have a real time experience while watching videos and should not feel any lag.

### Not in scope

Video recommendations, most popular videos, channels, subscriptions, watch later, favorites, etc.

## Capacity Estimation and Constraints

```text
Total users = 1.5 B
DAU = 800 M
If a user views 5 videos per day, total video-views
  = (800 M * 5) / 86400 sec = 46K videos/sec
If upload:views = 1:200, videos uploaded per second
  = 46 K / 200 = 230 videos/sec
```

### Storage Estimates

```text
Say, in 1 minute 500 hours worth of videos are uploaded
If on average 1 minute of video needs 50 MB of storage,
  total storage needed for videos updated in 1 minute
    = 500 hrs * 60 mins * 50 MB = 1500 GB/min = 25 GB/sec
```

Numbers are without considering video compression and replication.

### Bandwidth  Estimates

```text
Video uploads per minute = 500 hours worth
If each video takes bandwidth of 10 MB/sec, uploads per minute
 = 500 hrs * 60 mins * 10 MB = 300 GB/sec = 5 GB/sec
If upload:view = 1:200, egress bandwidth needed
 = 1 TB/s
```

## System APIs

```text
uploadVideo(api_dev_key, video_title, vide_description, tags[], category_id, default_language, recording_details, video_contents)

searchVideo(api_dev_key, search_query, user_location, maximum_videos_to_return, page_token)

streamVideo(api_dev_key, video_id, offset, codec, resolution)
```

## High Level Design

1. Processing Queue: Each uploaded video will be pushed to a processing queue to be de-queued later for encoding, thumbnail generation, and storage.
2. Encoder: To encode each uploaded video into multiple formats.
3. Thumbnails generator: To generate a few thumbnails for each video.
4. Video and Thumbnail storage: To store video and thumbnail files in some distributed file storage.
5. User Database: To store user’s information, e.g., name, email, address, etc.
6. Video metadata storage: A metadata database to store all the information about videos like title, file path in the system, uploading user, total views, likes, dislikes, etc. It will also be used to store all the video comments.

![high level design](https://raw.githubusercontent.com/tuliren/grokking-system-design/master/img/youtube-overview.png)

## Database Schema

### Video metadata storage - MySql

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

### User data storage - MySql

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
    - However, given that that we may be looking at milliseconds for data replicatoon to complete for writes to reflect in reads, it would be acceptable.
- Thumbnail storage
  - Lot more thumbnails than videos.
  - Say each video has 5 thumbnails.
  - Considerations
    - Thumbnails are small files, say maximum 5 KB each.
    - Read traffic for thumbnails will be very large compared to videos. Users will be watching one video at a time, but may be looking at a page with around 20 thumbnails of other videos.
  - Disk based storage would not be acceptable due to requiring large number of seeks on different disk locations, given large numbers of files, which is slow and will result in large latencies.
  - Bigtable is a reasonable choice as
    - it combines multiple files into one block to store on disk
    - is efficient in reading small amount of data.
  - Hot thumbnails can be kept in cache for improving latencies.
- Video uploads
  - Given that videos can be quite big, if while uploading connection is lost, resuming from the same point should be supported.
- Video encoding
  - Newly uploaded videos will be stored on the server.
  - New task will be added to proceeding queue to encode video into multiple formats.
  - Once encoding is done, uploaded will be notified and video will be made available for viewing/sharing.

![detailed component design](https://raw.githubusercontent.com/tuliren/grokking-system-design/master/img/youtube-detail.png)

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

## Cache

## Content Delivery Network (CDN)

## Fault Tolerance