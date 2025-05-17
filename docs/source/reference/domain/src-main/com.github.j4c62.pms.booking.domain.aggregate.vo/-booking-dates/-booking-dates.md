//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.vo](../index.md)/[BookingDates](index.md)/[BookingDates](-booking-dates.md)

# BookingDates

[src]\
constructor(startDate: [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html),
endDate: [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html))

Constructs a `BookingDates` object with the given start and end dates, enforcing business rules for date validity.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-25

#### Parameters

src

|           |                                                                        |
|-----------|------------------------------------------------------------------------|
| startDate | The check-in date; must not be null or in the past.                    |
| endDate   | The check-out date; must not be null and must be after the start date. |

#### Throws

|                                                                                                               |                                                                                   |
|---------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------|
| [NullPointerException](https://docs.oracle.com/javase/8/docs/api/java/lang/NullPointerException.html)         | if either date is null.                                                           |
| [IllegalArgumentException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalArgumentException.html) | if start date is after or equal to end date, or if the start date is in the past. |