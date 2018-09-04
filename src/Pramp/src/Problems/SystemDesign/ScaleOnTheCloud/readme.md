# Problem Definition

## Description

Many of today’s large scale concurrent systems rely on cloud computing platforms such as AWS or Google Cloud.

Describe how would you design a service using a common cloud computing platform such as AWS, to scale incrementally from supporting hundreds of users to millions of users.

For the purpose of the interview, assume the system generally receives user requests, does some processing, stores user data, and returns the results.

#####################

This editor is synced in real time with your peer.

Use it to share thoughts and resources, such as:

- Features scope
- API design
- Pseudo code for specific components
- Data model/schema
- Back-of-the-envelope calculations
- Reference links
- Link to whiteboard or diagram such as https://sketchboard.me/new

Good luck!

#####################

1. Assumptions

    1. Store data
    1. Read/write data - read/write queries.
    1. Design for 100s of users first.
    1. Re-design for millions of users.
    1. No UI
    1. Data has some patterns - non-blob data.
        1. Some data is metadata
        1. Some data is raw binary data

2. High-level abstractions

    1. API (read/write)
    1. Web server - host the EP(s)
    1. Storage

3. Design for 100s of users

    1. Storage solution
        1. SQL BE store for metadata
        1. Blob storage (Azure) or S3 (AWS)

    1. API hosting

        1. Web server will also host BL for API - read/write from BE storage.

    1. Testing for determining issues with increasing scale

        1. Need load testing.
        1. Need chaos testing - break the platform hosting the system - use platform (Azure/AWS) APIs to break items.

    1. Scale issues

        1. Web server connection limit
        1. Calls go all the way to BE storage - no fast in-memory caching.
        1. Issues with reliability
            1. What happens when a server goes down.
            1. What happens when BE storage is non-responsive.
            1. What happens when indeterminate transient problems happens - mostly network issues.

4. Calculations

    BE Storage - 10 GB.
    In-memory - 25% of BE storage.

5. Design for 1000s of users (high-level)

    1. Need more web servers (system gateways).
    1. Add LB before web server layer.
    1. Separate out BL into application servers.
    1. Add LB before application server layer.
    1. Add in-memory caching layer in app servers for storage.
        1. In-memory store will hold "hot" data.
        1. BE storage will hold "cold" data.
        1. "hot" - data that is being actively accessed.
        1. When data is not more "hot", flush to BE storage - LRU.
    1. No scaling at BE storage.

6. Design for millions of users

    1. Need more web servers (system gateways).
    1. Add LB before web server layer.
    1. Separate out BL into application servers.
    1. Add LB before application server layer.
    1. Add in-memory cache servers.
    1. Partitioning
        1. Both in-memory cache and BE storage
        1. Hash by UserId
        1. Implement range partitioning or consistent hashing at application server layer.
        1. Some logic in the in-memory caching servers to also correctly direct to the right BE storage partition.

    1. Async patterns using message brokers.
        1. API gateway that receives request and send request to MB.
        1. Message broker like Kafka or events hubs that receive all incoming requests.
        1. Queue/message processor services that take the MB message and send to BE services.
        1. When a message has been processed from the queue it will notify another service (ACK service) with the requests ID of the processed message. Catch - This is easy to do using web sockets, or some other protocol, using http - will have to use long polling.
        1. Does not provide data consistency guarantee!
        1. 1st ACK on request being queued. 2nd ACK on data in requests making it to BE store.

    1. AutoScaling
        1. Use Cloud provider solution - autos-scaling based on CPU, network I/O, memory, etc.
        1. Use some consensus algorithm platform like Azure SF, Apache Z.

## Notes

1. [Pramp - The Complete System Design Interviewer Guide](https://medium.com/@pramp/the-complete-system-design-interviewer-guide-e5d273724db8)
1. [GitHub - Donne Martin system-design-primer](https://github.com/donnemartin/system-design-primer/tree/master/solutions/system_design/scaling_aws#design-a-system-that-scales-to-millions-of-users-on-aws)