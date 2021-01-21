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
* HSQLDB
* Html
* Stream API
* Junit 4
* Maven

# Build and run
Build an image with docker
1. ./mvnw package && java -jar target/product-catalog-cn-spring-boot-0.0.1-SNAPSHOT.jar
2. docker build -t product-catalog-cn-spring-boot:0.0.1 .
3. docker run -d -p 8080:8080 -t product-catalog-cn-spring-boot:0.0.1

4. docker stop $(docker ps -a -q)
5. docker rm $(docker ps -a -q)

Developing in IntelliJ IDEA Ultimate
