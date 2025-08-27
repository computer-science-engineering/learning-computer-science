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

However note that that microservices do not live alone but as part of a larger ecosystem.

Qualitative growth scales allow the scalability of a service to tie in with higher-level business metrics: a microservice may, for example, scale with the number of users, with the number of people who open a phone application (“eyeballs”), or with the number of orders (for a food delivery service). These are not tied to an individual microservice but to  overall system or product(s).

There are exceptions to the rules of qualitative growth scales. Very complicated further down the service stack.  Internal tools tend to suffer from these complications. Internal tools can scale with, for example, number of deployments, number of services, number of logs aggregated, or gigabytes of data. These are more complicated because of the inherent difficulty in predicting these numbers, but they must be just as straightforward and predictable as the growth scales of microservices higher in the stack.

## The Quantitative Growth Scale

This is where RPS/QPS and similar metrics come into play. The quantitative growth scale is defined by translating the qualitative growth scale into a measurable quantity. For example, if the qualitative growth scale of our microservice is measured in “eyeballs” (e.g., how many people open a phone application), and each “eyeball” results in two requests to our microservice and one database transaction, then our quantitative growth scale is measured in terms of requests and transactions, resulting in requests per second and transactions per second as the two key quantities determining our scalability.

----

Growth scale will be used when making predictions about the service’s operational costs, hardware needs, and limitations.