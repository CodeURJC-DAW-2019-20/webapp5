#Image from https://hub.docker.com/_/maven
#Image from https://hub.docker.com/_/openjdk
FROM openjdk:8-jdk-alpine

COPY backend-0.0.1-SNAPSHOT.jar /usr/src

WORKDIR /usr/src
CMD ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]
