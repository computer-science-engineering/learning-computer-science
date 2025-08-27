# Evaluate Your Microservice

## Key Metrics

* What are this microservice’s key metrics?
* What are the host and infrastructure metrics?
* What are the microservice-level metrics?
* Are all the microservice’s key metrics monitored?

## Logging

* What information does this microservice need to log?
* Does this microservice log all important requests?
* Does the logging accurately reflect the state of the microservice at any given time?
* Is this logging solution cost-effective and scalable?

## Dashboards

* Does this microservice have a dashboard?
* Is the dashboard easy to interpret? Are all key metrics displayed on the dashboard?
* Can I determine whether or not this microservice is working correctly by looking at the dashboard?

## Alerting

* Is there an alert for every key metric?
* Are all alerts defined by good, signal-providing thresholds?
* Are alert thresholds set appropriately so that alerts will fire before an outage occurs?
* Are all alerts actionable?
* Are there step-by-step triage, mitigation, and resolution instructions for each alert in the on-call runbook?

## On-Call Rotations

* Is there a dedicated on-call rotation responsible for monitoring this microservice?
* Is there a minimum of two developers on each on-call shift?
* Are there standardized on-call procedures across the engineering organization?