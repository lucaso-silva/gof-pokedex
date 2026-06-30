# GOF Pokémon Service

A REST API built with Java and Spring Boot to manage a personal Pokémon collection.

This project was developed as a hands-on study lab focused on applying design patterns and software engineering best practices in a Spring Boot application.

Throughout the project, concepts such as **layered architecture, external API integration, data persistence, input validation, exception handling, and RESTful API design** were explored, with special emphasis on how **GoF design patterns** can be applied in real-world scenarios.

The project was developed as part of the **Santander 2026 - AI Java Back-End Bootcamp**, offered in partnership with [Digital Innovation One (DIO)](https://www.dio.me/en).

## Features

* Register a Pokémon by name
* Fetch Pokémon data from the external PokéAPI
* Prevent duplicated Pokémon registrations
* List all saved Pokémon
* Find a Pokémon by ID
* Find a Pokémon by name using query parameters
* Persist Pokémon data using Spring Data JPA
* Use H2 in-memory database for development
* Handle business and external API errors with custom exceptions
* Expose API documentation with Swagger/OpenAPI

## Tech Stack

* Java 21
* Spring Boot
* Spring Web MVC
* Spring Data JPA
* Spring Validation
* Spring Cloud OpenFeign
* H2 Database
* Lombok
* Springdoc OpenAPI

## Project Structure

```text
src/main/java/com/lucas/gofpokedex
├── controller
├── dto
│   ├── request
│   └── response
├── entity
├── exception
├── mapper
├── repository
├── service
│   └── impl
└── GofPokemonServiceApplication.java
```

## API Endpoints

### Save a Pokémon

```http
POST /api/pokemons
```

Request body:

```json
{
  "name": "squirtle"
}
```

### List all saved Pokémon

```http
GET /api/pokemons
```

### Find Pokémon by name

```http
GET /api/pokemons?name=pikachu
```

### Find Pokémon by ID

```http
GET /api/pokemons/{id}
```

Example:

```http
GET /api/pokemons/1
```

## Running the Project

Clone the repository:

```bash
git clone https://github.com/lucaso-silva/gof-pokemon-service.git
```

Enter the project folder:

```bash
cd gof-pokemon-service
```

Run the application:

```bash
mvn spring-boot:run
```

The API will be available at:

```text
http://localhost:8080
```

## H2 Console

The H2 console is available at:

```text
http://localhost:8080/h2-console
```

Default JDBC URL:

```text
jdbc:h2:mem:pokemons
```

## Swagger Documentation

After starting the application, Swagger UI should be available at:

```text
http://localhost:8080/swagger-ui/index.html
```

OpenAPI JSON:

```text
http://localhost:8080/v3/api-docs
```

## Design Patterns and Architectural Principles

This project explores both classic GoF design patterns and widely adopted enterprise application patterns commonly used in Spring Boot applications.

### GoF Design Patterns
#### Strategy Pattern

The application adopts a **Strategy-like approach** by defining dedicated interfaces for each use case and providing concrete implementations.

Example:

```java
public interface SavePokemon {
    SavePokemonOutput save(String name);
}
```

```java
@Service
public class SavePokemonImpl implements SavePokemon {
    ...
}
```

This approach promotes:

* Separation of responsibilities
* Easier testing through dependency injection
* Flexibility to introduce alternative implementations in the future

#### Adapter Pattern

The integration with the external PokéAPI through OpenFeign can be viewed as an application of the **Adapter Pattern**.

Instead of exposing external API structures directly to the business layer, the application adapts external responses to its internal model.

```text
PokéAPI → Feign Client → Service Layer → Domain Entity/DTO
```

Benefits:

* Decouples business logic from external APIs
* Simplifies future API replacements
* Centralizes integration concerns

### Enterprise Application Patterns

#### Repository Pattern

Persistence is implemented using the **Repository Pattern** through Spring Data JPA repositories.

```java
public interface PokemonRepository
        extends JpaRepository<Pokemon, Long> {
}
```

The repository abstracts data access operations, allowing the business layer to remain independent of persistence details.

#### Data Mapper Pattern

The project uses the **Data Mapper Pattern** through the `PokemonMapper` component.

The mapper is responsible for converting data between:

* External API responses
* Domain entities
* Request and response DTOs

This prevents controllers and services from containing transformation logic and helps maintain a clear separation of concerns.

### Architectural Principles

#### Dependency Injection (DI) and Inversion of Control (IoC)

Spring's dependency injection mechanism is extensively used throughout the application.

```java
@AllArgsConstructor
@Service
public class SavePokemonImpl implements SavePokemon {

    private final PokeApiService pokeApiService;
    private final PokemonRepository pokemonRepository;
}
```

By relying on Spring's IoC container, the application benefits from:

* Loose coupling
* Better testability
* Improved maintainability

The project also follows SOLID principles, particularly the **Dependency Inversion Principle (DIP)**, by depending on abstractions rather than concrete implementations.

#### Template Method (Spring Framework)

Although not implemented explicitly in the project, Spring internally applies the **Template Method Pattern** in several components, such as repositories and transaction management.

By extending and configuring Spring abstractions, the application benefits from this pattern without requiring a direct implementation.

## Status

Project under development as a study lab for Java, Spring Boot, REST APIs, external API integration, and design patterns.

---

### Developed by [Lucas Oliveira](https://www.linkedin.com/in/lucas-oliveira10/)
