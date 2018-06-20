# Traffic Management

There are several aspects to managing traffic in a scalable, performant way:

* the growth scale (quantitative and qualitative) needs to be used to predict future increases (or decreases) in traffic;
* the traffic patterns must be well understood and prepared for;
* third, microservices need to be able to intelligently handle increases in traffic, as well as surges or bursts of traffic.

When traffic patterns are clearly identified, both in terms of the requests per second sent to the service over time and all key metrics (see Chapter 6, Monitoring, for more about key metrics), changes to the service, operational downtimes, and deployments can be scheduled to avoid peak traffic times, cutting down on possible future outages if a bug is deployed and on potential downtime if the microservice is restarted while experiencing peak traffic load.

When we can predict future traffic growth and understand the current and past traffic patterns
well enough to know how the patterns will change with expected growth, we can perform load
testing on our services to make sure that they behave as we expect under heavier traffic loads.

The way a microservice handles traffic should be scalable, which means it should be prepared for drastic changes in traffic, especially bursts of traffic, handle them carefully, and prevent them from taking down the service entirely. These sorts of spikes should be prepared for at the infrastructure level, within all monitoring and logging systems, and by the development team as part of the service’s resiliency testing suite.

Many microservice ecosystems won’t be deployed only in one location, one datacenter, or one city, but rather across multiple datacenters across the country (or even the world). It’s not uncommon for datacenters themselves to experience large-scale outages, and when this happens, the entire microservice ecosystem can (and usually will) go down with the datacenter. Distributing and routing traffic appropriately between datacenters is the responsibility of the infrastructure level (in particular, the communication layer) of the microservice ecosystem, but each microservice needs to be prepared to re-route traffic from one datacenter to another without the service experiencing any decreased availability.