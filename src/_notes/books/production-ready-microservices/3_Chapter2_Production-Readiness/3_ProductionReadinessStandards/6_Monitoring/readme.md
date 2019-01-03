# Monitoring

Good monitoring has three components:

* proper logging of all important and relevant information
* useful graphical displays (dashboards) that are easily understood by any developer in the company and that accurately reflect the health of the services;
* alerting on key metrics that is effective and actionable.

Logging belongs and begins in the codebase of each microservice.

All key metrics (such as hardware utilization, database connections, responses and average response times, and the status of API endpoints) should be graphically displayed in real time on an easily accessible dashboard.

All key metrics must be alerted on, including (at the very least) CPU and RAM utilization, number of file descriptors, number of database connections, the SLA of the service, requests and responses, the status of
API endpoints, errors and exceptions, the health of the service’s dependencies, information about any database(s), and the number of tasks being processed (if applicable).

Normal, warning, and critical thresholds need to be set for each of these key metrics. Thresholds should be signal-providing: high enough to avoid noise, but low enough to catch any and all real problems.

Alerts need to be useful and actionable.  Every actionable alert — that is, every alert — should be accompanied by a runbook. For example, if an alert is triggered on a high number of exceptions of a certain type, then there needs to be a runbook containing mitigation strategies that any on-call developer can refer to while attempting to resolve the problem.

## MONITORING REQUIREMENTS

The requirements of building a properly monitored microservice are:

* Proper logging and tracing throughout the stack
* Well-designed dashboards that are easy to understand and accurately reflect the health of the service
* Effective, actionable alerting accompanied by runbooks
* Implementing and maintaining an on-call rotation

The details of production-ready monitoring requirements are covered in Chapter 6, Monitoring.