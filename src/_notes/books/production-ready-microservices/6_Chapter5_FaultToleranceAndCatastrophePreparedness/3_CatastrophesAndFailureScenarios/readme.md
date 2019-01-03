# Catastrophes and Failure Scenarios

Catastrophes happen all of the time: racks fail in datacenters, HVAC systems break, production databases are deleted by accident (yes, this happens more than most developers would like to admit), natural disasters wipe out entire datacenters. Any failure that can happen will happen: dependencies will fail, individual servers will fail, libraries will become corrupted or lost entirely, monitoring will fail, logs can and will be lost (seemingly vanishing into thin air).

We can separate types of failures and catastrophes into four main categories, organizing them using their place in the microservice ecosystem stack. The most common catastrophes and failure scenarios are hardware failures, infrastructure (communication-layer and application- platform-layer) failures, dependency failures, and internal failures.

## Common Failures Across an Ecosystem

Failures are usually caused (in some way or other) by the lack of standardization across an engineering organization, because they tend to be operational (and not necessarily technical) in nature. Of these types of failures, the most common are insufficient design reviews of system and service architecture, incomplete code reviews, poor development processes, and unstable deployment procedures.

Insufficient design reviews of system and microservice architecture lead to poorly designed services, especially within large and complex microservice ecosystems. Scheduled reviews of the architecture with experts from each part of the organization can help to ensure that the system or microservice is up-to-date and fits into the overall ecosystem appropriately. For more details on architecture reviews, see Chapter 7, Documentation and Understanding.

Incomplete code reviews are another common source of failure. Care needs to be taken to write extensive tests for each system and service, to test each new change extensively before it hits production, and to ensure that, if bugs aren’t caught before they are deployed, they’re caught elsewhere in the development process or in the deployment pipeline.

One of the leading causes of outages in microservice ecosystems are bad deployments. “Bad” deployments are those that contain bugs in the code, broken builds, etc. Putting good code review procedures into place, and creating an engineering culture where both code review is taken seriously and developers are given adequate time to focus on reviewing their teammates’
code is the first step toward avoiding these kinds of failures. However, the only way to catch these failures before they bring the system or service down is to build stable and reliable development processes and deployment pipelines. The details of building stable and reliable development processes and deployment pipelines are covered in Chapter 3, Stability and Reliability.

### SUMMARY: COMMON FAILURES ACROSS AN ECOSYSTEM

The most common failures that happen across all levels of microservice ecosystems are:

* Insufficient design reviews of system and service architecture
* Incomplete code reviews
* Poor development processes
* Unstable deployment procedures

## Hardware Failures

The lowest layer of the stack is where the hardware lies. Tt is the layer that genuine catastrophes (and not just failures) affect the most. 

The catastrophes that happen here are pure hardware failures: a machine dies or fails in some way, a rack goes down, or an entire datacenter fails.

Everything else within this layer that lies on top of the bare machines can fail, too.

* Machines need to be provisioned before anything can run on them, and if provisioning fails, then utilizing any new machines (or, in some cases, even old machines) won’t be able to happen.
* Many microservice ecosystems that utilize technologies that support resource isolation (like Docker) or resource abstraction and allocation (like Mesos and Aurora) can also break or fail, and their failures can bring the entire ecosystem to a halt.
* Failures caused by broken configuration management or configuration changes are extraordinarily common as well, and are often difficult to detect.
* Monitoring and logging can fail miserably here as well, and if host-level monitoring and logging fails in some way, triaging any outages becomes impossible because the data needed to mitigate any problems won’t be available.
* Network failures (both internal and external) can also happen.
* Finally, operational downtimes of critical hardware components — even if communicated properly throughout the organization — can lead to outages across the ecosystem.

### SUMMARY: COMMON HARDWARE FAILURE SCENARIOS

Some of the most common hardware failure scenarios are:

* Host failure
* Rack failure
* Datacenter failure
* Cloud provider failure
* Server provisioning failure
* Resource isolation and/or abstraction technology failure
* Broken configuration management
* Failures caused by configuration changes
* Failures and gaps in host-level monitoring
* Failures and gaps in host-level logging
* Network failure
* Operational downtimes
* Lack of infrastructure redundancy

## Communication-Level and Application Platform–Level Failures

These layers live between the hardware and the microservices, bridging the two as the glue that holds the ecosystem together.

The communication layer contains

* the network,
* DNS,
* the RPC framework,
* endpoints,
* messaging,
* service discovery,
* service registry, and
* load balancing.

The application platform layer is comprised of

* the self-service development tools,
* development environment,
* test and package and release and build tools,
* the deployment pipeline,
* microservice-level logging, and
* microservice-level monitoring

Within the communication layer, network failures are especially common.

* These can be failures of the internal network(s) that all remote procedure calls are made over, or failures of external networks.
* Problems with firewalls and improper iptables entries.

DNS errors are also quite common.

The RPC layer of communication is another source of failure, especially when there is only one channel connecting all microservices and internal systems. Setting up separate channels for RPC and health checks can mitigate this problem a bit if health checks and other related monitoring is kept separate from channels that handle data being passed between services.

