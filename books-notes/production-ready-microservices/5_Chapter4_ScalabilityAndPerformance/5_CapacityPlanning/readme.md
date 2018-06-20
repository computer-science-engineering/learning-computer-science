# Capacity Planning

To ensure that microservices can scale properly when traffic increases, we can perform scheduled capacity planning. The principles of capacity planning are pretty straightforward:

* determine the hardware needs of each microservice in advance,
* build the needs into the budget, and
* make sure that the required hardware is reserved.

To determine the hardware needs of each service, we can use

* the growth scales (both quantitative and qualitative),
* key business metrics and traffic predictions,
* the known resource bottlenecks and requirements, and
* historical data about the microservice’s traffic.

Once the hardware resources have been secured and dedicated to each microservice, capacity planning is complete.

Automating the majority of the capacity planning process away from development and operations teams cuts down on potential errors and failures, and a great way to accomplish this is to build and run a capacity planning self-service tool within the application platform layer of the microservice ecosystem.