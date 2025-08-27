# The Development Cycle

The stability and reliability of a microservice begins with the individual developer who is contributing code to the service.

Mitigating and resolving outages and failures caused by bugs in code usually entails nothing more than rolling back to the latest stable build, reverting whatever commit contained the bug, and re-deploying a new (bug-less) version of the code.

First, the developer makes a change to the code locally pulled from a central repository. Once the code has been committed to the central repository, the second step consists in having the change(s) reviewed carefully and thoroughly by other engineers on the team. If all
reviewers have approved the change(s), and all lint, unit, and integration tests have passed on a new build, the change can be merged into the repository. Then, can the new change be introduced into the deployment pipeline.

One way to ensure that all bugs are caught before they hit production is to run all lint, unit, integration, and end-to-end tests before the code review phase.