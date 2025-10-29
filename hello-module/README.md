# hello-module

Java 17 + Spring Boot REST module that exposes a simple greeting endpoint.

## Requisitos
- Java 17
- Maven 3.9+

## Cómo arrancar
```bash
mvn spring-boot:run
```

## Cómo testear / CI local
```bash
mvn -B -ntp verify
```
Esto ejecuta tests, verifica cobertura (JaCoCo ≥ 80% en `HelloService`), y chequea formato (Spotless) y estilo (Checkstyle).

## Uso del endpoint
- GET `http://localhost:8080/api/hello` → `{ "message": "Hello, World!" }`
- GET `http://localhost:8080/api/hello?name=Dani` → `{ "message": "Hello, Dani!" }`

## Paquete base
`com.company.hello`
