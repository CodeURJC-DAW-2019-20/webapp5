#Image from https://hub.docker.com/_/maven
#Image from https://hub.docker.com/_/openjdk
FROM openjdk:8-jdk-alpine

COPY backend.jar /usr/src

WORKDIR /usr/src
CMD ["java", "-jar", "backend.jar"]
