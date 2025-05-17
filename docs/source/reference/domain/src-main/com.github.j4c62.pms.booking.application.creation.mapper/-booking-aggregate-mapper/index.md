//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.application.creation.mapper](../index.md)/[BookingAggregateMapper](index.md)

# BookingAggregateMapper

[src]\
interface [BookingAggregateMapper](index.md)

MapStruct mapper interface for converting input commands into domain aggregates.

This mapper transforms
a [CreateBookingCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-create-booking-command/index.md)
into a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md), initializing
only the essential fields for the creation of a new booking. Non-mapped fields such as status and bookingEvents are
handled elsewhere in the domain logic.

The `bookingId` is generated automatically as a new wrapping a random UUID.

This mapper uses Spring's dependency injection framework.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-24

## Functions

| Name                           | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
|--------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [toAggregate](to-aggregate.md) | [src]<br>abstract fun [toAggregate](to-aggregate.md)(input: [CreateBookingCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-create-booking-command/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)<br>Maps a [CreateBookingCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-create-booking-command/index.md) to a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md). |