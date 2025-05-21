FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/tung-tung-tung-sahur-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
