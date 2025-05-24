//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.application.creation.mapper](../index.md)/[BookingOutputMapper](index.md)/[toBookingOutput](to-booking-output.md)

# toBookingOutput

[java]\
abstract fun [toBookingOutput](to-booking-output.md)(bookingAggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)

Maps a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md) to a [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md) DTO.

#### Return

A data transfer object suitable for presentation or external interfaces.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-30

#### Parameters

java

| | |
|---|---|
| bookingAggregate | The domain aggregate representing the booking state. |