FROM openjdk:latest
VOLUME /tmp
ADD target/MicroService-1.0.jar MicroService.jar
ENTRYPOINT ["java","-jar","MicroService.jar"]
