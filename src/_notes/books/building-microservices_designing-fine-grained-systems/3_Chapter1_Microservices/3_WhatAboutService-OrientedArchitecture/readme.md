# What About Service-Oriented Architecture

Multiple services collaborate to provide some end set of capabilities. A service here typically means a completely separate operating system process. Communication between these services
occurs via calls across a network rather than method calls within a process boundary.

An approach that aims to promote the reusability of software; two or more end-user applications, for example, could both use the same services.

Many of the problems laid at the door of SOA are actually problems with things like

1. Communication protocols (e.g., SOAP)
2. Vendor middleware
3. A lack of guidance  service granularity, or the wrong guidance on picking places to split your system.

The microservice approach has emerged from real-world use, taking our better understanding of systems and architecture to do SOA well. So you should instead think of microservices as a specific approach for SOA in the same way that XP or Scrum are specific approaches for Agile software development.