# PMS-Booking Service

**pms-booking** is one of the core microservices of the **Property Management System (PMS)**. Its responsibility is to
manage property bookings, validate availability, and publish domain events like `booking.created` and
`booking.cancelled` for processing by other services.

---

## Features

- Full booking management: creation, update, and cancellation.
- Communication via **gRPC**.
- Event publishing to **Apache Kafka**.
- **Event-driven** design, highly scalable and decoupled.
- Integration with the overall PMS architecture.

---

## Part of the PMS Ecosystem

This microservice is part of the **PMS** system, which includes:

- `pms-property` – Property management.
- `pms-billing` – Billing and payments.
- `pms-notification` – Multichannel notification delivery.
- `pms-maintenance` – Maintenance and issue management.
- `cloud-event-broadcaster` – Event broadcasting library.

---

## Internal Architecture

### Project Structure

```
com.github.j4c62.booking
 application
    service/BookingApplicationService.java
    dto/CreateBookingCommand.java
 domain
    model/Booking.java
    repository/BookingRepository.java
    event/BookingCreated.java
 interfaces
    grpc/BookingGrpcController.java
 infrastructure
    db/BookingJpaRepository.java
    kafka/BookingEventPublisher.java
 config
```

---

## Communication Interfaces

| Type   | Protocol | Description                           |
|--------|----------|---------------------------------------|
| Input  | gRPC     | Booking API (`BookingGrpcController`) |
| Output | Kafka    | Domain event publishing (`booking.*`) |

---

## Emitted Events

| Event              | Kafka Topic         | Trigger                               |
|--------------------|---------------------|---------------------------------------|
| `BookingCreated`   | `booking.created`   | When a new booking is created         |
| `BookingCancelled` | `booking.cancelled` | When an existing booking is cancelled |

Example:

```java
BookingCreated event = BookingCreated.from(booking);
kafkaPublisher.

publish("booking.created",event);
```

---

## Testing & Validation

| Test Type    | Description                                     |
|--------------|-------------------------------------------------|
| Unit Tests   | `BookingServiceTest` for business logic         |
| Integration  | Integration testing with Kafka and gRPC         |
| Contract     | gRPC contract validation                        |
| Mocked Kafka | Simulated publishing in `BookingEventPublisher` |

---

## Non-Functional Requirements

- Average gRPC response time: **< 300ms**
- Kafka must be available for event publishing
- High availability and horizontal scalability
- Modular and decoupled architecture (Hexagonal)

---

## Tech Stack

| Technology   | Role                         |
|--------------|------------------------------|
| Java 23      | Primary language             |
| Spring Boot  | Microservice framework       |
| gRPC         | Synchronous communication    |
| Apache Kafka | Event bus                    |
| PostgreSQL   | Persistence                  |
| Docker + K8s | Deployment and orchestration |

---

## Security

- Authentication and authorization delegated to the gateway/API Gateway.
- Property-level permission validation (optional multi-tenant support).
- Input validation via Protobuf + annotations in the `application` layer.

---

## Local Execution

### Requirements:

- Java 23
- Docker (for Kafka and PostgreSQL)
- `protoc` (gRPC code generator)

### Commands:

```bash
# Start external services
docker-compose up -d kafka postgres

# Build the project
./gradlew clean build

# Run locally
./gradlew bootRun
```

---

## gRPC Contract (simplified)

```proto
service BookingService {
  rpc CreateBooking(CreateBookingRequest) returns (BookingResponse);
  rpc CancelBooking(CancelBookingRequest) returns (BookingResponse);
}

message CreateBookingRequest {
  string propertyId = 1;
  string guestId = 2;
  string startDate = 3;
  string endDate = 4;
}

message BookingResponse {
  string bookingId = 1;
  string status = 2;
}
```

---

## Kafka Integration

The `BookingEventPublisher` class is responsible for publishing relevant events:

```java
kafkaTemplate.send("booking.created",event);
```

---

## Contribution

This service follows the conventions of the PMS ecosystem. Make sure to:

- Use `PascalCase` for classes, `camelCase` for variables.
- Maintain high test coverage.
- Use DTOs for specificInput/output in the `application` layer.

---

## Related Documentation

- General PMS Architecture
- Cloud Event Broadcaster Guide
- Booking Domain Spec

---

## Author & Maintenance

Developed by `@j4c62`  
Part of the **PMS** ecosystem  
License: MIT