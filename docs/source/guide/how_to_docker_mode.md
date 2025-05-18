# How to start PMS Booking Service docker mode

## Requirements Checklist

### Install:

- <input type="checkbox"> [Docker](https://www.docker.com/) or [Podman](https://podman.io/)

## Start docker compose

```shell
 docker compose -f $(pwd)/.docker/docker-compose.yml up -d
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
