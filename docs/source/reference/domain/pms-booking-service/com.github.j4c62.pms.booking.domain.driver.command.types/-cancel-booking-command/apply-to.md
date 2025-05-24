//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.driver.command.types](../index.md)/[CancelBookingCommand](index.md)/[applyTo](apply-to.md)

# applyTo

[java]\
open fun [applyTo](apply-to.md)(aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)

Applies this command to a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md) by generating and applying a .

#### Return

A new `BookingAggregate` with the cancellation applied.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-02

#### Parameters

java

| | |
|---|---|
| aggregate | The current state of the booking aggregate. |