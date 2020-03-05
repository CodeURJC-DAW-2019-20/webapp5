#!/bin/bash

#if [ $# -ne 1 ]; then
#    echo "Illegal number of parameters"
#    exit
#fi

path_docker=$(pwd)
path_project=$(dirname $(pwd))/backend
path_jar=$path_project/target
name_image=$1

echo "Compiling java application"
cd $path_project
docker run -it --rm -v "$(pwd)":/usr/src/backend -w /usr/src/backend maven:3.6.1-jdk-8-alpine mvn package -DskipTests

#echo "Copying java application"
#cd $path_docker
#mv $path_jar/SpringDocker.jar .
#mv SpringDocker.jar webapp-3.java

#echo "Creating docker image"
#docker build -t codeurjc/$name_image .