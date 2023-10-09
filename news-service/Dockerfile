FROM openjdk:17-slim

WORKDIR /app

COPY target/news-service-1.0.0.jar /app/app.jar
COPY wait-for-it.sh /app

ENTRYPOINT ["java", "-jar", "app.jar"]