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

| Technology | Badge |
|:-----------:|:-----:|
| Travis CI | [![Build Status](https://travis-ci.com/Sharypov-Denis/Product_catalog_on_Spring_Boot_plus_Docker.svg?branch=master)](https://travis-ci.com/github/Sharypov-Denis/Product_catalog_on_Spring_Boot_plus_Docker) |

# Build and run 
1. ./mvnw package && java -jar target/product-catalog-cn-spring-boot-0.0.1-SNAPSHOT.jar
2. docker build -t product-catalog-cn-spring-boot:0.0.1 .
3. docker run -d -p 8080:8080 -t product-catalog-cn-spring-boot:0.0.1

docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)

If you want to use PostgreSQL:
1. Correct "POM" (remove commits),
2. Correct "application.properties" (remove commits)
3. Create PostgreSQL database in docker: "docker run --name some-postgres --volume db-data:/var/lib/postgresql/data -e POSTGRES_PASSWORD=qqq -e POSTGRES_DB=prod -p 5434:5432 postgres:12-alpine"
   Build an image with docker
4. docker build -t product-catalog-cn-spring-boot:0.0.1 .
5. docker run -d -p 8080:8080 -t product-catalog-cn-spring-boot:0.0.1






Developing in IntelliJ IDEA Ultimate
