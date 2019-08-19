# HOW TO ACE A SYSTEMS DESIGN INTERVIEW

- [HOW TO ACE A SYSTEMS DESIGN INTERVIEW](#how-to-ace-a-systems-design-interview)
  - [FOCUS ON THOUGHT PROCESS](#focus-on-thought-process)
  - [WE CARE ABOUT YOUR THOUGHT PROCESS](#we-care-about-your-thought-process)
  - [TOPICS](#topics)
    - [Concurrency](#concurrency)
    - [Networking](#networking)
    - [Abstraction](#abstraction)
    - [Real-World Performance](#real-world-performance)
    - [Estimation](#estimation)
    - [Availability and Reliability](#availability-and-reliability)
    - [Approach](#approach)
  - [HOW TO PREPARE](#how-to-prepare)
    - [Do mock design sessions](#do-mock-design-sessions)
    - [Work on an actual system](#work-on-an-actual-system)
    - [Back-of-the-envelope calculations](#back-of-the-envelope-calculations)
    - [Dig into the performance characteristics of an open source system](#dig-into-the-performance-characteristics-of-an-open-source-system)
    - [Learn how databases and operating systems work under the hood](#learn-how-databases-and-operating-systems-work-under-the-hood)
  - [FINAL THOUGHT: RELAX AND BE CREATIVE](#final-thought-relax-and-be-creative)
  - [References](#references)

## FOCUS ON THOUGHT PROCESS

- Thought process behind your design choices.
- Take ownership of _open-ended problems_, and it’s our job to come up with the best solution to each.
- Being able to communicate effectively with the people around you.

## WE CARE ABOUT YOUR THOUGHT PROCESS

- Open ended question to design a system that performs a given task.
- The point of the interview is to see how much volume you can cover in 45 minutes.
- You’ll be steering the conversation. It’s up to you to understand the problem. That might mean asking questions, sketching diagrams on the board, and bouncing ideas off your interviewer. Do you know the constraints? What kind of inputs does your system need to handle? You have to get a sense for the scope of the problem before you start exploring the space of possible solutions. And remember, there is no single right answer to a real-world problem. Everything is a tradeoff.

## TOPICS

### Concurrency

- Do you understand threads, deadlock, and starvation?
- Do you know how to parallelize algorithms?
- Do you understand consistency and coherence?

### Networking

- Do you roughly understand IPC and TCP/IP?
- Do you know the difference between throughput and latency, and when each is the relevant factor?

### Abstraction

- You should understand the systems you’re building upon.
- Do you know roughly how an OS, file system, and database work?
- Do you know about the various levels of caching in a modern OS?

### Real-World Performance

- You should be familiar with the speed of everything your computer can do, including the relative performance of RAM, disk, SSD and your network.

### Estimation

- Estimation, especially in the form of a back-of-the-envelope calculation, is important because it helps you narrow down the list of possible solutions to only the ones that are feasible. Then you have only a few prototypes or micro-benchmarks to write.

### Availability and Reliability

- Are you thinking about how things can fail, especially in a distributed environment?
- Do know how to design a system to cope with network failures?
- Do you understand durability?

### Approach

More than mastery, close familiarity is important. We just want to make sure you have a good lay of the land, so you know which questions to ask and when to consult an expert.

## HOW TO PREPARE

### Do mock design sessions

- Design interviews are similar to actual design sessions, so getting better at one will make you better at the other.

### Work on an actual system

- Contribute to OSS or build something with a friend. Treat your class projects as more than just academic exercises—actually focus on the architecture and the tradeoffs behind each decision. As with most things, the best way to learn is by doing.

### Back-of-the-envelope calculations

- Do back-of-the-envelope calculations for something you’re building and then write micro-benchmarks to verify them.
- If your micro-benchmarks don’t match your back-of-the-envelope numbers, some part of your mental model will have to give, and you’ll learn something in the process.

### Dig into the performance characteristics of an open source system

- For example, take a look at [LevelDB](https://github.com/google/leveldb). It’s new and clean and small and well-documented. Read about the implementation to understand how it stores its data on disk and how it compacts the data into levels. Ask yourself questions about tradeoffs: which kinds of data and sizes are optimal, and which degrade read/write performance? (Hint: think about random vs. sequential writes.)

### Learn how databases and operating systems work under the hood

- These technologies are not only tools in your belt, but also a great source of design inspiration.
- If you can think like a DB or an OS and understand how each solves the problems it was designed to solve, you’ll be able to apply that mindset to other systems.

## FINAL THOUGHT: RELAX AND BE CREATIVE

- The systems design interview can be difficult, but it’s also a place to be creative and to take joy in the imagining of systems un-built.
- If you **listen carefully**, make sure you **fully understand the problem**, and then take a **clear, straightforward approach to communicating your ideas**, you should do fine.

## References

1. [Original Post over at Palantir](https://www.palantir.com/2011/10/how-to-rock-a-systems-design-interview/)
