# Designing Facebook's Newsfeed

- [Designing Facebook's Newsfeed](#designing-facebooks-newsfeed)
  - [What is Facebook's newsfeed](#what-is-facebooks-newsfeed)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
  - [Capacity Estimation and Constraints](#capacity-estimation-and-constraints)
    - [Traffic estimates](#traffic-estimates)
    - [Storage estimates](#storage-estimates)
  - [System APIs](#system-apis)
  - [Database Design](#database-design)
  - [High Level System Design](#high-level-system-design)
  - [Detailed Component Design](#detailed-component-design)
  - [Feed Ranking](#feed-ranking)
  - [Data Partitioning](#data-partitioning)

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
Say, we need 500 posts in each user's feed that we want to keep in memory for a quick fetch.
Say, each post is 1 KB in size.
Total storage needed per user = 500 KB.
Total storage needed for all DAU = 500 KB * 300 M = 150 TB.
If one server holds 100 GB, number of machines needed = 1500
```

## System APIs

```text
getUserFeed(api_dev_key, user_id, since_id, count, max_id, exclude_replies)
```

## Database Design

- Three primary objects
  - User
  - Entity (e.g. page, group, etc.)
  - FeedItem (or Post)
- Some points
  - A User can follow other entities and can become friends with other users.
  - Both users and entities can post FeedItems which can contain text, images, or videos.
  - Each FeedItem will have a UserID which will point to the User who created it. For simplicity, let’s assume that only users can create feed items, although, on Facebook Pages can post feed item too.
  - Each FeedItem can optionally have an EntityID pointing to the page or the group where that post was created.

## High Level System Design

## Detailed Component Design

## Feed Ranking

## Data Partitioning
