# Spring Boot – API Versioning, Global Exception Handling & File Upload/Download

## This project demonstrates professional Spring Boot backend best practices, including:

✅ API Versioning (v1/v2)

✅ Global Exception Handling

✅ Standard API Response Wrapper

✅ DTO Validation using @Valid

✅ File Upload & Download

✅ Service + DTO Layer Architecture

✅ Custom Exceptions

✅ Clean Controller Structure

🚀 Features
🔹 API Versioning

Supports multiple API versions:

/api/v1/users
/api/v2/users


Each version uses different DTOs and response structures.

🔹 Global Exception Handling

Centralized exception handling using @RestControllerAdvice:

BadRequestException

NotFoundException

Validation errors

Generic exceptions

Returns consistent error JSON using ApiResponse<T>.

🔹 Standard API Response Format

Every endpoint returns a structured JSON response:

{
  "status": 200,
  "success": true,
  "message": "User created successfully",
  "data": {},
  "timestamp": "2025-01-01T12:00:00"
}

🔹 DTO Validation

Uses Jakarta Validation (@NotBlank, @Email, @Size) with automatic error handling.

🔹 File Upload & Download

Supports:

Single file upload

Multiple file upload

File download by filename

Implemented with MultipartFile and local storage.

🛠️ Tech Stack

Java 17+

Spring Boot 3

Maven

Lombok

Jakarta Validation


📌 API Endpoints
User APIs
POST /api/v1/users
GET  /api/v1/users/{id}
POST /api/v2/users

File APIs
POST /file/upload
POST /file/uploadMultiple
GET  /file/download/{filename}
