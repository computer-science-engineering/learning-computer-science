# Microservice Architecture

The API endpoints of microservices should be standardized across an organization, i.e., the type of endpoint should be the same. Choice of endpoint type is reflective of the internal workings of the microservice itself, and will also dictate its architecture: it’s difficult to build an asynchronous microservice that communicates via HTTP over REST endpoints, for example, which would necessitate adding a messaging-based endpoint to the services as well.

Microservices interact with each other via remote procedure calls (RPCs), which are calls over the network designed to look and behave exactly like local procedure calls. The protocols used will be dependent on architectural choices and organizational support, as well as the endpoints used. A microservice with REST endpoints, for example, will likely interact with other microservices via HTTP, while a microservice with Thrift endpoints may communicate with other microservices over HTTP or a more customized, in-house solution.

Avoid versioning in microservices and endpoints since it tends to become a maintenance nightmare.

...developers are free to write the internal workings of their microservice however they wish. It can be written in any language whatsoever — it can be written in Go, in Java, in Erlang, in Haskell — as long as the endpoints and communication protocols are taken care of.