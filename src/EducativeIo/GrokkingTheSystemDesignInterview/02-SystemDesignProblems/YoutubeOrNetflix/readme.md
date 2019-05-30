# Designing YouTube or Netflix

- [Designing YouTube or Netflix](#designing-youtube-or-netflix)
  - [Why Youtube](#why-youtube)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
    - [Functional Requirements](#functional-requirements)
    - [Non-Functional Requirements](#non-functional-requirements)
    - [Not in scope](#not-in-scope)
  - [Capacity Estimation and Constraints](#capacity-estimation-and-constraints)
  - [System APIs](#system-apis)
  - [High Level Design](#high-level-design)
  - [Database Schema](#database-schema)
  - [Detailed Component Design](#detailed-component-design)
  - [Metadata Sharding](#metadata-sharding)
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

## System APIs

## High Level Design

## Database Schema

## Detailed Component Design

## Metadata Sharding

## Video Deduplication

## Load Balancing

## Cache

## Content Delivery Network (CDN)

## Fault Tolerance