# Order Event Processing System

This project is a simple Kafka-based event-driven system built using Spring Boot.

The goal of this project is to understand the basics of Apache Kafka including:
- Producer
- Multiple Consumers
- Consumer Groups
- JSON Events
- Kafka Topic communication
- KRaft mode setup
- Modular Monolith architecture


## Project Architecture

This project is implemented as a modular monolith.

Modules are separated using packages:

com.aman.order
- orderapi
- notification
- analytics
- common
- config


## Flow

REST API → Producer → Kafka Topic → Consumers

Topic name:

order-events

Producer:
orderapi

Consumers:
notification
analytics


## Event Flow

1. API call creates order
2. Producer sends OrderCreatedEvent to Kafka
3. Kafka publishes event to topic
4. Notification consumer receives event
5. Analytics consumer receives event


## Kafka Setup (KRaft mode)

Kafka version used:
4.2.0

Steps:

Generate UUID

C:\kafka>bin\windows\kafka-storage.bat random-uuid

Format storage

C:\kafka>bin\windows\kafka-storage.bat format -t <UUID> -c config\server.properties

Start Kafka

PS C:\kafka> cmd /V /C "set KAFKA_HEAP_OPTS=-Xmx512M -Xms512M && bin\windows\kafka-server-start.bat config\server.properties"

Create topic

PS C:\kafka> bin\windows\kafka-topics.bat --create --topic order-events --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

Created topic order-events.

To check the list of topics created

PS C:\kafka> .\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092

order-events

## API Test

POST

http://localhost:8080/orders

Body:

{
"orderId": "101",
"productName": "Laptop",
"quantity": 1
}


## What I learned

- Kafka producer and consumer
- Multiple consumer groups
- JSON serialization
- Kafka topic management
- KRaft setup
- Event driven architecture
- Modular monolith design


## Future Improvements

- Docker Kafka setup
- Logging improvement
- Retry handling
- Error handling
- Multi-topic support
