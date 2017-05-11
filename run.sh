#!/usr/bin/env bash

sbt universal:packageZipTarball
docker-compose up --build