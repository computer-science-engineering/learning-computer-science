# Key Benefits

- [Key Benefits](#key-benefits)
  - [Technology Heterogeneity](#technology-heterogeneity)
  - [Resilience](#resilience)

Many of these benefits of microservices can be laid at the door of any distributed system. Microservices, however, tend to achieve these benefits to a greater degree primarily due to how far they take the concepts behind distributed systems and service-oriented architecture.

## Technology Heterogeneity

With a system composed of multiple, collaborating services, we can decide to use different technologies inside each one. This allows us to pick the right tool for each job, rather than having to select a more standardized, one-size-fits-all approach that often ends up being the lowest common denominator.

For example, for a social network, we might store our users’ interactions in a graph-oriented database to reflect the highly interconnected nature of a social graph, but perhaps the posts the users make could be stored in a document-oriented data store, giving rise to a heterogeneous architecture.

With microservices, we are also able to adopt technology more quickly, and understand how new advancements may help us. With a system consisting of multiple
services, I have multiple new places in which to try out a new piece of technology. I
can pick a service that is perhaps lowest risk and use the technology there, knowing
that I can limit any potential negative impact.

Some organizations choose to place some constraints on language choices. Netflix and
Twitter, for example, mostly use the Java Virtual Machine (JVM) as a platform, as they have a very good understanding of the reliability and performance of that system. They also develop libraries and tooling for the JVM that make operating at scale much easier, but make it more difficult for non-Java-based services or clients. But neither Twitter nor Netflix use only one technology stack for all jobs, either. Another counterpoint to concerns about mixing in different technologies is the size. If I really can rewrite my microservice in two weeks, you may well mitigate the risks of embracing new technology.

Just like many things concerning microservices, it’s all about finding the right balance. We’ll discuss how to make technology choices in Chapter 2, which focuses on evolutionary architecture; and in Chapter 4, which deals with integration, you’ll learn how to ensure that your services can evolve their technology independently of each other without undue coupling.

## Resilience

A key concept in resilience engineering is the bulkhead. If one component of a system
fails, but that failure doesn’t cascade, you can isolate the problem and the rest of the system can carry on working. Service boundaries become your obvious bulkheads.

In a monolithic service, if the service fails, everything stops working. With a monolithic system, we can run on multiple machines to reduce our chance of failure, but with microservices, we can build systems that handle the total failure of services and degrade functionality accordingly.

To ensure our microservice systems can properly embrace this improved resilience, we need to understand the new sources of failure that distributed systems have to deal with. Networks can and will fail, as will machines. We need to know how to handle this, and what impact (if any) it should have on the end user of our software.

We’ll talk more about better handling resilience, and how to handle failure modes, in
Chapter 11.