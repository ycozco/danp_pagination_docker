# Usa una imagen de Gradle con Java para compilar el JAR
FROM gradle:7.4.2-jdk17 AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia todo el proyecto al contenedor
COPY . .

# Ejecuta el comando de compilacion para generar el JAR, excluyendo las pruebas
RUN ./gradlew clean build -x test

# Usa una imagen de Java para ejecutar la aplicacion
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el JAR generado en la imagen final
COPY --from=build /app/build/libs/api-docker-0.0.1-SNAPSHOT.jar app.jar

# Expone los puertos para pruebas locales
EXPOSE 8080 8443

# Ejecuta la aplicacion
ENTRYPOINT ["java", "-jar", "app.jar"]
