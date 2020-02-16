#!/bin/bash

docker build --tag payara-project-main .

#JUST IN CASE
{
    docker stop payara-project-main
    docker container rm payara-project-main
}

docker run --name payara-project-main \
    -p 8080:8080 \
    --detach \
    payara-project-main

echo -e "To follow the logs, execute: \e[1;31m docker logs --follow payara-project-main \033[0m"
echo -e "To connect with container, execute: \e[1;31m docker exec -it payara-project-main sh \033[0m"
echo -e "To stop container, execute: \e[1;31m docker stop payara-project-main \033[0m"