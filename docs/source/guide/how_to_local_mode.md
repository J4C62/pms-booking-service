# How to start PMS Booking Service local mode

## Requirements Checklist

:::{tip}
Use  [sdkman](https://sdkman.io/) to download 23
`sdk install java 23.ea.36-open`
:::

### Install:

- <input type="checkbox"> Java 23 </input>
- <input type="checkbox"> [Gradle](https://gradle.org/)
- <input type="checkbox"> [Docker](https://www.docker.com/) or [Podman](https://podman.io/)
- <input type="checkbox"> [grpcurl](https://github.com/fullstorydev/grpcurl)
- <input type="checkbox"> [git](https://git-scm.com/downloads)

## Clone the repository

* HTTPS method
  ```bash
    git clone https://github.com/J4C62/pms-booking-service.git
  ```
* SSH method
  ```bash
     git clone git@github.com:J4C62/pms-booking-service.git
  ```

---

## Start the Service

Start Kafka first:

```sh
./gradlew upKafka
```

Then run the app:

```sh
./gradlew bootRun
```

---

## You’re Ready!

### Health Check (gRPC)

```sh
grpcurl -plaintext localhost:9090 grpc.health.v1.Health/Check
````

You should see this response

```json
{
  "status": "SERVING"
}
```

```{toctree}
:maxdepth: 1

how_to_docker_mode.md
```