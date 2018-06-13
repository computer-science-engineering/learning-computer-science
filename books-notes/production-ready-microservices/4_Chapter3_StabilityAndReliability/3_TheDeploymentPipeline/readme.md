# The Deployment Pipeline

To ensure that things go wrong with less frequency, and that any failures can be caught before being rolled out to all production servers, introducing a standardized deployment pipeline across the engineering organization can help ensure stability and reliability across the ecosystem.

We can fit three separate stages or phases into this pipeline (Figure 3-2):

* first, we can test a new release in a staging environment;
* second, if it passes the staging phase, we can deploy it to a small canary environment, where it will serve 5%–10% of production traffic; * third, if it passes the canary phase, we can slowly roll it out to production servers until it has been deployed to every host.

## Staging

Any new release can first be deployed to a staging environment. A staging environment should be an exact copy of the production environment: it is a reflection of the state of the real world, but without real traffic.

The necessary staging capacity can be determined by the method we will use to test the microservice within the staging phase. To test in the staging environment, we have several options:

* we can run mock (or recorded) traffic through the microservice;
* we can test it manually by hitting its endpoints and evaluating its responses;
* we can run automated unit, integration, and other specialized tests;* we can test each new release with any combination of these methods.

Setting up staging environments in a microservice ecosystem can be difficult, due to the complexities introduced by dependencies. If your microservice depends on nine other microservices, then it relies on those dependencies to give accurate responses when requests are sent and reads or writes to the relevant database(s) are made. As a consequence of these complexities, the success of a staging environment hinges on the way staging is standardized across the company.

### Full Staging

A separate staging ecosystem is running as a complete mirror copy of the entire production ecosystem (though not necessarily with host
parity).

Staging environments in a full-staging ecosystem communicate only with the staging environments of other services.

Full staging also requires careful handling of test data: staging environments should never have write access to any production databases, and granting read access to production databases is discouraged as well. Because full staging is designed to be a complete mirror copy of production, every microservice staging environment should contain a separate test database that it can read from and write to.

Engineering organizations may need to require teams to coordinate and/or schedule deployments to staging to avoid the deployment of one service breaking the staging environment for all other related services.

### Partial staging

Not a complete mirror copy of the production environment. Rather, each microservice has its own staging environment, which is a pool of servers with (at the very least) staging-specific frontend and backend ports, and when new builds are introduced into the staging
phase, they communicate with the upstream clients and downstream dependencies that are running in production.

Partial staging deployments should hit all production endpoints of a microservice’s clients and dependencies to mimic the state of the actual world as accurately as possible.

Even though partial staging is restricted to read-only requests, production services can easily be taken down by bad staging deploys that send bad requests and/or overload production services with too many requests.

These types of staging environments should also be restricted to read-only database access: a staging environment should never write to a production database. However, some microservices may be very write-heavy, and testing the write functionality of a new build will
be essential. The most common way of doing this is to mark any data written by a staging environment as test data (this is known as test tenancy), but the safest way to do this is to write to a separate test database, since giving write access to a staging environment still runs the risk of altering real-world data.

Staging environments (full or partial) should have dashboards, monitoring, and logging just like production environments — all of which should be set up identically to the dashboards, monitoring, and logging of the production environment of the microservice.

Monitoring and logging for the staging environment should be identical to the monitoring and logging of the staging and production deployments so that any failures of tests and errors in new releases that are deployed to staging will be caught before they move to the next phase of the deployment pipeline.

When a bug is introduced by the code, it will usually be caught
in the staging environment (if it is set up correctly). Automated rollbacks of bad deploys are a necessity for partial staging environments (though are not required for full staging
environments). Establishing when to revert to a previous build should be determined by various thresholds on the microservice’s key metrics.

Since partial staging requires interacting with microservices running in production, bugs introduced by new releases deployed to a partial staging environment can bring down other microservices that are running in production. If there aren’t any automated rollbacks in place, mitigating and resolving these problems needs to be done manually. Any steps of the deployment process that need manual intervention are points of failure not only for the microservice itself, but for the entire microservice ecosystem.

The last question a microservice team needs to answer when setting up a staging environment is how long a new release should run on staging before it can be deployed to canary (and,
after that, to production). The answer to this question is determined by the staging-specific tests that are run on staging: a new build is ready to move to the next step of the deployment process as soon as all tests have passed without failing.