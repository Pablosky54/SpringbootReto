# Ejemplo de Microservicio con Spring Boot

Este es un ejemplo básico de un microservicio utilizando Spring Boot en Java. El microservicio expone una API REST simple.

## Requisitos

- Java 11 o superior
- Maven 3.6.0 o superior

## Estructura del Proyecto

El proyecto tiene la siguiente estructura:

```
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── ejemplo
│   │   │           └── microservicio
│   │   │               ├── MicroservicioApplication.java
│   │   │               ├── controlador
│   │   │               │   └── SaludoControlador.java
│   │   │               └── modelo
│   │   │                   └── Saludo.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── ejemplo
│                   └── microservicio
│                       └── MicroservicioApplicationTests.java
└── pom.xml
```

## Ejecutar el Microservicio

Para ejecutar el microservicio, utiliza el siguiente comando:

```bash
mvn spring-boot:run
```

El microservicio estará disponible en `http://localhost:8080`.

## API

El microservicio expone la siguiente API:

### Obtener un saludo

- **URL:** `/saludo`
- **Método:** `GET`
- **Respuesta:**
  ```json
  {
    "mensaje": "¡Hola, mundo!"
  }
  ```
