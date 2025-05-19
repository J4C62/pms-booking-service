# How to Perform a gRPC Health Check

To verify the service is running correctly:

## Run the Health Check Command

```bash
grpcurl -plaintext localhost:9090 grpc.health.v1.Health/Check
````

## Expected Response

```json
{
  "status": "SERVING"
}
```

