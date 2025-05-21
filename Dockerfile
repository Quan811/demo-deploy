FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY . /app
RUN mvn clean install
ENTRYPOINT ["java", "-jar", "target/tung-tung-tung-sahur-0.0.1.jar"]
