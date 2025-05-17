# Introductory Project

Welcome to my hands-on project for learning microservices with Spring Boot! This project serves as an introduction to microservices architecture and includes several key components and concepts.

## Project Overview

This project is designed to simulate a movie date backend system. It consists of the following services:

1. **Main Movie Service**: The primary service that interacts with the movie info and movie ratings services.
2. **Movie Info Service**: Provides information about movies.
3. **Movie Ratings Service**: Supplies ratings for movies.

### Additional Components

- **Eureka Discovery Server**: Used for service registration and discovery.
- **Eureka Clients**: Implemented in each microservice for service discovery.
- **RestTemplate**: Used for synchronous communication between microservices.
- **Reactive Programming (WebFlux)**: Provides a glimpse into reactive programming for asynchronous communication.


Note : Both Movie Info and Movie Ratings services return static data for simplicity.
