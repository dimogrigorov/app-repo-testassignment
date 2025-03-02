# Simple Spring Boot Application with Docker and GitHub Actions

## Overview
This repository contains a simple Spring Boot application that serves an endpoint to return its version. The application is built using Maven and packaged into a Docker image. A GitHub Actions workflow is included to automate the build and deployment process to Amazon Elastic Container Registry (ECR).

## Features
- Spring Boot 3.1.0 with Actuator
- Dockerized using a multi-stage build for efficiency
- CI/CD pipeline with GitHub Actions
- Deployment-ready for AWS EKS

## Project Structure
```
├── .github/workflows  # GitHub Actions workflow
├── src/main/java/com/example  # Java source code
│   ├── SimpleApp.java  # Main Spring Boot application
|   src/main/resources/
|   |-- application.properties # config properties file
├── pom.xml  # Maven build configuration
├── Dockerfile  # Docker build instructions
└── README.md  # Project documentation
```

## Application Endpoint
The application exposes a REST endpoint:
```
GET /application
Response: "Application Version: <version>"
```

## Build and Run Locally
To run the application locally:
```sh
mvn clean package
java -jar target/*.jar
```

## Docker Build and Run
### Build the Docker Image
```sh
docker build -t simpleapp:latest .
```
### Run the Docker Container
```sh
docker run -p 8080:8080 simpleapp:latest
```

## GitHub Actions Workflow
The CI/CD pipeline automatically builds and pushes the Docker image to Amazon ECR on a push to the `main` branch.

### Steps in Workflow:
1. **Checkout Code** – Retrieves the latest code from GitHub.
2. **Set Up QEMU & Buildx** – Ensures compatibility for multi-architecture builds.
3. **Configure AWS Credentials** – Sets up authentication for AWS.
4. **Login to Amazon ECR** – Authenticates to the container registry.
5. **Build & Push Docker Image** – Builds and pushes the image to ECR.

## AWS ECR Integration
### Store AWS Credentials in GitHub Secrets
Add the following secrets in GitHub:
- `AWS_ACCESS_KEY_ID`
- `AWS_SECRET_ACCESS_KEY`
- `AWS_DEFAULT_REGION`


## Conclusion
This project demonstrates how to build, containerize, and automate deployment of a Spring Boot application using GitHub Actions and AWS ECR.
