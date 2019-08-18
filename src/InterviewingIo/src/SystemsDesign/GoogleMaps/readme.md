# Problem Definition

## Description

Google Maps

1. Address lookup
2. Find route between 2 addresses
3. .. with live traffic

## Solution

### Scope

- Maps (routes and addresses) would be predefined and no user entry.
- Traffic info would be dynamic while travel is ongoing.

### High-level ideas

- Mechanism to store maps (locations, addresses, etc.)
- Mechanism for users to enter source, destination addresses.
- Mechanism for BE to calculate route(s) and return that to user.
- Dynamic traffic info
  - Get and store.
  - Provide to user for current ongoing route.
  
### Storage

#### Locations

- Relational d/b is not the right solution.
  - No scalable horizontally as well as other solutions.
  - Data is not really relational

- NoSQL
  - Maybe, but data needed would be very, very large. Document per location may not be the right approach.
  
- Custom DS solution?
  - Some sort of Tree DS.
  - with a grid on each node, with a max number of locations set (1000)
  - root - single grid - whole world.
    - Add locations, reach 1000, add child grids/nodes.
    - Keep going until we reach a child node with <= 1000 locations.

- Key
  - Scalability
  - We may have dense locations and sparce locations.
  - A location that relatively sparce now could become dense later, vice versa. (**??**)

- Grid: each square could represent a location with lat and long.

### High-level design

- Storage servers
- Shard custom tree DS based on some hashing algo
  - hashing algo is based on lat and long
    - Will ensure geo affinity within same server(s)
      - Will help with geo-location (**)

- Resiliency

- Data replication
  - Primary and multiple secs.
    - Implementation of distributed concensus algo: Paxos, Raft, etc.

- Load balancing: LB for read reqs going to sec servers.

- App will need to hit some sort of API gw.
  - Stateless service.
  - Multiple API gw replicas.
  - LBs in front.
  - How will client know which LB to hit?
    - DNS: Have a DNS server that holds the IP addresses of the LBs

### Route calculation

- S and D in same grid:
  - Graph traversal algo to find route:
    - BFS

How do we use lat, long (BFS/DFS does not use that)?

- A(0,0) b(10,20)
- 4 (n,w,e,s) / 2

- S and D in different grids:
  - Grids in same server
    - We have combine Graph traversal with Tree traversal
  - Grids in different servers
    - We have combine Graph traversal with Tree traversal
    - Now we need to know which tree nodes are in which servers
      - We need some sort of reverse index lookup (RI servers with resiliency baked in)

### Feedback

- Good understanding of fundamental service blocks
- Some fetch details - req flow - usage of DNS before LBs - scope for improvement
  - How client know LB?
- Tech details always good to know
- Route computation (algo) - should have gone beyond simple BFS, DFS
- Likes discuss of different storage representation
  - could go into detail of d/b schema
- Address some edge cases- route between NY and SF.
- How to scale route calculation?

## Notes

## References
