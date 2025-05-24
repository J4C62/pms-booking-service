//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate](../index.md)/[BookingAggregate](index.md)/[BookingAggregate](-booking-aggregate.md)

# BookingAggregate

[java]\
constructor(bookingId: [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md), propertyId: [PropertyId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-property-id/index.md), guestId: [GuestId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-guest-id/index.md), bookingDates: [BookingDates](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-dates/index.md), status: [BookingStatus](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-status/index.md), bookingEvents: [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md))

Compact constructor that ensures `bookingEvents` is never `null`. 

If `bookingEvents` is `null`, it will be initialized with an empty event list. This guarantees safe access to `bookingEvents()` throughout the aggregate.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-23