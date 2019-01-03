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

Load testing is where the growth scales and resource bottlenecks and requirements that were covered in Chapter 4, Scalability and Performance, come in handy. From a microservice’s qualitative growth scale and the associated high-level business metrics, development teams can learn how much traffic their microservice should be prepared to handle in the future. From the quantitative growth scale, developers will know exactly how many requests or queries per second their service will be expected to handle.  If the majority of the service’s resource bottlenecks and resource requirements have been identified, and the bottlenecks architected away, developers will know how to translate the quantitative growth scale (and, consequently, the quantitative aspects of future increases in traffic) into terms of the hardware
resources their microservice will require in order to handle higher traffic loads. Load testing after all of this, after applying the scalability requirements and working through them, can validate and ensure that the microservice is ready for the expected increase in traffic.

Load testing can be used the other way around, to discover the quantitative and qualitative growth scales, to identify resource bottlenecks and requirements, to ensure dependency scaling, to determine and plan for future capacity needs, and the like. When done well, load testing can give developers deep insight into the scalability (and scalability limitations) of their microservice.

### Running load tests in staging and production

Load testing is most effective when it is run on each stage of the deployment pipeline.

Load testing can be run in the staging phase of the deployment pipeline. If the deployment pipeline is
utilizing partial staging, where the staging environment communicates with production services, care needs to be taken to make sure that any load tests run in staging do not harm or compromise the availability of any production services that it communicates with. If the deployment pipeline contains full staging, which is a complete mirror copy of production and where no staging services communicate with any services in production, then care needs to be taken to make sure that load testing in full staging produces accurate results, especially if there isn’t host parity between staging and production.

It’s not enough to load test only in staging. Even the best staging environments — those that
are complete mirror copies of production and have full host parity — still are not production. Once you know the traffic load you need to hit, you’ve alerted all of the on-call rotations of the dependency teams, and you’ve tested your load tests in staging, you absolutely need to run load tests in production.

If your load tests send requests to other production services, be sure to alert all dependencies in order to avoid compromising their availability while running load tests.

Load testing in production can be dangerous and can easily cause a microservice and its dependencies to fail. Load testing is the way to explore the unknowns about a service and make sure that it is prepared for expected traffic growth. When a service is pushed to its limits in production, and things begin to break, there need to be automated pieces in place to make sure that any load tests can be quickly shut down. After the limitations of the service have been discovered and mitigated and the fixes have been tested and deployed, load testing can resume.

### Automating load testing

Ideally, a self-service load-testing tool and/or system should be part of the application platform layer of the microservice ecosystem, allowing developers to use a trusted, shared, automated, and centralized service.

Load testing should be scheduled regularly, and viewed as an integral component of the day-to-day function of the engineering organization. The scheduling should be linked to traffic patterns. If a centralized self-service load testing system is being used, it is incredibly useful to have an automated process for validating new tests, along with a suite of trusted (and required) tests that every service can run. In extreme cases, and when a self-service load testing tool is reliable, deployments can be blocked (or gated) if a microservice fails to perform adequately under load tests. Most importantly, every load test performed needs to be sufficiently logged and publicized internally so that any problems caused by load testing can quickly be detected, mitigated, and resolved.

### SUMMARY OF LOAD TESTING

Production-ready load testing has the following components:

* It uses a target traffic load that is calculated using the qualitative and quantitative growth scales and expressed in terms of RPS, QPS, or TPS.
* It is run in each stage of the deployment pipeline.
* Its runs are communicated to all dependencies.
* It is fully automated, is logged, and is scheduled.

## Chaos Testing

Code testing catches small potential failures at the individual microservice level, and load testing catches failures that arise from scalability limitations at the microservice level. To test for all failure scenarios, to make sure that microservices can gracefully recover from any potential catastrophe, there’s one additional type of resiliency testing that needs to be in place, and it’s known (quite appropriately) as chaos testing.

In chaos testing, microservices are actively pushed to fail in production, because the only way to make sure that a microservice can survive a failure is to make it fail all of the time, and in every way possible. That means that every failure scenario and potential catastrophe needs to be identified, and then is needs to be forced to happen in production. Running scheduled and random tests of each failure scenario and potential catastrophe can help mimic the real world of complex system failures.

Chaos testing must be well controlled in order to avoid chaos tests from bringing down the ecosystem. Make sure your chaos testing software has appropriate permissions, and that every single event is logged, so that if microservices are unable to gracefully recover (or if the chaos testing goes rogue), pinpointing and resolving the problems won’t require any serious sleuthing.

Chaos testing is best provided as a service, and not implemented in various ad hoc manners across development teams. Automate the testing, require every microservice to run a suite of both general and
service-specific tests, encourage development teams to discover additional ways their service can fail, and then give them the resources to design new chaos tests that push their microservices to fail in these new ways.

An open source solution like Simian Army (which comes with a standard suite of chaos tests that can be customized) will work for the majority of companies, but organizations with specific needs can easily build their own.

### EXAMPLES OF CHAOS TESTS

Some common types of chaos tests:

* Disable the API endpoint of one of a microservice’s dependencies.
* Stop all traffic requests to a dependency.
* Introduce latency between various parts of the ecosystem to mimic network problems: between clients and dependencies, between microservices and shared databases, between microservices and distributed task-processing systems, etc.
* Stop all traffic to a datacenter or a region.
* Take out a host at random by shutting down one machine.