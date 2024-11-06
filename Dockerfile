FROM gradle:7.4.2-jdk17 AS build
WORKDIR /app
COPY . .
RUN ./gradlew clean build -x test

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/build/libs/api-docker-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8443
ENTRYPOINT ["java", "-jar", "app.jar"]
