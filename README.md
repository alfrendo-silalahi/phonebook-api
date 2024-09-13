# Phonebook Application

This project consists of a Spring Boot backend and a React frontend for a simple phonebook application.

## Prerequisites

- Java JDK 17 or higher
- Node.js and npm
- Gradle
- Docker and Docker Compose (optional)

## Project Structure

- `phonebook-be-springboot`: Backend Spring Boot application
- `phonebook-fe-react`: Frontend React application

## Setup and Running

### Backend (Spring Boot)

1. Navigate to the `phonebook-be-springboot` directory.

2. Build the application:

   ```
   ./gradlew bootJar
   ```

   or on Windows:

   ```
   .\gradlew.bat bootJar
   ```

3. Run the application:
   - Using Gradle:
     ```
     ./gradlew bootRun
     ```
   - Using Java:
     ```
     java -jar build/libs/phonebook-be-springboot-0.0.1-SNAPSHOT.jar
     ```
   - Using an IDE like IntelliJ IDEA (recommended for development)

### Frontend (React)

1. Navigate to the `phonebook-fe-react` directory.

2. Install dependencies:

   ```
   npm install
   ```

3. Run the development server:
   ```
   npm run dev
   ```

## Running with Docker Compose

If you prefer to use Docker Compose:

1. Ensure you've built the Spring Boot application as described above.
2. Run the following command in the root directory:
   ```
   docker-compose up
   ```

## Accessing the Application

- Backend API: http://localhost:8080
- Swagger UI (API Documentation): http://localhost:8080/swagger-ui/index.html
- Frontend: http://localhost:5173

## API Documentation

The backend provides a complete CRUD API for managing phonebook entries. You can explore and test the API using the Swagger UI.

![Swagger UI](Swagger%20UI.png)

## Frontend Interface

The frontend currently supports GET and DELETE operations on the phonebook entries.

![React UI](Simple%20React%20Web%20UI.png)

## Development Notes

- The backend uses Spring Boot and provides a RESTful API.
- The frontend is built with React and currently implements a subset of the available API operations.
- MySQL is used as the database (when running with Docker Compose or configured separately).
