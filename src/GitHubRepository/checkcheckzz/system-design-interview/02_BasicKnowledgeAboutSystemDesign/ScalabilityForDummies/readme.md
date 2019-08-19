# Scalability for Dummies

- [Scalability for Dummies](#scalability-for-dummies)
  - [Part 1: Clones](#part-1-clones)
  - [Part 2: Database](#part-2-database)
  - [Part 3 Cache](#part-3-cache)
  - [Part 4: Asynchronism](#part-4-asynchronism)
  - [References](#references)

## Part 1: Clones

- Public servers of a scalable web service are hidden behind a load balancer.
- This load balancer evenly distributes load (requests from your users) onto your group/cluster of  application servers.
- User should always get the same results of his request back, independent what server he  “landed on”.
- That leads to the first golden rule for scalability: every server contains exactly the same codebase and does not store any user-related data, like sessions or profile pictures, on local disc or memory.
- Sessions need to be stored in a centralized data store which is accessible to all your application servers.
  - It can be an external database or
  - An external persistent cache, like Redis.
  - An external persistent cache will have better performance than an external database.
- Deployment: Have to ensure that a code change is sent to all your servers without one server still serving old code.
- After “outsourcing” your sessions and serving the same codebase from all your servers, you can now create an image file from one of these servers (AWS calls this AMI - Amazon Machine Image.)
- Use this AMI as a “super-clone” that all your new instances are based upon. Whenever you start a new instance/clone, just do an initial deployment of your latest code and you are ready!

## Part 2: Database

- Path #1 is to stick with MySQL and keep the “beast” running. Hire a database administrator (DBA,) tell him to do master-slave replication (read from slaves, write to master) and upgrade your master server by adding RAM, RAM and more RAM. In some months, your DBA will come up with words like “sharding”, “denormalization” and “SQL tuning” and will look worried about the necessary overtime during the next weeks. At that point every new action to keep your database running will be more expensive and time consuming than the previous one. You might have been better off if you had chosen Path #2 while your dataset was still small and easy to migrate.
- Path #2 means to denormalize right from the beginning and include no more Joins in any database query. You can stay with MySQL, and use it like a NoSQL database, or you can switch to a better and easier to scale NoSQL database like MongoDB or CouchDB. Joins will now need to be done in your application code. The sooner you do this step the less code you will have to change in the future. But even if you successfully switch to the latest and greatest NoSQL database and let your app do the dataset-joins, soon your database requests will again be slower and slower. You will need to introduce a cache.

## Part 3 Cache

- Here by cache we mean in-memory caches like Memcached or Redis. Please never do file-based caching, it makes cloning and auto-scaling of your servers just a pain.
- A cache is a simple key-value store and it should reside as a buffering layer between your application and your data storage. Whenever your application has to read data it should at first try to retrieve the data from your cache. Only if it’s not in the cache should it then try to get the data from the main data source.
- Advantages of using a cache: Lightning-fast. It holds every dataset in RAM and requests are handled as fast as technically possible. For example, Redis can do several hundreds of thousands of read operations per second when being hosted on a standard server. Also writes, especially increments, are very, very fast.

There are 2 patterns of caching your data.

- Cached Database Queries
  - Still the most commonly used caching pattern.
  - Whenever you do a query to your database, you store the result dataset in cache. A hashed version of your query is the cache key. The next time you run the query, you first check if it is already in the cache. The next time you run the query, you check at first the cache if there is already a result.
  - Issues:
    - The main issue is the expiration. It is hard to delete a cached result when you cache a complex query.
    - When one piece of data changes (for example a table cell) you need to delete all cached queries who may include that table cell.
- Cached Objects
  - Recommended.
  - See your data as an object like you already do in your code (classes, instances, etc.). Let your class assemble a dataset from your database and then store the complete instance of the class or the assembled dataset in the cache.
  - **Example**: You have, for example, a class called “Product” which has a property called “data”. It is an array containing prices, texts, pictures, and customer reviews of your product. The property “data” is filled by several methods in the class doing several database requests which are hard to cache, since many things relate to each other. Now, do the following: when your class has finished the “assembling” of the data array, directly store the data array, or better yet the complete instance of the class, in the cache!
  - Advantages:
    - This allows you to easily get rid of the object whenever something did change and makes the overall operation of your code faster and more logical.
    - Makes asynchronous processing possible! Just imagine an army of worker servers who assemble your objects for you! The application just consumes the latest cached object and nearly never touches the databases anymore!

Some ideas of objects to cache:

- user sessions (never use the database!)
- fully rendered blog articles
- activity streams
- user<->friend relationships

Advantages of Redis:

- Extra database-features of Redis like persistence and the built-in data structures like lists and sets. With Redis and a clever key’ing there may be a chance that you even can get completely rid of a database.

Advantages of Memcached:

- If you just need to cache, take Memcached, because it scales like a charm.

## Part 4: Asynchronism

In general, there are two ways / paradigms asynchronism can be done.

- Async #1
  - Doing the time-consuming work in advance and serving the finished work with a low request time.
  - Very often this paradigm is used to turn dynamic content into static content. Eg: Pages of a website, maybe built with a massive framework or CMS, are pre-rendered and locally stored as static HTML files on every change.
  - Computing tasks are done on a regular basis, maybe by a script which is called every hour by a cronjob.
  - This pre-computing of overall general data can extremely improve websites and web apps and makes them very scalable and performant. Just imagine the scalability of your website if the script would upload pre-rendered HTML pages to AWS S3 or Cloudfront or another Content Delivery Network! Your website would be super responsive and could handle millions of visitors per hour!
- Async #2
  - Handling tasks asynchronously.
  - Example workflow: A user comes to your website and starts a very computing intensive task which would take several minutes to finish. So the frontend of your website sends a job onto a job queue and immediately signals back to the user: your job is in work, please continue to the browse the page. The job queue is constantly checked by a bunch of workers for new jobs. If there is a new job then the worker does the job and after some minutes sends a signal that the job was done. The frontend, which constantly checks for new “job is done” - signals, sees that the job was done and informs the user about it.
  - Look at the first 3 tutorials on the [RabbitMQ website](https://www.rabbitmq.com/). RabbitMQ is one of many systems which help to implement async processing. You could also use [ActiveMQ](http://activemq.apache.org/) or a simple [Redis list](https://redis.io/topics/data-types). The basic idea is to have a queue of tasks or jobs that a worker can process. Asynchronism seems complicated, but it is definitely worth your time to learn about it and implement it yourself. Backends become nearly infinitely scalable and frontends become snappy which is good for the overall user experience.

If you do something time-consuming, try to do it always asynchronously. 

## References

1. [Scalability for Dummies](https://www.lecloud.net/tagged/scalability)
2. [Scalability for Dummies - Part 1: Clones](https://www.lecloud.net/post/7295452622/scalability-for-dummies-part-1-clones)
3. [Scalability for Dummies - Part 2: Database](https://www.lecloud.net/post/7994751381/scalability-for-dummies-part-2-database)
4. [Scalability for Dummies - Part 3: Cache](https://www.lecloud.net/post/9246290032/scalability-for-dummies-part-3-cache)
5. [Scalability for Dummies - Part 4: Asynchronism](https://www.lecloud.net/post/9699762917/scalability-for-dummies-part-4-asynchronism)
