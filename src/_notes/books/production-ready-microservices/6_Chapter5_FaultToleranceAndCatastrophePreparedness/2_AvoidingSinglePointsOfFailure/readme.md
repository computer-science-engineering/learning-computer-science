# Avoiding Single Points of Failure

No one piece of a microservice’s architecture should be able to bring down the service, but they frequently do. In fact, most microservices in the real world don’t have just one single point of failure but have multiple points of failure.

A great way to discover points of failure before they are responsible for an outage is to run architecture reviews with microservice development teams, ask the developers on each team to draw the architecture of their microservice on a whiteboard, and then walk them through the architecture, asking, “What happens if this piece of the microservice architecture fails?”

Due to the complex dependency chains that exist between different microservices within a microservice ecosystem, a point of failure in the architecture of one individual microservice is often a point of failure for the entire dependency chain, and in extreme cases, for the entire ecosystem. There are no isolated points of failure within microservice ecosystems, which makes identifying, mitigating, and architecting away points of failure essential for achieving fault-tolerance.

Once any single (or multiple) points of failure have been identified, they need to be mitigated, and (if possible) architected away.