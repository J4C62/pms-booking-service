//[pms-booking-service](../../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.grpc](../../index.md)/[BookingServiceGrpc](../index.md)/[AsyncService](index.md)

# AsyncService

interface [AsyncService](index.md)```kotlin

BookingService defines RPC operations to create, update and cancel bookings.

```

#### Inheritors

| |
|---|
| [BookingServiceImplBase](../-booking-service-impl-base/index.md) |

## Functions

| Name | Summary |
|---|---|
| [cancelBooking](cancel-booking.md) | [java]<br>open fun [cancelBooking](cancel-booking.md)(request: [CancelBookingRequest](../../-cancel-booking-request/index.md), responseObserver: StreamObserver&lt;[BookingResponse](../../-booking-response/index.md)&gt;) |
| [createBooking](create-booking.md) | [java]<br>open fun [createBooking](create-booking.md)(request: [CreateBookingRequest](../../-create-booking-request/index.md), responseObserver: StreamObserver&lt;[BookingResponse](../../-booking-response/index.md)&gt;) |
| [updateBooking](update-booking.md) | [java]<br>open fun [updateBooking](update-booking.md)(request: [UpdateBookingRequest](../../-update-booking-request/index.md), responseObserver: StreamObserver&lt;[BookingResponse](../../-booking-response/index.md)&gt;) |