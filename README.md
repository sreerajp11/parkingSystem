# parkingSystem
A scalable and modular Smart Parking System built using Spring Boot Microservices architecture. 
The system handles user registration, slot booking, and parking operations, with secure communication, service discovery, and asynchronous event handling.
It allows users to register, book parking slots, and receive notifications using secure JWT authentication. 
Features include service discovery with Eureka, inter-service communication with Feign, Redis caching, Kafka-based event handling, and Docker containerization.

- Backend: Java 17, Spring Boot, Spring Data JPA, RESTful API 
- Microservices: Spring Cloud (Eureka, OpenFeign)
- Security: Spring Security with JWT
- Database: MySQL
- Cache: Redis
- Messaging: Apache Kafka
- API Docs: Swagger / OpenAPI 3
- Containerization: Docker, Docker Compose
- Testing: JUnit, Mockito