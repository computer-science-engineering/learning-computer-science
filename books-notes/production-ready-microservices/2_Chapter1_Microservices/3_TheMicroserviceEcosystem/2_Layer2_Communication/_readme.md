# Layer 2: Communication

The communication layer bleeds into all of the other layers of the ecosystem (including the application platform and microservices layers)

## RPCs, endpoints, and messaging

...using a specified protocol, a microservice will send some data in a standardized format over the network to another service (perhaps to another microservice's API endpoint) or to a message broker which will make sure that the data is send to another microservice's API endpoint.

Forms of microservice communication:

1. HTTP+REST/THRIFT. The data is usually formatted and sent as JSON (or protocol buffers) over HTTP. The downside of adopting this paradigm is that it is, by necessity, synchronous (blocking).
1. messaging - asynchronous (non-blocking), but complicated. Microservice will send data (a message) over the network (HTTP or other) to a message broker, which will route the communication to other microservices.

Two most common flavors of messaging:

1. publish–subscribe (pubsub): clients will subscribe to a topic and will receive a message whenever a publisher publishes a message to that topic.
1. messaging and request–response messaging: a client will send a request to a service (or message broker), which will respond with the information requested.

There are some messaging technologies that are a unique blend of both models, like Apache Kafka. Celery and Redis (or Celery with RabbitMQ) can be used for messaging (and task processing) for microservices written in Python: Celery processes the tasks and/or messages using Redis or RabbitMQ as the broker.

Messaging - things to look out for - scalability challenges, points of failure for the entire ecosystem, race conditions and endless loops.

## Service discovery, service registry, and load balancing

...three technologies be implemented in the communication layer: service discovery, service registry, and load balancing.

service discovery (such as etcd, Consul, Hyperbahn, or ZooKeeper), which ensures that requests are routed to exactly where they are supposed to be sent and that (very importantly) they are only
routed to healthy instances.

service registry, which is a database that tracks all ports and IPs of all microservices across the ecosystem.

DYNAMIC SCALING AND ASSIGNED PORTS: In microservice architecture, ports and IPs can (and do) change all of the time, especially as microservices are scaled and re-deployed (especially with a hardware abstraction layer like Apache Mesos). One way to approach the discovery and routing is to assign static ports (both frontend and backend) to each microservice.

Load balancing will be needed at every location in the ecosystem in which a request is being sent to an application,
which means that any large microservice ecosystem will contain many, many layers of load balancing. Commonly used load balancers for this purpose are Amazon Web Services Elastic Load Balancer, Netflix Eureka, HAProxy, and Nginx.

## SUMMARY OF LAYER 2: THE COMMUNICATION LAYER

The communication layer (layer 2) of the microservice ecosystem contains:

* Network
* DNS
* Remote procedure calls (RPCs)
* Endpoints
* Messaging
* Service discovery
* Service registry
* Load balancing