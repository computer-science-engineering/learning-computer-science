# Problem Definition

## Description

Design a key-value cache to save the results of the most recent web server queries, including a snippet about the search results itself.

In case you’re not already familiar, a cache system is a widely adopted technique that is used in nearly every application today and applies to every layer of the technology stack. A cache system stores commonly used resources, for example in-memory, and the next time a request is made for the same resource, the system can return it immediately.

#####################

This editor is synced in real time with your peer.

Use it to share thoughts and resources, such as:

- Features scope
- API design
- Pseudo code for specific components
- Data model/schema
- Back-of-the-envelope calculations
- Reference links
- Link to whiteboard or diagram such as https://sketchboard.me/new

Good luck!

*******************

https://sketchboard.me/dBcAEeDpWGgU#/

1. Scope

- Search for SE like google - 1000 queries/s
- TTL/Eviction strategy? - [If item unused for x amount of time, release] - Only keep for last x queries.
- Data consistency? Interaction with BE persisted store? Yes.
- Text query - hyperlinks and snippet (snapshot). No additional media.

1. Some number crunching

- QPS - 1k
- What do we need to store
  - query string (10 KB)
  - hyperlinks of results (8 KB per result) (say 10 per query)
  - snapshot for each result (500 KB per result)
- 1 day ->
  - 10 * 1000 * 24 * 60 * 60 = KB (queries)
  - 80 * 1000 * 24 * 60 * 60 = KB (hyperlinks of results)
  - 500 * 1000 * 24 * 60 * 60 = KM (snapshots for results)
    10 TB;

1. Data Model

- Map DS for QS and Results. [LRU implementation here]
- Blob data - snapshot maps to a result/hyperlink. [LRU implementation here]

1. System design

1. Gateway
- API
- Hashing algo

1. Data partitioning
- Use a hashing algorithm (range partitioning for uniformity)
- partition by QS - HA - RP by Int64
  
- Caching service - deployed across multiple machines.
  deployed to 10 machines.
  
1. Availability

- Implement Paxos/Raft (*)
  - Use some OS solution
  - Apache Z
  - Microsoft SF
- Implement data replication

1. Caching service
- `Map<QS, List<hyperlink>>`
- Snapshot blob - `Map<hyperlink, byte[]>`
  
- Persists to disk and hold on to memory
- Disk persisted data eventually flushes to out-of-proc storage

- Redis and Memcache

## Notes

1. [Pramp - The Complete System Design Interviewer Guide](https://medium.com/@pramp/the-complete-system-design-interviewer-guide-e5d273724db8)
1. [GitHub - Donne Martin system-design-primer](https://github.com/donnemartin/system-design-primer/tree/master/solutions/system_design/query_cache#design-a-key-value-cache-to-save-the-results-of-the-most-recent-web-server-queries)