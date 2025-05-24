//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate](../index.md)/[BookingAggregate](index.md)

# BookingAggregate

class [BookingAggregate](index.md) : [Record](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Record.html)

Represents the aggregate root for a booking in the domain model. 

This class encapsulates the state and behavior of a booking, including operations such as creation ,confirmation, cancellation, and date updates. It is designed to be restored from a sequence of domain events (event sourcing pattern).

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-23

#### Parameters

java

| | |
|---|---|
| bookingId | The unique identifier of the booking. |
| propertyId | The identifier of the property being booked. |
| guestId | The identifier of the guest who made the booking. |
| bookingDates | The dates associated with the booking (check-in, check-out). |
| status | The current status of the booking (e.g., PENDING, CONFIRMED, CANCELLED). |
| bookingEvents | The list of domain events related to the booking. |

## Constructors

| | |
|---|---|
| [BookingAggregate](-booking-aggregate.md) | [java]<br>constructor(bookingId: [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md), propertyId: [PropertyId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-property-id/index.md), guestId: [GuestId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-guest-id/index.md), bookingDates: [BookingDates](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-dates/index.md), status: [BookingStatus](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-status/index.md), bookingEvents: [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md))<br>Compact constructor that ensures `bookingEvents` is never `null`. |

## Functions

| Name | Summary |
|---|---|
| [cancel](cancel.md) | [java]<br>open fun [cancel](cancel.md)(): [BookingAggregate](index.md)<br>Cancels the booking. |
| [confirm](confirm.md) | [java]<br>open fun [confirm](confirm.md)(): [BookingAggregate](index.md)<br>Confirms the booking. |
| [equals](index.md#-1797860926%2FFunctions%2F-1170581573) | [java]<br>abstract fun [equals](index.md#-1797860926%2FFunctions%2F-1170581573)(p: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [hashCode](index.md#1761002009%2FFunctions%2F-1170581573) | [java]<br>abstract fun [hashCode](index.md#1761002009%2FFunctions%2F-1170581573)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [restoreFrom](restore-from.md) | [java]<br>open fun [restoreFrom](restore-from.md)(events: [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md)): [BookingAggregate](index.md)<br>Reconstructs a `BookingAggregate` from a list of domain events. |
| [toString](index.md#1582835944%2FFunctions%2F-1170581573) | [java]<br>abstract fun [toString](index.md#1582835944%2FFunctions%2F-1170581573)(): [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html) |
| [updateDates](update-dates.md) | [java]<br>open fun [updateDates](update-dates.md)(newDates: [BookingDates](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-dates/index.md)): [BookingAggregate](index.md)<br>Updates the booking dates. |