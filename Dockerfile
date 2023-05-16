FROM amazoncorretto:11-alpine-jdk
MAINTAINER TomVillalba
COPY target/demo-0.0.1-SNAPSHOT.jar tom-app.jar
ENTRYPOINT ["java","-jar","/tom-app.jar"]