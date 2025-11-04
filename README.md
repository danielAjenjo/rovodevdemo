# rovodevdemo

This repository contains the hello-module (Spring Boot, Java 17, Maven).

Usage
- All commands must be executed with the Maven Wrapper inside hello-module
- Run application:
  - cd hello-module && ./mvnw spring-boot:run
- Format and verify:
  - cd hello-module && ./mvnw -B -ntp spotless:apply
  - cd hello-module && ./mvnw -B -ntp verify

CI/CD
- GitHub Actions workflow runs from .github/workflows/maven.yml with working-directory set to ./hello-module.
