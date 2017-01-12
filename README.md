# spring-cloud-examples

A project to showcase Spring Cloud

With the aim of creating a small Users microservice that is scalable, self documenting, and able to be easily incorporated into a more complex architecture.

Implemented features:

* Service discovery
* API gateway
* Users model
* Health check dashboard

Planned features:

* A working connection to a database for Users
* Functional endpoints for Creating, Reading, Updating, Deleting, and Finding Users
* Notifications for theoretical Search and Competition microservices

## Docker and Maven

Each service is built and deployed using Maven and Docker, allowing a developer to deploy all or any subset of services to their machine for testing.

Adding new microservices is a simple affair thanks to Service Discovery, and a Gateway that routes traffic through a single interface.

## Service discovery

Utilises the Netflix Eureka library, providing a proxy-based API gateway.

## Build and run

Executing `mvn clean install` in the top directory will build all the images.

Executing `docker-compose up` in the /docker/ directory will deploy each service onto separate containers.

## Service status

Browsing to `http://localhost:10000/` provides the following features:

* Ping
* Health
* Hosts/Gateway

## REST API

Sending Curl requests to `http://localhost:10000/users` provides a response.

`/users/create`, `/users/update`, `/users/delete` and `/users/find` should perform the corresponding actions on a database, but are not currently operational.
