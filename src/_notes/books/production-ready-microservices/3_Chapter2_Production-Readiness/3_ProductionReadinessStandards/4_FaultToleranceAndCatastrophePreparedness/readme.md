# Fault Tolerance and Catastrophe-Preparedness

Even the simplest of microservices is a fairly complex system.

Microservices don’t live in isolation, but within dependency chains as part of a larger, incredibly complex microservice ecosystem.

Every microservice within the ecosystem must be fault tolerant and prepared for any catastrophe.

A fault-tolerant, catastrophe-prepared microservice is one that can withstand both internal and external failures.

Identifying failure and catastrophe scenarios is the first requirement of building a fault-tolerant, production-ready microservice.

Standardization of failure mitigation and resolution at the organizational level means that incidents and outages of individual microservices, infrastructure components, or the ecosystem as a whole need to be wrapped into carefully executed, easily understandable
procedures.

Making failures and catastrophes predictable means going one step further after identifying failure and catastrophe scenarios and planning for them. It means forcing the microservices, the infrastructure, and the ecosystem to fail in any and all known ways to test the availability
of the entire system. This is accomplished through various types of resiliency testing. Code testing (including unit tests, regression tests, and integration tests) is the first step in testing for resiliency. The second step is load testing, where microservices and infrastructure
components are tested for their ability to handle drastic changes in traffic. The last, most intense, and most relevant type of resiliency testing is chaos testing, in which failure scenarios are run (both scheduled and randomly) on production services to ensure that microservices and infrastructure components are truly prepared for all known failure scenarios.

## FAULT TOLERANCE AND CATASTROPHE-PREPAREDNESS REQUIREMENTS

The requirements of building a fault-tolerant microservice that is prepared for any catastrophe are:

* Potential catastrophes and failure scenarios are identified and planned for.
* Single points of failure are identified and resolved.
* Failure detection and remediation strategies are in place.
* It is tested for resiliency through code testing, load testing, and chaos testing.
* Traffic is managed carefully in preparation for failure.
* Incidents and outages are handled appropriately and productively.

The details of production-ready fault tolerance and catastrophe-preparedness requirements are covered in Chapter 5,
Fault Tolerance and Catastrophe-Preparedness.