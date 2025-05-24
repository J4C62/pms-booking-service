//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.vo](../index.md)/[BookingEventType](index.md)

# BookingEventType

[java]\
enum [BookingEventType](index.md)

Enumeration representing the types of domain events that can occur for a booking. 

Each enum constant is associated with a string identifier, typically used for serialization, deserialization, or message publishing (e.g., Kafka topics). 

- 
   [BOOKING_CREATED](-b-o-o-k-i-n-g_-c-r-e-a-t-e-d/index.md) - Indicates that a booking was created.
- 
   [BOOKING_UPDATED](-b-o-o-k-i-n-g_-u-p-d-a-t-e-d/index.md) - Indicates that a booking's dates or details were updated.
- 
   [BOOKING_CONFIRMED](-b-o-o-k-i-n-g_-c-o-n-f-i-r-m-e-d/index.md) - Indicates that a booking was confirmed by the system.
- 
   [BOOKING_CANCELLED](-b-o-o-k-i-n-g_-c-a-n-c-e-l-l-e-d/index.md) - Indicates that a booking was cancelled.

#### Author

Jose Antonio (J4c62)

#### Since

2025-03-25

## Entries

| | |
|---|---|
| [BOOKING_CREATED](-b-o-o-k-i-n-g_-c-r-e-a-t-e-d/index.md) | [java]<br>[BOOKING_CREATED](-b-o-o-k-i-n-g_-c-r-e-a-t-e-d/index.md) |
| [BOOKING_UPDATED](-b-o-o-k-i-n-g_-u-p-d-a-t-e-d/index.md) | [java]<br>[BOOKING_UPDATED](-b-o-o-k-i-n-g_-u-p-d-a-t-e-d/index.md) |
| [BOOKING_CONFIRMED](-b-o-o-k-i-n-g_-c-o-n-f-i-r-m-e-d/index.md) | [java]<br>[BOOKING_CONFIRMED](-b-o-o-k-i-n-g_-c-o-n-f-i-r-m-e-d/index.md) |
| [BOOKING_CANCELLED](-b-o-o-k-i-n-g_-c-a-n-c-e-l-l-e-d/index.md) | [java]<br>[BOOKING_CANCELLED](-b-o-o-k-i-n-g_-c-a-n-c-e-l-l-e-d/index.md) |

## Properties

| Name | Summary |
|---|---|
| [eventType](event-type.md) | [java]<br>val [eventType](event-type.md): [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html) |

## Functions

| Name | Summary |
|---|---|
| [valueOf](value-of.md) | [java]<br>open fun [valueOf](value-of.md)(name: [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html)): [BookingEventType](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [java]<br>open fun [values](values.md)(): [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[BookingEventType](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. This method may be used to iterate over the constants. |