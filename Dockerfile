# Use the official eclipse-temurin image with OpenJDK 21 based on Ubuntu
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy your application's JAR file into the container
COPY ms-prestamex-gestion.jar /app/ms-prestamex-gestion.jar

# Define the command to run your application when the container starts
CMD ["java", "-jar", "ms-prestamex-gestion.jar"]
