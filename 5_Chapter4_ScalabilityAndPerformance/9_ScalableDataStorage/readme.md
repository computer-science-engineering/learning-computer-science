# Scalable Data Storage

Microservices need to handle data in a scalable and performant way. The way in which a microservice stores and handles data can easily become the most significant limitation or constraint.

## Database Choice in Microservice Ecosystems

If we think about microservice architecture as being composed of four separate layers (see “Microservice Architecture” for more details) and recognize that, thanks to the Inverse Conway’s Law, the engineering organizations of companies that adopt microservice architecture will mirror the architecture of its product, then we can see where the responsibility for choosing the appropriate databases, building them, running them, and maintaining them lies: either in the application platform layer, which would allow databases to be provided as a service to microservice teams, or the microservice layer, where the database used by a microservice is considered part of the service.

One approach to this works particularly well: offering databases as a service within the application platform layer, and then allowing individual microservice development teams to run their own database if the databases offered as part of the application platform do not fit their specific needs.

The most common types of databases are relational databases (SQL, MySQL) and NoSQL databases (Cassandra, Vertica, MongoDB, and key-value stores like Dynamo, Redis, and Riak). Choosing between a relational database and a NoSQL database, and then choosing the specific appropriate database for a microservice’s needs depends on the answers to several questions:

* What are the needed transactions per second of each microservice?
* What type of data does each microservice need to store?
* What is the schema needed by each microservice? And how often will it need to be changed?
* Do the microservices need strong consistency or eventual consistency?
* Are the microservices read-heavy, write-heavy, or both?
* Does the database need to be scaled horizontally or vertically?

Regardless of whether the database is maintained as part of the application platform or by each individual microservice development team, database choice should be driven by the answers to those questions. For example, if the database in question needs to be scaled horizontally, or if reads and writes need to be made in parallel, then a NoSQL database should be chosen, since relational databases struggle with horizontal scaling and parallel reads and writes.

## Database Challenges in Microservice Architecture

When databases are shared among microservices, competition for resources kicks in, and some microservices may utilize more than their fair share of the available storage. Engineers building and maintaining shared databases need to design their data storage solutions so that the database can be easily scaled if any of the tenant microservices either require additional space or are running the risk of using up all available space.

Some databases have strict limitations on the number of database connections that can be open simultaneously. Make sure that all connections are closed appropriately to avoid compromising both a service’s availability and the availability of the database to all microservices that use it.

Another challenge microservices often face, especially once they’ve built and standardized stable and reliable development cycles and deployment pipelines, is the handling of test data from end-to-end testing, load testing, and any test writes done in staging. The staging phase of the deployment pipeline requires reading and/or writing to databases. If full staging has been implemented, then the staging phase will have its own separate test and staging database, but partial staging requires read and write access to production servers, so great care needs to be taken to ensure that test data is handled appropriately: it needs to be clearly marked as test data (a process known as test tenancy), and then all test data must be deleted at regular intervals.