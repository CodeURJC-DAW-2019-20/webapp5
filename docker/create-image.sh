#!/bin/bash

path_docker=$(pwd)

path_project_front=$(dirname $(pwd))/frontend
path_dist=$path_project_front/dist

path_project_back=$(dirname $(pwd))/backend
path_jar=$path_project_back/target

echo "Building frontend"
cd $path_project_front

#docker run -it --rm -v "$(pwd)":/app -w /app alexsuch/angular-cli:7.3.8-chromium ng build
#docker run --rm -it -v $(pwd):/opt -w /opt teracy/angular-cli /bin/bash

#https://hub.docker.com/r/alexsuch/angular-cli (top)
#https://hub.docker.com/r/teracy/angular-cli
#https://hub.docker.com/r/pivotalpa/angular-cli






#echo "Compiling java application"
#cd $path_project_back
#docker run -it --rm -v "$(pwd)":/usr/src/backend -v "$HOME/.m2":/root/.m2 -w /usr/src/backend maven:3.6.1-jdk-8-alpine mvn package -DskipTests
#echo "Copying java application"
#cd $path_docker
#mv $path_jar/backend-0.0.1-SNAPSHOT.jar .
#rm backend.jar
#mv backend-0.0.1-SNAPSHOT.jar backend.jar
#
#echo "Creating docker image"
#docker build -t bygranizo/lcdd_backend .
#docker push bygranizo/lcdd_backend