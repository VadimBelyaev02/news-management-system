FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/user-service-1.0.0.jar /app/app.jar
COPY wait-for-it.sh /app

ENTRYPOINT ["java", "-jar", "app.jar"]