# Dependencies

Building and running production-ready microservices requires developers to plan for dependency failures, to mitigate them, and to protect against them.

SLA for a microservice is dependent on its dependencies' SLAs. A stable and reliable microservice needs to mitigate dependency failures (and yes, not meeting an SLA is a failure!). This can be accomplished by having backups, fallbacks, caching, and/or alternatives for each dependency just in case they fail.

Before dependency failures can be planned for and mitigated, the dependencies of a microservice must be known, documented, and tracked. Any dependency that could harm a microservice’s SLA needs to be included in the architecture diagram and documentation of the microservice (see Chapter 7, Documentation and Understanding) and should be included on the service’s dashboard(s) (see Chapter 6, Monitoring).

All dependencies should be tracked by automatically creating dependency graphs for each service, which can be accomplished by implementing a distributed tracking system across all microservices in the organization.

Once all of the dependencies are known and tracked, the next step is to set up backups, alternatives, fallbacks, or caching for each dependency. The right way to do this is completely dependent on the needs of the service. Some examples include calling the endpoint of another service, requests that need to be sent to the dependency can be held in a queue when the dependency is unavailable, put caching for the dependency into place within the service: cache any relevant data so that any failures will be handled gracefully.

The type of cache most often used in these cases is a Least Recently Used (LRU) cache, in which relevant data is kept in a queue, and where any unused data is deleted when the cache’s queue fills up. This is known as defensive caching, and it is useful for protecting a microservice against the failures
of its dependencies: cache the information your microservice gets from its dependencies, and if the dependencies go down, the availability of your microservice will be unaffected.