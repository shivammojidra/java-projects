# eCommerce Microservices Backend

This repository contains a Spring Boot microservices-based backend for an eCommerce application. The project is structured into multiple microservices, each responsible for a specific domain. Below are the key components and their functionalities.

## Microservices

### Order Service
- Manages all order-related details.
- CRUD operations for orders.
- Tracks order statuses and history.

### Product Service
- Manages all product-related details.
- CRUD operations for products.
- Handles product inventory and details.

### Payment Service
- Stores payment-related data.
- Integrates with front-end for payment processing (no payment processing logic here).

### Service Registry
- Eureka Discovery Server.
- Auto-registration of all microservices for service discovery.

### Cloud Gateway
- API Gateway for routing and load balancing.
- Centralized entry point for all the microservices.

## Technologies & Tools

- **Spring Boot** - Framework for building microservices.
- **Spring Data JPA** - ORM for database operations.
- **MySQL** - Relational database.
- **Eureka** - Service registry and discovery server.
- **Feign Client** - Simplifies HTTP client code.
- **API Gateway** - Zuul/Spring Cloud Gateway for routing.
- **Aspect-Oriented Programming (AOP)** - Global exception handling.
- **Swagger** - API documentation.
- **Dev Tools** - Spring Boot DevTools for hot reload.
- **Lombok** - Reduces boilerplate code with annotations.

## Features

- **Service Registry (Eureka)**: Centralized service registry for all microservices.
- **Feign Client**: For internal microservice communication.
- **API Gateway**: For routing and load balancing.
- **Global Exception Handlers**: Consistent error and success responses using AOP.
- **Swagger Integration**: Auto-generated API documentation.
- **Spring Boot DevTools**: For developer convenience and productivity.
- **Lombok**: Simplifies code with annotations.

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven
- MySQL
