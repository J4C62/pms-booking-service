//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.creation](../index.md)/[BookingEventFactory](index.md)/[createUpdateBookingEvent](create-update-booking-event.md)

# createUpdateBookingEvent

[src]\
open fun [createUpdateBookingEvent](create-update-booking-event.md)(
bookingId: [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md),
newDates: [BookingDates](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-dates/index.md)): [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)

Creates a [BookingUpdateEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-update-event/index.md)
representing a change in booking dates.

#### Return

A `BookingUpdateEvent` with the current timestamp and `BOOKING_UPDATED` type.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-11

#### Parameters

src

|           |                                              |
|-----------|----------------------------------------------|
| bookingId | The identifier of the booking being updated. |
| newDates  | The new booking dates to apply.              |