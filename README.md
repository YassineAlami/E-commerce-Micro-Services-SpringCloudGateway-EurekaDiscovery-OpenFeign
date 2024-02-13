In the pursuit of creating an E-commerce Application within this project, we ve collaborated with Spring Cloud to shape the microservice architecture. The foundational cornerstone of this structure is the customer-service,
an autonomous microservice responsible for managing the clients of our application. along with the inventory-service which assumes the role of overseeing product management. 
The third microservice of significance is the Spring Cloud Gateway. The configuration of its routes has been executed in two distinctive manners: statically, through the use of the .yml file to precisely outline the routes,
and dynamically, employing the 'DiscoveryClientRouteDefinitionLocator' object, among other methods. 
At this stage, we introduced the Eureka Discovery Service to enhance overall system coherence and discoverability.
To make things more interesting we incorporated an additional microservice: the 'billing-service' This entity was designed to facilitate communication with the previously established microservices, athis was made possible by
the utilization of the Open Feign framework.

the following schema summarizes and simplifies what have been said to make it less confusing:

![Screenshot (1684)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/c3282572-b05a-458d-bc24-a8ac4eb93a3a)



after establishing the feature of our micro service, now we can access the h2 console to display our customer
![Screenshot (1685)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/257f0dbb-289e-411f-8b53-10bd9c3d391d)




we can as well access a Rest Controller, since we used Spring Data Rest which provides the ability to use all the basic feachers of a rest controller
![Screenshot (1686)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/ed20947e-7cf0-4cb7-87b3-1e9d2118d415)




this time we ve exposed the Ids as well, for it might be beneficial for us later
![Screenshot (1687)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/f43b5cc6-750a-46a9-854d-bd0f1591e909)




here is the result of the projection named "fullCustomer" which shows only 2 attributes of the "Customer"
![Screenshot (1688)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/2b12896f-9324-4da2-92d0-494e20d34c3a)




and this is the list of "Products" from the newly created micro service "inventory-service"
![Screenshot (1689)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/70f89ca7-c834-4b02-817d-1dbc2506a1d9)



here is a test of accessing the micro services of our application through the gateway. we have configured the gateway's routes statically using the "yml" file
we can now reach out to the gateway in order to get to one of the app's microservices
![Screenshot (1692  )](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/b3d53fa8-d150-4cb8-bd6c-95ffdab8717f)

![Screenshot (1692 )](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/545004d1-2be8-45a1-8823-954b4f5ac113)

![Screenshot (1692)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/42075f9e-fdc7-4447-bea6-488cd957a610)



there is another way to configure a gateway -still static- is via the "java configuration" within the "gatewayApplication.java"
![Screenshot (1695)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/9638d131-e67b-4e5d-88eb-5630f5ab16bc)




now we ve introduced Eureka Discovery Service to our application. thia allows us to configure the gateway's routes dynamically
the following Eureka interface shows us the list of Micro Services that are registered in the discovery service. as it is mentioned here, so far we have none.. cuz we ve disabled the 'spring cloud discovery' in the different micro services and the gateway
![Screenshot (1697)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/75249d41-49ff-49de-a8f0-eac51e7e4cf9)



there we go! we can see that our services are now actually registered in the Eureka discovery service
this means that every one among these micro services once it starts it shall connect to the discovery service in order to regester its name and address
![Screenshot (1698)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/f61cd855-c38a-4a1f-864f-e9726c42902c)



now that we ve enabled the discovery, we can access our micro services dynamically via the gateway without knowing the their names
that means the gateway does not know the addresses, it only knows their names 
![Screenshot (1699)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/ab902a2b-1ab8-4524-8605-47d5158d13cb)




we can do even better, like we give the name of the micro service in the url with every request
in other words, to be able to call a micro service, we must specify its name in the URL 
the gateway does no longer need to know the names of the micro sevices, each time we want to access a micro service it s up to us to specify its name
![Screenshot (1700)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/0609a643-fb4a-479b-a22d-e0eca4e1d528)




we ve added a new service to our app, the "billing-service", which will take care of handling bills that come from the act of {customers purchasing products}.
the issue here is that this new service is related to both services created earlier ("customer-service" and "inventory-service")
![Screenshot (1701)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/5109039b-33b7-4d66-8aad-c93b5ed99875)



we can see that the billing service is in deed created and that it can communicate (via Rest useing interfaces from openFeign) with the other services, namely "inventory-service" and "customer-service"
![Screenshot (1703)  png](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/c068bbfb-0018-4c1f-b7e9-9f48248a800a)

![Screenshot (1703)](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/170574d1-6ed4-4f9c-9ad9-a4b1caba8f77)




i have gathered data from all three services, we searched for the bill that has "1" as id and we got detailed info about it, starting from its elemental attributes as with "id" and "billDate", next we have "productItems" which itself presents numerous elements, such as "quantity", "price" etc.
within "productItem" we have another element that is "product", which contains details about a specific product.
in a nutshell, we can now reach out from the billing microservice to our other microservices to access the needed data which is located in their databases with the help of the openFeign Framework
![Screenshot (1706) png](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/e637aea7-c895-4744-94b2-b59e1cab74e0)




and ofc, we can also access our BILLING-SERVICE via the gateway to get either the general list of bills or we can specify a cetain bill to get more details about it.

![Screenshot (1707) ](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/49355628-6cc1-48e0-b372-ba4dc7ed8440)

![Screenshot (1707) png](https://github.com/YassineAlami/E-commerce-Micro-Services-with-Spring-Cloud/assets/40896739/2bbe8a3e-4879-47e8-9453-b5272d61ba4e)

