#!/bin/bash

DOCKER_FILE_DIR=$(dirname $(realpath "$0"))

cd ../../../
PROJECT_TEST_CONTAINER_DIR=$(realpath .)

mkdir -p "$PROJECT_TEST_CONTAINER_DIR/containers_data/db/oracle-18c-xe-HR"

chmod -R 777 "$PROJECT_TEST_CONTAINER_DIR/containers_data/db/oracle-18c-xe-HR"

cd "$DOCKER_FILE_DIR"
docker build --tag oracle-18c-xe-hr .

#JUST IN CASE
{
    docker stop oracle-18c-xe-hr
    docker container rm oracle-18c-xe-hr
}

docker run --name oracle-18c-xe-hr \
    -v "$PROJECT_TEST_CONTAINER_DIR/containers_data/db/oracle-18c-xe-HR":"/opt/oracle/oradata" \
    -p 1521:1521 \
    --detach \
    --privileged \
    oracle-18c-xe-hr

echo -e "To follow the logs, execute: \e[1;31m docker logs --follow oracle-18c-xe-hr \033[0m"
echo -e "To connect with container, execute: \e[1;31m  exec -it oracle-18c-xe-hr /bin/bash \033[0m"
echo -e "To stop container, execute: \e[1;31m docker stop oracle-18c-xe-hr \033[0m"