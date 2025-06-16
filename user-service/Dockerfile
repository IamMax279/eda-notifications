FROM maven:latest AS build
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine AS production
WORKDIR /app
COPY --from=build /app/target/user-service-0.0.1-SNAPSHOT.jar /app/target/user-service-0.0.1-SNAPSHOT.jar
COPY wait-for.sh ./wait-for.sh
RUN chmod +x wait-for.sh
EXPOSE 8080
ENTRYPOINT ["./wait-for.sh", "rabbitmq:5672", "--", "java", "-jar", "/app/target/user-service-0.0.1-SNAPSHOT.jar"]