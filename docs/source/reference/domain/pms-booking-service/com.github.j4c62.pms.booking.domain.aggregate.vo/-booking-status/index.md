//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.vo](../index.md)/[BookingStatus](index.md)

# BookingStatus

[java]\
enum [BookingStatus](index.md)

Enumeration representing the status of a booking within the system. 

Booking statuses describe the lifecycle state of a `BookingAggregate`. 

- 
   [PENDING](-p-e-n-d-i-n-g/index.md) - The booking has been created but not yet confirmed.
- 
   [CANCELLED](-c-a-n-c-e-l-l-e-d/index.md) - The booking has been cancelled and is no longer active.
- 
   [CONFIRMED](-c-o-n-f-i-r-m-e-d/index.md) - The booking has been confirmed and is considered active.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-15

## Entries

| | |
|---|---|
| [PENDING](-p-e-n-d-i-n-g/index.md) | [java]<br>[PENDING](-p-e-n-d-i-n-g/index.md) |
| [CANCELLED](-c-a-n-c-e-l-l-e-d/index.md) | [java]<br>[CANCELLED](-c-a-n-c-e-l-l-e-d/index.md) |
| [CONFIRMED](-c-o-n-f-i-r-m-e-d/index.md) | [java]<br>[CONFIRMED](-c-o-n-f-i-r-m-e-d/index.md) |

## Functions

| Name | Summary |
|---|---|
| [isCancelled](is-cancelled.md) | [java]<br>open fun [isCancelled](is-cancelled.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [valueOf](value-of.md) | [java]<br>open fun [valueOf](value-of.md)(name: [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html)): [BookingStatus](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [java]<br>open fun [values](values.md)(): [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[BookingStatus](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. This method may be used to iterate over the constants. |