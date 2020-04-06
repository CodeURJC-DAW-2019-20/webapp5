#!/bin/bash

path_docker=$(pwd)

path_project_front=$(dirname $(pwd))/frontend
path_dist=$path_project_front/dist/frontend

path_project_back=$(dirname $(pwd))/backend
path_jar=$path_project_back/target

mkdir -p $path_project_back/src/main/resources/public/new
path_front_location_in_back=$path_project_back/src/main/resources/public/new

echo "Building frontend"
cd $path_project_front

docker run --rm -it -v $(pwd):/frontend -w /frontend teracy/angular-cli:8.3 npm install --no-bin-links && ng build --prod --base-href="https://localhost:8443/new/"

echo "Moving frontend"
rm -r $path_front_location_in_back/
cp -a $path_dist/. $path_front_location_in_back
#echo "Compiling java application"
#cd $path_project_back
#docker run -it --rm -v "$(pwd)":/usr/src/backend -v "$HOME/.m2":/root/.m2 -w /usr/src/backend maven:3.6.1-jdk-8-alpine mvn package -DskipTests
#echo "Copying java application"
#cd $path_docker
#mv $path_jar/backend-0.0.1-SNAPSHOT.jar .
#rm backend.jar
#mv backend-0.0.1-SNAPSHOT.jar backend.jar
#
#
#echo "Creating docker image"
#docker build -t bygranizo/lcdd_backend .
#docker push bygranizo/lcdd_backend