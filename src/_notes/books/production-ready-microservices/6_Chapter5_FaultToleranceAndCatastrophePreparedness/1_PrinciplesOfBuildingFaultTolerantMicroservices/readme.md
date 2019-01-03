# Principles of Building Fault-Tolerant Microservices

The reality of building large-scale distributed systems is that individual components can fail, they will fail, and they will fail often. These failures are made worse by the complex dependency chains within microservice ecosystems.

The only way to mitigate catastrophic failures and avoid compromising the availability of the entire system is to require each microservice within the ecosystem to be fault tolerant and prepared for any catastrophe.

* The first step involved in building a fault-tolerant, catastrophe-prepared microservice is to architect away single points of failure.
* Identifying failure scenarios is the next step. Fault tolerance and  catastrophe-preparedness require that a microservice withstand both internal failures (failures within the microservice itself) and external failures (failures within other layers of the ecosystem).
* The next step is to test for these failures to see whether or not the microservice can recover gracefully when these failures occur, and determine whether or not it is resilient. The resiliency of a service can be tested very thoroughly through code testing, load testing, and chaos testing. The only way to build a truly fault-tolerant microservice is to push it to fail in production by actively, repeatedly, and randomly failing each component that could cause the system to break.
* Failure detection and mitigation strategies need to be in place and should be standardized across each microservice team, and every new failure that a service experiences should be added to the resiliency testing suite to ensure it never happens again. Microservice teams also need to be trained to handle failures appropriately: dealing with outages and incidents (regardless of severity) should be standardized across the engineering organization.

## A PRODUCTION-READY SERVICE IS FAULT TOLERANT AND PREPARED FOR ANY CATASTROPHE

* It has no single point of failure.
* All failure scenarios and possible catastrophes have been identified.
* It is tested for resiliency through code testing, load testing, and chaos testing.
* Failure detection and remediation has been automated.
* There are standardized incident and outage procedures in place within the microservice development team and across the organization.