//[pms-booking-service](../../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.grpc](../../index.md)/[CancelBookingRequest](../index.md)/[Builder](index.md)/[setCancelledAt](set-cancelled-at.md)

# setCancelledAt

[java]\
open fun [setCancelledAt](set-cancelled-at.md)(
value: [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html)): [CancelBookingRequest.Builder](index.md)

```kotlin
ISO 8601 timestamp of when the booking was cancelled (e.g., 2025-05-14T10:00:00Z).

```

`string cancelledAt = 4 [(.validate.rules) = { ... }`

#### Return

This builder for chaining.

#### Parameters

java

|       |                         |
|-------|-------------------------|
| value | The cancelledAt to set. |