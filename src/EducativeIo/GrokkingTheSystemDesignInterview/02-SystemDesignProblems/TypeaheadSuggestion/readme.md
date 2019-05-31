# Designing Typeahead Suggestion

- [Designing Typeahead Suggestion](#designing-typeahead-suggestion)
  - [What is Typeahead Suggestion](#what-is-typeahead-suggestion)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
  - [Basic System Design and Algorithm](#basic-system-design-and-algorithm)
  - [Permanent Storage of the Trie](#permanent-storage-of-the-trie)
  - [Scale Estimation](#scale-estimation)
  - [Data Partition](#data-partition)
  - [Cache](#cache)
  - [Replication and Load Balancer](#replication-and-load-balancer)
  - [Fault Tolerance](#fault-tolerance)
  - [Typeahead Client](#typeahead-client)
  - [Personalization](#personalization)

Similar Services: Auto-suggestions, Typeahead search

## What is Typeahead Suggestion

## Requirements and Goals of the System

**Functional Requirements:** As the user types in their query, our service should suggest top 10 terms starting with whatever the user has typed.

**Non-function Requirements:** The suggestions should appear in real-time. The user should be able to see the suggestions within 200ms.

## Basic System Design and Algorithm

- If the d/b contains the following terms: cap, cat, captain, or capital and the user has typed in ‘cap’, our system should suggest ‘cap’, ‘captain’ and ‘capital’.
- Need to serve lot of queries with minimum latency.
- Need to store index in memory in a highly efficient data structure.
- Will use th trie data structure.

[Trie data structure](./images/trie-data-structure_base64.md)

We can merge nodes that have only one branch to save storage space.

[Trie merged nodes](./images/trie-merged-nodes_base64.md)

**Case sensitivity in trie:** We assume data is case-insensitive.

**Finding top suggestion:**

## Permanent Storage of the Trie

## Scale Estimation

## Data Partition

## Cache

## Replication and Load Balancer

## Fault Tolerance

## Typeahead Client

## Personalization