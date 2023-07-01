# Indica la imagen base que se utilizará
FROM openjdk:11-jdk

# Copia el archivo JAR generado por Spring Boot al contenedor
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación cuando se inicie el contenedor
ENTRYPOINT ["java","-jar","/app.jar"]
