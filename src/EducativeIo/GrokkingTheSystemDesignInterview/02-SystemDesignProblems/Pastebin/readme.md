# Designing Pastebin

- [Designing Pastebin](#designing-pastebin)
  - [What is Pastebin](#what-is-pastebin)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
    - [Functional Requirements](#functional-requirements)
    - [Non-Functional Requirements](#non-functional-requirements)
    - [Extended Requirements](#extended-requirements)
  - [Some Design Considerations](#some-design-considerations)
  - [Capacity Estimation and Constraints](#capacity-estimation-and-constraints)
    - [Traffic estimates](#traffic-estimates)
    - [Storage estimates](#storage-estimates)
    - [Bandwidth estimates](#bandwidth-estimates)
    - [Memory estimates](#memory-estimates)
  - [System APIs](#system-apis)
  - [Database Design](#database-design)
  - [High Level Design](#high-level-design)
  - [Component Design](#component-design)
    - [Application layer](#application-layer)
    - [Datastore layer](#datastore-layer)
    - [Purging or DB Cleanup](#purging-or-db-cleanup)
    - [Data Partitioning and Replication](#data-partitioning-and-replication)
    - [Cache and Load Balancer](#cache-and-load-balancer)
    - [Security and Permissions](#security-and-permissions)

Similar Services: pastebin.com, pasted.co, chopapp.com
Difficulty Level: Easy

## What is Pastebin

## Requirements and Goals of the System

### Functional Requirements

1. Users should be able to upload or paste their data and get a unique URL to access it.
2. Users will only be able to upload text.
3. Data and links will expire after a specific timespan automatically; users should also be able to specify expiration time.
4. Users should optionally be able to pick a custom alias for their paste.

### Non-Functional Requirements

### Extended Requirements

## Some Design Considerations

- Limit on the amount of text user can paste at a time: No more than 10 MB.
- Size limits on custom URLs: Reasonable.

## Capacity Estimation and Constraints

Read-heavy service. We can assume a 5:1 ratio between read and write.

### Traffic estimates

```text
1 M new pastes per day.
5 M reads per day.

New pastes per second = 1 M / (24 hours * 3600 seconds) ~= 12 pastes/sec
Paste reads per second = 5 M / (24 hours * 3600 seconds) ~= 58 reads/sec
```

### Storage estimates

### Bandwidth estimates

### Memory estimates

## System APIs

## Database Design

## High Level Design

## Component Design

### Application layer

### Datastore layer

### Purging or DB Cleanup

### Data Partitioning and Replication

### Cache and Load Balancer

### Security and Permissions