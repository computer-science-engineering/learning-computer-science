# 1. Distributed systems at a high level

- [1. Distributed systems at a high level](#1-distributed-systems-at-a-high-level)
  - [What we want to achieve: Scalability and other good things](#what-we-want-to-achieve-scalability-and-other-good-things)
    - [Performance (and latency)](#performance-and-latency)

_Distributed programming is the art of solving the same problem that you can solve on a single computer using multiple computers._ (usually because the problem no longer fits on a single computer)

Basic tasks that any computer system needs to accomplish:

- storage
- computation

The key for any system is to find the right place on some real-world cost-benefit curve. At a small scale, upgrading hardware is a viable strategy. However, as problem sizes increase there will be a point where either the hardware upgrade that allows solving the problem on a single node does not exist, or becomes cost-prohibitive. At that point, we move into the domain of distributed systems.

It is a current reality that the best value is in mid-range, commodity hardware - as long as the maintenance costs can be kept down through fault-tolerant software.

Computations primarily benefit from high-end hardware to the extent to which they can replace slow network accesses with internal memory accesses. The performance advantage of high-end hardware is limited in tasks that require large amounts of communication between nodes. [Barroso, Clidaras & Hölzle](http://www.morganclaypool.com/doi/abs/10.2200/S00516ED2V01Y201306CAC024)

Ideally, adding a new machine would increase the performance and capacity of the system linearly. But of course this is not possible, because there is some overhead that arises due to having separate computers. Data needs to be copied around, computation tasks have to be coordinated and so on. This is why it's worthwhile to study distributed algorithms - they provide efficient solutions to specific problems, as well as guidance about what is possible, what the minimum cost of a correct implementation is, and what is impossible.

## What we want to achieve: Scalability and other good things

Informally speaking, in a scalable system as we move from small to large, things should not get incrementally worse. As per Wikipedia, [scalability](http://en.wikipedia.org/wiki/Scalability) is the ability of a system, network, or process, to handle a growing amount of work in a capable manner or its ability to be enlarged to accommodate that growth.

What is it that is growing?

- Size scalability: adding more nodes should make the system linearly faster; growing the dataset should not increase latency.
- Geographic scalability: it should be possible to use multiple data centers to reduce the time it takes to respond to user queries, while dealing with cross-data center latency in some sensible manner.
- Administrative scalability: adding more nodes should not increase the administrative costs of the system (e.g. the administrators-to-machines ratio).

Of course, in a real system growth occurs on multiple different axes simultaneously; each metric captures just some aspect of growth.

A scalable system is one that continues to meet the needs of its users as scale increases. There are two particularly relevant aspects - performance and availability - which can be measured in various ways.

### Performance (and latency)

[Performance](http://en.wikipedia.org/wiki/Computer_performance) is characterized by the amount of useful work accomplished by a computer system compared to the time and resources used.

Depending on the context, this may involve achieving one or more of the following:

- Short response time/low latency for a given piece of work
- High throughput (rate of processing work)
- Low utilization of computing resource(s)

There are tradeoffs involved in optimizing for any of these outcomes. For example, a system may achieve a higher throughput by processing larger batches of work thereby reducing operation overhead. The tradeoff would be longer response times for individual pieces of work due to batching.

Etymology of the word Latency: The state of being latent; delay, a period between the initiation of something and the occurrence.

And what does it mean to be "latent"? From Latin latens, latentis, present participle of lateo ("lie hidden"). Existing or present but concealed or inactive.

This highlights how latency is really the time between when something happened and the time it has an impact or becomes visible. The time during which something that has already happened is concealed from view.

Let's assume for a moment that our distributed system does just one high-level task: given a query, it takes all of the data in the system and calculates a single result. In other words, think of a distributed system as a data store with the ability to run a single deterministic computation (function) over its current content:

`result = query(all data in the system)`

Then, what matters for latency is not the amount of old data, but rather the speed at which new data "takes effect" in the system. For example, latency could be measured in terms of how long it takes for a write to become visible to readers.

The other key point based on this definition is that if nothing happens, there is no "latent period". A system in which data doesn't change doesn't (or shouldn't) have a latency problem.

In a distributed system, there is a minimum latency that cannot be overcome: the speed of light limits how fast information can travel, and hardware components have a minimum latency cost incurred per operation (think RAM and hard drives but also CPUs).

How much that minimum latency impacts your queries depends on the nature of those queries and the physical distance the information needs to travel.