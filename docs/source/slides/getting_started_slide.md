# Getting Started

Welcome to **PMS Booking Service**  
A lightweight booking microservice powered by Java and Kafka.

---

## Installation

Clone the repo and move into the directory:

```git
git clone https://github.com/J4C62/pms-booking-service.git
cd pms-booking-service
````

---

## Requirements

Make sure the following are installed:

* ✅ Java **23**
* ✅  <a href="https://gradle.org/" target="_blank" data-preview-link>Gradle</a>
* ✅  <a href="https://www.docker.com/" target="_blank" data-preview-link>Docker</a>
  or <a href="https://podman.io/" target="_blank" data-preview-link>Podman</a>
* ✅ <a href="https://github.com/fullstorydev/grpcurl" target="_blank" data-preview-link>grpcurl</a>
  or <a href="https://github.com/fullstorydev/grpcui" target="_blank" data-preview-link>
  grpcui</a>

---

## Start the Service

Start Kafka first:

```gradle
./gradlew upKafka
```

Then run the app:

```gradle
./gradlew bootRun
```

---

## You’re Ready!

### Health Check (gRPC)

```bash
grpcurl -plaintext localhost:9090 grpc.health.v1.Health/Check
````

You should see this response

```json
{
  "status": "SERVING"
}
```