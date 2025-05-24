//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.application.creation.mapper](../index.md)/[BookingAggregateMapper](index.md)/[toAggregate](to-aggregate.md)

# toAggregate

[java]\
abstract fun [toAggregate](to-aggregate.md)(input: [CreateBookingCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-create-booking-command/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)

Maps a [CreateBookingCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-create-booking-command/index.md) to a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md). 

- Generates a new `BookingId` using a random UUID.
- Ignores `status`, `bookingEvents`, and `updateDates` — those are set later in domain logic.

#### Return

A partially initialized `BookingAggregate` with values from the command.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-24

#### Parameters

java

| | |
|---|---|
| input | The booking creation command. |