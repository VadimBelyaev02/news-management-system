FROM openjdk:17-slim

WORKDIR /app

COPY target/config-server-1.0.0.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]