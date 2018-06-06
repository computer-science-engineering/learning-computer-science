# From Monoliths to Microservices

Monolith - three-tier architecture.

Increases in traffic place significant scalability and performance demands on the application, requiring that more
servers host the application. More servers are added, a copy of the application is deployed to each server, and load balancers are put into place so that the requests are distributed
appropriately among the servers hosting the application.

Horizontal scaling: scale by adding more servers.

Vertical scaling becomes a necessity as the application begins
processing a larger number of tasks related to its diverse set of features, so the application is deployed to larger, more powerful servers that can handle CPU and memory demands.

Vertical scaling: scale by increasing the resources (CPU, RAM) of each host.

...nature of a monolith is directly opposed to scalability in the
most general possible sense. Scalability requires concurrency and partitioning: the two things that are difficult to accomplish with a monolith.

The basic concept of a microservice is simple: it’s a small application that does one thing only, and does that one thing well. A microservice is a small component that is easily
replaceable, independently developed, and independently deployable.

...to let each microservice be autonomous, independent,
and self-contained.

Some benefits to adopting microservice architecture: reduced technical debt, improved developer productivity and velocity, better testing efficiency, increased scalability, and ease of deployment.

There are several steps in breaking apart a monolith. The first is to identify the components that should be written as independent services.
Then re-structure and reorganization.
Finally, possibly an abstracted infrastructure team for microservice ecosystem.

To summarize the three steps — the componentization of the application, the restructuring of engineering teams to staff each microservice, and the development of the infrastructure organization within the company.