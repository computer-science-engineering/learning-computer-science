# Key Characteristics of Distributed Systems

Include:

* Scalability
* Reliability
* Availability
* Efficiency
* Manageability

## Scalability

* Capability of a system, process or a network to grow and manage increased demand.
* A scalable systems needs to achieve scale without performance loss.
* some tasks may not be distributed, either because of their inherent atomic nature or because of some flaw in the system design. A scalable architecture avoids this situation and attempts to balance the load on all the participating nodes evenly.

**Horizontal vs. Vertical Scaling:** Horizontal scaling means that you scale by adding more servers into your pool of resources whereas Vertical scaling means that you scale by adding more power (CPU, RAM, Storage, etc.) to an existing server.

With horizontal-scaling (e.g.: Cassandra and MongoDB) it is often easier to scale dynamically. Vertical-scaling is usually limited to the capacity of a single server, scaling beyond that capacity often involves downtime and comes with an upper limit.

## Reliability

By definition, reliability is the probability a system will fail in a given period. In simple terms, a distributed system is considered reliable if it keeps delivering its services even when one or several of its software or hardware components fail. 

redundancy has a cost, and a reliable system has to pay that to achieve such resilience for services by eliminating every single point of failure.

## Availability

By definition, availability is the time a system remains operational to perform its required function, in a specific period. It is a simple measure of the percentage of time that a system, service, or a machine remains operational under normal conditions.

Reliability is availability over time considering the full range of possible real-world conditions that can occur.

### Reliability Vs. Availability

If a system is reliable, it is available. However, if it is available, it is not necessarily reliable. In other words, high reliability contributes to high availability, but it is possible to achieve a high availability even with an unreliable product by minimizing repair time and ensuring that spares are always available when they are needed.

## Efficiency

To understand how to measure the efficiency of a distributed system, let’s assume an operation that runs in a distributed manner, and delivers a set of items as result. Two standard measures of its efficiency are:

* the response time (or latency) that denotes the delay to obtain the first item, and
* the throughput (or bandwidth) which denotes the number of items delivered in a given time unit (e.g., a second).

The two measures correspond to the following unit costs:

* Number of messages globally sent by the nodes of the system, regardless of the message size.
* Size of messages representing the volume of data exchanges.

The complexity of operations supported by distributed data structures (e.g., searching for a specific key in a distributed index) can be characterized as a function of one of these cost units.

## Serviceability or Manageability

 Serviceability or manageability is the simplicity and speed with which a system can be repaired or maintained; if the time to fix a failed system increases, then availability will decrease.

 Things to consider for manageability are

* the ease of diagnosing and understanding problems when they occur,
* ease of making updates or modifications, and
* how simple the system is to operate (i.e., does it routinely operate without failure or exceptions?).