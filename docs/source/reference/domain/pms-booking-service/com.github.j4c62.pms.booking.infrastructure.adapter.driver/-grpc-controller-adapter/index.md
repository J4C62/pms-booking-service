//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driver](../index.md)/[GrpcControllerAdapter](index.md)

# GrpcControllerAdapter

[java]\
@GrpcService

open class [GrpcControllerAdapter](index.md) : [BookingServiceGrpc.BookingServiceImplBase](../../com.github.j4c62.pms.booking.infrastructure.provider.grpc/-booking-service-grpc/-booking-service-impl-base/index.md)

gRPC controller adapter for the Booking Service. 

This class acts as the entry point for gRPC requests related to booking operations. It delegates the handling of commands to the [BookingHandler](../../com.github.j4c62.pms.booking.domain.driver.handler/-booking-handler/index.md) and maps requests and responses via dedicated mappers. 

Supported operations: 

- Create a booking
- Cancel an existing booking
- Update booking dates

All methods return a [BookingResponse](../../com.github.j4c62.pms.booking.infrastructure.provider.grpc/-booking-response/index.md) via StreamObserver. Errors are handled via global gRPC exception handlers.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-17

## Constructors

| | |
|---|---|
| [GrpcControllerAdapter](-grpc-controller-adapter.md) | [java]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [bindService](../../com.github.j4c62.pms.booking.infrastructure.provider.grpc/-booking-service-grpc/-booking-service-impl-base/bind-service.md) | [java]<br>fun [bindService](../../com.github.j4c62.pms.booking.infrastructure.provider.grpc/-booking-service-grpc/-booking-service-impl-base/bind-service.md)(): ServerServiceDefinition<br>abstract fun [bindService](index.md#994931071%2FFunctions%2F-1170581573)(): ServerServiceDefinition |
| [cancelBooking](cancel-booking.md) | [java]<br>open fun [cancelBooking](cancel-booking.md)(request: [CancelBookingRequest](../../com.github.j4c62.pms.booking.infrastructure.provider.grpc/-cancel-booking-request/index.md), responseObserver: StreamObserver&lt;[BookingResponse](../../com.github.j4c62.pms.booking.infrastructure.provider.grpc/-booking-response/index.md)&gt;) |
| [createBooking](create-booking.md) | [java]<br>open fun [createBooking](create-booking.md)(request: [CreateBookingRequest](../../com.github.j4c62.pms.booking.infrastructure.provider.grpc/-create-booking-request/index.md), responseObserver: StreamObserver&lt;[BookingResponse](../../com.github.j4c62.pms.booking.infrastructure.provider.grpc/-booking-response/index.md)&gt;) |
| [updateBooking](update-booking.md) | [java]<br>open fun [updateBooking](update-booking.md)(request: [UpdateBookingRequest](../../com.github.j4c62.pms.booking.infrastructure.provider.grpc/-update-booking-request/index.md), responseObserver: StreamObserver&lt;[BookingResponse](../../com.github.j4c62.pms.booking.infrastructure.provider.grpc/-booking-response/index.md)&gt;) |