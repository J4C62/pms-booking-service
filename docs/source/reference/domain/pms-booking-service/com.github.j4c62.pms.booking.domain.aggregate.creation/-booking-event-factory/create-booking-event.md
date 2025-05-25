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

[java]\
open fun [createBookingEvent](create-booking-event.md)(
bookingId: [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md),
propertyId: [PropertyId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-property-id/index.md),
guestId: [GuestId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-guest-id/index.md),
bookingDates: [BookingDates](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-dates/index.md)): [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)

Creates
a [BookingCreatedEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-created-event/index.md) with
explicit values for all required properties.

This method is useful when constructing a creation event outside an aggregate context, such as in DTO-to-domain
mappings, test setups, or event replay scenarios. It ensures that the created event has a valid structure and consistent
metadata.

#### Return

A `BookingCreatedEvent` instance with `BOOKING_CREATED` type and the current timestamp.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-25

#### Parameters

java

|              |                                                             |
|--------------|-------------------------------------------------------------|
| bookingId    | The unique identifier of the booking.                       |
| propertyId   | The identifier of the property associated with the booking. |
| guestId      | The identifier of the guest who made the booking.           |
| bookingDates | The booking date range (start and end).                     |