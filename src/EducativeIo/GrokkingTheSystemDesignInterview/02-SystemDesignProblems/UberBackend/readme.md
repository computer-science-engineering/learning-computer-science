# Designing Uber backend

- [Designing Uber backend](#designing-uber-backend)
  - [What is Uber](#what-is-uber)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
  - [Capacity Estimation and Constraints](#capacity-estimation-and-constraints)
  - [Basic System Design and Algorithm](#basic-system-design-and-algorithm)
  - [Fault Tolerance and Replication](#fault-tolerance-and-replication)
  - [Ranking](#ranking)
  - [Advanced Issues](#advanced-issues)

Design a ride-sharing service like Uber, which connects passengers who need a ride with drivers who have a car.

Similar Services: Lyft, Didi, Via, Sidecar etc.

Prerequisite: Designing Yelp

## What is Uber

## Requirements and Goals of the System

There are two kinds of users in our system:

1. Drivers
2. Customers.

- Drivers need to regularly notify the service about their current location and their availability to pick passengers.
- Passengers get to see all the nearby available drivers.
- Customer can request a ride; nearby drivers are notified that a customer is ready to be picked up.
- Once a driver and a customer accept a ride, they can constantly see each other's current location until the trip finishes.
- Upon reaching the destination, the driver marks the journey complete to become available for the next ride.

## Capacity Estimation and Constraints

- Assume 300M customers and 1M drivers
- Assume 1M daily active customers and 500K daily active drivers.
- Assume 1M daily rides.
- Assume that all active drivers notify their current location every three seconds.
- Once a customer puts a request for a ride, the system should be able to contact drivers in real-time.

## Basic System Design and Algorithm

- Based on Yelp design.
- Biggest difference: QuadTree with frequent updates
- Two issues with the Dynamic Grid solution
  - All active drivers are reporting their locations every three seconds. Need to update the data structures to reflect that, which can be costly. Would involve potentially updating position to new grid and/or repartitioning.
  - Need to quickly propagate the current location of all the nearby drivers to any active customer in that area. When a ride is in progress, our system needs to notify both the driver and passenger about the current location of the car.
- **Do we need to modify our QuadTree every time a driver reports their location?**
  - Since all active drivers report their location every three seconds, therefore there will be a lot more updates happening to our tree than querying for nearby drivers.
  - We can keep the latest position reported by all drivers in a hash table (DriverLocationHT) and update our QuadTree a little less frequent.
  - Assume we guarantee that a driver's current location will be reflected in the QuadTree within 15 seconds.
- **Memory for DriverLocationHT**
  - Each driver: 35 bytes
    - Driver ID: 3B
    - Old latitude: 8B
    - Old longitude: 8B
    - New latitude: 8B
    - New longitude: 8B
  - 1 M drivers * 35 B = 35 MB
- **Bandwidth for receiving driver location updates**
  - Each driver: 3 + (8 * 2) = 19 B
  - 1M drivers * 19 B = 19 MB per three seconds
- **Distributing DriverLocationHT onto multiple servers**
  - All information can be stored on one server.
  - But storing the hashtable on multiple server is necessary for scalability, performance, and fault tolerance.
  - Distribute based on the DriverID to make the distribution completely random.
  - Machines holding DriverLocationHT: Driver Location server.
  - Other than storing the driver’s location, each of these servers will do two things:
    - As soon as the server receives an update for a driver’s location, they will broadcast that information to all the interested customers.
    - The server needs to notify the respective QuadTree server to refresh the driver’s location. As discussed above, this can happen every 10 seconds.
- **Broadcasting the driver's location to customers**
  - Push model
    - When Driver Location Server receives an update for a driver's location, it pushes the update to all interested customers.
    - Use a dedicated Notification Service on a publisher/subscriber model.
    - When a customer opens the app, the app queries the server to find nearby drivers.
    - On the server side, a list of nearby drivers is pulled from the QuadTree Server. The customer is subscribed for all the updates, and the list of drivers is sent to the customer's app.
    - Whenever there is an update in DriverLocationHT for a relevant driver, that information is pushed to all subscribed customers.
- **Memory needed to store all the subscriptions**
  - 1 M DAU and 500 K daily active drivers.
  - Say, 5 customers subscribe to 1 driver.
  - Store information in a aHash Table.Need to store driver and customer IDs.
  - 3 bytes for DriverID and 8 bytes for CustomerID.
  - Total memory needed = `(500 K * 3) + (500 K * 5 * 8) ~= 21 MB`
- **Bandwidth needed to broadcast the driver’s location to customers**
  - Total subscribers: 5 * 500 K = 2.5 M
  - To all these customers we need to send DriverID (3 bytes) and their location (16 bytes) every second.
  - Total bandwidth needed: `2.5 M * 19 bytes = 47.5 MB/s`
- **Efficiently implementing Notification service**
  - HTTP long polling or push notifications.
- **How will the new publishers/drivers get added for a current customer?**
  - Customers will be subscribed to nearby drivers when they open the Uber app for the first time.
  - What will happen when a new driver enters the area the customer is looking at?
    - To add a new customer/driver subscription dynamically, we need to keep track of the area the customer is watching.
    - This will make our solution complicated; how about if instead of pushing this information, clients pull it from the server?
- **How about if clients pull information about nearby drivers from the server?**
  - Clients can send their current location.
  - Server will find all the nearby drivers from the QuadTree to return them to the client.
  - Client will update their screen to reflect current positions of the drivers.
  - Clients can query every five seconds to limit the number of round trips to the server.
  - Much simpler than push model.
- **Need to repartition a grid as soon as it reaches the maximum limit**
  - The grid can grow or shrink an extra percentage before it is repartitioned or merged with other grids.
  - For example, grids can grow/shrink an extra 10% before we partition/merge them.
  - This will decrease the load for grid partition or merge on high traffic grids.

![high level design](https://raw.githubusercontent.com/tuliren/grokking-system-design/master/img/uber-backend-overview.png)

- **Ride request**
  - A customer will put a request for a ride.
  - One of the Aggregator servers takes the request and asks QuadTree servers to return nearby drivers.
  - The Aggregator server collects all the results and sorts them by ratings.
  - The Aggregator server will send a notification to the top (say three) drivers simultaneously, whichever driver accepts the request first will be assigned the ride. If none of the three drivers respond, the Aggregator will request a ride from the next three drivers from the list.
  - Once a driver accepts a request, the customer is notified.

## Fault Tolerance and Replication

- If a Driver Location server or Notification server dies.
- Need replicas of these servers, so that if the primary dies the secondary can take control.
- Should store this data in some persistent storage like SSDs that can provide fast IOs.
- Also, if both primary and secondary servers die, data can be recovered from persistent storage.

## Ranking

- Ranking the search results not just by proximity but also by popularity or relevance?
- Returning top rated drivers within a given radius
  - Keep track of the overall ratings of each driver in our database and QuadTree.
  - An aggregated number can represent this popularity in our system.
  - While searching for the top 10 drivers within a given radius, we can ask each partition of the QuadTree to return the top 10 drivers with a maximum rating.
  - The aggregator server can then determine the top 10 drivers among all the drivers returned by different partitions.

## Advanced Issues

1. How will we handle clients on slow and disconnecting networks?
2. What if a client gets disconnected when they are a part of a ride? How will we handle billing in such a scenario?
3. How about if clients pull all the information, compared to servers always pushing it?
