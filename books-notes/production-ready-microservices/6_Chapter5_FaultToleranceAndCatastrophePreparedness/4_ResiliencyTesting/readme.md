# Resiliency Testing

In order to be truly fault tolerant, a microservice must be able to experience failures and recover from them gracefully without affecting their own availability, the availability of their clients, and the availability of the overall microservice ecosystem. The single best way to ensure that a microservice is fault tolerant is to take all of the possible
failure scenarios that it could be affected by, and then actively, repeatedly, and randomly push it to fail in production — a practice known as resiliency testing.

A resilient microservice is one that can experience and recover from failures at every level of the microservice ecosystem: the hardware layer (e.g., a host or datacenter failure), the communication layer (e.g., RPC failures), the application layer (e.g., a failure in the deployment pipeline), and in the microservice layer (e.g., failure of a dependency, a bad deployment, or a sudden increase in traffic).

The first type of resiliency testing we will look at is code testing, which is comprised of four types of tests that check syntax, style, individual components of the microservice, how the components work together, and how the microservice performs within its complex dependency chains. Code testing usually isn’t considered part of the resiliency testing suite, but it is important two reasons: first, since it is crucial for fault tolerance and catastrophe-preparedness; second, development teams have preferred to keep all testing information in one place.

The second is load testing, in which microservices are exposed to higher traffic loads to see how they behave under increased traffic.

The third type of resiliency testing is chaos testing, which is the most important type of resiliency testing, in which microservices are actively pushed to fail in production.

## Code Testing

In microservice architecture, code testing needs to be run at every layer of the ecosystem, both within the microservices and on any system or service that lives in the layers below: in addition to microservices, service discovery, configuration management, and related systems also need to have proper code testing in place.

### Lint tests

Syntax and style errors are caught using lint testing. For ensuring language-specific (and sometimes team-specific or organization-specific) style guidelines.

### Unit tests

Small and independent tests that are run over various small pieces (or units) of the microservice’s code. While unit testing is good, it’s not good enough to evaluate the actual ways in which the microservice will behave in production.

### Integration tests

Tests how the entire service works. In integration testing, all of the smaller components of the microservice (which were testing individually using unit tests) are combined and tested together to make sure that they
work as expected when they need to work together.

### End-to-end tests

Evaluates the behavior of the microservice with respect to its clients and dependencies. This means that  developers need to build end-to-end tests that

* run just like real production traffic,
* that hit the endpoints of their microservice’s clients,
* hit their own microservice’s endpoints,
* hit the endpoints of the microservice’s dependencies,
* send read requests to any databases, and
* catch any problems in the request flow that might have been introduced with a code change.

### Automating code tests

All four types of code tests (lint, unit, integration, and end-to-end) should be written by the development team, but running them should be automated as part of the development cycle and the deployment pipeline. Unit and integration tests should run during the development cycle on an external build system, right after changes have made it through the code review process. If the new code changes fail any unit or integration tests, then they should not be introduced into the deployment pipeline as a candidate for production, but should be rejected and brought to the attention of the development team for repair. If the new code changes pass all unit and integration tests, then the new build should be sent to the deployment pipeline as a candidate for production.

### SUMMARY OF CODE TESTING

The four types of production-ready code testing are:

* Lint tests
* Unit tests
* Integration tests
* End-to-end tests

## Load Testing

A production-ready microservice needs to be both scalable and performant. It needs to handle a large number of tasks or requests at the same time and handle them efficiently, and it also must be prepared for tasks or requests to increase in the future.

To protect against any scalability-related incidents and outages, and to be fully prepared for future increases in traffic, we can test the scalability of our services using load testing.

### Fundamentals of load testing

A way to test how a microservice behaves under a specific traffic load. If the microservice fails or experiences any issues during load testing, its developers will be able to resolve any scalability issues that appear in load tests.