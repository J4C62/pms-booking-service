//[pms-booking-service](../../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.grpc](../../index.md)/[BookingResponse](../index.md)/[Builder](index.md)/[setStatusBytes](set-status-bytes.md)

# setStatusBytes

[java]\
open fun [setStatusBytes](set-status-bytes.md)(value: ByteString): [BookingResponse.Builder](index.md)

```kotlin
Status of the booking (e.g., "CONFIRMED", "CANCELLED", "UPDATED").

```
`string status = 2;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The bytes for status to set. |