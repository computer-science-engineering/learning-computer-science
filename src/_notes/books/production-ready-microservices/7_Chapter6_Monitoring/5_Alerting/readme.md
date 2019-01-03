# Alerting

The detection of failures, as well as the detection of changes within key metrics that could lead to a failure, is accomplished through alerting. To ensure this, all key metrics — host-
level metrics, infrastructure metrics, and microservice-specific metrics — should be alerted on, with alerts set at various thresholds.

## Setting up Effective Alerting

Alerts must be set up for all key metrics. Any change in a key metric at the host level, infrastructure level, or microservice level that could lead to an outage, cause a spike in
latency, or somehow harm the availability of the microservice should trigger an alert. Importantly, alerts should also be triggered whenever a key metric is not seen.

All alerts should be useful: they should be defined by good, signal-providing thresholds. Three types of thresholds should be set for each key metric, and have both upper and lower
bounds: normal, warning, and critical.

Normal thresholds reflect the usual, appropriate upper and lower bounds of each key metric and shouldn’t ever trigger an alert. Warning thresholds on each key metric will trigger alerts when there is a deviation from the norm that could lead to a problem with the microservice; warning thresholds should be set such that they will trigger alerts before any deviations from the norm cause an outage or otherwise negatively affect the microservice. Critical thresholds should be set based on which upper and lower bounds on key metrics actually cause an outage, cause latency to spike, or otherwise hurt a microservice’s availability. In an ideal world, warning thresholds should trigger alerts that lead to quick detection, mitigation, and resolution before any critical thresholds are reached. In each category, thresholds should be high enough to avoid noise, but low enough to catch any and all real problems with key metrics.

Thresholds for key metrics can be very difficult to set without historical data. Any thresholds set early in a microservice’s lifecycle run the risk of either being useless or triggering too many alerts. To determine the appropriate thresholds for a new microservice (or even an old one), developers can run load testing on the microservice to gauge where the thresholds should lie. Running “normal” traffic loads through the microservice can determine the normal thresholds, while running larger-than-expected traffic loads can help determine warning and critical thresholds.

All alerts need to be actionable. Any alert that cannot be immediately acted on by the on-call developer(s) should be removed from the pool of alerts, reassigned to the relevant on-call rotation, or (if possible) changed so that it becomes actionable.

Some of the key microservice metrics run the risk of being non-actionable. For example, alerting on the availability of dependencies can easily lead to non-actionable alerts if
dependency outages, increases in dependency latency, or dependency downtime do not require any action to be taken by their client(s). If no action needs to be taken, then the thresholds
should be set appropriately, or in more extreme cases, no alerts should be set on dependencies at all. However, if any action at all should be taken, even something as small as contacting the dependency’s on-call or development team in order to alert them to the issue and/or coordinate mitigation and resolution, then an alert should be triggered.

## Handling Alerts

The root cause of the triggered alert should be mitigated and resolved. To quickly and effectively handle alerts, there are several steps that can be taken.

The first step is to create step-by-step instructions for each known alert that detail how to triage, mitigate, and resolve each alert. These step-by-step alert instructions should live within an on-call runbook within the centralized documentation of each microservice, making them easily accessible to anyone who is on call for the microservice (more details on runbooks can be found in Chapter 7, Documentation and Understanding). Runbooks are crucial to the monitoring of a microservice: they allow any on-call developer to have step-by-step instructions on how to mitigate and resolve the root causes of each alert. Since each alert is tied to a deviation in a key metric, runbooks can be written so that they address each key metric, known causes of deviations from the norm, and how to go about debugging the problem.

Two types of on-call runbooks should be created. The first are runbooks for host-level and infrastructure-level alerts that should be shared between the whole engineering organization
— these should be written for every key host-level and infrastructure-level metric. The second are on-call runbooks for specific microservices that have step-by-step instructions
regarding microservice-specific alerts triggered by changes in key metrics.

The second step is to identify alerting anti-patterns. If the microservice on-call rotation is overwhelmed by alerts yet the microservice appears to work as expected, then any alerts that
are seen more than once but that can be easily mitigated and/or resolved should be automated away. That is, build the mitigation and/or resolution steps into the microservice itself. Any alert that, once triggered, requires a simple set of steps to be taken in order to be mitigated and resolved, can be easily automated away. Once this level of production-ready monitoring has been established, a microservice should never experience the same exact problem twice.