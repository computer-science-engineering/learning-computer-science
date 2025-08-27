# Distributed Systems

- [Distributed Systems](#distributed-systems)
  - [Introduction](#introduction)
  - [1. Basics](#1-basics)
  - [2. Up and down the level of abstraction](#2-up-and-down-the-level-of-abstraction)
  - [3. Time and order](#3-time-and-order)
  - [4. Replication: preventing divergence](#4-replication-preventing-divergence)
  - [5. Replication: accepting divergence](#5-replication-accepting-divergence)
  - [Appendix](#appendix)

## Introduction

In my view, much of distributed programming is about dealing with  implications of two consequences of distribution:

- that information travels at the speed of light
- that independent things fail independently [This is a lie. [This post by Jay Kreps elaborates](http://blog.empathybox.com/post/19574936361/getting-real-about-distributed-system-reliability).]

In other words, that the core of distributed programming is dealing  distance (duh!) and having more than one thing (duh!). These define a space of possible system designs, and my hope is that after reading this you'll have a better sense of how distance, time and consistency models interact.

## 1. Basics

The first chapter covers distributed systems at a high level. It covers high level goals, such as

- scalability,
- availability,
- performance,
- latency and
- fault tolerance;

how those are hard to achieve, and how abstractions and models as well as partitioning and replication come into play.

## 2. Up and down the level of abstraction

The second chapter dives deeper into abstractions and impossibility results. It introduces system models and the many assumptions that are made in a typical system model. It then discusses the CAP theorem and summarizes the FLP impossibility result. It then turns to the implications of the CAP theorem, one of which is that one ought to explore other consistency models. A number of consistency models are then discussed.

## 3. Time and order

If we fail to understand and model time, our systems will fail. The third chapter discusses time and order, and clocks as well as the various uses of time, order and clocks (such as vector clocks and failure detectors).

## 4. Replication: preventing divergence

The fourth chapter introduces the replication problem, and the two basic ways in which it can be performed. It turns out that most of the relevant characteristics can be discussed with just this simple characterization. Then, replication methods for maintaining single-copy consistency are discussed from the least fault tolerant (2PC) to Paxos.

## 5. Replication: accepting divergence

The fifth chapter discussed replication with weak consistency guarantees. It introduces a basic reconciliation scenario, where partitioned replicas attempt to reach agreement. It then discusses Amazon's Dynamo as an example of a system design with weak consistency guarantees. Finally, two perspectives on disorderly programming are discussed: CRDTs and the CALM theorem.

## Appendix

Covers recommendations for further reading.