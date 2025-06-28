FROM maven:3.9.7-eclipse-temurin-21 as build
WORKDIR /app
COPY . .
RUN java -version && mvn -version && mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/ms-prestamex-gestion-0.0.1-SNAPSHOT.jar /app/ms-prestamex-gestion.jar
EXPOSE 3000
CMD ["java", "-jar", "/app/ms-prestamex-gestion.jar"]
