FROM ubuntu:20.04 AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -ydo
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY /target/api-meLivra-Comentarios-0.0.1-SNAPSHOT.jar appComentario.jar

ENTRYPOINT ["java", "-jar","appComentario.jar"]