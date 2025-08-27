# Failure Detection and Remediation

When a failure does happen, the goal of failure detection and remediation always needs to be the following: reduce the impact to users. Users could be another microservice (who is a client of the service) or an actual customer of the product (if the service in question is customer-facing).

If the failure in question was (or may have been) introduced into production by a new deployment, the single most effective way to reduce the impact to users when something is going wrong is to immediately roll back to the last stable build of the service. The same holds for changes to low-level configurations: treat configs like code, deploy them in various successive releases, and make sure that if a config change causes an outage,the system can quickly and effortlessly roll back to the last stable set of configurations.

A second strategy in case of failure is failing over to a stable alternative. If one of a microservice’s dependencies is down, this would mean sending requests to a different endpoint (if the endpoint is broken) or a different service (if the entire service is down). If it’s not possible to route to another service or endpoint, then there needs to be a way to queue or save the requests and hold them until problems with the dependency have been mitigated.

Detection needs monitoring. To cut out the potential and possibility for human error in failure remediation, all mitigation strategies need to be automated.