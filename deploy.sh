#!/bin/bash

IMAGE_NAME=cw7430/next-java-server-sangyoonlee
TAG=latest

# 빌드
docker build -t $IMAGE_NAME:$TAG .

# 푸시
docker push $IMAGE_NAME:$TAG