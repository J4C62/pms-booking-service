//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.creation](../index.md)/[BookingAggregateFactory](index.md)/[createBookingAggregate](create-booking-aggregate.md)

# createBookingAggregate

[src]\
open fun [createBookingAggregate](create-booking-aggregate.md)(
bookingId: [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md),
propertyId: [PropertyId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-property-id/index.md),
guestId: [GuestId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-guest-id/index.md),
bookingDates: [BookingDates](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-dates/index.md),
status: [BookingStatus](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-status/index.md),
bookingEvents: [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)

Creates a new [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md) with
the provided parameters.

#### Return

A new instance of `BookingAggregate`.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-01

#### Parameters

src

|               |                                                        |
|---------------|--------------------------------------------------------|
| bookingId     | The unique identifier of the booking.                  |
| propertyId    | The identifier of the property being booked.           |
| guestId       | The identifier of the guest who made the booking.      |
| bookingDates  | The dates associated with the booking.                 |
| status        | The current status of the booking.                     |
| bookingEvents | The list of domain events associated with the booking. |