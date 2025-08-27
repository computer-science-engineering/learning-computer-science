# Scalability

one of the hallmarks of a successful microservice (and of a successful microservice ecosystem) is a steady increase in traffic.
Microservices need to be built in preparation for this growth, they need to accommodate it easily, and they need to be able to actively scale with it.

Scalability is essential for availability.

To ensure a microservice is scalable, we need to know both (1) its qualitative growth scale (e.g., whether it scales with page views or customer orders) and (2) its quantitative growth scale (e.g., how many requests per second it can handle).

The way a microservice handles traffic should also be scalable. It should be prepared for bursts of traffic, handle them carefully, and prevent them from taking down the service entirely.

any dependencies of the service should be alerted when increases in traffic are expected. Cross-team communication and collaboration are essential for scalability.

the way a microservice stores and handles data needs to be scalable as well.

## SCALABILITY REQUIREMENTS

The requirements of building a scalable microservice are:

* Well-defined quantitative and qualitative growth scales
* Identification of resource bottlenecks and requirements
* Careful, accurate capacity planning
* Scalable handling of traffic
* The scaling of dependencies
* Scalable data storage

The details of production-ready scalability requirements are covered in Chapter 4, Scalability and Performance.