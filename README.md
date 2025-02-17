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


  Environment:
Java version: 1.8
Maven version: 3.*
Spring Boot version: 2.2.1.RELEASE
Read-Only Files:
src/test/*
Data:
Sample example of JSON data object:

[
  {
    "name": "Trial Product",
    "price": "909",
    "discount_percentage": 10,
    "image": "http://placehold.it/940x300/999/CCC",
    "ratings": [
      {
        "rating": 3,
        "rated_by": "User123"
      },
      {
        "rating": 4,
        "rated_by": "User1233"
      }
    ]
  },
  {
    "name": "Trial Product 2",
    "detail": "Lorem ipsum dolor sit amet",
    "price": "850",
    "discount_percentage": 5,
    "image": "http://placehold.it/300x300/999/CCC",
    "ratings": [
      {
        "rating": 5,
        "rated_by": "User123"
      },
      {
        "rating": 4,
        "rated_by": "User1233"
      }
    ]
  }
]
Requirements:
You are provided with the implementation of the models required for all the API's. The task is to implement a set of REST service that exposes the endpoints, which allows for filtering and sorting the collection of product records in the following way:

POST request to /rating/compute/ :

all the average ratings for all the products should be computed and returned as an array of the given objects.
the response code is 200 and the response body is the array of the computed ratings
GET request to /filter/discount/{discount_percentage}:

returns a collection of all events whose discount percentage is greater than the given input
the response code is 200, and the response body is an array of all products that have a discount percentage greater than the one given in the query parameter
In case there are no such products return status code 400
GET request to /filter/price/{initial_range}/{final_range}:

returns a collection of all products whose price is between the initial and the final range supplied
the response code is 200, and the response body is an array of products in the price range provided
In case there are no such products return status code 400
GET request to /sort/price:

returns a collection of all products sorted by their pricing
the response code is 200 and the response body is an array of the product names sorted in ascending order of price
Your task is to complete the given project so that it passes all the test cases when running the provided unit tests.

Commands
run:
mvn clean package; java -jar target/project_jar-1.0.jar
install:
mvn clean install
test:
mvn clean test

