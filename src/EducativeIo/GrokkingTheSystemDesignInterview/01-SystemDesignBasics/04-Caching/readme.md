# Caching

* Load balancing enables horizontal scaling across an ever-increasing number of servers.
* Caching enables much better use of available resources to meet product requirements.
* Caches take advantage of the locality of reference principle: recently requested data is likely to be requested again.
* Used in almost every layer of computing.
* Cache is like a short-term memory
  * limited amount of scape
  * typically faster than original data source
  * contains most recently accessed items
* Caches can exist at all levels in architecture, but often found nearest to front-end, to return data quickly without taxing downstream levels.

## Application server cache

* Placing a cache on request layer node enables local storage of response data.
* When a request is made, node will return local cached data if exists. If not, node will query data from disk.
* Cache could be both in memory (fast) and on local disk (faster than going to network storage).
* If the request layer is expanded to multiple nodes
  * it is still possible to have each node host its own cache.
  * But if LB randomly distributes requests across the nodes, the same request will go to different nodes, thus increasing cache misses. This can be resolved by using:
    * global caches
    * distributed caches

## Distributed cache

* Each node owns part of the cached data.
* Typically cache is divided using a consistent hashing function so that is a request node is looking for a certain piece of data it knows where to look within the distributed cache.
* So each node has a small piece of the cache, and will then send a request to another node for the data before going to the origin.
* This is advantageous in that cache space can be increased by simply adding nodes to the request pool.
* Disadvantage is in resolving missing node.
  * One workaround is storing multiple copies of the data on different nodes - but this gets complicates, specially when adding or removing modes from the request layer.
  * If a node disappears and part of the cache is lost, requests will just pull from the origin.

## Global cache

* All nodes use the same single cache space.
* Involves adding a server or file store of some sort, 
  * faster than origin store and
  * accessible by all request layer nodes.
* Can get complicated since easy to overwhelm a single cache as clients and requests increase.
* Very effective in some architectures such as
  * ones with specialized hardware that make this global cache very fast
  * Ones that have fixed dataset that needs to be cached.
* Two common forms of global cache
  * When a cached response is not found in the cache, the cache itself becomes responsible for retrieving the missing piece of data from the underlying/original store.
  * Request layer nodes are responsible to retrieve any data that is not found in the cache.
* Most applications use first type, where cache itself manages eviction and fetching of data to prevent a flood of requests for same data from clients.
* Second implementation would make more sense in certain cases such as
  * if cache is being used for large files, a low cache hit percentage would cause the cache buffer to become overwhelmed with cache misses; in this situation, it helps to have a large percentage of the total data set (or hot data set) in the cache.
  * an architecture where the files stored in the cache are static and should not be evicted (could be due to application latency requirements).

## Content Distribution Network (CDN)

* Relevant for sites serving large amounts of static data.
* In a typical CDN setup,
  * a request will first ask the CDN for a piece of static media
  * the CDN will serve that content if it has it locally available.
  * If it isn’t available, the CDN will query the back-end servers for the file and then
  * cache it locally and serve it to the requesting user.
* Initially is system does not necessitate a CDN, future transition can be eased by serving the static media off a separate subdomain (e.g. static.yourservice.com) using a lightweight HTTP server like Nginx, and cut-over the DNS from your servers to a CDN later.

## cache Invalidation
