#Image from https://hub.docker.com/_/maven
#Image from https://hub.docker.com/_/openjdk

FROM openjdk:8-jdk

COPY backend.jar /usr/src
COPY wait-for-it.sh /usr/src
WORKDIR /usr/src
CMD ["java", "-jar", "backend.jar"]

