# Order Event Processing System — Kafka Setup

This project demonstrates Kafka integration with Spring Boot using Docker.

The goal is to simulate a real-world event-driven architecture.

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Kafka
- Docker
- Apache Kafka
- Zookeeper

---

## Project Features

- Kafka Producer
- Multiple Kafka Consumers
- JSON Serialization
- Docker Kafka setup
- Event-driven architecture

---

## Kafka Setup using Docker

### Step 1 — Install Docker

Install Docker Desktop

https://www.docker.com/

Start Docker before running.

---

### Step 2 — Open the root directory of the project in cmd

Run command:

1. Pull and create the Kafka and zookeeper
   ```
   docker compose up -d
   ```
2. Check the container
   ```
   docker ps
   ```
3. Enter Kafka container
   ```
   docker exec -it kafka bash
   ```
4. Create topic
   ```
   kafka-topics --create --topic order-events --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
   ```
5. Check the list of topic
   ```
   kafka-topics --list --bootstrap-server localhost:9092
   ```
6. Optional: If want to check in the container the consumer
   
   6.1 Go to kafka container
   ```
    docker exec -it kafka bash
   ```
   6.2 Create consumer
   ```
   kafka-console-consumer --topic order-events --bootstrap-server localhost:9092 --from-beginning
   ```

---

By now your Kafka uding Docker is running, keep it running. Now open your springboot application and run the project.

Go to ```Postman```, hit the curl:

```
curl --location 'http://localhost:8080/orders' \
--header 'Content-Type: application/json' \
--data '{
  "orderId": "101",
  "productName": "Phone",
  "quantity": 6
}'
```

Check the application logs, you will find something like the below attached image
<img width="1208" height="115" alt="image" src="https://github.com/user-attachments/assets/c6ab1b2b-ff04-4a76-807e-20429ff15d60" />

Also if you go to your consumer console running in the cmd, you can find the same consumer logs there as well 
<img width="733" height="51" alt="image" src="https://github.com/user-attachments/assets/d3b88989-2abf-4ce1-9aba-439eced48bad" />

