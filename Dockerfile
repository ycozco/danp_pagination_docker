# Usa una imagen de Gradle con Java para compilar el JAR
FROM gradle:7.4.2-jdk17 AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia todo el proyecto al contenedor
COPY . .

# Ejecuta el comando de compilación para generar el JAR
RUN ./gradlew clean build

# Usa una imagen de Java para ejecutar la aplicación
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el JAR generado en la imagen final
COPY --from=build /app/build/libs/api-docker-0.0.1-SNAPSHOT.jar app.jar

# Expone los puertos 8080 y 8443 para la API
EXPOSE 8080 8443

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
