# Redundancy and Replication

* Redundancy means duplication of critical data or services with the intention of increased reliability of the system.
* Redundancy applicable for data as well as services.
* Creating redundancy 
  * removed single points of failure
  * enables backups if needed
* Failover will have to baked in. Failover can be automatic or manual.
* Important point w.r.t. service redundancy
  * Create shared-nothing architecture - each node operates independently.
  * No central management or orchestration service.
  * Helps with scalability since new server can be added with little to no additional configuration.
  * Added to resiliency since no single point of failure.