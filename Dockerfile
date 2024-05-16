# Use the official Maven image as the base image
FROM maven:3.8.4-openjdk-11 AS build

# Set the working directory
WORKDIR /app

# Copy the source code into the container
COPY . .

# Build the application
RUN mvn clean install

# Use the official OpenJDK image as the runtime image
FROM openjdk:11-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built application from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port that the application will run on
EXPOSE 8080

# Start the application
CMD ["java", "-jar", "app.jar"]
