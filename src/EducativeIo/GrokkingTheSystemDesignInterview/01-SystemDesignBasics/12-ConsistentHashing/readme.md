# Consistent Hashing

* Distributed Hash Table (DHT) is a fundamental component in distributed systems.
* Hash Tables need key, value and a hash function, where hash function maps the key to a location where the value is stored.

`index = hash_function(key)`

Given ‘n’ cache servers, an intuitive hash function would be ‘key % n’. It is simple and commonly used. But it has two major drawbacks:

* Not horizontally scalable. Whenever a new cache host is added to the system, all existing mappings will break.
* May not be load balanced, especially for non-uniformly distributed data.

In these situations consistent hashing is useful to improving the caching system.

## What is Consistent Hashing

* Allows distributing data across a cluster in such a way that will minimize reorganization when nodes are added or removed.
* Makes the caching system easier to scale up or scale down.
* In consistent hashing, when hash table is resized, i.e., new cache host is added, only k/n keys need to be remapped, where  k is the today number of keys and n is the total number of servers. In a caching system using "mod" as the hash function, all keys need to be remapped.
* In consistent hashing objects are mapped to the same host if possible.
* When a host is removed from the system, the objects on that host are shared by other hosts; and when a new host is added, it takes its share from a few hosts without touching others' shares.

## How it works

* Maps a key to an integer.
* Suppose the output of the hash function is in the range of [0, 256), and the integers in the range are placed on a ring such that the values are wrapped around. With this in mind, here is how it works:
  * Given a list of cache servers, hash them to integers in the range.
  * To map a key to a server,
    * Hash it to a single integer.
    * Move clockwise on the ring until finding the first cache it encounters.
    * That cache is the one that contains the key.
* To add a new server, keys that were originally residing at an existing server, usually close to the new one, will be split. Some of them will be shifted to the new server, while other keys will not be touched.
* To remove a cache or if a cache failed, all keys that were originally mapping to the server that failed will fall into a server that is usually closest to it, and only those keys need to be moved to the the other server, other keys will not be affected.
* Load balancing
  * Data is randomly distributed and so may not be uniform resulting in keys on caches being unbalanced.
  * To handle this, we can add virtual replicas for caches. Instead of mapping each cache to a single point on the ring, we map it to multiple points on the ring, i.e. replicas. This way, each cache is associated with multiple portions of the ring.
  * If the hash function results in uniform distribution, with or without replicas (increasing or otherwise), keys becomes balanced.