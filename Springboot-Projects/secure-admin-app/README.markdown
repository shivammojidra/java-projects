# RBAC Demo Application

## Overview
The RBAC Demo Application is a Spring Boot-based web application demonstrating Role-Based Access Control (RBAC) with JWT authentication. It provides a secure REST API for user authentication and role-based access to protected endpoints, using MySQL as the database and Spring Security for authorization.

## Features
- **User Authentication**: Login with username/password to obtain a JWT token.
- **Role-Based Authorization**: Supports `ADMIN` and `USER` roles with endpoint restrictions.
- **Secure API**: Protects endpoints with JWT and Spring Security.
- **MySQL Database**: Stores users, roles, and their relationships.
- **CORS Support**: Configurable for multiple origins (e.g., `admin.myapp.com`, `app.myapp.com`).
- **Production-Ready**: Configured with Flyway for database migrations and secure environment variables.

## Technologies
- **Spring Boot**: 3.4.5
- **Spring Security**: For authentication and authorization
- **MySQL**: 8.0+ for persistent storage
- **JJWT**: 0.12.6 for JWT generation and validation
- **Flyway**: For database schema migrations
- **Lombok**: To reduce boilerplate code

## Prerequisites
- **Java**: 21
- **MySQL**: 8.0+
- **Maven**: 3.8+
- **Git**: For cloning and pushing to GitHub