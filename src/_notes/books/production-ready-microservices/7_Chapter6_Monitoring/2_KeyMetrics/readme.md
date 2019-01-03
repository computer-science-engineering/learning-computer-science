# Key Metrics

It’s important to identify precisely what we want and need to monitor. The key is identifying which properties of a microservice are necessary and sufficient for describing its behavior,
and then determining what changes in those properties tell us about the overall status and health of the microservice. We’ll call these properties key metrics.

There are two types of key metrics: host and infrastructure metrics, and microservice metrics. In terms of the four-layer model of the microservice ecosystem as described in Chapter 1, Microservices, host and infrastructure metrics are metrics belonging to layers 1–3, while microservice metrics are those belonging to layer 4.

Separating key metrics into these two different types is important both organizationally and technically. Host and infrastructure metrics often affect more than one microservice. Teams should monitor both types of key metrics (that is, all metrics relevant to their microservice), and any metrics relevant to multiple microservices should be monitored and shared between the appropriate teams.

The host and infrastructure metrics that should be monitored for each microservice are

* the CPU utilized by the microservice on each host,
* the RAM utilized by the microservice on each host,
* the available threads,
* the microservice’s open file descriptors (FD), and
* the number of database connections that the microservice has to any databases it uses.

Monitoring these key metrics should be done in such a way that the status of each metric is accompanied by information about the infrastructure and the microservice. This means that monitoring should be granular enough that developers can know the status of the keys metrics for their microservice on any particular host and across all of the hosts that it runs on.

Note: Some microservice ecosystems may use cluster management applications (like Mesos) in which the resources (CPU, RAM, etc.) are abstracted away from the host level. Host-level metrics won’t be available in the same way to developers in these situations, but all key metrics for the microservice overall should still be monitored by the microservice team.

Determining the necessary and sufficient key metrics at the microservice level is a bit more complicated because it can depend on the particular language that the microservice is written
in.

In addition to language-specific key metrics, we also must monitor

* the availability of the service,
* the service-level agreement (SLA) of the service,
* latency (of both the service as a whole and its API endpoints),
* success of API endpoints,
* responses and average response times of API endpoints,
* the services (clients) from which API requests originate (along with which endpoints they send requests to),
* errors and exceptions (both handled and unhandled), and
* the health and status of dependencies.

Importantly, all key metrics should be monitored everywhere that the application is deployed. This means that every stage of the deployment pipeline should be monitored. It almost goes without saying that all deployments to production servers should be monitored carefully, both in the canary and production deployment phases.

Once the key metrics for a microservice have been identified, the next step is to capture the metrics emitted by your service. Capture them, and then log them, graph them, and alert on
them.

## SUMMARY OF KEY METRICS

Host and infrastructure key metrics:

* CPU
* RAM
* Threads
* File descriptors
* Database connections

Microservice key metrics:

* Language-specific metrics
* Availability
* SLA
* Latency
* Endpoint success
* Endpoint responses
* Endpoint response times
* Clients
* Errors and exceptions
* Dependencies