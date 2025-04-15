# Etapa 1: Build
FROM gradle:8.5-jdk23 AS builder
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project
RUN ./gradlew clean bootJar --no-daemon

# Etapa 2: Runtime
FROM openjdk:23-jdk-slim
WORKDIR /app
COPY --from=builder /home/gradle/project/build/libs/*.jar pms-booking-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
