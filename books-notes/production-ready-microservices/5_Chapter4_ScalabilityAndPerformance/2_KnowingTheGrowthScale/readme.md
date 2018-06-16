# Knowing the Growth Scale

Determining how a microservice scales (at a very high level) is the first step toward understanding how to build and maintain a scalable microservice.

There are two aspects to knowing the growth scale of a microservice:

* qualitative growth scale, which comes from understanding where the service fits into the overall microservice ecosystem and which key high-level business metrics it will be affected by.
* quantitative growth scale, which is, as its name suggests, a well-defined, measurable, and quantitative understanding of how much traffic a microservice can handle.

## The Qualitative Growth Scale

The natural tendency when trying to determine the growth scale of a microservice is to phrase the growth scale in terms of requests per second (RPS) or queries per second (QPS) that the service can support, then predicting how many RPS/QPS will be made to the service in the future.

The term “requests per second” is generally used when talking about microservices, and “queries per second” when talking about databases or microservices that return data to clients, though in many cases they are interchangeable.

If the growth scale is calculated by only looking at the current levels of traffic and how the microservice handles the current traffic load, making any inferences about how much traffic the microservice can handle in the future runs the risk of being misguided. This can be mitigated by

* load tests which can present a more accurate picture of the scalability of the service.
* analyzing historical traffic data to see how the traffic level grows over time.