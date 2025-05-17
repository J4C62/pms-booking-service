//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driver](../index.md)/[GrpcControllerAdapter](index.md)

# GrpcControllerAdapter

[src]\
open class [GrpcControllerAdapter](index.md)

gRPC controller adapter for the Booking Service.

This class acts as the entry point for gRPC requests related to booking operations. It delegates the handling of
commands to the [BookingHandler](../../com.github.j4c62.pms.booking.domain.driver.handler/-booking-handler/index.md) and
maps requests and responses via dedicated mappers.

Supported operations:

- Create a booking
- Cancel an existing booking
- Update booking dates

All methods return a BookingResponse via StreamObserver. Errors are handled via global gRPC exception handlers.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-17

## Constructors

|                                                      |                        |
|------------------------------------------------------|------------------------|
| [GrpcControllerAdapter](-grpc-controller-adapter.md) | [src]<br>constructor() |

## Functions

| Name                               | Summary                                                                                                                                      |
|------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------|
| [cancelBooking](cancel-booking.md) | [src]<br>open fun [cancelBooking](cancel-booking.md)(request: CancelBookingRequest, responseObserver: StreamObserver&lt;BookingResponse&gt;) |
| [createBooking](create-booking.md) | [src]<br>open fun [createBooking](create-booking.md)(request: CreateBookingRequest, responseObserver: StreamObserver&lt;BookingResponse&gt;) |
| [updateBooking](update-booking.md) | [src]<br>open fun [updateBooking](update-booking.md)(request: UpdateBookingRequest, responseObserver: StreamObserver&lt;BookingResponse&gt;) |