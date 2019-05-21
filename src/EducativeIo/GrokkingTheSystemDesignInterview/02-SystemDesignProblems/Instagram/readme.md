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
  - [Component Design](#component-design)
  - [Reliability and Redundancy](#reliability-and-redundancy)
  - [Data Sharding](#data-sharding)
  - [Ranking and Timeline Generation](#ranking-and-timeline-generation)
  - [Timeline Creation with Sharded Data](#timeline-creation-with-sharded-data)
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
```

## Component Design

## Reliability and Redundancy

## Data Sharding

## Ranking and Timeline Generation

## Timeline Creation with Sharded Data

## Cache and Load balancing