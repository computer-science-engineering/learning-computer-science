# Principles of Building Stable and Reliable Microservices

Microservice architecture lends itself to fast-paced development. The freedom offered by microservices means that the ecosystem will be in a state of continuous change, never static, always evolving.

A stable microservice is one for which development, deployment, the adoption of new technologies, and the decommissioning or deprecation of other services do not give rise to instability across the larger microservice ecosystem.

A reliable microservice is one that can be trusted by other microservices and by the overall ecosystem.

Stability goes hand in hand with reliability because each stability
requirement carries with it a reliability requirement (and vice versa).

There are several things that can be done to ensure that a microservice is stable and reliable.

* A standardized development cycle can be implemented to protect against poor development practices.
* The deployment process can be designed so that changes to the code are forced to pass through multiple stages before being rolled out to all production servers.
* Dependency failures can be protected against.
* Health checks, proper routing, and circuit breaking can be built into the routing and discovery channels to handle anomalous traffic patterns.
* Finally, microservices and their endpoints can be deprecated and/or decommissioned without causing any failures for other microservices.

## A PRODUCTION-READY SERVICE IS STABLE AND RELIABLE

* It has a standardized development cycle.
* Its code is thoroughly tested through lint, unit, integration, and end-to-end testing.
* Its test, packaging, build, and release process is completely automated.
* It has a standardized deployment pipeline, containing staging, canary, and production phases.
* Its clients are known.
* Its dependencies are known, and there are backups, alternatives, fallbacks, and caching in place in case of failures.
* It has stable and reliable routing and discovery in place.