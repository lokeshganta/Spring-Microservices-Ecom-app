# 🛒 Spring-Microservices-Ecom-app

Built a scalable e-commerce platform using Spring Boot microservices (Product, Inventory, Cart, Order, Auth), integrated with Eureka Service Registry and API Gateway, secured with JWT authentication, and backed by MongoDB.
The project demonstrates **service decomposition, inter-service communication, centralized routing, and JWT authentication**.

---

## 🚀 Features

- **Microservices Architecture**  
  - **Product Service** → Manage product catalog (CRUD).  
  - **Inventory Service** → Track stock availability of products.  
  - **Cart Service** → Manage user-selected items before checkout.  
  - **Order Service** → Place orders, check inventory availability, sync product status.  
  - **Auth Service** → Handle user registration, login, and secure endpoints with JWT.  

- **Authentication & Authorization**  
  - JWT-based authentication for secure API access.  
  - Passwords stored securely using BCrypt.  

- **API Gateway**  
  - Centralized routing for all microservices.  
  - Request filtering and path-based routing.  

- **Service Registry (Eureka)**  
  - Dynamic service discovery.  
  - Fault tolerance and scalability.  

- **Inter-Service Communication**  
  - Feign Client & REST APIs used between services.  
  - Product availability displayed in real time after inventory checks.  

- **Database**  
  - MongoDB Atlas for distributed and scalable data storage.  
---
---

## 🛠️ Tech Stack

- **Backend**: Java 17, Spring Boot, Spring Cloud, Spring Security  
- **Service Discovery**: Eureka  
- **API Gateway**: Spring Cloud Gateway  
- **Database**: MongoDB Atlas  
- **Authentication**: JWT + BCrypt  
- **Build Tool**: Maven  

---




