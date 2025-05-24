//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper](../index.md)/[BookingRequestMapper](index.md)/[toUpdateInput](to-update-input.md)

# toUpdateInput

[java]\
abstract fun [toUpdateInput](to-update-input.md)(request: [UpdateBookingRequest](../../com.github.j4c62.pms.booking.infrastructure.provider.grpc/-update-booking-request/index.md)): [UpdateBookingDatesCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-update-booking-dates-command/index.md)

Maps a gRPC `UpdateBookingRequest` to an `UpdateBookingDatesCommand`.

#### Return

a domain command representing the update

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-19

#### Parameters

java

| | |
|---|---|
| request | the incoming gRPC update request |