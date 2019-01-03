# On-Call Rotations

In a microservice ecosystem, the development teams themselves are responsible for the availability of their microservices. Where monitoring is concerned, this means that developers need to be on call for their own microservices. The goal of each developer on-call for a microservice needs to be clear: they are to detect, mitigate, and resolve any issue that arises with the microservice during their on call shift before the issue causes an outage for their microservice or impacts the business itself.

In some larger engineering organizations, site reliability engineers, DevOps, or other operations engineers may take on the responsibility for monitoring and on call, but this requires each microservice to be relatively stable and reliable before the on-call responsibilities can be handed off to another team.

In a microservice ecosystem, developers need to bear the responsibility of monitoring the code that they deploy.

Designing good on-call rotations is crucial and requires the involvement of the entire team. To prevent burnout, on-call rotations should be both brief and shared: no fewer than two
developers should ever be on call at one time, and on-call shifts should last no longer than one week and be spaced no more frequently than one month apart.

The on-call rotations of each microservice should be internally publicized and easily accessible. If a microservice team is experiencing issues with one of their dependencies, they
should be able to track down the on-call engineers for the microservice and contact them very quickly. Hosting this information in a centralized place helps to make developers more
effective in triaging problems and preventing outages.

Developing standardized on-call procedures across an engineering organization will go a long way toward building a sustainable microservice ecosystem.