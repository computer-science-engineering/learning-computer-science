# Chapter 2: The Evolutionary Architect

- [Chapter 2: The Evolutionary Architect](#chapter-2-the-evolutionary-architect)
  - [Inaccurate Comparisons](#inaccurate-comparisons)
  - [An Evolutionary Vision for the Architect](#an-evolutionary-vision-for-the-architect)
  - [Zoning](#zoning)
  - [A Principled Approach](#a-principled-approach)

Microservices give us a lot of choice, and accordingly a lot of decisions to make.

1. How many different technologies should we use.
2. Should we let different teams use different programming idioms.
3. Should we split or merge a service.

## Inaccurate Comparisons

In our industry, a view of the architect analogues to those in civil engineering or architecture leads to some terrible practices. Diagram after diagram, page after page of documentation, created with a view to inform the construction of the perfect system, without taking into account the fundamentally unknowable future. Utterly devoid of any understanding as to how hard it will be to implement, or whether or not it will actually work, let alone having any ability to change as we learn more.

When we compare ourselves to engineers or architects, we are in danger of doing everyone a disservice. Unfortunately, we are stuck with the word architect for now. So the best we can do is to redefine what it means in our context.

## An Evolutionary Vision for the Architect

The things we create are not fixed points in time. Architects need to shift their thinking away from creating the perfect end product, and instead focus on helping create a framework in which the right systems can emerge, and continue to grow as we learn more.

As our users use our software, we need to react and change. We cannot foresee everything that will happen, and so rather than plan for any eventuality, we should plan to allow for change by avoiding the urge to over-specify every last thing. Our city — the system — needs to be a good, happy place for everyone who uses it. One thing that people often forget is that our system doesn’t just accommodate users; it also accommodates developers and operations people who also have to work there, and who have the job of making sure it can change as required. To borrow a term from Frank Buschmann, architects have a duty to ensure that the system is habitable for developers too.

A town planner, just like an architect, also needs to know when his plan isn’t being followed. As he is less prescriptive, the number of times he needs to get involved to correct direction should be minimal, but if someone decides to build a sewage plant in a residential area, he needs to be able to shut it down.

So our architects as town planners need to set direction in broad strokes, and only get involved in being highly specific about implementation detail in limited cases. They need to ensure that the system is fit for purpose now, but also a platform for the future. And they need to ensure that it is a system that makes users and developers equally happy.

## Zoning

Zones could be service boundaries, or coarse-grained group of services. Architects need to worry much less about what happens inside the zone than what happens between the zones. So we need to spend time thinking about how our services talk to each other, or ensuring that we can properly monitor the overall health of our system.

Within each service, you may be OK with the team who owns that zone picking a different technology stack or data store. Other concerns may kick in here, of course. Your inclination to let teams pick the right tool for the job may be tempered by the fact that it becomes harder to hire people or move them between teams if you have 10 different technology stacks to support.

Between services is where things can get messy, however. If one service decides to expose REST over HTTP, another makes use of protocol buffers, and a third uses Java RMI, then integration can become a nightmare as consuming services have to understand and support multiple styles of interchange. This is why I try to stick to the guideline that we should "be worried about what happens between the boxes, and be liberal in what happens inside."

**The Coding Architect**: Important it is for the architect to actually sit with the team, perhaps even work with them sometime, including coding with them if need be.

## A Principled Approach