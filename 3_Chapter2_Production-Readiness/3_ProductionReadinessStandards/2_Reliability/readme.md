# Reliability

A reliable microservice is one that can be trusted by its clients, by its dependencies, and by the microservice ecosystem as a whole.

While stability is related to mitigating the negative side effects accompanying change, and reliability is related to trust, the two are inextricably linked. Each stability requirement also carries a reliability requirement alongside it: for example, developers should not only seek to have stable deployment processes, they should also ensure that each deployment is reliable from the point of view of one of their clients or dependencies.

We can make our deployment processes reliable by making sure that our integration tests are comprehensive and our staging and canary deployment phases are successful so that every change introduced into production can be trusted not to contain any errors that might compromise its clients and dependencies.

By building reliability into our microservices, we can protect their availability. We can cache data so that it will be readily available to client services, helping them protect their SLAs by making our own services highly available. To protect our own SLA from any problems with
the availability of our dependencies, we can implement defensive caching.

The last reliability requirement is related to routing and discovery. Availability requires that the communication and routing between different services be reliable: health checks should be accurate, requests and responses should reach their destinations, and errors should be handled carefully and appropriately.

## RELIABILITY REQUIREMENTS

The requirements of building a reliable microservice are:

* A reliable deployment process
* Planning, mitigating, and protecting against the failures of dependencies
* Reliable routing and discovery

The details of production-ready reliability requirements are covered in Chapter 3, Stability and Reliability.