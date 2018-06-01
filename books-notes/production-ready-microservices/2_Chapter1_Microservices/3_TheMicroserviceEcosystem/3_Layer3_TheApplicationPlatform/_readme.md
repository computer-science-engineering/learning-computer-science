# Layer 3: The Application Platform

Contains all of the internal tooling and services that are independent of the microservices.

## Self-service internal development tools

TechOps teams will be responsible for layer 1, infrastructure teams will be responsible for layer 2, application platform teams will be responsible for layer 3, and microservice teams will be responsible for layer 4 (this is, of course, a very simplified view, but you get the general idea).

Within this organizational scheme, any time that an engineer working on one of the higher layers needs to set up, configure, or utilize something on one of the lower layers, there should be a self-service tool in place that the engineer can use.

In a diverse microservice ecosystem, the average engineer on any given team will have no (or very little) knowledge of how the services and systems in other teams work...

The second reason to build these tools and build them well is that, in all honesty, you do not want a developer from another team to be able to make significant changes to your service or system, especially not one that could cause an outage.

## The development cycle

...streamlining and standardizing the development process and automating away as much as possible.

...several things that need to be in place within the third layer of a microservice ecosystem in order for stable and reliable development to be possible.

The first requirement is a centralized version control system...

The second requirement is a stable, efficient development environment. The most stable and reliable way to design a development environment is to create a mirror of the production environment (one that is not staging, nor canary, nor production)
containing all of the intricate dependency chains.

## Test, build, package, and release

...between development and deployment ... should be standardized and centralized as much as possible.

## Deployment pipeline

Building tooling around deployment, and standardizing deployment practices for all development teams is often necessary.

## Logging and monitoring

All microservices should have microservice-level logging of all requests made to the microservice (including all relevant and important information) and its responses. Due to the fast-paced nature of microservice development, it’s often impossible to reproduce bugs in the code because it’s impossible to reconstruct the state of the system at the time of failure.

## SUMMARY OF LAYER 3: THE APPLICATION PLATFORM LAYER

The application platform layer (layer 3) of the microservice ecosystem contains:

* Self-service internal development tools
* Development environment
* Test, package, build, and release tools
* Deployment pipeline
* Microservice-level logging
* Microservice-level monitoring