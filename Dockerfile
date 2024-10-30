# Usa una imagen de Java como base
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado en el contenedor
COPY build/libs/api-docker-0.0.1-SNAPSHOT.jar app.jar

# Expone los puertos 8080 y 8443 para la API
EXPOSE 8080 8443

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
