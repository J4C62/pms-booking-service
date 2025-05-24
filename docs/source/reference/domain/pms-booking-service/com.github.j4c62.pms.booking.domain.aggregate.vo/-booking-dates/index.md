//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.vo](../index.md)/[BookingDates](index.md)

# BookingDates

class [BookingDates](index.md) : [Record](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Record.html)

Value object representing the start and end dates of a booking. 

Ensures that the date range is valid by enforcing domain invariants: the start date must not be in the past, and must be before the end date. 

This class is immutable and performs validation at construction time to guarantee consistency across the system.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-25

#### Parameters

java

| | |
|---|---|
| startDate | The check-in date of the booking. |
| endDate | The check-out date of the booking. |

## Constructors

| | |
|---|---|
| [BookingDates](-booking-dates.md) | [java]<br>constructor(startDate: [LocalDate](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/time/LocalDate.html), endDate: [LocalDate](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/time/LocalDate.html))<br>Constructs a `BookingDates` object with the given start and end dates, enforcing business rules for date validity. |

## Functions

| Name | Summary |
|---|---|
| [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-1170581573) | [java]<br>abstract fun [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-1170581573)(p: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-1170581573) | [java]<br>abstract fun [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-1170581573)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [isSameAs](is-same-as.md) | [java]<br>open fun [isSameAs](is-same-as.md)(other: [BookingDates](index.md)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Compares this `BookingDates` instance to another for equality. |
| [of](of.md) | [java]<br>open fun [of](of.md)(start: [LocalDate](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/time/LocalDate.html), end: [LocalDate](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/time/LocalDate.html)): [BookingDates](index.md)<br>Static factory method to create a [BookingDates](index.md) instance. |
| [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-1170581573) | [java]<br>abstract fun [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-1170581573)(): [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html) |