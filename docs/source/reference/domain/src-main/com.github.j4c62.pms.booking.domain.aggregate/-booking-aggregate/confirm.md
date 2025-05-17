//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate](../index.md)/[BookingAggregate](index.md)/[confirm](confirm.md)

# confirm

[src]\
open fun [confirm](confirm.md)(): [BookingAggregate](index.md)

Confirms the booking.

#### Return

A new `BookingAggregate` with updated status and confirmation event.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-10

#### Throws

|                                                                                                         |                                            |
|---------------------------------------------------------------------------------------------------------|--------------------------------------------|
| [IllegalStateException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html) | if the booking has already been cancelled. |