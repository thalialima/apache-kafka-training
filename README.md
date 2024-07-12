# Apache Kafka with Spring Boot - Training Project

This project is an implementation of Apache Kafka using Spring Boot, Docker Compose, and Zookeeper. The project includes four microservices: `consumer`, `json-consumer`, `payment-service`, and `producer`. The services communicate with each other via Apache Kafka.

## Prerequisites

- Java 17
- Docker and Docker Compose or Podman
- Apache Maven
- Postman (for sending messages)

## Microservices

### 1. Consumer
This service consumes messages from Kafka topics as plain strings.

### 2. Json-Consumer
This service consumes JSON objects from Kafka topics.

### 3. Payment-Service
This service sends and receives JSON objects through Kafka topics.

### 4. Producer
This service produces messages to Kafka topics as plain strings.

### Consumer and Producer (String Communication)
- **Producer:** Runs on `localhost:8000/producer`
- **Consumer:** Listens to Kafka topics for string messages.

### Json-Consumer and Payment-Service (Object Communication)
- **Payment-Service:** Runs on `localhost:8200/payments`
- **Json-Consumer:** Listens to Kafka topics for JSON objects.

## Getting Started

1. **Clone the repository:**
   ```sh
   git clone https://github.com/thalialima/apache-kafka-training.git
   cd apache-kafka-training

## Endpoints

### Producer Service (Strings)
- **Endpoint:** `POST http://localhost:8000/producer`
- **Description:** Send string messages to Kafka topic.
- **Example Request:**
  ```json
  {
      "message": "Hello Kafka"
  }

### Payment Service (Objects)
- **Endpoint:** `POST http://localhost:8200/payments`
- **Description:** Send JSON objects to Kafka topic.
- **Example Request:**
  ```json
  {
    "id": 12,
    "userId": 123,
    "productId": 45,
    "cardNumber": "411111111111111"
  }

## Monitoring Kafka with Kafdrop
- The project uses Kafdrop for monitoring Kafka clusters. Kafdrop is accessible at:
`http://localhost:9000`





