//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate](../index.md)/[BookingAggregate](index.md)/[cancel](cancel.md)

# cancel

[src]\
open fun [cancel](cancel.md)(): [BookingAggregate](index.md)

Cancels the booking.

#### Return

A new `BookingAggregate` with updated status and cancellation event.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-23

#### Throws

|                                                                                                         |                                      |
|---------------------------------------------------------------------------------------------------------|--------------------------------------|
| [IllegalStateException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html) | if the booking is already cancelled. |