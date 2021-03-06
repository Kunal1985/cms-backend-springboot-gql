# CMS-SpringBoot-GraphQL
Backend-CMS application developed using SpringBoot-GraphQL.

## Pre-Requisites
Maven  
Java 8 (minimum required)  
Building a GraphQL Server with Spring Boot (https://www.pluralsight.com/guides/java-and-j2ee/building-a-graphql-server-with-spring-boot).  
MongoDB (3.xx)

## Installation
### Install Basic Maven Packages from pom.xml
`mvn clean intall`  
OR  
`mvn clean` followed by `mvn install`  
NOTE: `mvn clean` is required as per individual machine configurations.

## Configurations
### Mongo Configuration
All the MongoDB related configurations present under src\main\resources\application.properties

### GraphQL Configurations/Samples
#### Configurations
GraphQL Definitions for Query/Mutation can be found under the folder - src\main\resources\graphql

#### Samples
GraphQL Samples for Query/Mutation can be found under the folder - src\main\resources\samples

## Running the Application
### Start the SpringBoot Application Server
Navigate to CMSApplication.java  
Run/Debug As Java Application.

### Accessing the application
http://localhost:8080/graphiql >> GraphiQL Interface

# License
MIT
