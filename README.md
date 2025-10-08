

## Project Overview

The **Product API** is a Spring Boot application developed as part of a backend assignment.  
It demonstrates how to design a layered, maintainable REST API with:
- Authentication using JWT tokens
- Input validation 
- Proper exception handling and clean architecture

---

##  Key Features

- 🔐 **JWT-based Authentication**
  - Secure login endpoint that issues tokens.
  - Protected routes for product management accessible only with valid JWT tokens.
  - Uses Spring Security for authentication and authorization.

-  **Input Validation**
  - Bean Validation (`javax.validation`) ensures required fields like `name`, `price`, etc. are valid.
  - Custom error messages and centralized exception handling.

- 🧩 **CRUD Operations**
  - Create, read, update, and delete products from a MySQL database.
  - Follows RESTful design principles.

- 🧠 **Clean Architecture**
  - Layered structure: Controller → Service → Repository → Entity.
  - Business logic separated from API logic.

- 📘 **Swagger Documentation**
  - Interactive API testing at `/swagger-ui/index.html`.

---

## 🧠 Tech Stack

 Technology |
|--------|-------------|
|  Java 17 |
|  Spring Boot 3.x |
| Spring Security + JWT |
| MySQL |
| Spring Data JPA (Hibernate) |
|  Jakarta Bean Validation (JSR 380) |
|  Swagger / OpenAPI 3 |
|  Maven |

---

## 🪄 Authentication Flow

1. **User Login**
   - Send POST request to `/api/auth/login` with valid username and password.
   - If credentials are correct, you receive a **JWT token** in response.

2. **Access Protected Routes**
   - Include the JWT token in the `Authorization` header as `Bearer <token>` for all subsequent requests.

3. **Token Validation**
   - Spring Security filters every request to ensure the token is valid before allowing access.

---

## 🧰 Validation Example

### Request Body (Invalid)
```json
{
  "name": "",
  "price": -100,
  "description": ""
}
```

### Response
```json
{
  "timestamp": "2025-10-08T11:00:00",
  "errors": {
    "name": "Product name must not be blank",
    "price": "Price must be greater than zero"
  },
  "status": 400
}
```

---

## 🏗️ Project Structure

```
src
 ├── main
 │   ├── java/com/product/api
 │   │    ├── controller     → REST controllers (Auth + Product)
 │   │    ├── service        → Business logic
 │   │    ├── repository     → Data access layer
 │   │    ├── entity         → Product & User entities
 │   │    ├── config         → Security configuration (JWT)
 │   │    └── exception      → Global exception handling
 │   └── resources
 │        └── application.properties
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository
```bash
git clone https://github.com/prakhar25794/product-api.git
```

### 2️⃣ Configure your MySQL database
Edit `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/productdb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3️⃣ Run the project
```bash
mvn spring-boot:run
```

### 4️⃣ Access the APIs
- Swagger: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- Product API: `http://localhost:8080/api/products`
- Auth API: `http://localhost:8080/api/auth/login`

---

## 🔗 Product Endpoints

| Method | Endpoint | Description | Secured |
|--------|-----------|-------------|----------|
| POST | `/api/auth/login` | Authenticate user & get JWT token | ❌ |
| GET | `/api/products` | Fetch all products | ✅ |
| GET | `/api/products/{id}` | Fetch product by ID | ✅ |
| POST | `/api/products` | Create new product | ✅ |
| PUT | `/api/products/{id}` | Update product | ✅ |
| DELETE | `/api/products/{id}` | Delete product | ✅ |

✅ = Requires JWT token

---

## 📘 Example Request (POST Product)
```json
{
  "name": "Bluetooth Speaker",
  "price": 1499.99,
  "description": "Portable speaker with high-quality sound"
}
```

### ✅ Response
```json
{
  "id": 3,
  "name": "Bluetooth Speaker",
  "price": 1499.99,
  "description": "Portable speaker with high-quality sound",
  "createdAt": "2025-10-08T10:30:00"
}
```
Name - PRAKHAR GUPTA
email - prakhargupta25794@gmail.com

---

## 👨‍💻 Authorand clean code architecture.*
