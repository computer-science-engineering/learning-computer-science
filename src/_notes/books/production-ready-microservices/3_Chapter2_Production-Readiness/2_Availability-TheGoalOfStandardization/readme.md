# Availability: The Goal of Standardization

Within microservice ecosystems, service-level agreements (SLAs) regarding the availability of a service are the most commonly used methods of measuring a service’s success.

Calculating and measuring availability is easy. You need to calculate only three measurable quantities: uptime (the length of time that the microservice worked correctly), downtime (the length of time that the microservice was not working correctly), and the total time a service was operational (the sum of uptime and downtime). Availability is then the uptime divided by the total time a service was operational (uptime + downtime).