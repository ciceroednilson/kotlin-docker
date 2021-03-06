# Api feita em Kotlin rodando no Docker.

Exemplo simples de api usando Kotlin, Spring Boot, Mysql e Docker.


# Docker

### Criando a rede para os containers.
docker network create -d bridge ciceroednilson

### Baixando a imagem do banco de dados.
docker pull mysql

### Criando um container do banco de dados.
docker run  -p 3306:3306 --network=ciceroednilson --hostname base-mysql --name base-mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:latest

### Dockerizando aplicação Kotlin.
Na raiz do seu projeto executar o comando abaixo para gerar a imagem a partir do DockerFile.
docker build -f Dockerfile -t img-api-cliente .

![docker build](https://user-images.githubusercontent.com/17622032/90956675-18f5a800-e45f-11ea-8f65-d8099d9f950d.png)


### Criando o container da Api.
docker run -d -v /apis/config:/apis/config -p 9000:8080 img-api-cliente:latest --hostname api-cliente --name api-cliente --network=ciceroednilson  

### Iniciando os Container
* sudo docker container start id_container_mysql
* sudo docker container start id_container_api


# Testando a api.

![teste-api-docker](https://user-images.githubusercontent.com/17622032/90956936-39266680-e461-11ea-89d5-6d4e1141ad29.png)






