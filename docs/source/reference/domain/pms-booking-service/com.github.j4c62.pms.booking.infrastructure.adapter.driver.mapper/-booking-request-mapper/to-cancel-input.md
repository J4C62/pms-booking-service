//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper](../index.md)/[BookingRequestMapper](index.md)/[toCancelInput](to-cancel-input.md)

# toCancelInput

[java]\
abstract fun [toCancelInput](to-cancel-input.md)(request: [CancelBookingRequest](../../com.github.j4c62.pms.booking.infrastructure.provider.grpc/-cancel-booking-request/index.md)): [CancelBookingCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-cancel-booking-command/index.md)

Maps a gRPC `CancelBookingRequest` to a `CancelBookingCommand`.

#### Return

a domain command representing the cancellation

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-19

#### Parameters

java

| | |
|---|---|
| request | the incoming cancellation request |