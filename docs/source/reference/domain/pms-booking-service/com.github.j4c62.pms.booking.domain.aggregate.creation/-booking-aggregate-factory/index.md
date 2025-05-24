//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.creation](../index.md)/[BookingAggregateFactory](index.md)

# BookingAggregateFactory

[java]\
class [BookingAggregateFactory](index.md)

Factory class for creating instances of [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md). 

This class provides a centralized place for constructing `BookingAggregate` instances, encapsulating the instantiation logic and ensuring consistency. 

This class cannot be instantiated.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-01

## Functions

| Name | Summary |
|---|---|
| [createBookingAggregate](create-booking-aggregate.md) | [java]<br>open fun [createBookingAggregate](create-booking-aggregate.md)(bookingId: [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md), propertyId: [PropertyId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-property-id/index.md), guestId: [GuestId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-guest-id/index.md), bookingDates: [BookingDates](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-dates/index.md), status: [BookingStatus](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-status/index.md), bookingEvents: [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)<br>Creates a new [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md) with the provided parameters. |