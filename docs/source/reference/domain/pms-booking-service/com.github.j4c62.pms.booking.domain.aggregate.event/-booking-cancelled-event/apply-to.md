//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.event](../index.md)/[BookingCancelledEvent](index.md)/[applyTo](apply-to.md)

# applyTo

[java]\
open fun [applyTo](apply-to.md)(aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)

Applies this event to the given [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md), marking it as cancelled.

#### Return

A new [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md) with updated status.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-23

#### Parameters

java

| | |
|---|---|
| aggregate | The current booking aggregate state. |

#### Throws

| | |
|---|---|
| [IllegalStateException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalStateException.html) | if the booking is already cancelled. |