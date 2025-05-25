//[pms-booking-service](../../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.grpc](../../index.md)/[CancelBookingRequest](../index.md)/[Builder](index.md)/[setCancelledByBytes](set-cancelled-by-bytes.md)

# setCancelledByBytes

[java]\
open fun [setCancelledByBytes](set-cancelled-by-bytes.md)(value: ByteString): [CancelBookingRequest.Builder](index.md)

```kotlin
Identifier of the user or service initiating the cancellation.

```

`string cancelledBy = 3 [(.validate.rules) = { ... }`

#### Return

This builder for chaining.

#### Parameters

java

|       |                                   |
|-------|-----------------------------------|
| value | The bytes for cancelledBy to set. |