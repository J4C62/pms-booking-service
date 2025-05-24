//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.creation](../index.md)/[BookingEventFactory](index.md)/[createConfirmedBookingEvent](create-confirmed-booking-event.md)

# createConfirmedBookingEvent

[java]\
open fun [createConfirmedBookingEvent](create-confirmed-booking-event.md)(bookingId: [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md)): [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)

Creates a [BookingConfirmedEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-confirmed-event/index.md) representing the confirmation of a booking.

#### Return

A `BookingConfirmedEvent` with the current timestamp and `
    BOOKING_CONFIRMED` type.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-10

#### Parameters

java

| | |
|---|---|
| bookingId | The identifier of the booking being confirmed. |