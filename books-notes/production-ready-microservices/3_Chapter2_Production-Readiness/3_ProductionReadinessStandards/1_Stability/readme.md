# Stability

To ensure availability, we need to carefully guard against this
instability that stems from increased developer velocity and the constant evolution of the microservice ecosystem.

A stable microservice is one in which development, deployment, the addition of new technologies, and the decommissioning and deprecation of microservices do not give rise to instability within and across the larger microservice ecosystem. We can determine stability requirements for each microservice to mitigate the negative side effects that may
accompany each change.

To mitigate any problems that may arise from the development cycle, stable development procedures can be put into place. To counteract any instability introduced by deployment, we can ensure our microservices are deployed carefully with proper staging, canary (a small pool of 2%–5% of production hosts), and production rollouts. To prevent the introduction of new technologies and the deprecation and decommissioning of old microservices from compromising the availability of other services, we can enforce stable introduction and deprecation procedures.

## STABILITY REQUIREMENTS

The requirements of building a stable microservice are:

* A stable development cycle
* A stable deployment process
* Stable introduction and deprecation procedures

The details of stability requirements are covered in Chapter 3, Stability and Reliability.