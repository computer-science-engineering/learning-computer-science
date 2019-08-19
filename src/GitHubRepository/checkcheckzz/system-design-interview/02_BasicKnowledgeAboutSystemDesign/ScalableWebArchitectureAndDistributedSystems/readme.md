# Scalable Web Architecture and Distributed Systems

- [Scalable Web Architecture and Distributed Systems](#scalable-web-architecture-and-distributed-systems)
  - [1.1. Principles of Web Distributed Systems Design](#11-principles-of-web-distributed-systems-design)
  - [1.2. The Basics](#12-the-basics)
    - [Example: Image Hosting Application](#example-image-hosting-application)
      - [Services](#services)
      - [Redundancy](#redundancy)
  - [References](#references)

## 1.1. Principles of Web Distributed Systems Design

Below are some of the key principles that influence the design of large-scale web systems:

- **Availability**
  - The uptime of a website is absolutely critical to the reputation and functionality of many companies. For some of the larger online retail sites, being unavailable for even minutes can result in thousands or millions of dollars in lost revenue, so designing their systems to be constantly available and resilient to failure is both a fundamental business and a technology requirement.
  - High availability in distributed systems requires the careful consideration of
    - redundancy for key components
    - rapid recovery in the event of partial system failures
    - graceful degradation when problems occur.
- **Performance**
  - Website performance has become an important consideration for most sites. The speed of a website affects usage and user satisfaction, as well as search engine rankings, a factor that directly correlates to revenue and retention. As a result, creating a system that is optimized for fast responses and low latency is key.
- **Reliability**
  - A system needs to be reliable, such that a request for data will consistently return the same data.
  - In the event the data changes or is updated, then that same request should return the new data.
  - Users need to know that if something is written to the system, or stored, it will persist and can be relied on to be in place for future retrieval.
- **Scalability**
  - When it comes to any large distributed system, size is just one aspect of scale that needs to be considered. Just as important is the effort required to increase capacity to handle greater amounts of load, commonly referred to as the scalability of the system.
  - Scalability can refer to many different parameters of the system:
    - How much additional traffic can it handle.
    - How easy is it to add more storage capacity.
    - How many more transactions can be processed.
- **Manageability**
  - Designing a system that is easy to operate is another important consideration.
  - The manageability of the system equates to the scalability of operations
    - Maintenance
    - Updates
  - Things to consider for manageability are
    - The ease of diagnosing and understanding problems when they occur.
    - Ease of making updates or modifications.
    - How simple the system is to operate. (i.e., does it routinely operate without failure or exceptions?)
- **Cost**
  - Cost is an important factor.
  - Factors:
    - Hardware costs.
    - Software costs.
    - Other facets needed to deploy and maintain the system.
      - The amount of developer time the system takes to build.
      - The amount of operational effort required to run the system.
      - The amount of training required should all be considered.
  - Cost is the total cost of ownership.

Each of these principles provides the basis for decisions in designing a distributed web architecture. However, they also can be at odds with one another, such that achieving one objective comes at the cost of another. A basic example: choosing to address capacity by simply adding more servers (scalability) can come at the price of manageability (you have to operate an additional server) and cost (the price of the servers).

## 1.2. The Basics

When it comes to system architecture there are a few things to consider:

- what are the right pieces
- how these pieces fit together
- what are the right tradeoffs

Investing in scaling before it is needed is generally not a smart business proposition; however, some forethought into the design can save substantial time and resources in the future.

This section is focused on some of the core factors that are central to almost all large web applications:

- services
- redundancy
- partitions
- handling failure

Each of these factors involves choices and compromises, particularly in the context of the principles described in the previous section.

### Example: Image Hosting Application

For big sites that host and deliver lots of images, there are challenges in building an architecture that is

- cost-effective,
- highly available, and
- has low latency (fast retrieval).

For the sake of simplicity, let's assume that this application has two key parts:

- the ability to upload (write) an image to the server, and
- the ability to query for an image.

While we certainly want the upload to be efficient, we care most about having very fast delivery when someone requests an image (for example, images could be requested for a web page or other application). This is very similar functionality to what a web server or Content Delivery Network (CDN) edge server (a server CDN uses to store content in many locations so content is geographically/physically closer to users, resulting in faster performance) might provide.

Other important aspects of the system are:

- There is no limit to the number of images that will be stored, so storage scalability, in terms of image count needs to be considered.
- There needs to be low latency for image downloads/requests.
- If a user uploads an image, the image should always be there (data reliability for images).
- The system should be easy to maintain (manageability).
- Since image hosting doesn't have high profit margins, the system needs to be cost-effective

Figure 1.1 is a simplified diagram of the functionality.

![Figure 1.1: Simplified architecture diagram for image hosting application](http://www.aosabook.org/images/distsys/imageHosting1.jpg)

This architecture would be a good baseline but would not work for a large-scale application like Flickr or Instagram.

#### Services

- When considering scalable system design, it helps to decouple functionality and think about each part of the system as its own service with a clearly defined interface. This is known as Service-Oriented Architecture (SOA).
- For these types of systems, each service has its own distinct functional context, and interaction with anything outside of that context takes place through an abstract interface, typically the public-facing API of another service.
- Deconstructing a system into a set of complementary services decouples the operation of those pieces from one another.
- This abstraction helps establish clear relationships between the service, its underlying environment, and the consumers of that service.
- Creating these clear delineations
  - can help isolate problems
  - allows each piece to scale independently of one another.
- This sort of service-oriented design for systems is very similar to object-oriented design for programming.
- In our example, all requests to upload and retrieve images are processed by the same server; however, as the system needs to scale it makes sense to break out these two functions into their own services.
- Fast-forward and assume that the service is in heavy use; such a scenario makes it easy to see how longer writes will impact the time it takes to read the images (since they two functions will be competing for shared resources).
- Even if the upload and download speeds are the same (which is not true of most IP networks, since most are designed for at least a 3:1 download-speed:upload-speed ratio), read files will typically be read from cache, and writes will have to go to disk eventually (and perhaps be written several times in eventually consistent situations).
- Even if everything is in memory or read from disks (like SSDs), database writes will almost always be slower than reads. (Pole Position, an open source tool for DB benchmarking, <http://polepos.org/> and results <http://polepos.sourceforge.net/results/PolePositionClientServer.pdf>).
- Another potential problem with this design is that a web server like Apache or lighttpd typically has an upper limit on the number of simultaneous connections it can maintain (defaults are around 500, but can go much higher) and in high traffic, writes can quickly consume all of those.
- Since reads can be asynchronous, or take advantage of other performance optimizations like gzip compression or chunked transfer encoding, the web server can switch serve reads faster and switch between clients quickly serving many more requests per second than the max number of connections (with Apache and max connections set to 500, it is not uncommon to serve several thousand read requests per second).
- Writes, on the other hand, tend to maintain an open connection for the duration for the upload, so uploading a 1MB file could take more than 1 second on most home networks, so that web server could only handle 500 such simultaneous writes.

![Figure 1.2: Splitting out reads and writes](http://www.aosabook.org/images/distsys/imageHosting2.png)

- Splitting out reads and writes of images into their own services allows us to scale each of them independently (since it is likely we will always do more reading than writing), but also helps clarify what is going on at each point. Finally, this separates future concerns, which would make it easier to troubleshoot and scale a problem like slow reads.
- The advantage of this approach is that we are able to solve problems independently of one another.
  - They are free to optimize their own performance with service-appropriate methods (for example, queuing up requests, or caching popular images—more on this below).
  - From a maintenance and cost perspective each service can scale independently as needed.
- Of course, the above example can work well when you have two different endpoints (in fact this is very similar to several cloud storage providers' implementations and Content Delivery Networks).
- Flickr solves this read/write issue by distributing users across different shards such that each shard can only handle a set number of users, and as users increase more shards are added to the cluster (see the presentation on Flickr's scaling, <http://mysqldba.blogspot.com/2008/04/mysql-uc-2007-presentation-file.html>)
- Comparison
  - In the first example it is easier to scale hardware based on actual usage (the number of reads and writes across the whole system), whereas Flickr scales with their user base (but forces the assumption of equal usage across users so there can be extra capacity).
  - In the former an outage or issue with one of the services brings down functionality across the whole system (no-one can write files, for example), whereas an outage with one of Flickr's shards will only affect those users.
  - In the first example it is easier to perform operations across the whole dataset—for example, updating the write service to include new metadata or searching across all image metadata—whereas with the Flickr architecture each shard would need to be updated or searched (or a search service would need to be created to collate that metadata—which is in fact what they do).
- When it comes to these systems there is no right answer, but it helps to go back to the principles at the start of this chapter, determine the system needs (heavy reads or writes or both, level of concurrency, queries across the data set, ranges, sorts, etc.), benchmark different alternatives, understand how the system will fail, and have a solid plan for when failure happens.

#### Redundancy

- Losing data is seldom a good thing, and a common way of handling it is to create multiple, or redundant, copies.
- This same principle also applies to services. If there is a core piece of functionality for an application, ensuring that multiple copies or versions are running simultaneously can secure against the failure of a single node.
- Creating redundancy in a system can remove single points of failure and provide a backup or spare functionality if needed in a crisis. Typically orchestrated using failovers. Failover can happen automatically or require manual intervention.
- Another key part of service redundancy is creating a _shared-nothing architecture_.
  - With this architecture, each node is able to operate independently of one another and there is no central "brain" managing state or coordinating activities for the other nodes.
  - Advantages:
    - Helps a lot with scalability since new nodes can be added without special conditions or knowledge.
    - There is no single point of failure in these systems, so they are much more resilient to failure.

## References

1. [The Architecture of Open Source Applications (Volume 2): Scalable Web Architecture and Distributed Systems](http://www.aosabook.org/en/distsys.html)
