//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper](../index.md)/[BookingRequestMapper](index.md)/[toCreateInput](to-create-input.md)

# toCreateInput

[src]\
abstract fun [toCreateInput](to-create-input.md)(request:
CreateBookingRequest): [CreateBookingCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-create-booking-command/index.md)

Maps a gRPC `CreateBookingRequest` to a `CreateBookingCommand`.

#### Return

a domain command representing the creation request

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-19

#### Parameters

src

|         |                           |
|---------|---------------------------|
| request | the incoming gRPC request |