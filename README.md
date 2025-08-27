# Trip JPA

A simple Spring Boot application that demonstrates how to use Spring Data JPA to manage entities and expose them via RESTful endpoints.

## Features
- Create, read, update, and delete (CRUD) operations for Flight entities.
- Uses an in-memory H2 database for simplicity.
- Exposes RESTful endpoints for managing Flight entities.
- Logging using AspectJ post-compile weaving.

## How to run the application
1. Ensure you have Java and Gradle installed on your machine.
2. Clone the repository to your local machine.
3. Navigate to the project directory.
4. Run the application using the command:
   ```
   ./gradlew :flight-springboot:bootRun
   ```