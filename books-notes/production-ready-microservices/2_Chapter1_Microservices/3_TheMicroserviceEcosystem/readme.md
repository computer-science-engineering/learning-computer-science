# The Microservice Ecosystem

In well-designed, sustainable microservice ecosystems, the microservices are abstracted away from all infrastructure. They are abstracted away from the hardware, abstracted away from
the networks, abstracted away from the build and deployment pipeline, abstracted away from service discovery and load balancing. This is all part of the infrastructure of the microservice ecosystem, and building, standardizing, and maintaining this infrastructure in a stable, scalable, fault-tolerant, and reliable way is essential for successful microservice operation.

In well-designed, sustainable microservice ecosystems, the microservices are abstracted away from all infrastructure -  hardware, networks, build and deployment pipeline, service discovery and load balancing.

Developing a microservice within a stable microservice ecosystem should be just like developing a small standalone application. This requires very sophisticated, top-notch infrastructure.

The microservice ecosystem can be split into four layers - Hardware, Communication, Application platform, Microservices. The first three layers are the infrastructure layers, the fourth (top) layer is where all individual microservices live.

## Layer 1: Hardware

Many different types of servers can live here: some are
optimized for databases; others for processing CPU-intensive tasks. These servers can either be owned by the company itself, or “rented” from so-called cloud providers like Amazon Web Services’ Elastic Compute Cloud (AWS EC2), Google Cloud Platform (GCP), or Microsoft Azure.

The majority of microservice ecosystems run some variant of Linux. Additional abstractions can be built and layered atop the hardware: resource isolation and resource abstraction (as offered by technologies like Docker and Apache Mesos) also belong in this layer, as do databases (dedicated or shared).

Installing an operating system and provisioning the hardware is the first layer on top of the servers themselves. Each host must be provisioned and configured, and after the operating system is installed, a configuration management tool (such as Ansible, Chef, or Puppet) should be used to install all of the applications and set all the necessary configurations.

The hosts need proper host-level monitoring (using something like Nagios) and host-level logging so that if anything happens (disk failure, network failure, or if CPU utilization goes
through the roof), problems with the hosts can be easily diagnosed, mitigated, and resolved.

### SUMMARY OF LAYER 1: THE HARDWARE LAYER

The hardware layer (layer 1) of the microservice ecosystem contains:

* The physical servers (owned by the company or rented from cloud providers)
* Databases (dedicated and/or shared)
* The operating system
* Resource isolation and abstraction
* Configuration management
* Host-level monitoring
* Host-level logging

## Layer 2: Communication

The communication layer bleeds into all of the other layers of the ecosystem (including the application platform and microservices layers)

### RPCs, endpoints, and messaging

...using a specified protocol, a microservice will send some data in a standardized format over the network to another service (perhaps to another microservice's API endpoint) or to a message broker which will make sure that the data is send to another microservice's API endpoint.

Forms of microservice communication:

1. HTTP+REST/THRIFT. The data is usually formatted and sent as JSON (or protocol buffers) over HTTP. The downside of adopting this paradigm is that it is, by necessity, synchronous (blocking).
1. messaging - asynchronous (non-blocking), but complicated. Microservice will send data (a message) over the network (HTTP or other) to a message broker, which will route the communication to other microservices.

Two most common flavors of messaging:

1. publish–subscribe (pubsub): clients will subscribe to a topic and will receive a message whenever a publisher publishes a message to that topic.
1. messaging and request–response messaging: a client will send a request to a service (or message broker), which will respond with the information requested.

There are some messaging technologies that are a unique blend of both models, like Apache Kafka. Celery and Redis (or Celery with RabbitMQ) can be used for messaging (and task processing) for microservices written in Python: Celery processes the tasks and/or messages using Redis or RabbitMQ as the broker.

Messaging - things to look out for - scalability challenges, points of failure for the entire ecosystem, race conditions and endless loops.

### Service discovery, service registry, and load balancing

...three technologies be implemented in the communication layer: service discovery, service registry, and load balancing.

service discovery (such as etcd, Consul, Hyperbahn, or ZooKeeper), which ensures that requests are routed to exactly where they are supposed to be sent and that (very importantly) they are only routed to healthy instances.

service registry, which is a database that tracks all ports and IPs of all microservices across the ecosystem.

DYNAMIC SCALING AND ASSIGNED PORTS: In microservice architecture, ports and IPs can (and do) change all of the time, especially as microservices are scaled and re-deployed (especially with a hardware abstraction layer like Apache Mesos). One way to approach the discovery and routing is to assign static ports (both frontend and backend) to each microservice.

Load balancing will be needed at every location in the ecosystem in which a request is being sent to an application,
which means that any large microservice ecosystem will contain many, many layers of load balancing. Commonly used load balancers for this purpose are Amazon Web Services Elastic Load Balancer, Netflix Eureka, HAProxy, and Nginx.

### SUMMARY OF LAYER 2: THE COMMUNICATION LAYER

The communication layer (layer 2) of the microservice ecosystem contains:

* Network
* DNS
* Remote procedure calls (RPCs)
* Endpoints
* Messaging
* Service discovery
* Service registry
* Load balancing

## Layer 3: The Application Platform

Contains all of the internal tooling and services that are independent of the microservices.

### Self-service internal development tools

TechOps teams will be responsible for layer 1, infrastructure teams will be responsible for layer 2, application platform teams will be responsible for layer 3, and microservice teams will be responsible for layer 4 (this is, of course, a very simplified view, but you get the general idea).

Within this organizational scheme, any time that an engineer working on one of the higher layers needs to set up, configure, or utilize something on one of the lower layers, there should be a self-service tool in place that the engineer can use.

In a diverse microservice ecosystem, the average engineer on any given team will have no (or very little) knowledge of how the services and systems in other teams work...

The second reason to build these tools and build them well is that, in all honesty, you do not want a developer from another team to be able to make significant changes to your service or system, especially not one that could cause an outage.

### The development cycle

...streamlining and standardizing the development process and automating away as much as possible.

...several things that need to be in place within the third layer of a microservice ecosystem in order for stable and reliable development to be possible.

The first requirement is a centralized version control system...

The second requirement is a stable, efficient development environment. The most stable and reliable way to design a development environment is to create a mirror of the production environment (one that is not staging, nor canary, nor production)
containing all of the intricate dependency chains.

### Test, build, package, and release

...between development and deployment ... should be standardized and centralized as much as possible.

### Deployment pipeline

Building tooling around deployment, and standardizing deployment practices for all development teams is often necessary.

### Logging and monitoring

All microservices should have microservice-level logging of all requests made to the microservice (including all relevant and important information) and its responses. Due to the fast-paced nature of microservice development, it’s often impossible to reproduce bugs in the code because it’s impossible to reconstruct the state of the system at the time of failure.

### SUMMARY OF LAYER 3: THE APPLICATION PLATFORM LAYER

The application platform layer (layer 3) of the microservice ecosystem contains:

* Self-service internal development tools
* Development environment
* Test, package, build, and release tools
* Deployment pipeline
* Microservice-level logging
* Microservice-level monitoring

## Layer 4: Microservices

This layer is where the microservices — and anything specific to them — live, completely abstracted away from the lower infrastructure layers. The only things that are not abstracted away from the microservice layer are the configurations specific to each service for using the tools.

...all microservice-specific configurations can live in the repository of the microservice and should be accessed there by the tools and systems of the layers below.

### SUMMARY OF LAYER 4: THE MICROSERVICE LAYER

The microservice layer (layer 4) of the microservice ecosystem contains:

* The microservices
* All microservice-specific configurations