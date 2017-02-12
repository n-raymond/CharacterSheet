#!/bin/bash

set -e

# Variables

POSTGRES_CONTAINER_NAME="tcard-postgres"
CONTAINER_NAME="tcard-app"
IMAGE_NAME="tcard-app"
PORT="9000"


# Stop and remove running containers docker

CONTAINERS=$(docker ps -q -a --filter="name=$CONTAINER_NAME")

if [ -n "$CONTAINERS" ]; then
    docker rm -vf $CONTAINERS || true
    echo "This containers have been removed : $CONTAINERS"
fi


# Remove running containers docker

IMAGES=$(docker images -q $IMAGE_NAME)

if [ -n "$IMAGES" ]; then
    docker rmi -f $IMAGES || true
    echo "This images have been removed : $IMAGES"
fi


# Build or force rebuild of the image postgres-storage
docker build -t $IMAGE_NAME:latest --no-cache .

# Run container from postgres-storage image on port 5433
docker run -it --name $CONTAINER_NAME -p $PORT:9000 $IMAGE_NAME:latest
