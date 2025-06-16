FROM maven:latest AS build
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine AS production
WORKDIR /app
COPY --from=build /app/target/email-service-0.0.1-SNAPSHOT.jar /app/target/email-service-0.0.1-SNAPSHOT.jar
EXPOSE 8081
CMD ["java", "-jar", "/app/target/email-service-0.0.1-SNAPSHOT.jar"]