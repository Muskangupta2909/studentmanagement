# Student Management System - Backend (Spring Boot)

Student Management System is a backend REST API application built using Spring Boot.
It allows managing student records with proper layered architecture and best backend practices.

## 🚀 Features

Student CRUD APIs (Create, Read, Update, Delete)
Database Integration (MySQL / PostgreSQL)
Proper Table Design (Primary Key, Unique, Not Null)
DTO Usage (Request & Response)
Validations (@NotNull, @NotBlank, @Email, @Size)
Pagination Support
Search API
Global Exception Handling
Custom Exception (ResourceNotFoundException)
Clean Response Structure (status, message, data)
Proper HTTP Status Codes (200, 201, 400, 404, 500)

## 🛠 Tech Stack

Java
Spring Boot
Spring Data JPA
Hibernate
MySQL / PostgreSQL
Maven
Lombok

## 📂 Project Structure

controller - API endpoints
service - business logic
repository - database operations
entity - database entity classes
dto - request and response DTOs
exception - custom exception and global exception handler
response - API response wrapper

## ⚙️ Setup & Run

Clone the repository

git clone https://github.com/Muskangupta2909/student-management.git

Navigate to project folder

cd student-management

Run the project

mvn spring-boot:run
