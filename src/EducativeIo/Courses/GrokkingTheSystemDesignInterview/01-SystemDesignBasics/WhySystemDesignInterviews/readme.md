# Why System Design Interviews

## What are system design interviews

* Demonstrate ability to develop a high-level architecture of a large system.
* Questions are flexible, unpredictable, usually open-ended, and have no standard or squarely correct answer.
* In coding interviews problem solving ability of the candidates is evaluated. In design interviews complicated and fuzzy questions are asked which aim at testing candidate’s
  * ability to analyze a vague and complicated problem
  * compatibility with building large systems
  * presentation of their solution
  * competence in guiding and moving the conversation forward
* Goal is to determine
  * candidate's approach and strategy to handle a problem
  * how organized, disciplined, systematic, and professional candidate is in solving it
  * candidate's capacity to analyze an issue and your level of professional mechanics to solve it step by step
* Discussion with the interviewer that is of core importance

## How to give system design interview

* No strictly defined process for system design interview.
* Very important to ask for clarification.
* Questions are intentionally weakly defined so should not jump to solution without understanding the problem first.
* Important to gather requirements. Considering the example of a URL shortening service:
  * It could be serving just a few thousand users, but each could be sharing millions of URLs.
  * It could also mean to handle millions of clicks on the shortened URLs or just a few dozens.
  * The service may also require providing extensive statistics about each shortened URL, or not.
* With full detail of problem not being presented, candidate would be expected to scale the breadth and depth of a blurred and indistinct problem.

### Try to learn from existing systems

* How have existing systems been designed?
* Interviewing would expect candidate's analytical and questioning ability to be similar to his/her own.
* For experiences candidates some basic questions may not be appropriate which may be fine for a fresh graduate.

### Leading the conversation

* More than the solution, the discussion is important.
* Candidate should lead the discussion going both broad and deep into the components of the problem.

### Solve by breaking down

* A top-down and modularization approach can help a lot in solving the problem.
* Break down problem into modules and tackle each of them independently.
* Subsequently, each component can be solved as a sub problem by reducing it to the level of a known algorithm.
* This strategy makes design as well as evaluation cleaner and easier.
* However important to note that design interview problems usually do not have solutions, and the primary thing is the
  * approach to the problem and,
  * how candidate makes progress,
  * using what sort of strategies.

## Summary

Three step approach:

* **Scoping the problem:** Do not make assumptions. Ask questions to understand constraints and use-cases.
* **Sketching up an abstract design:** Illustrate the building blocks of the system and the relationships between them.
* **Identifying and addressing the bottlenecks:** Use the fundamental principles of scalable system design.

## Conclusion

* Design interviews are formidable, open-ended problems that cannot be solved in the allotted time.
* So, understand what interviewer intends to focus on and spend sufficient time on it.
* Be aware that discussion on system design problem could go in different directions depending on preferences of interviewer.
* Possible that interviewer may be unwilling to look at high-level architecture and interested in deep-diving into specific area.
* So very important to understand situation and focus accordingly on the right aspects which discussing the problem.
* There is no one right answer to a system design question because it can be built in different ways.
* The only thing that is going to be looked into is candidate's ability to rationalize ideas and inputs.
