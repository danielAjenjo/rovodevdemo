# hello-module

Java 17 + Spring Boot REST module that exposes a simple greeting endpoint.

## Requisitos
- Java 17
- Maven 3.9+

## Cómo arrancar
```bash
./mvnw spring-boot:run
```

## Cómo testear / CI local
```bash
./mvnw -B -ntp verify
```
Esto ejecuta tests, formatea el código con Spotless (si es necesario) y verifica:
- Cobertura (JaCoCo ≥ 80% en `HelloService`)
- Estilo (Checkstyle)
- Tests (JUnit 5 + Mockito)


## Uso del endpoint
- GET `http://localhost:8080/api/hello` → `{ "message": "Hello, World!" }`
- GET `http://localhost:8080/api/hello?name=Dani` → `{ "message": "Hello, Dani!" }`

## Paquete base
`com.company.hello`

## Links
- Confluence: https://nicolas-champions.atlassian.net/wiki/spaces/MP/pages/3473410
- Jira: https://nicolas-champions.atlassian.net/browse/MP-14

