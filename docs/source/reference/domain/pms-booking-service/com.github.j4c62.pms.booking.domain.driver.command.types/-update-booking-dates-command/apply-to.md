//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.driver.command.types](../index.md)/[UpdateBookingDatesCommand](index.md)/[applyTo](apply-to.md)

# applyTo

[java]\
open fun [applyTo](apply-to.md)(aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)

Applies this command to a given [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md) by generating a  and applying it to mutate the aggregate state.

#### Return

A new `BookingAggregate` reflecting the updated dates.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-01

#### Parameters

java

| | |
|---|---|
| aggregate | The current state of the booking aggregate. |