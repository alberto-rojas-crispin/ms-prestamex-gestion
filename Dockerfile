# Use the official eclipse-temurin image with OpenJDK 21 based on Ubuntu
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy your application's JAR file into the container
COPY target/ms-prestamex-gestion-0.0.1-SNAPSHOT.jar /app/ms-prestamex-gestion.jar

#Exponer el puerto que usa la aplicacion
EXPOSE 3000

# Define the command to run your application when the container starts
CMD ["java", "-jar", "/app/ms-prestamex-gestion.jar"]
