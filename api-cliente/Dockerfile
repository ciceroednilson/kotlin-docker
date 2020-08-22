#IMAGE BASE: https://hub.docker.com/_/microsoft-java-jdk

FROM mcr.microsoft.com/java/jdk:8-zulu-alpine

MAINTAINER  Cicero Ednilson <ciceroednilson@gmail.com>

VOLUME ["/apis/config"]

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

RUN apk update && apk add bash

ENTRYPOINT ["java","-jar","/app.jar", "--spring.config.location=/apis/config/application.yml"]