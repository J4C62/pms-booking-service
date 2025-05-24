//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper](../index.md)/[BookingRequestMapper](index.md)/[toCreateInput](to-create-input.md)

# toCreateInput

[java]\
abstract fun [toCreateInput](to-create-input.md)(request: [CreateBookingRequest](../../com.github.j4c62.pms.booking.infrastructure.provider.grpc/-create-booking-request/index.md)): [CreateBookingCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-create-booking-command/index.md)

Maps a gRPC `CreateBookingRequest` to a `CreateBookingCommand`.

#### Return

a domain command representing the creation request

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-19

#### Parameters

java

| | |
|---|---|
| request | the incoming gRPC request |