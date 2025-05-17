//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.creation](../index.md)/[BookingEventFactory](index.md)/[createCancelledBookingEvent](create-cancelled-booking-event.md)

# createCancelledBookingEvent

[src]\
open fun [createCancelledBookingEvent](create-cancelled-booking-event.md)(
bookingId: [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md)): [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)

Creates
a [BookingCancelledEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-cancelled-event/index.md)
representing the cancellation of a booking.

#### Return

A `BookingCancelledEvent` with the current timestamp and `
    BOOKING_CANCELLED` type.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-11

#### Parameters

src

|           |                                                |
|-----------|------------------------------------------------|
| bookingId | The identifier of the booking being cancelled. |