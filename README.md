# Task Manager API

A RESTful task management API built with **Java 21** and **Spring Boot**, featuring **PostgreSQL persistence**, **Flyway database migrations**, **OpenAPI/Swagger documentation**, and **Docker-based deployment**.

This project demonstrates clean backend architecture, layered design, and production-ready tooling.

---

## Tech Stack

- Java 21
- Spring Boot 3
- Spring Web & Spring Data JPA
- PostgreSQL 16
- Flyway (database migrations)
- OpenAPI / Swagger (springdoc)
- Docker & Docker Compose
- Maven

---

## Features

- CRUD operations for tasks
- RESTful API design
- DTO-based request/response mapping
- Database migrations with Flyway
- Health check endpoint
- Fully containerized local development
- Auto-generated OpenAPI documentation

---

## API Endpoints

### Tasks

- `GET /tasks` – List all tasks
- `POST /tasks` – Create a task
- `GET /tasks/{id}` – Get task by ID
- `PATCH /tasks/{id}` – Update task
- `DELETE /tasks/{id}` – Delete task

### Health

- `GET /health` – Service health check

---

## Running Locally (Docker)

### Prerequisites

- Docker
- Docker Compose

### Start the application

```bash
docker compose up --build
```

### Access the application

- **API:** http://localhost:8081
- **Swagger UI:** http://localhost:8081/swagger-ui/index.html
- **OpenAPI spec:** http://localhost:8081/v3/api-docs

---

## Example Requests

### Create a task

```bash
curl -X POST http://localhost:8081/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Write README"}'
```

### List tasks

```bash
curl http://localhost:8081/tasks
```

### Update a task

```bash
curl -X PATCH http://localhost:8081/tasks/1 \
  -H "Content-Type: application/json" \
  -d '{"done":true}'
```

### Delete a task

```bash
curl -X DELETE http://localhost:8081/tasks/1
```

---

## Project Structure

```
src/main/java/com/svencol/taskmanager
├── task
│   ├── Task.java
│   ├── TaskController.java
│   ├── TaskService.java
│   ├── TaskRepository.java
│   └── dto
│       ├── TaskCreate.java
│       ├── TaskUpdate.java
│       └── TaskOut.java
├── HealthController.java
└── TaskManagerApiApplication.java
```

---

## License

MIT