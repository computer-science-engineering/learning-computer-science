# Designing Typeahead Suggestion

- [Designing Typeahead Suggestion](#designing-typeahead-suggestion)
  - [What is Typeahead Suggestion](#what-is-typeahead-suggestion)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
  - [Basic System Design and Algorithm](#basic-system-design-and-algorithm)
  - [Permanent Storage of the Trie](#permanent-storage-of-the-trie)
  - [Scale Estimation](#scale-estimation)
    - [Storage Estimation](#storage-estimation)
  - [Data Partition](#data-partition)
  - [Cache](#cache)
  - [Replication and Load Balancer](#replication-and-load-balancer)
  - [Fault Tolerance](#fault-tolerance)
  - [Typeahead Client](#typeahead-client)
  - [Personalization](#personalization)

Design a real-time suggestion service, which will recommend terms to users as they enter text for searching.

Similar Services: Auto-suggestions, Typeahead search

## What is Typeahead Suggestion

## Requirements and Goals of the System

**Functional Requirements:** As the user types in their query, our service should suggest top 10 terms starting with whatever the user has typed.

**Non-function Requirements:** The suggestions should appear in real-time. The user should be able to see the suggestions within 200ms.

## Basic System Design and Algorithm

- If the d/b contains the following terms: cap, cat, captain, or capital and the user has typed in ‘cap’, our system should suggest ‘cap’, ‘captain’ and ‘capital’.
- Need to serve lot of queries with minimum latency.
- Need to store index in memory in a highly efficient data structure.
- Will use the trie data structure.

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
    - Since we are storing the top 10 queries in each node, it is possible that this search team jumped into the top 10 queries of a few other nodes.
    - So we need to update the top 10 queries of those nodes.
    - We have to traverse back from the node all the way up to the root.
    - For every parent,
      - we check if the current query is part of the top 10.
        - If so, we update the corresponding frequency.
        - If not, we check if the current query's frequency is high enough to be a part of the top 10.
          - If so, we insert this new term and remove the term with the lowest frequency.
- **How to remove a term from the trie:**
  - Remove term when regular update happens, or
  - Add a filtering layer on each server that will remove any such term before sending to users.
- **What could be different ranking criteria for suggestions?**
  - In addition to simple count, other factors that can be considered:
    - freshness
    - user location
    - language
    - demographics
    - personal history

## Permanent Storage of the Trie

- We need mechanisms to store trie in a file so that it can be rebuilt. This is needed for when a machine might restart.
- We can take a snapshot of the trie periodically and store it in a file.
- To store,
  - start with root node and save trie level-by-level.
  - With each node, we can store what character it contains and how many children it has.
  - Right after each node, we should out all of its children.
  - "C2,A2,R1,T,P,O1,D" is an example for [this trie](./images/trie-storage-example_base64.md).
  - In this example, we are not storing top suggestions and their counts with each node.
    - It is hard to store this information; as our trie is being stored top down, we don’t have child nodes created before the parent, so there is no easy way to store their references.
    - For this, we have to recalculate all the top terms with counts.
    - This can be done while we are building the trie.
    - Each node will calculate its top suggestions and pass it to its parent.
    - Each parent node will merge results from all of its children to figure out its top suggestions.

## Scale Estimation

- Say 5 B searches per day.
- So, 60 K QPS.
- Say, only 20% of searches are unique.
- Say, we want to index only top 50% of search terms.
- Say, we will have 100 M unique terms for which to build an index.

### Storage Estimation

```text
Say, each query has 3 words and each word has 5 characters,
  then each query has on average 15 characters.
Say, each character needs 2 bytes, so each query needs 30 bytes.
Total storage needed = 100 M * 30 bytes = 3 GB
Say we add 2% new queries each day,
 and we maintain index for last year.
Then, total storage needed  = 3 GB + (0.02 * 3 GB * 365 days) = 25 GB
```

## Data Partition

- **Range based partitioning**
  - Store phrases in separate partitions based on first letter.
  - Issues
    - Can lead to unbalanced servers.
- **Partitioning based on the maximum capacity of the server**
  - We partition our trie based on the maximum memory capacity of the servers.
  - We can keep storing data on a server as long as it has memory available.
  - When a sub-tree cannot fit into a server, we break our partition there to assign that range to this server and move on the next server to repeat this process.
  - We can keep a hash table to quickly access this partitioning scheme:
    - Server 1, A-AABC
    - Server 2, AABD-BXA
    - Server 3, BXB-CDA
  - When the user has typed ‘AA’, we still have to query server 1 and 2, but when the user has typed ‘AAA’ we only need to query server 1.
  - We can have a load balancer in front of our trie servers which can store this mapping and redirect traffic.
  - If we are querying from multiple servers, either we need to merge the results at the server side to calculate overall top results or make our clients do that.
  - If we prefer to do this on the server side, we need to introduce another layer of servers between load balancers and trie severs (let’s call them aggregator). These servers will aggregate results from multiple trie servers and return the top results to the client.
  - Issues
    - Partitioning based on the maximum capacity can still lead us to hotspots, e.g., if there are a lot of queries for terms starting with ‘cap’, the server holding it will have a high load compared to others.
- **Partitioning based on the hash of the term**
  - Each term will be passed to a hash function, which will generate a server number and we will store the term on that server.
  - This will make our term distribution random and hence minimize hotspots.
  - To find typeahead suggestions for a term we have to ask all the servers and then aggregate the results.

## Cache

- There will be a small percentage of queries that will be responsible for most of the traffic.
- Separate cache servers in front of the trie servers holding most frequently searched terms and their typeahead suggestions.
- Can also have Machine Learning (ML) model that can try to predict the engagement on each suggestion based on simple counting, personalization, or trending data etc., and cache these terms.

## Replication and Load Balancer

- Replicas for our trie servers both for load balancing and also for fault tolerance.
- A load balancer that keeps track of our data partitioning scheme and redirects traffic based on the prefixes.

## Fault Tolerance

Master-slave configuration for trie server. If the master dies, the slave can take over after failover. Any server that comes back up, can rebuild the trie based on the last snapshot.

## Typeahead Client

Optimizations on the client to improve user’s experience:

1. The client should only try hitting the server if the user has not pressed any key for 50ms.
2. If the user is constantly typing, the client can cancel the in-progress requests.
3. Initially, the client can wait until the user enters a couple of characters.
4. Clients can pre-fetch some data from the server to save future requests.
5. Clients can store the recent history of suggestions locally. Recent history has a very high rate of being reused.
6. Establishing an early connection with the server turns out to be one of the most important factors. As soon as the user opens the search engine website, the client can open a connection with the server. So when a user types in the first character, the client doesn’t waste time in establishing the connection.
7. The server can push some part of their cache to CDNs and Internet Service Providers (ISPs) for efficiency.

## Personalization

- Users will receive some typeahead suggestions based on their historical searches, location, language, etc.
- We can store the personal history of each user separately on the server and cache them on the client too. The server can add these personalized terms in the final set before sending it to the user.
- Personalized searches should always come before others.
