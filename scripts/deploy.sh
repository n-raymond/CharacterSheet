#!/bin/bash

export APP_VERSION=$1
DOCKER_IMAGE="nraymond/charactersheet"

echo "***************************"
echo "* Deploying version $APP_VERSION *"
echo "***************************"

echo "Packaging the app..."
sed -i "s/\(version := \"\).*\(\"\)/\1${APP_VERSION}\2/" build.sbt
scripts/build.sh

echo "Creating docker image..."
docker-compose build app

echo "Sending docker image on registry..."
echo "$DOCKER_PASSWORD" | docker login --username="$DOCKER_USERNAME" --password-stdin
docker tag $DOCKER_IMAGE:latest $DOCKER_IMAGE:$APP_VERSION
docker push $DOCKER_IMAGE:latest
docker push $DOCKER_IMAGE:$APP_VERSION

# Connect to SSH

# pull latest image
# use docker-compose to stop and remove tcard-app container
# set variable CHARACTERSHEET_VERSION using the tag version
# check if tcard-db is up. If not use docker-compose to launch both containers
# else use docker-compose to attach on the new version of tcard-app

