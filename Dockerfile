FROM adoptopenjdk/openjdk14:alpine-jre
ARG JAR_FILE=target/product-catalog-cn-spring-boot-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]