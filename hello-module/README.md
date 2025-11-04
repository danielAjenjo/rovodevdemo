# Hello Module (Spring Boot, Java 17, Maven)

This module provides a simple REST endpoint.

Requirements
- Java 17
- Maven Wrapper (included)

How to run
- Build and run the application:
  - ./mvnw spring-boot:run

How to test and verify
- Format code and run the full build including tests and checks:
  - ./mvnw -B -ntp spotless:apply
  - ./mvnw -B -ntp verify

Endpoint
- GET /api/hello?name=YourName
  - Response: { "message": "Hello, YourName!" }

Project structure
- com.company.hello
  - HelloApplication
  - api/HelloController
  - service/HelloService
  - model/HelloResponse (record)

Notes
- All commands use ./mvnw (do not use mvn).
- JaCoCo enforces ≥ 80% line coverage on HelloService.
