# CRUD Demo Application using Spring Boot/Hibernate

## 📌 Project Description
This is a Spring Boot-based CRUD (Create, Read, Update, Delete) application that connects to a MySQL database using Hibernate (JPA). It allows users to manage electric guitar records by performing basic CRUD operations through a DAO-based persistence layer.

## 🚀 Features
- Add a new electric guitar to the database
- Retrieve a guitar by ID or brand
- Retrieve all guitars
- Update an existing guitar
- Delete a guitar by ID or brand
- Delete all guitars

## 🛠️ Technologies Used
- **Java 17**
- **Spring Boot** (3.x)
- **Spring Data JPA (Hibernate)**
- **MySQL**
- **Maven**

## ⚙️ Setup and Installation
### 1️⃣ Clone the Repository
```sh
git clone https://github.com/ozy-7/electric-guitars-crud.git
cd electric-guitars-crud
```

### 2️⃣ Configure MySQL Database
Make sure MySQL is running and update `src/main/resources/application.properties` if needed:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/electricguitars
spring.datasource.username=electricguitars
spring.datasource.password=electricguitars
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

### 3️⃣ Build and Run the Application
```sh
mvn spring-boot:run
```

## 📡 API Endpoints
### Retrieve All Guitars
```sh
GET /electricguitars/all
```
### Retrieve Guitar by ID
```sh
GET /electricguitars/{id}
```
### Retrieve Guitar by Brand
```sh
GET /electricguitars/brand/{brand}
```
### Add a New Guitar
```sh
POST /electricguitars
Content-Type: application/json
{
  "brand": "Fender",
  "model": "Stratocaster",
  "pickup": "SSS",
  "fretCount": 22,
  "woodType": "Alder"
}
```
### Update a Guitar
```sh
PUT /electricguitars/{id}
Content-Type: application/json
{
  "brand": "Gibson",
  "model": "Les Paul",
  "pickup": "HH",
  "fretCount": 22,
  "woodType": "Mahogany"
}
```
### Delete Guitar by ID
```sh
DELETE /electricguitars/{id}
```
### Delete All Guitars
```sh
DELETE /electricguitars/all
```

## 🏗️ Future Improvements
- Add a REST Controller to expose API endpoints (currently only DAO layer is implemented).
- Implement Swagger documentation.
- Improve validation and exception handling.
