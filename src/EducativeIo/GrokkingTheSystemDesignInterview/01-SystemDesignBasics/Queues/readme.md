# Queues

* Used to effectively manage requests in large-scale distributed systems.
* More generically, can be used to manage distributed communication between components of any large scale distributed system.
* In more complex and large systems writes can take an almost non-deterministically long time.
  * data may have to be written in different places on different servers or indices
  * system could be under high load
* In such cases, where individual tasks (such as writes) can take a long time, high performance nd availability requests components to work asynchronously. Queues can be used to achieve this.
* Queues are a way of building an abstraction layer between client requests and the the actual work performed to service it.
* A processing queue works as follows:
  * all incoming tasks are added to the queue
  * as soon as any worker has the capacity to process, it will pick up a task from the queue.
  * Queues are implemented on the asynchronous communication protocol.
    * Clients receive acknowledgement/response that request was received.
    * The work on that request will be performed later.
    * The received acknowledgement can contain information that may later serve as reference for the results of the performed work, when the client requires it.
* Queues have implicit or explicit limits on
  * size of data transmitted in a single request
  * number of requests that may remain outstanding
* Queues are also used for fault tolerance
  * Can provide some protection from service outages and failures.
  * Retry handling logic can pick up messages/requests/tasks from queue.
  * Can be used to enforce QoS guarantees.
* Eg. of some open-source queues: RabbitMQ, ZeroMQ, ActiveMQ, BeanstalkD.
