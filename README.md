# E-Inventory-Management-System
A Spring Microservice Application, used for the management of product and order type inventories.

# Used Technlogies: 
1. Java 17
2. Spring 5
3. Hibernate
4. Eureka Server (Netflix)
5. Java / Spring JPA
6. Srping web flux.

# Explanation: 

It is an application, that is created using the concept of microservice architecture, meaning various services for each of their own responsibilites are created to work as an independent system. Here, too in this application a lot of services are created: 
1. API Gateway
2. Order, Product, Inventory
3. Authentication Server
4. Discovery Server

These different services work independently to each other and contact through the webclient, through a closed circuit breaker system only when the transmission of the data is required for the system to function in desired manner. 

## 1. Order, Product, Inventory Services:
-> Order Service represents an independent service, following the spring MVC model, responsible for the placement of the orders made by the customers. 
-> Product Service represents a service, responsible for creating a new product into the database and listing all the possible products inside the database. 
-> Inventory Service represnet a service, responsible for regulating the products in the database, checking the availability of the product inside the database. 
  
## 2. Discovery Server Serivce: 
-> It represents an independent service, build with netflix eureka server, allocating the target points to the required services, when one service directs the data pointer to other. It ensures that 
   services between each other always maintains a contacting address, even in the case of dynamic ip addresses. It provides the wrapped services a static cover up names, in case of any ip addresses of the    service, securing a fixed address to call the service in any case.  

## 3. Authentication Server Service: 
-> It refers to an independent spring service, required for the authentication of the login system. It is not a project/component in itself but is integrated within required services to contact it and do     the required security checks.  

## 4. API Gateway Service: 
-> It represent an independent service, transmitting the client side requests into the required API endpoint. It correctly identifies the API endpoint request by the client side application and directs       the request to the following respective service, then service's controller takes care for the endpoint to meet it's corresponding acting method.    

