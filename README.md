In the pursuit of creating an E-commerce Application within this project, we ve collaborated with Spring Cloud to shape the microservice architecture. The foundational cornerstone of this structure is the customer-service,
an autonomous microservice responsible for managing the clients of our application. along with the inventory-service which assumes the role of overseeing product management. 
The third microservice of significance is the Spring Cloud Gateway. The configuration of its routes has been executed in two distinctive manners: statically, through the use of the .yml file to precisely outline the routes,
and dynamically, employing the 'DiscoveryClientRouteDefinitionLocator' object, among other methods. 
At this stage, we introduced the Eureka Discovery Service to enhance overall system coherence and discoverability.
To make things more interesting we incorporated an additional microservice: the 'billing-service' This entity was designed to facilitate communication with the previously established microservices, athis was made possible by
the utilization of the Open Feign framework.

the following schema summarizes and simplifies what have been said to make it less confusing:

![Screenshot (1684)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/c3282572-b05a-458d-bc24-a8ac4eb93a3a)


