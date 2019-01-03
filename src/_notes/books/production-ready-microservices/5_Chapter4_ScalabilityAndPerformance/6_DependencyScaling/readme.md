# Dependency Scaling

A microservice that is architected, built, and run to be perfectly scalable in every way still
faces scalability challenges if it’s dependencies cannot scale with it. Ensuring that all dependencies will scale with a microservice’s expected growth is essential for building production-ready services.

Microservice teams also need to make sure that their service isn’t a scalability bottleneck for its clients.

The inevitable additional traffic and growth from a microservice’s clients need to be prepared for.

When dealing with incredibly complex dependency chains, making sure that all microservice teams tie the scalability of their services to high-level business metrics (using the qualitative growth scale) can make sure that all services are properly prepared for expected growth, even when cross-team communication becomes difficult.

Aside from standardization across the ecosystem, and holding each microservice development team to high scalability standards, it’s important that development teams work together across microservice boundaries to ensure that each dependency chain will scale together. The development teams responsible for any dependencies of a microservice need to be alerted when increases in traffic are expected. Cross-team communication and collaboration are essential. An option is to hold architecture and scalability overview meetings with teams whose services rely on one another. In these meetings, we cover the architecture of each service and its scalability limitations, then discuss together what needs to be done to scale the entire set of services.