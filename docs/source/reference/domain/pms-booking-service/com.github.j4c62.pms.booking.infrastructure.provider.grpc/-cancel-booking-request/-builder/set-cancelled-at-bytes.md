//[pms-booking-service](../../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.grpc](../../index.md)/[CancelBookingRequest](../index.md)/[Builder](index.md)/[setCancelledAtBytes](set-cancelled-at-bytes.md)

# setCancelledAtBytes

[java]\
open fun [setCancelledAtBytes](set-cancelled-at-bytes.md)(value: ByteString): [CancelBookingRequest.Builder](index.md)

```kotlin
ISO 8601 timestamp of when the booking was cancelled (e.g., 2025-05-14T10:00:00Z).

```

`string cancelledAt = 4 [(.validate.rules) = { ... }`

#### Return

This builder for chaining.

#### Parameters

java

|       |                                   |
|-------|-----------------------------------|
| value | The bytes for cancelledAt to set. |