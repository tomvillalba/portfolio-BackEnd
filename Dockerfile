FROM amazoncorretto:11-alpine-jdk
MAINTAINER TOMVILLALBA

COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
