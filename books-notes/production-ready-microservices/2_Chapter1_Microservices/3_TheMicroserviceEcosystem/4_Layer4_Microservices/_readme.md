# Layer 4: Microservices

This layer is where the microservices — and anything specific to them — live, completely abstracted away from the lower infrastructure layers. The only things that are not abstracted away from the microservice layer are the configurations specific to each service for using the tools.

...all microservice-specific configurations can live in the repository of the microservice and should be accessed there by the tools and systems of the layers below.

## SUMMARY OF LAYER 4: THE MICROSERVICE LAYER

The microservice layer (layer 4) of the microservice ecosystem contains:

* The microservices
* All microservice-specific configurations