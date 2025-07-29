# Use a minimal JDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Add jar file (built using Maven)
ARG JAR_FILE=target/extravars-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the app
ENTRYPOINT ["java","-jar","/app/app.jar"]
