//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.vo](../index.md)/[BookingDates](index.md)/[BookingDates](-booking-dates.md)

# BookingDates

[java]\
constructor(startDate: [LocalDate](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/time/LocalDate.html), endDate: [LocalDate](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/time/LocalDate.html))

Constructs a `BookingDates` object with the given start and end dates, enforcing business rules for date validity.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-25

#### Parameters

java

| | |
|---|---|
| startDate | The check-in date; must not be null or in the past. |
| endDate | The check-out date; must not be null and must be after the start date. |

#### Throws

| | |
|---|---|
| [NullPointerException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/NullPointerException.html) | if either date is null. |
| [IllegalArgumentException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalArgumentException.html) | if start date is after or equal to end date, or if the start date is in the past. |