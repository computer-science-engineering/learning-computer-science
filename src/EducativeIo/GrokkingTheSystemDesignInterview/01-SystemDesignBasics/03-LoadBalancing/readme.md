# Load Balancing

* Load balancer (LB) is a critical piece of any distributed system.
* Used to distribute load across multiple resources according to some metric such as
  * random
  * round-robin
  * random with weighting for memory or CPU utilization
  * etc.
* If a server is not available to take new requests or is not responding or has elevated error rate, LB will stop sending traffic to such a server.

To utilize full scalability and redundancy, we can try to balance the load at each layer of the system. We can add LBs at three places:

* Between user and web server
* Between web servers and an internal platform layer, like application servers or cache servers
* Between internal platform layer and database.

```ascii

                                                                                                 Database Server
                                Web Server                   Application Server
                    +--+                             +---+                           +---+          +-----+
+----------+        |  |       +-----------+         |   |     +-----------+         |   |          |     |
|          |        |  +------->           +--------->   +----->           +--------->   +---------->     |
|          +------->+  |       +-----------+         |   |     +-----------+         |   |          +-----+
|          |        |  |                             |   |                           |   |
|          |        |  |                             |   |                           |   |
+----------+        |  |       +-----------+         |   |     +-----------+         |   |          +-----+
                    |  +------->           +--------->   +----->           +--------->   +---------->     |
   Client           +--+       +-----------+         |   |     +-----------+         |   |          |     |
                     LB                              +---+                           +---+          +-----+
                               Web Server             LB     Application Server       LB
                                                                                                 Database Server
```

There are many ways to implement load balancing.

## Smart Clients

* A smart client will take a pool of service hosts and balances loads across them.
* Detects hosts that are not responding and avoid sending requests their way.
* Detects recovered hosts and is able to add new hosts.
* Adding load balancing functionality into the database (cache, service, etc.) client is an option.
  * Easy to implement and manage specially when system is not large.
  * However, as system grows, LBs need to evolve into standalone servers.

## Hardware Load Balancers

* Expensive but high-performance solution. Eg.: Citrix NetScaler.
* Can solve wide range of problems, but very expensive and non-trivial to configure.
* Usually used only as first point of contact for user requests to infrastructure and then use other mechanisms (smart clients or hybrid approach) for load balancing traffic within internal network.

## Software Load Balancers

* Also called hybrid approach.
* HAProxy is a popular open source software LB.
* LB can be placed between client and server or between two server side layers.
* Each service we want to load balance can have a locally bound port (e.g., localhost:9000) on that machine, and the client will use this port to connect to the server.
* This port is, actually, managed by HAProxy; every client request on this port will be received by the proxy and then passed to the backend service in an efficient way (distributing load)
* HAProxy can run either on the machine where client is running or an intermediate server.
* Similarly, we can have proxies running between different server side components. 
* HAProxy manages health checks and will remove or add machines to those pools. It also balances requests across all the machines in those pools.
* It is recommended to start with a software load balancer and move to smart clients and/or hardware load balancing as need arises.