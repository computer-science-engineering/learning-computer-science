# Routing and Discovery

Ensure that communication and interaction between microservices is itself stable and reliable.

Layer 2 (the communication layer) of the microservice ecosystem (see Chapter 1, Microservices) must be built to perform in a way that protects against harmful traffic patterns and maintains trust across the ecosystem.

The relevant parts of the communication layer for stability and reliability (aside from the network itself) are service discovery, service registry, and load balancing.

The health of a microservice at both the host level and the service level as a whole should always be known. This means that health checks should be running constantly so that a request is never sent to an unhealthy host or service. Running health checks on a separate channel (not used for general microservice communication) is the easiest way to ensure that health checks aren’t ever compromised by something like a clogged network.

If an instance of a service on a host is unhealthy, the load balancers should no longer route traffic to it. If a microservice as a whole is unhealthy (with all health checks failing on either a certain percentage of hosts or all hosts in production), then traffic should no longer be routed to that particular microservice until the problems causing the health checks to fail are resolved.

A large number of unhandled exceptions should also lead to a service being marked
unhealthy, and circuit breakers should be put into place for these failures so that if a service experiences an abnormal amount of errors, no more requests will be sent to the service until the problem is resolved.

The key in stable and reliable routing and discovery is this: preserve the microservice ecosystem by preventing bad actors from serving production traffic and accepting requests from other microservices.