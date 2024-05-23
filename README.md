# Udemy Clone Course Management System

## Overview

This project is a backend system for a course management platform inspired by Udemy. It is developed using Spring Boot, Hibernate, and MySQL. The system includes functionalities for managing courses, instructors, enrollments, and user authentication.

## Features

- *User Authentication*: Secure login and registration system.
- *Course Management*: Create, update, and delete courses.
- *Instructor Management*: Manage instructor profiles and their courses.
- *Enrollment Management*: Enroll and track students in courses.
- *Data Persistence*: Efficient data storage and retrieval using Hibernate ORM.

## Technologies Used

- *Spring Boot*
- *Hibernate*
- *MySQL*
- *Java*

## Project Structure


udemy-clone-backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── example/
│   │   │   │   │   ├── controllers/
│   │   │   │   │   ├── models/
│   │   │   │   │   ├── repositories/
│   │   │   │   │   ├── services/
│   │   │   │   │   └── UdemyCloneApplication.java
│   │   ├── resources/
│   │       ├── application.properties
├── pom.xml


## Installation and Setup

### Prerequisites

- Java JDK
- Maven
- MySQL

### Setup

1. Clone the repository:
   bash
   git clone https://github.com/JashPatel2004/UdemyClone.git
   cd udemy-clone-backend
   

2. Configure the MySQL database in application.properties:
   properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   

3. Build and run the Spring Boot application:
   bash
   mvn clean install
   mvn spring-boot:run
   

## API Endpoints

- *User Authentication*
  - POST /api/auth/register - Register a new user
  - POST /api/auth/login - Login an existing user

- *Course Management*
  - GET /api/courses - Get all courses
  - GET /api/courses/{id} - Get course by ID
  - POST /api/courses - Create a new course
  - PUT /api/courses/{id} - Update a course
  - DELETE /api/courses/{id} - Delete a course

- *Instructor Management*
  - GET /api/instructors - Get all instructors
  - GET /api/instructors/{id} - Get instructor by ID
  - POST /api/instructors - Create a new instructor
  - PUT /api/instructors/{id} - Update an instructor
  - DELETE /api/instructors/{id} - Delete an instructor

- *Enrollment Management*
  - POST /api/enrollments - Enroll a student in a course
  - GET /api/enrollments - Get all enrollments
  - GET /api/enrollments/{id} - Get enrollment by ID

## Usage

- The backend server will be running at http://localhost:8080.
- Use API clients like Postman to interact with the endpoints.

 
