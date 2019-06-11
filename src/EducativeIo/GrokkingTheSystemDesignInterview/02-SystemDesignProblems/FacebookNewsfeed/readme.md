# Designing Facebook's Newsfeed

- [Designing Facebook's Newsfeed](#designing-facebooks-newsfeed)
  - [What is Facebook's newsfeed](#what-is-facebooks-newsfeed)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
  - [Capacity Estimation and Constraints](#capacity-estimation-and-constraints)
    - [Traffic estimates](#traffic-estimates)
    - [Storage estimates](#storage-estimates)
  - [System APIs](#system-apis)
  - [Database Design](#database-design)
    - [User](#user)
    - [Entity](#entity)
    - [UserFollow](#userfollow)
    - [FeedItem](#feeditem)
    - [FeedMedia](#feedmedia)
    - [Media](#media)
  - [High Level System Design](#high-level-system-design)
    - [Feed generation](#feed-generation)
    - [Feed publishing](#feed-publishing)
  - [Detailed Component Design](#detailed-component-design)
    - [Feed generation design](#feed-generation-design)
    - [Feed publishing design](#feed-publishing-design)
  - [Feed Ranking](#feed-ranking)
  - [Data Partitioning](#data-partitioning)
    - [Sharding posts and metadata](#sharding-posts-and-metadata)
    - [Sharding feed data](#sharding-feed-data)

Design Facebook's Newsfeed, which would contain posts, photos, videos, and status updates from all the people and pages a user follows.

Similar Services: Twitter Newsfeed, Instagram Newsfeed, Quora Newsfeed

## What is Facebook's newsfeed

## Requirements and Goals of the System

- Functional requirements:
  1. Newsfeed will be generated based on the posts from the people, pages, and groups that a user follows.
  2. A user may have many friends and follow a large number of pages/groups.
  3. Feeds may contain images, videos, or just text.
  4. Our service should support appending new posts as they arrive to the newsfeed for all active users.
- Non-functional requirements
  1. Our system should be able to generate any user’s newsfeed in real-time - maximum latency seen by the end user would be 2s.
  2. A post shouldn’t take more than 5s to make it to a user’s feed assuming a new newsfeed request comes in.

## Capacity Estimation and Constraints

- Say, user has 300 friends and follows 200 pages.

### Traffic estimates

```text
Say, 300 M DAU.
Each user fetches their timeline an average of 5 times a day.
Total newsfeed requests per day
    = 300 M * 5 = 1.5 B
Total newsfeed requests per second
    = 1.5 B / (24 hours * 60 mins * 60 sec)
    = 17500 RPS
```

### Storage estimates

```text
Say, we need 500 posts in each user's feed that
  we want to keep in memory for a quick fetch.
Say, each post is 1 KB in size.
Total storage needed per user = 500 KB.
Total storage needed for all DAU
  = 500 KB * 300 M = 150 TB.
If one server holds 100 GB,
  number of machines needed = 1500
```

## System APIs

```text
getUserFeed(api_dev_key, user_id, since_id, count,
  max_id, exclude_replies)
```

## Database Design

- Three primary objects
  - User
  - Entity (e.g. page, group, etc.)
  - FeedItem (or Post)
- Some points
  - A User can follow other entities and can become friends with other users.
  - Both users and entities can post FeedItems which can contain text, images, or videos.
  - Each FeedItem will have a UserID which will point to the User who created it. For simplicity, let’s assume that only users can create feed items, although, on Facebook, Pages can post feed item too.
  - Each FeedItem can optionally have an EntityID pointing to the page or the group where that post was created.
- If using a relation d/b, two relations need to be modeled:
  - User-Entity
  - FeedItem-Media

### User

| Column       | Type        |
| ------------ | ----------- |
| UserID (PK)  | int         |
| Name         | varchar(20) |
| Email        | varchar(32) |
| DateOfBirth  | datetime    |
| CreationDate | datetime    |
| LastLogin    | datetime    |

### Entity

| Column        | Type         |
| ------------- | ------------ |
| EntityID (PK) | int          |
| Name          | varchar(20)  |
| Type          | tinyint      |
| Description   | varchar(512) |
| CreationDate  | datetime     |
| Category      | smallint     |
| Phone         | varchar(12)  |
| Email         | varchar(20)  |

### UserFollow

| Column                 | Type    |
| ---------------------- | ------- |
| UserID (PK)            | int     |
| EntityOrFriendID  (PK) | int     |
| Type                   | tinyint |

Type identifies if the entity being followed is a User ot Entity.

### FeedItem

| Column            | Type         |
| ----------------- | ------------ |
| FeedItemID (PK)   | int          |
| UserID            | int          |
| Contents          | varchar(256) |
| EntityID          | int          |
| LocationLatitude  | int          |
| LocationLongitude | int          |
| CreationDate      | datetime     |
| NumLikes          | int          |

### FeedMedia

| Column          | Type |
| --------------- | ---- |
| FeedItemID (PK) | int  |
| MediaID  (PK)   | int  |

### Media

| Column            | Type         |
| ----------------- | ------------ |
| MediaID (PK)      | int          |
| Type              | smallint     |
| Description       | varchar(256) |
| Path              | varchar(256) |
| LocationLatitude  | int          |
| LocationLongitude | int          |
| CreationDate      | datetime     |

## High Level System Design

### Feed generation

1. Retrieve IDs of all users and entities that a user (say Jane) follows.
2. Retrieve latest, most popular and relevant posts for those IDs. These are the potential posts that we can show in Jane’s newsfeed.
3. Rank these posts based on the relevance to Jane. This represents Jane’s current feed.
4. Store this feed in the cache and return top posts (say 20) to be rendered on Jane’s feed.
5. On the front-end, when Jane reaches the end of her current feed, she can fetch the next 20 posts from the server and so on.

We can periodically (say every five minutes) perform the above steps to rank and add newer posts to her feed. Jane can then be notified that there are newer items in her feed that she can fetch.

### Feed publishing

When she reaches the end of her current feed, she can pull more data from the server. For newer items either the server can notify Jane and then she can pull, or the server can push, these new posts.

At a high level, we will need following components in our Newsfeed service:

1. **Web servers:** To maintain a connection with the user. This connection will be used to transfer data between the user and the server.
2. **Application server:** To execute the workflows of storing new posts in the database servers. We will also need some application servers to retrieve and to push the newsfeed to the end user.
3. **Metadata database and cache:** To store the metadata about Users, Pages, and Groups.
4. **Posts database and cache:** To store metadata about posts and their contents.
5. **Video and photo storage, and cache:** Blob storage, to store all the media included in the posts.
6. **Newsfeed generation service:** To gather and rank all the relevant posts for a user to generate newsfeed and store in the cache. This service will also receive live updates and will add these newer feed items to any user’s timeline.
7. **Feed notification service:** To notify the user that there are newer items available for their newsfeed.

High-level architecture diagram of system. User B and C are following User A.

![high level diagram](https://raw.githubusercontent.com/tuliren/grokking-system-design/master/img/facebook-newsfeed-overview.png)

## Detailed Component Design

### Feed generation design

- SQL like querying will not be efficient at all.
  - Very slow with performance issues arising from sorting, merging, ranking, etc. of large number of posts for users with lots of friends and/or follows.
  - Timeline generation at user page load time would result in high latency and response times.
  - For live updates, each status update will result in feed updates for all followers. This could result in high backlogs in our Newsfeed Generation Service.
  - For live updates, the server pushing (or notifying about) newer posts to users could lead to very heavy loads, especially for people or pages that have a lot of followers. To improve the efficiency, we can pre-generate the timeline and store it in a memory.
- **Offline generation for newsfeed:**
  - Dedicated servers that continuously generate users' newsfeed and store them in memory.
  - Whenever these servers need to generate the feed for a user, they will first query to see what was the last time the feed was generated for that user. Then, new feed data would be generated from that time onwards.
  - Data can be stored in hash table.
    - Key: UserID
    - Value:

        ```text
        Struct {
            LinkedHashMap<FeedItemID, FeedItem> feedItems;
            DateTime lastGenerated;
        }
        ```

- **How many feed items in memory for user's feed:**
  - Initially 500 feed items per user.
  - Based on usage pattern, can be adjusted.
  - For example, if we assume that one page of a user’s feed has 20 posts and most of the users never browse more than ten pages of their feed, we can decide to store only 200 posts per user.
  - For any user who wants to see more posts (more than what is stored in memory), we can always query backend servers.
- **Should we generate and keep in emory newsfeeds for all users:**
  - Approach 1: LRU based cache that can remove users from memory who have not accessed their newsfeed for a long time.
  - Approach 2: Determine login pattern of users to pre-generate their newsfeed.

### Feed publishing design

- Approaches:
  1. Pull model or Fan-out-on-load:
     - Keep all recent feed data in memory so that users can pull from server on-demand.
     - Clients can pull data periodically or on-demand.
     - Issues;
       - New data may not be shown until users issue a pull request.
       - Hard to find the right pull cadence.
       - Most of the time pull requests will result in empty response resulting in wastage of resources.
  2. Push model or Fan-out-on-write:
     - Once a user has published a post, we immediately push this post to all followers.
     - Advantage: When fetching feed, no need to go through friend's list and get feeds for each of them. Significantly reduces read operations.
     - Users have to main a Long Poll request to server for receiving updates.
     - Issue:
       - When a user has millions of followers, server has to push updates to lot of people. This is resource intensive.
  3. Hybrid:
     - Combination of push and pull.
     - Stop pushing posts from (celebrity) users from a high number of followers.
     - Push data only for those users who have relatively few(er) followers.
     - Users who follow celebrities can pull updates.
     - Another approach could be that once a user publishes a post, we can limit the fanout to only his/her online friends.
- How many feed items should be returned to the client per request:
  - There should be a maximum limit (say 20).
  - Client should specify - will be different depending on client devices, i.e., desktop, or mobile.
- Notifying users if there are new posts available for their newsfeed:
  - Yes.
  - On mobile devices we should let users pull or refresh to get data, instead of pushing data, to save bandwidth.

## Feed Ranking

- Easiest to do so by creation time of posts.
- Important first select key signals that make a post important and then find out how to combine them to calculate a final ranking score.
- Signals could be things like number of likes, comments, shares, etc.
- More sophistical ranking system can constantly improve itself by evaluating if we are making progress in user stickiness, retention, ads revenue, etc.

## Data Partitioning

### Sharding posts and metadata

For sharding our databases that are storing posts and their metadata, we can have a similar design as discussed under Designing Twitter.

### Sharding feed data

- For feed data, which is being stored in memory, we can partition it based on UserID.
- When storing, we can pass the UserID to our hash function that will map the user to a cache server where we will store the user’s feed objects.
- Since we don't expect to store more than 500 FeedItemIDs for a user, we will not run into a scenario where feed data for a user doesn’t fit on a single server. To get the feed of a user, we would always have to query only one server.
- For future growth and replication, we can use Consistent Hashing.
