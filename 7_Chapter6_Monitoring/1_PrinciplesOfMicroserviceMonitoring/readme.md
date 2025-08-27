# Principles of Microservice Monitoring

The majority of outages in a microservice ecosystem are caused by bad deployments. The second most common cause of outages is the lack of proper monitoring. If the state of a microservice is unknown, if key metrics aren’t tracked, then any precipitating failures will remain unknown until an actual outage occurs.  If the state of a microservice is unknown, if key metrics aren’t tracked, then any precipitating failures will remain unknown until an actual outage occurs. By the time a microservice experiences an outage due to lack of monitoring, its availability has already been compromised. During these outages, the time to mitigation and time to repair are prolonged, pulling the availability of the microservice down even further. Proper monitoring provides the development team with all of the relevant information about the microservice. When a microservice is properly monitored, its state is never unknown.

Monitoring a production-ready microservice has four components.

* The first is proper logging of all relevant and important information.
* The second is the use of well-designed dashboards that accurately reflect the health of the microservice
* The third component is actionable and effective alerting on all key metrics
* The final component is the implementation and practice of running a sustainable on-call rotation responsible for the monitoring of the microservice

## A PRODUCTION-READY SERVICE IS PROPERLY MONITORED

* Its key metrics are identified and monitored at the host, infrastructure, and microservice levels.
* It has appropriate logging that accurately reflects the past states of the microservice.
* Its dashboards are easy to interpret, and contain all key metrics.
* Its alerts are actionable and are defined by signal-providing thresholds.
* There is a dedicated on-call rotation responsible for monitoring and responding to any incidents and outages.
* There is a clear, well-defined, and standardized on-call procedure in place for handling incidents and outages.