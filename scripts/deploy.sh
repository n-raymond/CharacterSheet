#!/bin/bash

echo "Deploying !"

# set variable for the version number in Dockerfile
# set version in build.sbt

# Run scripts/build.sh

# login on docker-hub
# create a new docker image with the tag version
# push the image to registry

# Connect to SSH

# pull latest image
# use docker-compose to stop and remove tcard-app container
# set variable CHARACTERSHEET_VERSION using the tag version
# check if tcard-db is up. If not use docker-compose to launch both containers
# else use docker-compose to attach on the new version of tcard-app

