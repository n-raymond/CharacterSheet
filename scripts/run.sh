#!/bin/bash

# This script should be run from the project root using ./scripts/run.sh

scripts/build.sh
docker-compose up --build

