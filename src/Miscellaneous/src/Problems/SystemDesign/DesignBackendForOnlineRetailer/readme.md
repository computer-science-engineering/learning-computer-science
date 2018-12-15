# Problem Definition

## Description

Design the backend for an online retailer.

Scale: 10k orders/day.

Data Model?

What type of database - SQL vs NoSQL.
Why? ACID?

Which parts/entities of data model would go into SQL and which to NoSQL.
Consistency?

What if two warehouses are completely separate and services two non-overlapping regions? Two pools for BE?
You have designed, developed and deployed the backend for an online retailer. It is all microservices based with application and data layers. Partitioned by customer Id. Now, the online retailer has expanded with another warehouse in a totally different part of the world. The customers, sellers and products under the ambit of this new warehouse are totally distinct from the previous warehouse. And they are guaranteed to always remain distinct. How do you manage the BE infrastructure to incorporate this new warehouse? Keep same BE and change partitioning scheme? Create a totally new BE pool for the new warehouse? Any other mechanism?

What if single global BE and then lots of customers/users in one region?
CDN?

What if website becomes loaded?
Load balancers?

## Notes