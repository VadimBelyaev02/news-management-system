FROM maven:3.9.4-eclipse-temurin-17-alpine as build

WORKDIR /app

COPY pom.xml /app

RUN mvn dependency:resolve

COPY src /app

RUN mvn clean package

FROM eclipse-temurin:17-jre-alpine

COPY --from=build /app/target/user-service-1.0.0.jar .
COPY wait-for-it.sh app

ENTRYPOINT ["java", "-jar", "/app/target/user-service-1.0.0.jar"]