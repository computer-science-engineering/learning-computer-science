# Preface

- [Preface](#preface)
  - [Who Should Read This Book](#who-should-read-this-book)
  - [Why I Wrote This Book](#why-i-wrote-this-book)
  - [A Word on Microservices Today](#a-word-on-microservices-today)
  - [Navigating This Book](#navigating-this-book)
    - [Chapter 1, Microservices](#chapter-1-microservices)
    - [Chapter 2, The Evolutionary Architect](#chapter-2-the-evolutionary-architect)
    - [Chapter 3, How to Model Services](#chapter-3-how-to-model-services)
    - [Chapter 4, Integration](#chapter-4-integration)
    - [Chapter 5, Splitting the Monolith](#chapter-5-splitting-the-monolith)
    - [Chapter 6, Deployment](#chapter-6-deployment)
    - [Chapter 7, Testing](#chapter-7-testing)
    - [Chapter 8, Monitoring](#chapter-8-monitoring)
    - [Chapter 9, Security](#chapter-9-security)
    - [Chapter 10, Conway’s Law and System Design](#chapter-10-conways-law-and-system-design)
    - [Chapter 11, Microservices at Scale](#chapter-11-microservices-at-scale)
    - [Chapter 12, Bringing It All Together](#chapter-12-bringing-it-all-together)

Microservices are an approach to distributed systems that promote the use of finely grained services with their own lifecycles, which collaborate together.

## Who Should Read This Book

- It should appeal to people interested in aspects of design, development, deployment, testing, and maintenance of systems.
- Those of you who have already embarked on the journey toward finer-grained architectures, whether for a greenfield application or as part of decomposing an existing, more monolithic system
- The curious, so that you can determine whether microservices are right for you.

## Why I Wrote This Book

This book was imagined as a one-stop shop that would help encompass the wide variety of top‐ics that are necessary for understanding microservices.

## A Word on Microservices Today

- Microservices is a fast-moving topic.
- Tried to focus this book on ideas more than specific technologies, knowing that implementation details always change faster than the thoughts behind them.
- Be prepared for many years of continuous learning to keep on top of the state of the art!

## Navigating This Book

- This book is primarily organized in a topic-based format.
- Chapter 2 touches on the breadth of the topic as well as providing some framing for how I go about things in case if you want to dive deeper into some of the later topics.

Here is an overview of what we cover:

### Chapter 1, Microservices

1. Introduction to microservices.
1. The key benefits as well as some of the downsides.

### Chapter 2, The Evolutionary Architect

1. Difficulties in terms of making trade-offs as architects.
1. Specifically just how many things we need to think about with microservices.

### Chapter 3, How to Model Services

1. Start to define the boundary of microservices.
1. Using techniques from domain-driven design to help focus our thinking.

### Chapter 4, Integration

1. Start getting a bit deeper into specific technology implications, as we discuss what sorts of service collaboration techniques will help us most.
1. Delve into the topic of user interfaces and integrating with legacy and
commercial off-the-shelf (COTS) products.

### Chapter 5, Splitting the Monolith

1. Microservices as an antidote to large, hard-to-change monolithic systems.

### Chapter 6, Deployment

1. Although this book is primarily theoretical, few topics in the book have been as
impacted by recent changes in technology as deployment, which we’ll explore
here.

### Chapter 7, Testing

1. Deep discussion of testing, an area of particular concern when handling the deployment of multiple discrete services.
1. Role that consumer-driven contracts can play in helping us ensure the quality of our software.

### Chapter 8, Monitoring

1. Explores how we can monitor our fine-grained systems.
1. Deal with some of the emergent complexity of distributed systems.

### Chapter 9, Security

1. Examine the security aspects of microservices.
1. Consider how to handle user-to-service and service-to-service authentication and authorization.
1. Goal is to help you consider some of the security aspects you need to be aware of when building systems, and microservice systems in particular.

### Chapter 10, Conway’s Law and System Design

1. This chapter focuses on the interplay of organizational structure and architecture. Trouble will occur if you don’t keep the two in harmony.
1. We’ll attempt to get to the bottom of this dilemma, and consider some different ways to align system design with the structure of your teams.

### Chapter 11, Microservices at Scale

1. This is where we start looking at doing all of this at scale, so that we can handle the increased chance of failure that can happen with large numbers of services, as well as large volumes of traffic.

### Chapter 12, Bringing It All Together

1. The final chapter attempts to distill down the core essence of what makes microservices different.
1. It includes a list of seven microservices principles, as well as a wrap-up of the key points of the book.