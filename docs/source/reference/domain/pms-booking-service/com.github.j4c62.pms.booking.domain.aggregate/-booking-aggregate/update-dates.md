//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate](../index.md)/[BookingAggregate](index.md)/[updateDates](update-dates.md)

# updateDates

[java]\
open fun [updateDates](update-dates.md)(newDates: [BookingDates](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-dates/index.md)): [BookingAggregate](index.md)

Updates the booking dates.

#### Return

A new `BookingAggregate` with updated dates and event.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-23

#### Parameters

java

| | |
|---|---|
| newDates | The new dates for the booking. |

#### Throws

| | |
|---|---|
| [IllegalStateException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalStateException.html) | if the booking is cancelled or the dates have not changed. |