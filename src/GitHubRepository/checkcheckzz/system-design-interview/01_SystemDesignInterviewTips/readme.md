# System Design Interview Tips

## Clarify the constraints and identify the user cases

- Ask clarifying questions to interviewer.
- Make sure there is agreement on the scope of the system.
- Ensure any and all requirements not explicitly stated by interviewer are captured.

User cases indicate the main functions of the system, and constraints list the scale of the system such as requests per second, requests types, data written per second, data read per second.

## High-level architecture design

- Sketch the important components and the connections between them, but don't go into some details.
- Usually, a scalable system includes webserver (load balancer), service (service partition), database (primary/secondary database cluster plug cache).

## Component design

- For each component, you need to write the specific APIs for each component.
- You may need to finish the detailed OOD design for a particular function.
- You may also need to design the database schema for the database.
