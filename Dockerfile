# Indica la imagen base que se utilizará
FROM amazoncorretto:11-alpine-jdk
MAINTAINER TOMVILLALBA

# Copia el archivo JAR generado por Spring Boot al contenedor
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación cuando se inicie el contenedor
ENTRYPOINT ["java","-jar","/app.jar"]
