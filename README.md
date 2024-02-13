In the pursuit of creating an E-commerce Application within this project, we ve collaborated with Spring Cloud to shape the microservice architecture. The foundational cornerstone of this structure is the customer-service,
an autonomous microservice responsible for managing the clients of our application. along with the inventory-service which assumes the role of overseeing product management. 
The third microservice of significance is the Spring Cloud Gateway. The configuration of its routes has been executed in two distinctive manners: statically, through the use of the .yml file to precisely outline the routes,
and dynamically, employing the 'DiscoveryClientRouteDefinitionLocator' object, among other methods. 
At this stage, we introduced the Eureka Discovery Service to enhance overall system coherence and discoverability.
To make things more interesting we incorporated an additional microservice: the 'billing-service' This entity was designed to facilitate communication with the previously established microservices, athis was made possible by
the utilization of the Open Feign framework.

the following schema summarizes and simplifies what have been said to make it less confusing:

![Screenshot (1684)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/c3282572-b05a-458d-bc24-a8ac4eb93a3a)



after establishing the feachesr of our micro service, now we can access the h2 console to display our customer
![Screenshot (1685)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/257f0dbb-289e-411f-8b53-10bd9c3d391d)




we can as well access a Rest Controller, since we used Spring Data Rest which provides the ability to use all the basic feachers of a rest controller
![Screenshot (1686)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/ed20947e-7cf0-4cb7-87b3-1e9d2118d415)




this time we ve exposed the Ids as well, for it might be beneficial for us later
![Screenshot (1687)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/f43b5cc6-750a-46a9-854d-bd0f1591e909)




here is the result of the projection named "fullCustomer" which shows only 2 attributes of the "Customer"
![Screenshot (1688)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/2b12896f-9324-4da2-92d0-494e20d34c3a)




and this is the list of "Products" from the newly created micro service "inventory-service"
![Screenshot (1689)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/70f89ca7-c834-4b02-817d-1dbc2506a1d9)





















