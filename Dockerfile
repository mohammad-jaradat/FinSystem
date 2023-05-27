#FROM openjdk:8-jdk-alpine
FROM openjdk:17-jdk-slim-buster
MAINTAINER QU IT
COPY target/finsys-1.0.1.jar finsys-1.0.1.jar
ENTRYPOINT ["java","-jar","/finsys-1.0.1.jar"]