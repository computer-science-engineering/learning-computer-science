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