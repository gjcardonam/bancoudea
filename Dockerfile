# Imagen base con Java 17
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el JAR compilado al contenedor
COPY target/bancoudea-0.0.1-SNAPSHOT.jar app.jar

# Puerto que expone tu aplicación
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
