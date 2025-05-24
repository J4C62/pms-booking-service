//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.creation](../index.md)/[BookingEventFactory](index.md)

# BookingEventFactory

[java]\
class [BookingEventFactory](index.md)

Factory class for creating instances of [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md). 

This class centralizes the creation of various booking-related domain events. It provides convenience methods that encapsulate event creation logic and ensure proper event typing and timestamping. 

This class cannot be instantiated.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-01

## Functions

| Name | Summary |
|---|---|
| [createBookingEvent](create-booking-event.md) | [java]<br>open fun [createBookingEvent](create-booking-event.md)(aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)<br>Creates a [BookingCreatedEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-created-event/index.md) based on the current state of a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md). |
| [createCancelledBookingEvent](create-cancelled-booking-event.md) | [java]<br>open fun [createCancelledBookingEvent](create-cancelled-booking-event.md)(bookingId: [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md)): [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)<br>Creates a [BookingCancelledEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-cancelled-event/index.md) representing the cancellation of a booking. |
| [createConfirmedBookingEvent](create-confirmed-booking-event.md) | [java]<br>open fun [createConfirmedBookingEvent](create-confirmed-booking-event.md)(bookingId: [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md)): [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)<br>Creates a [BookingConfirmedEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-confirmed-event/index.md) representing the confirmation of a booking. |
| [createUpdateBookingEvent](create-update-booking-event.md) | [java]<br>open fun [createUpdateBookingEvent](create-update-booking-event.md)(bookingId: [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md), newDates: [BookingDates](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-dates/index.md)): [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)<br>Creates a [BookingUpdateEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-update-event/index.md) representing a change in booking dates. |