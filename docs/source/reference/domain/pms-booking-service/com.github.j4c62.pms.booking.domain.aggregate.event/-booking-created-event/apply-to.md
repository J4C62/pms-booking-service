//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.event](../index.md)/[BookingCreatedEvent](index.md)/[applyTo](apply-to.md)

# applyTo

[java]\
open fun [applyTo](apply-to.md)(aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)

Applies this event to create a new [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md). 

This is the only event that can initialize a new aggregate instance. It sets the booking status to `PENDING` and wraps this event in the event list.

#### Return

A new `BookingAggregate` initialized from this event.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-23

#### Parameters

java

| | |
|---|---|
| aggregate | This parameter is ignored as this event creates a new aggregate. |