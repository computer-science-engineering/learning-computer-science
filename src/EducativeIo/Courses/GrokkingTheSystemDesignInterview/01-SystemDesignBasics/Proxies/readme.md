# Proxies

* Proxy server is an intermediate piece of hardware/software that sits between client and back-end server.
* Typically proxies are used to
  * filter requests
  * log requests
  * transform requests by
    * adding/removing headers
    * encrypting/decrypting
    * compression
* One advantage of proxy server is that its cache can serve a lot of requests.
* Also useful for coordinating requests from multiple servers and can be used to optimize request traffic from a system-wide perspective. Eg.: collapse the same (or similar) data access requests into one request and then return the single result to the user; this scheme is called collapsed forwarding.
* Another use for proxy is to collapse requests for data that is spatially close together in the storage (consequently on disk). This will result in decreasing request latency.
* Proxies are useful under high load situations or when there is limited caching since proxies can mostly batch several requests into one.