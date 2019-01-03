# Principles of Microservice Scalability and Performance

Efficiency is of the utmost importance in real-world, large-scale distributed systems architecture.

Evaluating the efficiency and achieving greater efficiency in a large ecosystem of microservices is incredibly difficult. It’s also bounded by the laws of computer architecture and distributed systems, which place limits on the efficiency of large-scale, complex distributed systems: the more distributed your
system, and the more microservices you have in place within that system, the less of a difference the efficiency of one microservice will have on the entire system. Standardization of principles that will increase overall efficiency becomes a necessity. Two of our production-readiness standards — scalability and performance — help to achieve this overall efficiency, and increase the availability of the microservice ecosystem.

Scalability and performance are uniquely intertwined because of the effects they have on the efficiency of each microservice and the ecosystem as a whole. In order to  (see also Chapter 1, Microservices) build a scalable application, we need to design for concurrency and partitioning:

* concurrency allows each task to be broken up into smaller pieces,
* while partitioning is essential for allowing these smaller pieces to be processed in parallel.

So, while scalability is related to how we divide and conquer the processing of tasks, performance is the measure of how efficiently the application processes those tasks.

Where traffic is increasing steadily, each microservice needs to be able to scale with the entire system without suffering from performance problems.

To ensure that our microservices are scalable and performant, we need to require several things of each microservice.

* We need to understand its growth scale, both quantitative and qualitative, so that we can prepare for expected growth.
* We need to use our hardware resources efficiently, be aware of resource bottlenecks and requirements, and do appropriate capacity planning.
* We need to ensure that a microservice’s dependencies will scale with it.
* We need to manage traffic in a scalable and performant way.
* We need to handle and process tasks in a performant manner.
* Last but not least, we need to store data in a scalable way.

## A PRODUCTION-READY SERVICE IS SCALABLE AND PERFORMANT

* Its qualitative and quantitative growth scales are known.
* It uses hardware resources efficiently.
* Its resource bottlenecks and requirements have been identified.
* Capacity planning is automated and performed on a scheduled basis.
* Its dependencies will scale with it.
* It will scale with its clients.
* Its traffic patterns are understood.
* Traffic can be re-routed in case of failures.
* It is written in a programming language that allows it to be scalable and performant.
* It handles and processes tasks in a performant manner.
* It handles and stores data in a scalable and performant way.