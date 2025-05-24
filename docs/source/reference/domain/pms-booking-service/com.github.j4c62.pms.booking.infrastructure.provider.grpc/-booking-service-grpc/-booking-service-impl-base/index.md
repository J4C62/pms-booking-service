//[pms-booking-service](../../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.grpc](../../index.md)/[BookingServiceGrpc](../index.md)/[BookingServiceImplBase](index.md)

# BookingServiceImplBase

abstract class [BookingServiceImplBase](index.md) : BindableService, [BookingServiceGrpc.AsyncService](../-async-service/index.md)

Base class for the server implementation of the service BookingService. 

```kotlin

BookingService defines RPC operations to create, update and cancel bookings.

```

#### Inheritors

| |
|---|
| [GrpcControllerAdapter](../../../com.github.j4c62.pms.booking.infrastructure.adapter.driver/-grpc-controller-adapter/index.md) |

## Constructors

| | |
|---|---|
| [BookingServiceImplBase](-booking-service-impl-base.md) | [java]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [bindService](bind-service.md) | [java]<br>fun [bindService](bind-service.md)(): ServerServiceDefinition |
| [cancelBooking](../-async-service/cancel-booking.md) | [java]<br>open fun [cancelBooking](../-async-service/cancel-booking.md)(request: [CancelBookingRequest](../../-cancel-booking-request/index.md), responseObserver: StreamObserver&lt;[BookingResponse](../../-booking-response/index.md)&gt;) |
| [createBooking](../-async-service/create-booking.md) | [java]<br>open fun [createBooking](../-async-service/create-booking.md)(request: [CreateBookingRequest](../../-create-booking-request/index.md), responseObserver: StreamObserver&lt;[BookingResponse](../../-booking-response/index.md)&gt;) |
| [updateBooking](../-async-service/update-booking.md) | [java]<br>open fun [updateBooking](../-async-service/update-booking.md)(request: [UpdateBookingRequest](../../-update-booking-request/index.md), responseObserver: StreamObserver&lt;[BookingResponse](../../-booking-response/index.md)&gt;) |