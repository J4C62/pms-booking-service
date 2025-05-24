//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.driven](../index.md)/[BookingEventStore](index.md)/[getEventsForBooking](get-events-for-booking.md)

# getEventsForBooking

[java]\
abstract fun [getEventsForBooking](get-events-for-booking.md)(bookingId: [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md)): [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md)

Retrieves all [com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) instances associated with the given [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md).

#### Return

a [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md) container with the full event history of the booking; never `null`, but may be empty

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-04

#### Parameters

java

| | |
|---|---|
| bookingId | the unique identifier of the booking |