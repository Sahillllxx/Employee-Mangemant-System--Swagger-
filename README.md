# Employee Management API

A simple **Spring Boot** application for managing employees using **CRUD operations**. This version uses **hardcoded in-memory data** instead of a database, making it easy to run and test without any setup.

The project also includes **DTOs, Service, Controller, Mapper** using the **builder pattern** (Lombok), and **Swagger UI** for API documentation.

---

## Features

* **CRUD operations** for Employee: Create, Read, Update, Delete
* In-memory repository with initial hardcoded data
* DTO mapping using a Mapper class with **builder pattern**
* **Lombok** annotations for boilerplate reduction
* API documentation via **Swagger (springdoc-openapi)**
* Validation of request DTOs using **Jakarta Validation**
* Fully **self-contained** (no database required)

---

## Technologies Used

* Java 21
* Spring Boot 3
* Lombok
* Spring Web
* Jakarta Validation
* Springdoc OpenAPI (Swagger UI)
* Maven

---

## Getting Started

### Prerequisites

* Java 21+
* Maven 3+

### Running the Application

1. Clone the repository:

   ```bash
   git clone <your-repo-url>
   cd employee-management
   ```

2. Build and run the project:

   ```bash
   mvn clean package
   mvn spring-boot:run
   ```

3. Access the APIs via Swagger UI:

   ```
   http://localhost:8080/swagger-ui/index.html
   ```

---

## API Endpoints

| Method | Endpoint            | Description                 |
| ------ | ------------------- | --------------------------- |
| GET    | /api/employees      | Get all employees           |
| GET    | /api/employees/{id} | Get employee by ID          |
| POST   | /api/employees      | Create a new employee       |
| PUT    | /api/employees/{id} | Update an existing employee |
| DELETE | /api/employees/{id} | Delete an employee          |

---

## Sample Hardcoded Employees

On application startup, the repository contains 3 employees:

| ID | First Name | Last Name | Email                                                         | Department |
| -- | ---------- | --------- | ------------------------------------------------------------- | ---------- |
| 1  | John       | Doe       | [john.doe@example.com](mailto:john.doe@example.com)           | IT         |
| 2  | Jane       | Smith     | [jane.smith@example.com](mailto:jane.smith@example.com)       | HR         |
| 3  | Alice      | Johnson   | [alice.johnson@example.com](mailto:alice.johnson@example.com) | Finance    |

---

## Swagger Documentation

The Swagger UI provides a convenient interface to test all endpoints:

```
http://localhost:8080/swagger-ui/index.html
```

The OpenAPI spec in JSON format is available at:

```
http://localhost:8080/v3/api-docs
```

---

