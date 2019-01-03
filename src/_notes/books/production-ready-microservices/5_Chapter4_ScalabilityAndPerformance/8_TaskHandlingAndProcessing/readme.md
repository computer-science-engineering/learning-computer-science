# Task Handling and Processing

Every microservice will be receiving requests from upstream client services who either need some sort of information from the microservice or need the microservice to compute or process something and then return information about that computation or process, and then the microservice will need to fulfill that request (usually by communicating with downstream services in addition to doing some work of its own) and return any requested information or response to the client that sent the request.

## Programming Language Limitations

Microservices can accomplish this and play their required role in a myriad of ways, and the ways in which they will perform computations, interact with downstream services, and process various tasks will depend on the language that the service is written in, and consequently, on the architecture of the service (which is, in many ways, determined by the language).

For example, a microservice written in Python has a number of ways that it can process various tasks, some of which require the use of asynchronous frameworks (like Tornado) and others which can utilize messaging technologies like RabbitMQ and Celery to efficiently process tasks. For these reasons, a microservice’s ability to handle and process tasks in a scalable and performant manner is dictated in part by choice of language.

Many programming languages are not optimized for the performance and scalability requirements of microservice architecture, or do not have scalable or performant frameworks that allow microservices to process tasks efficiently.

Programming language constraints need to be taken into account, and language choice should be determined not by whether a language is fashionable or fun (or even whether it is the most common language that the development team is familiar with), but with the performance and scalability limitations of each potential language held as the deciding factors. There is no one “best” language to write a microservice in, but there are languages that are better suited than others to certain types of microservices.

## Handling Requests and Processing Tasks Efficiently

Microservices need to be able to handle and process a large number of tasks at the same time, handle and process those tasks efficiently, and be prepared for tasks and requests to increase in the future. Development teams should be able to answer three basic questions about their microservices:

* how their microservice processes tasks,
* how efficiently their microservice processes those tasks, and
* how their microservice will perform as the number of requests scales.

To ensure scalability and performance, microservices need to process tasks efficiently. In
order to do this, they need to have both concurrency and partitioning. Concurrency requires
that the service can’t have one single process that does all of the work. Instead of architecting our service to use a single process, we can introduce concurrency so that each task is broken up into smaller pieces.

Taking the smaller pieces of these tasks, we can process them more efficiently using partitioning, where each task is not only broken up into small pieces but can be processed in parallel. If we have a large number of small tasks, we can process then all at the same time by sending them to a set of workers that can process them in parallel. If we need to process more tasks, we can easily scale with the increased demand by adding additional workers to process the new tasks without affecting the efficiency of our system. Together, concurrency and partitioning help ensure that our microservice is optimized for both scalability and partitioning.

**Note:** [*WRITE MICROSERVICES IN PROGRAMMING LANGUAGES THAT ARE OPTIMIZED FOR CONCURRENCY AND PARTITIONING*] Some languages are better suited for efficient (concurrent and partitioned) task handling and processing than others. When writing a new microservice, make sure that the language the service is being written in won’t introduce scalability and performance constraints on the microservices. For example, if you are optimizing for concurrency and partitioning, and want to use an asynchronous framework to help you accomplish that, writing your service in Python (rather than C++, Java, or Go — three languages built for concurrency and partitioning) is going to introduce a lot of scalability and performance bottlenecks that will be difficult to mitigate.