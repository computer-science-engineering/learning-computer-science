# Other Decompositional Techniques

- [Other Decompositional Techniques](#other-decompositional-techniques)
  - [Shared Libraries](#shared-libraries)
  - [Modules](#modules)

Many of the advantages of a microservice-based architecture come from its granular nature and the fact that it gives you many more choices as to how to solve problems. But could similar decompositional techniques achieve the same benefits?

## Shared Libraries

A very standard decompositional technique is breaking down a codebase into multiple libraries.

There are some drawbacks with this approach:

1. You lose true technology heterogeneity. The library typically has to be in the same language, or at the very least run on the same platform.
2. The ease with which you can scale parts of your system independently from each other is curtailed.
3. Next, unless you’re using dynamically linked libraries, you cannot deploy a new library without redeploying the entire process, so your ability to deploy changes in isolation is reduced.
4. You lack the obvious seams around which to erect architectural safety measures to ensure system resiliency.
5. Shared code used to communicate between services can become a point of coupling.

Services can and should make heavy use of third-party libraries to reuse common code. But they don’t get us all the way there.

## Modules

Some languages provide their own modular decomposition techniques that go beyond simple libraries. They allow some lifecycle management of the modules, such that they can be deployed into a running process, allowing you to make changes without taking the whole process down.