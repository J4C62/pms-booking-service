//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.driver.command.types](../index.md)/[UpdateBookingDatesCommand](index.md)

# UpdateBookingDatesCommand

class [UpdateBookingDatesCommand](index.md) : [Record](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Record.html), [UpdateBookingCommand](../-update-booking-command/index.md)

Command representing an update to the booking dates of an existing booking. 

This command is part of the [UpdateBookingCommand](../-update-booking-command/index.md) hierarchy and carries the new dates to apply along with a reason for the update. When executed, it generates a  and applies it to the [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md).

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-01

#### Parameters

java

| | |
|---|---|
| bookingId | The identifier of the booking to be updated. |
| guestId | The identifier of the actor responsible for the update. |
| bookingDates | The new check-in and check-out dates for the booking. |
| updateReason | A business-contextual reason for changing the booking dates. |

## Constructors

| | |
|---|---|
| [UpdateBookingDatesCommand](-update-booking-dates-command.md) | [java]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [applyTo](apply-to.md) | [java]<br>open fun [applyTo](apply-to.md)(aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)<br>Applies this command to a given [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md) by generating a  and applying it to mutate the aggregate state. |
| [bookingId](../-update-booking-command/booking-id.md) | [java]<br>abstract fun [bookingId](../-update-booking-command/booking-id.md)(): [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md)<br>Returns the identifier of the booking to be updated. |
| [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-1170581573) | [java]<br>abstract fun [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-1170581573)(p: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-1170581573) | [java]<br>abstract fun [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-1170581573)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-1170581573) | [java]<br>abstract fun [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-1170581573)(): [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html) |