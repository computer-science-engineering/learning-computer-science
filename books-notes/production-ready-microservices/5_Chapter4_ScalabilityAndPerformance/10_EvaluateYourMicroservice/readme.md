# Evaluate Your Microservice

## Knowing the Growth Scale

* What is this microservice’s qualitative growth scale?
* What is this microservice’s quantitative growth scale?

## Efficient Use of Resources

* Is the microservice running on dedicated or shared hardware?
* Are any resource abstraction and allocation technologies being used?

## Resource Awareness

* What are the microservice’s resource requirements (CPU, RAM, etc.)?
* How much traffic can one instance of the microservice handle?
* How much CPU does one instance of the microservice require?
* How much memory does one instance of the microservice require?
* Are there any other resource requirements that are specific to this microservice?
* What are the resource bottlenecks of this microservice?
* Does this microservice need to be scaled vertically, horizontally, or both?

## Capacity Planning

* Is capacity planning performed on a scheduled basis?
* What is the lead time for new hardware?
* How often are hardware requests made?
* Are any microservices given priority when hardware requests are made?
* Is capacity planning automated, or is it manual?

## Dependency Scaling

* What are this microservice’s dependencies?
* Are the dependencies scalable and performant?
* Will the dependencies scale with this microservice’s expected growth?
* Are dependency owners prepared for this microservice’s expected growth?

## Traffic Management

* Are the microservice’s traffic patterns well understood?
* Are changes to the service scheduled around traffic patterns?
* Are drastic changes in traffic patterns (especially bursts of traffic) handled carefully and appropriately?
* Can traffic be automatically routed to other datacenters in case of failure?

## Task Handling and Processing

* Is the microservice written in a programming language that will allow the service to be scalable and performant?
* Are there any scalability or performance limitations in the way the microservice handles  requests?
* Are there any scalability or performance limitations in the way the microservice processes tasks?
* Do developers on the microservice team understand how their service processes tasks, how efficiently it processes those tasks, and how the service will perform as the number
* of tasks and requests increases?

## Scalable Data Storage

* Does this microservice handle data in a scalable and performant way?
* What type of data does this microservice need to store?
* What is the schema needed for its data?
* How many transactions are needed and/or made per second?
* Does this microservice need higher read or write performance?
* Is it read-heavy, write-heavy, or both?
* Is this service’s database scaled horizontally or vertically? Is it replicated or partitioned?
* Is this microservice using a dedicated or shared database?
* How does the service handle and/or store test data?