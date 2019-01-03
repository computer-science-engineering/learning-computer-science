# Efficient Use of Resources

Useful abstractions - treat properties of hardware and infrastructure systems as resources. CPU, memory, data storage, and the network are similar to resources in the natural world: they are finite, they are physical objects
in the real world, and they must be distributed and shared between various key players in  ecosystem.

The organizational challenge of resource allocation and distribution can be alleviated by giving business-critical microservices a greater share of the resources.

The technical challenge of resource allocation and distribution presents some difficulty, because many decisions need to be made about the first layer (the hardware layer) of  microservice ecosystem. Many engineering organizations opt to share hardware among multiple microservices, and each host will run several different services.

Care must be taken to ensure that the microservices are sufficiently isolated and don’t compromise the performance, efficiency, or availability of their neighboring microservices. Containerization (using Docker) along with resource isolation can help prevent microservices from being harmed by badly behaved neighbors.

One of the most effective ways to allocate and distribute hardware resources across a microservice ecosystem is to fully abstract away the notion of a host and replace it with hardware resources using resource abstraction technologies like Apache Mesos. Using this level of resource abstraction allows resources to be allocated dynamically, eliminating many
of the pitfalls associated with resource allocation and distribution in large-scale distributed systems like microservice ecosystems.