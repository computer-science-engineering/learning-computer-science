# Evaluate Your Microservice

## The Development Cycle

* Does the microservice have a central repository where all code is stored?
* Do developers work in a development environment that accurately reflects the state of production (e.g., that accurately reflects the real world)?
* Are there appropriate lint, unit, integration, and end-to-end tests in place for the microservice?
* Are there code review procedures and policies in place?
* Is the test, packaging, build, and release process automated?

## The Deployment Pipeline

* Does the microservice ecosystem have a standardized deployment pipeline?
* Is there a staging phase in the deployment pipeline that is either full or partial staging?
* What access does the staging environment have to production services?
* Is there a canary phase in the deployment pipeline?
* Do deployments run in the canary phase for a period of time that is long enough to catch any failures?
* Does the canary phase accurately host a random sample of production traffic?
* Are the microservice’s ports the same for canary and production?
* Are deployments to production done all at the same time, or incrementally rolled out?
* Is there a procedure in place for skipping the staging and canary phases in case of an emergency?

## Routing and Discovery

* Are health checks to the microservice reliable?
* Do health checks accurately reflect the health of the microservice?
* Are health checks run on a separate channel within the communication layer?
* Are there circuit breakers in place to prevent unhealthy microservices from making requests?
* Are there circuit breakers in place to prevent production traffic from being sent to unhealthy hosts and microservices?

## Deprecation and Decommissioning

* Are there procedures in place for decommissioning a microservice?
* Are there procedures in place for deprecating a microservice’s API endpoints?