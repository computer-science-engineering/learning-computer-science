# Dashboards

Every microservice must have at least one dashboard where all key metrics (such as hardware utilization, database connections, availability, latency, responses, and the status of API
endpoints) are collected and displayed. Dashboards should be easily accessible, centralized, and standardized across the microservice ecosystem.

Dashboards should be easy to interpret so that an outsider can quickly determine the health of the microservice. This requires striking a balance between overloading a viewer with information (which would render the dashboard effectively useless) and not displaying enough information (which would also make the dashboard useless): only the necessary minimum of information about key metrics should be displayed.

A dashboard should also serve as an accurate reflection of the overall quality of monitoring of the entire microservice. Any key metric that is alerted on should be included in the
dashboard: the exclusion of any key metric in the dashboard will reflect poor monitoring of the service, while the inclusion of metrics that are not necessary will reflect a neglect of alerting (and, consequently, monitoring) best practices.

There are several exceptions to the rule against inclusion of non-key metrics. In addition to key metrics, information about each phase of the deployment pipeline should be displayed.  Developers working on microservices that require monitoring a large number of key metrics may opt to set up separate dashboards for each deployment phase (one for staging, one for canary, and one for production) to accurately reflect the health of the microservice at each deployment phase: since different builds will be running on the deployment phases simultaneously, accurately reflecting the health of the microservice in a dashboard might require approaching dashboard design with the goal of reflecting the health of the microservice at a particular deployment phase (treating them almost as different microservices, or at least as different instantiations of a microservice).

Note: Even though dashboards can illuminate anomalies and negative trends of a microservice’s key metrics, developers should never need to watch a microservice’s dashboard in order to detect incidents and outages. Doing so is an anti-pattern that leads to deficiencies in alerting and overall monitoring.

To assist in determining problems introduced by new deployments, it helps to include information about when a deployment occurred in the dashboard. The most effective and useful way to accomplish this is to make sure that deployment times are shown within the graphs of each key metric.

A careful look at an accurate dashboard can illuminate anomalies that would otherwise go undetected. Alerting thresholds, which we will cover in the next section, are notoriously difficult to determine, but can be set appropriately when historical data on the dashboard is examined: developers can see normal patterns in key metrics, view spikes in metrics that occurred with outages (or led to outages) in the past, and then set thresholds accordingly.