# kotlin-docker
Api feita em Kotlin rodando no Docker


# Docker

## Criando a rede para os containers
docker network create -d bridge ciceroednilson

## Baixando a imagem do banco de dados
docker pull mysql

## Criando um container do banco de dados
docker run  -p 3306:3306 --network=ciceroednilson --hostname base-mysql --name base-mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:latest

## Dockerizando aplicação Kotlin
--Na raiz do seu projeto executar o comando abaixo para gerar a imagem a partir do DockerFile.
docker build -f Dockerfile -t img-api-cliente .


