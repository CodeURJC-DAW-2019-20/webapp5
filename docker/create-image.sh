#!/bin/bash

#if [ $# -ne 1 ]; then
#    echo "Illegal number of parameters"
#    exit
#fi

path_docker=$(pwd)
path_project=$(dirname $(pwd))/backend
path_jar=$path_project/target
#name_image=$1



echo "Compiling java application"
cd $path_project
#docker run -it --rm -v "$(pwd)":/usr/src/backend -w /usr/src/backend maven:3.6.1-jdk-8-alpine /bin/bash
#docker run -it --rm -v "$(pwd)":/usr/src/backend -w /usr/src/backend maven:3.6.1-jdk-8-alpine mvn package -DskipTests
docker run -it --rm -v "$(pwd)":/usr/src/backend -v "$HOME/.m2":/root/.m2 -w /usr/src/backend maven:3.6.1-jdk-8-alpine mvn package -DskipTests
echo "Copying java application"
cd $path_docker
mv $path_jar/backend-0.0.1-SNAPSHOT.jar .
mv backend-0.0.1-SNAPSHOT.jar backend.jar

echo "Creating docker image"
#docker build -t bygranizo/lcdd_backend .
#docker run -t lcdd_backend
docker push bygranizo/lcdd_backend