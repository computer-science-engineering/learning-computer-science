# Logging

Logging is the first component of production-ready monitoring. It begins and belongs in the codebase of each microservice. Describing the state of the microservice at any given time in the recent past is the ultimate goal of logging.

When faced with a problem, often the only way to determine the root cause of an incident or outage is to comb through the logs, discover the state of the microservice at the time of the outage, and figure out why the service failed in that state. Logging needs to be such that developers can determine from the logs exactly what went wrong and where things fell apart.

Note: Microservice versioning is often discouraged because it can lead to other (client) services pinning to specific versions of a microservice that may not be the best or most updated version of the microservice. Without versioning, determining the state of a microservice when a failure or outage occurred can be difficult, but thorough logging can prevent this from becoming a problem: if the logging is good enough that state of a microservice at the time of an outage can be sufficiently known and understood, the lack of versioning ceases to be a hindrance to quick and effective mitigation and resolution.

Determining precisely what to log is specific to each microservice. The best guidance is: log whatever information is essential to describing the state of the service at a given time. Host-level and infrastructure-level information won’t (and shouldn’t) be logged by the application itself, but by services and tools running the application platform. Some microservice-level key metrics and information, like hashed user IDs and request and response details can and should be located in the microservice’s logs.

Logs should never contain identifying information, such as names of customers, Social Security numbers, and other private data. They should never contain information that could present a security risk, such as passwords, access keys, or secrets. In most cases, even seemingly innocuous things like user IDs and usernames should not be logged unless encrypted.

At times, logging at the individual microservice level will not be enough. Tracking and logging requests and responses throughout the entire client and dependency chains from end-to-end
can illuminate important information about the system that would otherwise go unknown (such as total latency and availability of the stack). To make this information accessible and
visible, building a production-ready microservice ecosystem requires tracing each request through the entire stack.

Logs are data, and logging is expensive: they are expensive to store, they are expensive to access, and both storing and accessing logs comes with the additional cost associated with making expensive calls over the network.

Note: Avoid adding debugging logs in code that will be deployed to production — such logs are very costly. If any logs are added specifically for the purpose of debugging, developers should take great care to ensure that any branch or build containing these additional logs does not ever touch production.

Logging needs to be scalable, it needs to be available, and it needs to be easily accessible and searchable. To keep the cost of logs down and to ensure scalability and high availability, it’s often necessary to impose per-service logging quotas along with limits and standards on what information can be logged, how many logs each microservice can store, and how long the logs will be stored before being deleted.