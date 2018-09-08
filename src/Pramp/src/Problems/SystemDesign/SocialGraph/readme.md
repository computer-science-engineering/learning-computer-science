# Problem Definition

## Description

Popular social networks contain millions and even billions of connections between individuals.

Design a system that allows a user to search for another person, and see the shortest path between them.

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

#####################

1. Scope of problem
    1. Social platform - not facebook, but something similar.
    1. Includes storage of data
    1. Similar to Kevin Bacon problem
    1. Focus is system design not algorithm

1. High-level design - components
    1. API end-point - API gateway - usually hosted using a web server.
    1. Raw data storage
        1. Relational data - SQL database. For scaling we should choose a NoSQL d/b like Cassandra. (*)
    1. Shortest path finder - service - computational.
    1. Data Model
    1. Lookup Service (optional)

1. Data Model
    1. Person - id, last_name, first_name, List<id> friends

1. API
  https://socialgraph.com/api/shortestpath/?person_start={start}&person_end={end}
  
  return json of a list of persons starting with start and ending withe end.

1. Diving in
    1. User/client hits web server.
    1. Need LB before web server.
    1. Web server calls out to application server. Hosts the hashing algo.
    1. Need some partitioning for path finder MS.
        1. Combine start and end Ids. Then hash the result. We use a hashing algo that guarantees uniform hash output. Range partitioning. Consistent hashing.
    1. Path finder MS
        1. (DFS, BFS. Topological search). BFS.
        1. Talks to Lookup service
        1. Holds in-memory latest accessed paths. (LRU)
        1. In-Memory caching service
        1. Holds results of path finding (LRU).
    1. Lookup service
        1. Talks to BE data store - Cassandra - data partitioned by person Id.
        1. Holds in-memory latest accessed persons. (LRU)
        1. Can be partitioned as well.

1. Feedback
    1. Algo aspect is imp too.
    1. Data models imp. Start earlier.
  
linkedin.com/in/akg009

## Notes

1. [Pramp - The Complete System Design Interviewer Guide](https://medium.com/@pramp/the-complete-system-design-interviewer-guide-e5d273724db8)
1. [GitHub - Donne Martin system-design-primer](https://github.com/donnemartin/system-design-primer/tree/master/solutions/system_design/social_graph)