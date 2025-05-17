//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate](../index.md)/[BookingAggregate](index.md)/[restoreFrom](restore-from.md)

# restoreFrom

[src]\
open fun [restoreFrom](restore-from.md)(
events: [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md)): [BookingAggregate](index.md)

Reconstructs a `BookingAggregate` from a list of domain events.

#### Return

The reconstructed `BookingAggregate`.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-03

#### Parameters

src

|        |                                                         |
|--------|---------------------------------------------------------|
| events | The list of events from which to restore the aggregate. |

#### Throws

|                                                                                                               |                                                    |
|---------------------------------------------------------------------------------------------------------------|----------------------------------------------------|
| [IllegalArgumentException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalArgumentException.html) | if the event list is empty.                        |
| [IllegalStateException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html)       | if the first event is not a `BookingCreatedEvent`. |