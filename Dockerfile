# Use JDK 21 image as the base
FROM eclipse-temurin:21-jdk

LABEL author="RAHUL NATH"

# Set working directory inside the container
WORKDIR /app

# Copy the packaged jar from your local target folder
COPY target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
