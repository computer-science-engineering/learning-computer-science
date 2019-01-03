# Incidents and Outages

The development teams and the engineering organization(s) responsible for the microservices and the ecosystem they live in need to have the appropriate organizational response procedures in place for handling incidents and outages when they happen.

The length of the time to detection, the time to mitigation, and the time to resolution of outages can add up very quickly and cost the company money, because they count against a microservice’s uptime (and, consequently, its availability).

## Appropriate Categorization

First, it is incredibly helpful to categorize the microservices themselves with regard to how their failures will affect the ecosystem so that it will be easy to prioritize various incidents and failures (this also helps with problems related to competition for resources — both engineering resources and
hardware resources — within the organization).

Second, incidents and outages need to be categorized so that the scope and severity of every single failure will be understood across the organization.

### Categorizing microservices

Each microservice within the ecosystem can (and should) be categorized and ranked according to its criticality to the business. Infrastructure layers are always of the highest priority: anything within the hardware, communication, and application platform layers that is used by any of the business-critical microservices should be the highest priority within the ecosystem.

### Categorizing incidents and outages

There are two axes that every incident, outage, and failure can be plotted against:

* the first is the severity of the incident, outage, or failure, and
* the second is its scope.

If the microservice is business-critical (i.e., if either the business or an essential customer-facing part of the product cannot function without it), then the severity of any failure it experiences should match the service’s categorization. Scope, on the other hand, is related to how much of the ecosystem is affected by the failure, and is usually split into three categories: high, medium, and low. An incident whose scope is high is an incident that affects the entire business and/or an external (e.g., user-facing) feature; a medium-scope incident would be one that affected only the service itself, or the service and a few of its clients; a low-scope incident would be one whose negative effects are not noticed by clients, the business, or external customers using the product. In other words, severity should be categorized based on the impact to the business, and scope should be categorized based on whether the incident is local or global.

## The Five Stages of Incident Response

Within the industry today, there are typically three standard steps in the process of responding to and resolving an incident: triage, mitigate, and resolve. Adopting microservice architecture, however, and achieving high availability and fault tolerance requires adopting two additional
steps in the incident response process: one for coordination, and another for follow-up. Together, these steps give us the five stages of incident response: assessment, coordination, mitigation, resolution, and follow-up.

### Assessment

The on-call engineer is the first responder, triaging every problem as soon as it triggers an alert, and his job is to determine the severity and scope of the issue.

### Coordination

Once the incident has been assessed and triaged, the next step is to first coordinate with other developers and teams and then begin communicating about the incident. This means that there need to be clear channels of communication for incidents and outages.

During the incident or outage, it’s important to have a clear record of communication regarding the incident for several reasons. First, recording communication during the
incident (in chat logs, over email, etc.) helps in diagnosing, root-causing, and mitigating the incident: everyone knows who is working on which fix, everyone knows what possible
failures have been eliminated as possible causes, and once the root has been identified, everyone knows exactly what caused the problem. Second, other services that depend on the
service experiencing the incident or outage need to be apprised of any problems so that they can mitigate its negative effects and ensure that their own service is protected from the failure. This keeps overall availability high, and prevents one service from bringing down entire dependency chains. Third, it helps when postmortems are written for severe, global incidents by giving a clear, detailed record of exactly what happened and how the problem was triaged, mitigated, and resolved.

### Mitigation

Mitigation is not the same as resolution: it is not fixing the root cause of the problem completely, only reducing its impact. An issue is not mitigated until both its availability and the availability of its clients are no longer compromised or suffering.

### Resolution

After the effects of the incident or outage have been mitigated, engineers can work to resolve the root cause of the problem. This entails actually fixing the root cause of the problem, which may not have been done when the problem was mitigated. Most importantly, this is when the clock stops ticking. The two most important quantities that count against a microservice’s SLA are time to detection (TTD) and time to mitigation (TTM). Once a problem has been mitigated, it should no longer be affecting end users or compromising the service’s SLA, and so time to resolution (TTR) rarely (if ever) counts against a service’s availability.

### Follow-up

Three things need to happen in the fifth and final follow-up stage of incident response:

* postmortems need to be written to analyze and understand the incident or outage,
* severe incidents and outages need to be shared and reviewed, and
* a list of action items needs to be put together so that the development team(s) can complete them in order for the affected microservice(s) to return to a production-ready state (action items can often be fit into postmortems).