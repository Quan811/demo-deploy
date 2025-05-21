FROM eclipse-temurin:21-jdk-alpine
RUN apk add --no-cache bash curl tar && \
    curl -fsSL https://archive.apache.org/dist/maven/maven-3/3.9.1/binaries/apache-maven-3.9.1-bin.tar.gz | tar xz -C /opt && \
    ln -s /opt/apache-maven-3.9.1/bin/mvn /usr/bin/mvn
WORKDIR /app
COPY . /app
RUN mvn clean install -DskipTests
ENTRYPOINT ["java", "-jar", "target/tung-tung-tung-sahur-0.0.1.jar"]
