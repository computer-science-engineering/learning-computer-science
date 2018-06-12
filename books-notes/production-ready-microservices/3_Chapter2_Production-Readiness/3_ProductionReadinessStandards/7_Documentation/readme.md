# Documentation

Microservice architecture carries the potential for increased technical debt — it’s one of the key trade-offs that come with adopting microservices. As a rule, technical debt tends to increase with developer velocity. Organizational clarity and structure around the documentation and understanding of a microservice cut through this technical debt and shave off a lot of the confusion, lack of awareness, and lack of
architectural comprehension that tend to accompany it.

Just like each of the other production-readiness standards, documentation and its counterpart (understanding) directly and
measurably influence the availability of a microservice.

When it’s time for code changes to be reviewed, technologies to be swapped, or features to be added, the lack of alignment of knowledge and understanding will lead to the design and/or evolution of microservices that are not production-ready, containing serious flaws that undermine the service’s ability to reliably serve production traffic.

This confusion and the problems that it creates can be successfully and rather easily avoided by requiring that every microservice follow a very strictly standardized set of documentation requirements. Documentation needs to contain all the essential knowledge (facts) about a
microservice, including:

* an architecture diagram,
* an onboarding and development guide,
* details about the request flow and any API endpoints, and
* an on-call runbook for each of the service’s alerts.

By making architecture reviews part of each team’s process and
scheduling them regularly, you can guarantee that knowledge and understanding about any changes in the microservice will be disseminated to the entire team.

Consider the production-readiness standards themselves - running audits of whether a microservice meets the requirements and then creating a roadmap for the service detailing how to bring it to a production-ready state. Checking the requirements can also be automated across the organization.

## DOCUMENTATION REQUIREMENTS

The requirements of building a well-documented microservice are:

* Thorough, updated, and centralized documentation containing all of the relevant and essential information about the microservice
* Organizational understanding at the developer, team, and ecosystem levels

The details of production-ready documentation requirements are covered in Chapter 7, Documentation and Understanding.