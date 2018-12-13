# Thinking About Data Systems

Many new tools for data storage and processing have emerged in recent years. They are optimized for a variety of different use cases, and they no longer neatly fit into traditional categories. For example, there are data stores that are also used as message queues (Redis), and there are message queues with database-like durability guarantees (Apache Kafka). The boundaries between the categories are becoming blurred.

Secondly, increasingly many applications now have such demanding or wide-ranging requirements that a single tool can no longer meet all of its data processing and storage needs. Instead, the work is broken down into tasks that can be performed efficiently on a single tool, and those different tools are stitched together using application code.

If you are designing a data system or service, a lot of tricky questions arise. How do you ensure that the data remains correct and complete, even when things go wrong internally? How do you provide consistently good performance to clients, even when
parts of your system are degraded? How do you scale to handle an increase in load? What does a good API for the service look like?

In this book, we focus on three concerns that are important in most software systems:

**Reliability**: The system should continue to work correctly (performing the correct function at the desired level of performance) even in the face of adversity (hardware or soft‐
ware faults, and even human error).

**Scalability**: As the system grows (in data volume, traffic volume, or complexity), there should be reasonable ways of dealing with that growth.

**Maintainability**: Over time, many different people will work on the system (engineering and operations, both maintaining current behavior and adapting the system to new use cases), and they should all be able to work on it *productively*.

Various techniques, architectures, and algorithms are used in order to achieve those goals.