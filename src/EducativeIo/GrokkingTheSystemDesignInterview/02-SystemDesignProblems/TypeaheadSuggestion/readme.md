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

- **Case sensitivity in trie:** We assume data is case-insensitive.
- **Finding top suggestion:**
  - Given that we can find all the terms for a prefix, how do we know the top 10 terms that should be suggested?
  - One option is to store the count of searches that terminated at each node. For example, if users have searched about ‘CAPTAIN’ 100 times and ‘CAPTION’ 500 times, we can store this number with the last character of the phrase.
- **Given a prefix how long will it take to traverse its sub-tree:** Given strict latency requirements, need to improve efficiency of solution.
- **Can we store top suggestions with each node:**
  - Will speed up searches.
  - Will require lot of extra storage.
  - Storage can be optimized by storing only references of the terminal nodes rather than storing the entire phrase.
  - To find the suggested terms we need to traverse back using the parent reference from the terminal node.
  - We will also need to store the frequency with each reference to keep track of top suggestions.
- **How would be build the trie:**
  - Bottom up.
  - Each parent node will recursively call all child nodes to calculate top suggestions and their counts.
  - Parent nodes will combine top suggestions from all their children to determine their top suggestions.
- **How to update the trie:**
  - Say, 5 B searches a day => 60K QPS.
  - Real-time update of trie for every query would be inefficient.
    - Resource intensive.
    - Hamper read requests.
  - Update trie offline after a certain internal.
  - As queries come in,
    - log them and track frequency.
    - Or, we can log every nth query. This would ensure that we ignore terms searched for less than n times.
  - Map-Reduce (MR) setup to process all the logging data periodically (say 1 hour).
  - MR jobs will calculate frequencies of searched terms in the past hour.
  - Trie can then be updated with this data.
  - How to not disrupt read calls while doing this update:
    - Option1:
      - Make copy of trie on each server to update it offline.
      - Once done switch it to start using it and discard old one.
    - Option2:
      - Master-slave configuration for each trie server.
      - Update slave while master is serving traffic.
      - Once update is complete, promote slave to become new master.
      - Later update old master, which can then start serving traffic too.
- **How to update the frequencies of typeahead suggestions:**
  - Need to update frequencies of typeahead suggestions being stored with each node.
  - Update only differences in frequencies instead of recounting from scratch.
  - We can add and subtract frequencies based on Exponential Moving Average (EMA; also known as exponentially weighted moving average) of each term. In EMA we give more weight to the latest data.
  - Workflow
    - After inserting a new term in the trie, we go to the terminal node of the phrase and increase its frequency.
    - Since we are storing the top 10 queries in each node, it is possible that this search team jumped into the top 10 queres of a few other nodes.
    - So we need to update the top 10 queries of those nodes.
    - We have to traverse back from the node all the way up to the root.
    - For every parent,
      - we check if the current query is part of the top 10.
        - If so, we update the corresponding frequency.
        - If not, we check if the current query;s frequency is high enough to be a part of the top 10.
          - If so, we insert this new term and remove the term with the lowest frequency.

## Permanent Storage of the Trie

## Scale Estimation

## Data Partition

## Cache

## Replication and Load Balancer

## Fault Tolerance

## Typeahead Client

## Personalization
