# What are Microservices

- [What are Microservices](#what-are-microservices)
  - [Small, and Focused on Doing One Thing Well](#small-and-focused-on-doing-one-thing-well)
  - [Autonomous](#autonomous)

Microservices are small, autonomous services that work together. Let’s break that definition down a bit and consider the characteristics that make microservices different.

## Small, and Focused on Doing One Thing Well

Cohesion — the drive to have related code grouped together — is an important concept when we think about microservices. This is reinforced by Robert C. Martin’s  definition of the Single Responsibility Principle, which states “Gather together those things that change for the same reason, and separate those things that change for different reasons.”

Microservices take this same approach to independent services. We focus our service
boundaries on business boundaries, making it obvious where code lives for a given
piece of functionality. The key is keeping this service focused on an explicit boundary.

A question may be _how small is small_?

1. Giving a number for lines of code is problematic.
   1. Some languages are more expressive than others and can therefore do more in fewer lines of code.
   2. We could be pulling in multiple dependencies, which themselves contain many lines of code.
   3. Some part of your domain may be legitimately complex, requiring more code.
2. Jon Eaves at RealEstate.com.au in Australia characterizes a microservice as something that could be rewritten in two weeks, a rule of thumb that may make sense for his context.
3. _Small enough and no smaller_: Once a piece of code no longer feels too big, it’s probably small enough.
4. A strong factor in helping us answer _how small_? is how well the service aligns to team structures. If the codebase is too big to be managed by a small team, looking to break it down is very sensible.
5. The smaller the service, the more you maximize the benefits and downsides of microservice architecture. As you get smaller, the benefits around interdependence increase. But so too does some of the complexity that emerges from having more and  moving parts, something that we will explore throughout this book. As you get better
at handling this complexity, you can strive for smaller and smaller services.

## Autonomous

1. A microservice is a separate entity in itself.
1. It might be deployed as an isolated service on a platform as a service (PAAS)
1. It might be its own operating system process.
1. We try to avoid packing multiple services onto the same machine, although the definition of machine in today’s world is pretty hazy!

    Disadvantage: This isolation can add some overhead, but newer technologies are able to mitigate many of the challenges associated with this form of deployment.

    Advantage: The resulting simplicity makes our distributed system much easier to reason about.

1. All communication between the services themselves are via network calls. This enforces separation between the services and avoids the perils of tight coupling.
1. These services need to be able to change independently of each other.
1. Services should support being deployed by themselves without requiring consumers to change.
   1. We need to think about what our services should expose, and what they should allow to be hidden.
   2. If there is too much sharing, our consuming services become coupled to our internal representations. This decreases our autonomy, as it requires additional coordination with consumers when making changes.
1. Services expose application programming interface (API), and collaborating services communicate with us via those APIs.
   1. Need to think about technology-agnostic APIs to ensure that we don’t constrain technology choices and decouple consumers.
1. Without decoupling, everything breaks down for us. The golden rule: can you make a change to a service and deploy it by itself without changing anything else? If the answer is no, then many of the advantages we discuss throughout this book will be hard for you to achieve.
1. To do decoupling well, you’ll need to model your services right and get the APIs right.