It’s possible for messaging systems to break (Redis-Celery example earlier in this chapter), and messaging queues, message brokers, and task processors often live in microservice ecosystems without any backups or alternatives.

Failures of service discovery, service registry, and load balancing can (and do) happen as well: if any
part of these systems breaks or experiences downtime without any alternatives, then traffic won’t be routed, allocated, and distributed properly.

Failures within the application platform are more specific to the way that engineering organizations have set up their development process and deployment pipeline. If development tools and/or environments are working incorrectly when developers are trying to build new features or repair existing bugs, bugs and new failure modes can be introduced into production. The same goes for any failures or shortcomings of the test, package, build, and release pipelines. If the deployment pipeline is unavailable, buggy, or fails outright, then deployment will grind to a halt, preventing not only deployment of new features but of critical bug-fixes that may be in the works. Finally, monitoring and logging of individual microservices can contain gaps or fail as well, making triaging or logging any issues impossible.

### SUMMARY: COMMON COMMUNICATION AND APPLICATION PLATFORM FAILURES

Some of the most common communication and application platform failures are:

* Network failures
* DNS errors
* RPC failures
* Improper handling of requests and/or responses
* Messaging system failures
* Failures in service discovery and service registry
* Improper load balancing
* Failure of development tools and development environment
* Failures in the test, package, build, and release pipelines
* Deployment pipeline failures
* Failures and gaps in microservice-level logging
* Failures and gaps in microservice-level monitoring

## Dependency Failures

Failures within the top level of the microservice ecosystem (the microservice layer) can be
divided into two separate categories:

* those that are internal to a specific microservice and caused by problems within it,
* those that are external to a microservice and caused by the microservice’s dependencies.

If even one microservice in the dependency chain goes down, it can take all of its upstream clients down with it if there are no protections in place. However, a microservice doesn’t always necessarily need to experience a full-blown outage in order to negatively affect the availability of its upstream clients — if it fails to meet its SLA by just one or two nines, the availability of all upstream client microservices will drop.

If a service’s availability drops by one or two nines, all upstream clients suffer, all thanks to how the math works: the availability of a microservice is calculated as its own availability multiplied by the availability of its downstream dependencies. Failing to meet an SLA is an important (and often overlooked) microservice failure, and it’s a failure that brings down the availability of every other service that depends on it (along with the services that depend on those services).

Other common dependency failures are those caused by timeouts to another service,

* the deprecation or decommissioning of a dependency’s API endpoints (without proper communication regarding the deprecation or decommissioning to all upstream clients), and
* the deprecation or decommissioning of an entire microservice.

In addition, versioning of internal libraries and/or microservices and pinning to specific versions of internal libraries and/or services is very much discouraged - maintenance issue due to high development velocity.

Failures of external dependencies (third-party services and/or libraries) can and do happen as well.  The complexity associated with depending on third-party services and/or libraries can be handled properly if these scenarios are anticipated from the beginning of the microservice’s life cycle:

* choose established and stable external dependencies, and
* try to avoid using them unless completely necessary, lest they become a single point of failure for your service.

### SUMMARY: COMMON DEPENDENCY FAILURE SCENARIOS

Some of the most common dependency failure scenarios are:

* Failures or outages of a downstream (dependency) microservice
* Internal service outages
* External (third-party) service outages
* Internal library failures
* External (third-party) library failures
* A dependency failing to meet its SLA
* API endpoint deprecation
* API endpoint decommissioning
* Microservice deprecation
* Microservice decommissioning
* Interface or endpoint deprecation
* Timeouts to a downstream service
* Timeouts to an external dependency

## Internal (Microservice) Failures

At the very top of the microservice ecosystem stack lie the individual microservices.

The majority of incidents and outages experienced by a microservice will be almost solely self-inflicted.

Incomplete code reviews, lack of proper test coverage, and poor development processes in general (specifically, the lack of a standardized development cycle) lead to buggy code being deployed to production. Without a stable and
reliable deployment pipeline containing staging, canary, and production phases in place to catch any errors before they are fully rolled out to production servers, any problems not caught by testing in the development phases can cause serious incidents and outages for the microservice itself, its dependencies, and any other parts of the microservice ecosystem that
depend on it.

Anything specific to the microservice’s architecture can also fail here, including any databases, message brokers, task-processing systems, and the like.

This is also where general and specific code bugs within the microservice will cause failures, as well as improper error and exception handling: unhandled exceptions and the practice of catching exceptions are an
often-overlooked culprit when microservices fail. Finally, increases in traffic can cause a service to fail if the service isn't prepared for unexpected growth.

## SUMMARY: COMMON MICROSERVICE FAILURE SCENARIOS

Some of the most common microservice failures are:

* Incomplete code reviews
* Poor architecture and design
* Lack of proper unit and integration tests
* Bad deployments
* Lack of proper monitoring
* Improper error and exception handling
* Database failure
* Scalability limitations