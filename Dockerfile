FROM openjdk:11
LABEL maintainer="masud"
ADD target/bank-microservice-0.0.1-SNAPSHOT.jar bank-microservice.jar
ENTRYPOINT ["java", "-jar", "bank-microservice.jar"]