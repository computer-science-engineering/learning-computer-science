# Performance

A performant microservice is one that handles requests quickly, processes tasks efficiently, and properly utilizes resources (such as hardware and other infrastructure components).

A microservice that makes a large number of expensive network calls, for example, is not performant. Neither is a microservice that processes and handles tasks synchronously in cases when asynchronous (non-blocking) task processing would increase the performance and availability of the service.

Similarly, dedicating a large number of resources (like CPU) to a microservice that doesn’t utilize it is inefficient.

There’s a fine line between under-utilization and proper capacity planning.

## PERFORMANCE REQUIREMENTS

The requirements of building a performant microservice are:

* Appropriate service-level agreements (SLAs) for availability
* Proper task handling and processing
* Efficient utilization of resources

The details of production-ready performance requirements are covered in Chapter 4, Scalability and Performance.