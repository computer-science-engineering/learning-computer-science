# Designing Twitter

- [Designing Twitter](#designing-twitter)
  - [What is Twitter](#what-is-twitter)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
    - [Functional Requirements](#functional-requirements)
    - [Non-Functional Requirements](#non-functional-requirements)
    - [Extended Requirements](#extended-requirements)
  - [Capacity Estimation and Constraints](#capacity-estimation-and-constraints)
  - [System APIs](#system-apis)
  - [High Level System Design](#high-level-system-design)
  - [Database Schema](#database-schema)
  - [Data Sharding](#data-sharding)
  - [Cache](#cache)
  - [Timeline Generation](#timeline-generation)
  - [Replication and Fault Tolerance](#replication-and-fault-tolerance)
  - [Load Balancing](#load-balancing)
  - [Monitoring](#monitoring)
  - [Extended Requirements](#extended-requirements-1)

Difficulty Level: Medium

## What is Twitter

## Requirements and Goals of the System

### Functional Requirements

1. Users should be able to post new tweets.
2. A user should be able to follow other users.
3. Users should be able to mark tweets as favorites.
4. The service should be able to create and display a user’s timeline consisting of top tweets from all the people the user follows.
5. Tweets can contain photos and videos.

### Non-Functional Requirements

1. Our service needs to be highly available.
2. Acceptable latency of the system is 200ms for timeline generation.
3. Consistency can take a hit (in the interest of availability); if a user doesn't see a tweet for a while, it should be fine.

### Extended Requirements

## Capacity Estimation and Constraints

- 1 B total users with 200 M DAU.
- 100 M new tweets every day.
- On average each user follows 200 people.

## System APIs

## High Level System Design

## Database Schema

## Data Sharding

## Cache

## Timeline Generation

## Replication and Fault Tolerance

## Load Balancing

## Monitoring

## Extended Requirements