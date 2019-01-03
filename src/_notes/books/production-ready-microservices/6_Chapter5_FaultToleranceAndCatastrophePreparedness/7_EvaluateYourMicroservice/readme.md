# Evaluate Your Microservice

## Avoiding Single Points of Failure

* Does the microservice have a single point of failure?
* Does it have more than one point of failure?
* Can any points of failure be architected away, or do they need to be mitigated?

## Catastrophes and Failure Scenarios

* Have all of the microservice’s failure scenarios and possible catastrophes been identified?
* What are common failures across the microservice ecosystem?
* What are the hardware-layer failure scenarios that can affect this microservice?
* What communication-layer and application-layer failures can affect this microservice?
* What sorts of dependency failures can affect this microservice?
* What are the internal failures that could bring down this microservice?

### Resiliency Testing

* Does this microservice have appropriate lint, unit, integration, and end-to-end tests?
* Does this microservice undergo regular, scheduled load testing?
* Are all possible failure scenarios implemented and tested using chaos testing?

### Failure Detection and Remediation

* Are there standardized processes across the engineering organization(s) for handling incidents and outages?
* How do failures and outages of this microservice impact the business?
* Are there clearly defined levels of failure?
* Are there clearly defined mitigation strategies?
* Does the team follow the five stages of incident response when incidents and outages occur?