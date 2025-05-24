//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.creation](../index.md)/[BookingEventFactory](index.md)/[createBookingEvent](create-booking-event.md)

# createBookingEvent

[java]\
open fun [createBookingEvent](create-booking-event.md)(aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)

Creates a [BookingCreatedEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-created-event/index.md) based on the current state of a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md).

#### Return

A `BookingCreatedEvent` with the current timestamp and `BOOKING_CREATED` type.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-10

#### Parameters

java

| | |
|---|---|
| aggregate | The aggregate to extract data from for the event. |