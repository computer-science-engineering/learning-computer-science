# Failure Detection and Remediation

When a failure does happen, the goal of failure detection and remediation always needs to be the following: reduce the impact to users. Users could be another microservice (who is a client of the service) or an actual customer of the product (if the service in question is customer-facing).

If the failure in question was (or may have been) introduced into production by a new deployment, the single most effective way to reduce the impact to users when something is going wrong is to immediately roll back to the last stable build of the service.