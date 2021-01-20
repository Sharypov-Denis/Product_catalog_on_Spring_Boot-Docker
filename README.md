В разработке!!!
# The task is: Implement a small web application - Product Catalog, packaging in container Docker

# Functionality: 
* Add a product
* Delete a product
* Edit a product
* Search for a product by name

# Technology stack: 
* Java 14
* Spring Framework(Spring Boot, Core,MVC, Data JPA)
* Docker
* PostgreSQL
* JSP
* Stream API
* Junit 4
* Maven

# Build and run
1. Create PostgreSQL database,
2. Add credentials to application.properties,
3. Execute InitDB_Postgresql.sql script

Build an image with docker
1. ./mvnw package && java -jar target/product-catalog-cn-spring-boot-0.0.1-SNAPSHOT.jar
2. docker build -t product-catalog-cn-spring-boot:0.0.1 .
3. docker run -d -p 8080:8080 -t product-catalog-cn-spring-boot:0.0.1

Developing in IntelliJ IDEA Ultimate
