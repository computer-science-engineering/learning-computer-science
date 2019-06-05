# Designing Yelp or Nearby Friends

- [Designing Yelp or Nearby Friends](#designing-yelp-or-nearby-friends)
  - [Why Yelp or Proximity Server](#why-yelp-or-proximity-server)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
  - [Scale Estimation](#scale-estimation)
  - [Database Schema](#database-schema)
  - [System APIs](#system-apis)
  - [Basic System Design and Algorithm](#basic-system-design-and-algorithm)
    - [SQL solution](#sql-solution)
    - [Grids](#grids)
    - [Dynamic size grids](#dynamic-size-grids)
  - [Data Partitioning](#data-partitioning)
  - [Replication and Fault Tolerance](#replication-and-fault-tolerance)
  - [Cache](#cache)
  - [Load Balancing (LB)](#load-balancing-lb)
  - [Ranking](#ranking)

Similar Services: Proximity server.

## Why Yelp or Proximity Server

## Requirements and Goals of the System

- Functional Requirements:
  1. Users should be able to add/delete/update Places.
  2. Given their location (longitude/latitude), users should be able to find all nearby places within a given radius.
  3. Users should be able to add feedback/review about a place. The feedback can have pictures, text, and a rating.
- Non-functional Requirements:
  1. Users should have a real-time search experience with minimum latency.
  2. Our service should support a heavy search load. There will be a lot of search requests compared to adding a new place.

## Scale Estimation

```text
500 M places
100K QPS
20% growth in number of places and QPS each year
```

## Database Schema

Each location can have the following fields:

1. LocationID (8 bytes): Uniquely identifies a location.
2. Name (256 bytes)
3. Latitude (8 bytes)
4. Longitude (8 bytes)
5. Description (512 bytes)
6. Category (1 byte): E.g., coffee shop, restaurant, theater, etc.

Although a four bytes number can uniquely identify 500 M locations, with future growth in mind, we will go with 8 bytes for LocationID.

Total size: 8 + 256 + 8 + 8 + 512 + 1 => 793 bytes

Table to store reviews for Places:

1. LocationID (8 bytes)
2. ReviewID (4 bytes): Uniquely identifies a review, assuming any location will not have more than 2^32 reviews.
3. ReviewText (512 bytes)
4. Rating (1 byte): how many stars a place gets out of ten.

Similarly, we can have a separate table to store photos for Places and Reviews.

## System APIs

```text
search(api_dev_key, search_terms, user_location, radius_filter, maximum_results_to_return,
    category_filter, sort, page_token)

Return: (JSON)
A JSON containing information about a list of businesses matching the search query. Each result entry will have the business name, address, category, rating, and thumbnail.
```

## Basic System Design and Algorithm

- Need to store and index each dataset (places, reviews, etc.).
- Indexing needs to be read efficient and very low latency and response times, to support real-time viewing of results.

### SQL solution

- Using MySQL.
  - Each location in a row.
  - PK of LocationID.
  - Indexed on latitude and longitude to support fast queries.
- Sample query
  - `Select * from Places where Latitude between X-D and X+D and Longitude between Y-D and Y+D`
  - **Efficiency:**
    - Performing intersection on two indexes for huge list of returned places is highly inefficient.
    - Would be manageable if the returned list of locations were small(er).

### Grids

[2d grid](./images/2d-grid_base64.md)

- Divide the whole map into smaller grids to group locations into smaller sets.
- Based on a given location and radius, we can find all the neighboring grids and then query these grids to find nearby places.
- GridID (a four bytes number) would uniquely identify grids in our system.
- **Grid size**
  - Grid size could be equal to the distance we would like to query since we also want to reduce the number of grids.
  - If the grid size is equal to the distance we want to query, then we only need to search within the grid which contains the given location and neighboring eight grids.
  - In the database, we can store the GridID with each location and have an index on it, too, for faster searching. 
  - Sample query
    - `Select * from Places where Latitude between X-D and X+D and Longitude between Y-D and Y+D and GridID in (GridID, GridID1, GridID2, ..., GridID8)`
- **Index in-memory?**
  - Will improve performance.
  - Using Hash Table;
    - Key: grid number
    - Value: list of places contained in that grid
- **Memory needed to store the index**
  - Say search radius is 10 miles.
  - Given radius of earth is around 200 M miles, we need 20 M grids.
  - To uniquely identify each grid, we need a 4 byte number.
  - LocationID is 8 bytes.
  - Total memory needed: `(4 * 20 M) + (8 * 500 M) ~= 4 GB`
- Issues:
  - Slow for grids that have lot of places.
  - Places are not uniformly distributed among grids.
- Solution:
  - Dynamically adjust grid size such that whenever we have a grid with a lot of places we break it down to create smaller grids.
    - Challenges:
      - Mapping grids to locations
      - Finding all neighboring grids of a grid.

### Dynamic size grids

[QuadTree](./images/quadtree_base64.md)

- Say no more than 500 places in a grid, for faster searching.
- When a grid reaches this limit, we break it down into four grids of equal size and distribute places among them.
- **Data Structure**
  - QuadTree
- **Building a QuadTree**
  - Start with a single node that represents the world.
  - As it will contain more than 500 locations, we will break it down into 4 nodes and distribute locations among them.
  - Repeat process with each child node, until there are no more nodes with more than 500 locations.
- **Finding grid for a given location**
  - Start with root node and search downward.
  - At each step, check if current node has children.
    - If so, move to child node that contains desired location and repeat process.
    - If not, that is the desired node.
- **Finding neighboring grids of a given grid**
  - Approach 1
    - Since only leaf nodes contain a list of locations, we can connect all leaf nodes with a doubly linked list.
    - We can iterate forward or backward among the neighboring leaf nodes to find out our desired locations.
  - Approach 2
    - Using parent nodes.
    - Keep a pointer in each node to access its parent, and since each parent node has pointers to all of its children, we can easily find siblings of a node.
    - We can keep expanding our search for neighboring grids by going up through the parent pointers.
- Once we have nearby LocationIDs, we can query the backend database to find details about those places.
- **Search workflow**
  - First find the node that contains the user's location.
    - If that node has enough desired places, we return them to the user.
    - If not, we keep expanding to neighboring nodes (either through parent pointers ot doubly linked list) until
      - either we find required number of places, or
      - exhaust search based on maximum radius.
- **Memory needed to store the QuadTree**
  - For each place, if we cache only LocationID and Latitude/LOngitude, we need: 24 * 500 M = 12 GB.
  - Given each grid can have maximum of 500 places, and we have 500 M locations, total grids = 500 M / 500 = 1 M grids.
  - So, number of leaf nodes = 1 M and they will hold 12 GB of location data.
  - A QuadTree with 1 M leaf nodes will have approximately (1/3)rd internal nodes and each internal ndoe will have 4 pointers, for its children.
  - If each pointer is 8 bytes, then memory need to store all internal nodes: `1 M * 1/3 * 4 * 8 = 10 MB`
  - Total memory needed to hold whole QuadTree = 12.01 GB
- **Inserting a new Place into the system**
  - Insert into d/b as well as QuadTree.
  - If QuadTree is partitioned and distributed across multiple servers, would need to find the grid/server of the new Place and add it there.

## Data Partitioning

- **Sharding based on regions**
  - All places belonging to a region will be stored on a fixed node.
  - Issues:
    - If a region becomes hot, will lead to hotspots and effect performance of the service.
    - Over time, some regions can end up storing more places than others. Maintaining a uniform distribution of places, while regions are growing is quite difficult.
  - To recover from these situations, either we have to repartition our data or use consistent hashing.
- **Sharding based on LocationID**
  - Hash function will map each LocationID to a server where that place will be stored.
  - While building the QuadTree, we will iterate through all the places and calculate the hash of each LocationID to find a server where it would be stored.
  - To find places near a location
    - Query all servers and each server will return a set of nearby places.
    - A centralized server will aggregate these results to return them to the user.
- **Different QuadTree structure on different partitions**
  - Probable, since there is no guarantee of equal number of places in any given grid on all partitions.
  - All servers will have approximately equal number of Places.
  - We will still be searching all the neighboring grids within the given radius on all partitions.

![high level design](https://raw.githubusercontent.com/tuliren/grokking-system-design/master/img/yelp-overview.png)

## Replication and Fault Tolerance

- Replicas of QuadTree servers as alternatives to data partitioning.
- To distribute read traffic, we can have replicas of each QuadTree server.
- Master-slave configuration where
  - slaves will serve read traffic.
  - All writes first go to the master and then gets replicated to slaves. This will be eventual consistency, but is acceptable.

## Cache

## Load Balancing (LB)

## Ranking
