# Layer 1: Hardware

Many different types of servers can live here: some are
optimized for databases; others for processing CPU-intensive tasks. These servers can either be owned by the company itself, or “rented” from so-called cloud providers like Amazon Web Services’ Elastic Compute Cloud (AWS EC2), Google Cloud Platform (GCP), or Microsoft Azure.

The majority of microservice ecosystems run some variant of Linux. Additional abstractions can be built and layered atop the hardware: resource isolation and resource abstraction (as offered by technologies like Docker and Apache Mesos) also belong in this layer, as do databases (dedicated or shared).

Installing an operating system and provisioning the hardware is the first layer on top of the servers themselves. Each host must be provisioned and configured, and after the operating system is installed, a configuration management tool (such as Ansible, Chef, or Puppet) should be used to install all of the applications and set all the necessary configurations.

The hosts need proper host-level monitoring (using something like Nagios) and host-level logging so that if anything happens (disk failure, network failure, or if CPU utilization goes
through the roof), problems with the hosts can be easily diagnosed, mitigated, and resolved.

## SUMMARY OF LAYER 1: THE HARDWARE LAYER

The hardware layer (layer 1) of the microservice ecosystem contains:

* The physical servers (owned by the company or rented from cloud providers)
* Databases (dedicated and/or shared)
* The operating system
* Resource isolation and abstraction
* Configuration management
* Host-level monitoring
* Host-level logging