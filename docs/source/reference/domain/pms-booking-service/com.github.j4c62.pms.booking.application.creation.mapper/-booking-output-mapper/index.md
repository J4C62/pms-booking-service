//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.application.creation.mapper](../index.md)/[BookingOutputMapper](index.md)

# BookingOutputMapper

[java]\
interface [BookingOutputMapper](index.md)

MapStruct mapper interface for converting a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md) to a [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md) DTO. 

This mapper is used to transform the internal domain representation of a booking into a format suitable for external layers such as APIs, UIs, or external systems. 

It is integrated with Spring's dependency injection via `componentModel = "spring"`.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-30

## Functions

| Name | Summary |
|---|---|
| [toBookingOutput](to-booking-output.md) | [java]<br>abstract fun [toBookingOutput](to-booking-output.md)(bookingAggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)<br>Maps a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md) to a [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md) DTO. |