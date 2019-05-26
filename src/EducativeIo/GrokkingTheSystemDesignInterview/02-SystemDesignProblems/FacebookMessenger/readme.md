# Designing Facebook Messenger

- [Designing Facebook Messenger](#designing-facebook-messenger)
  - [What is Facebook Messenger](#what-is-facebook-messenger)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
  - [Capacity Estimation and Constraints](#capacity-estimation-and-constraints)
  - [High Level Design](#high-level-design)
  - [Detailed Component Design](#detailed-component-design)
    - [Messages Handling](#messages-handling)
    - [Storing and retrieving the messages from the database](#storing-and-retrieving-the-messages-from-the-database)
    - [Managing user’s status](#managing-users-status)
  - [Data partitioning](#data-partitioning)
  - [Cache](#cache)
  - [Load balancing](#load-balancing)
  - [Fault tolerance and Replication](#fault-tolerance-and-replication)
  - [Extended Requirements](#extended-requirements)
    - [Group chat](#group-chat)
    - [Push notifications](#push-notifications)

## What is Facebook Messenger

- Functional Requirements
  1. Messenger should support one-on-one conversations between users.
  2. Messenger should keep track of the online/offline statuses of its users.
  3. Messenger should support persistent storage of chat history.
- Non-functional Requirements
  1. Users should have real-time chat experience with minimum latency.
  2. Our system should be highly consistent; users should be able to see the same chat history on all their devices.
  3. Messenger's high availability is desirable; we can tolerate lower availability in the interest of consistency.

## Requirements and Goals of the System

## Capacity Estimation and Constraints

## High Level Design

## Detailed Component Design

### Messages Handling

### Storing and retrieving the messages from the database

### Managing user’s status

## Data partitioning

## Cache

## Load balancing

## Fault tolerance and Replication

## Extended Requirements

### Group chat

### Push notifications