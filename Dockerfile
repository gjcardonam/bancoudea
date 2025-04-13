# Etapa de compilación
FROM maven:3.8.5-eclipse-temurin-17-alpine AS build

WORKDIR /app

# Copia todo el proyecto
COPY . .

# Ejecuta el build (esto genera el JAR)
RUN mvn clean package -DskipTests

# Etapa final (runtime)
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copia el JAR desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
