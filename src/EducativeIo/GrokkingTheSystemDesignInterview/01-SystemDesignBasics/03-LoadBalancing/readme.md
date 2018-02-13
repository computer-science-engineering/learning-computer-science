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