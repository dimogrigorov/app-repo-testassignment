# First stage: Build the application
FROM maven:3.8.6-eclipse-temurin-17 AS builder

# Set working directory
WORKDIR /app

# Copy Maven project files
COPY pom.xml . 

# Auto-increment version using Maven versions plugin
RUN mvn build-helper:parse-version versions:set \
    -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}.\${parsedVersion.incrementalVersion} \
    -DgenerateBackupPoms=false

# Copy application source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Second stage: Create a minimal runtime image
FROM eclipse-temurin:17-jre

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

