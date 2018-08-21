# Sharding or Data Partitioning

* Technique to break up a big database into many smaller parts.
* Improves
  * manageability
  * performance
  * availability
  * load balancing
* After a certain scale point, it is cheaper and more feasible to scale horizontally by adding more machines than to grow it vertically by adding beefier servers.

## Partitioning Methods

### Horizontal Partitioning

* We put different rows into different tables.
* Also called range based sharding since we would be storing different ranges of data in separate tables.
* Issue - if the value whose range is used for sharding isn’t chosen carefully, then the partitioning scheme will lead to unbalanced servers. For eg.: splitting locations based on their zip codes assumes that places will be evenly distributed across the different zip codes. Which is not true since there will me more places in thickly populated areas.

### Vertical Partitioning

* We divide data to store tables related to a specific feature on specific servers.
* Straightforward and low impact on application.
* Issue - if application experiences additional growth, then it may be necessary to further partition a feature specific DB across various servers.

### Directory Based Partitioning

* Create a lookup service which knows current partitioning scheme and abstracts it away from the DB access code.
* So, to find out where does a particular data entity resides, we query our directory server that holds the mapping between each tuple key to its DB server.
* This loosely coupled approach means we can perform tasks like adding servers to the DB pool or change our partitioning scheme without having to impact your application.

## Partitioning Criteria

### Key or Hash-based partitioning

* We apply a hash function to some key attribute of the entity we are storing, that yields the partition number.
* Ensures uniform allocation of data among servers.
* Issue - fixes total number of servers, since hash function may be function of total number of servers. So, changing total number of servers means changing the hash function which would require redistribution of data and downtime for the service. A workaround for this problem is to use Consistent Hashing.

### List partitioning

Each partition is assigned a list of values, so whenever we want to insert a new record, we will see which partition contains our key and then store it there.

### Round-robin partitioning

Very simple strategy that ensures uniform data distribution. With ‘n’ partitions, the ‘i’ tuple is assigned to partition (i mod n).

### Composite partitioning

* We combine any of above partitioning schemes to devise a new scheme.
* Eg: first applying a list partitioning and then a hash based partitioning.
* Consistent hashing could be considered a composite of hash and list partitioning where the hash reduces the key space to a size that can be listed.

## Common Problems of Sharding

* Certain extra constraints on the different operations that can be performed.
* Most of these constraints are due to the fact that operations across multiple tables or multiple rows in the same table, will no longer run on the same server.

### Joins and Denormalization

* Joins that span database shard are not performance efficient since data has to be compiled from multiple servers/machines.
* Common workaround for this problem is to denormalize the database so that queries that previously required joins can be performed from a single table.
* Service now has to deal with all the perils of denormalization such as data inconsistency.

### Referential integrity

* Trying to enforce data integrity constraints such as foreign keys in a sharded database can be extremely difficult.
* Applications that require referential integrity on sharded databases
  * often have to enforce it in application code since most relational databases do not support foreign keys constants across databases on different database servers.
  * have to run regular SQL jobs to clean up dangling references.

### Rebalancing

There could be many reasons we have to change our sharding scheme:

1. Data distribution is not uniform.
1. Lot of load on a shard.

In such cases,

* either we have to create more DB shards
* or have to rebalance existing shards, which means
  * the partitioning scheme changed and
  * all existing data moved to new locations.

This almost always implies incurring downtime.

Rebalancing, in these cases, becomes easier when using a directory based partitioning scheme, but that

* increases complexity of the system.
* creates single point of failure (the lookup service).