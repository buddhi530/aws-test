FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY target/aws-test-0.0.1-SNAPSHOT.jar awsapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "awsapp.jar"]
