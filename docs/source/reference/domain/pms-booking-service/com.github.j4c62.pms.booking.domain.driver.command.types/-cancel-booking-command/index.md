//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.driver.command.types](../index.md)/[CancelBookingCommand](index.md)

# CancelBookingCommand

class [CancelBookingCommand](index.md) : [Record](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Record.html), [UpdateBookingCommand](../-update-booking-command/index.md)

Command representing a request to cancel an existing booking. 

This command is part of the booking modification command set and carries metadata about the reason and the actor responsible for the cancellation. It produces a  that is applied to the [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md).

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-17

#### Parameters

java

| | |
|---|---|
| bookingId | The identifier of the booking to cancel. |
| guestId | The identifier of the actor responsible for the cancellation. |
| reason | The reason for the cancellation. |

## Constructors

| | |
|---|---|
| [CancelBookingCommand](-cancel-booking-command.md) | [java]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [applyTo](apply-to.md) | [java]<br>open fun [applyTo](apply-to.md)(aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)<br>Applies this command to a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md) by generating and applying a . |
| [bookingId](../-update-booking-command/booking-id.md) | [java]<br>abstract fun [bookingId](../-update-booking-command/booking-id.md)(): [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md)<br>Returns the identifier of the booking to be updated. |
| [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-1170581573) | [java]<br>abstract fun [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-1170581573)(p: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-1170581573) | [java]<br>abstract fun [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-1170581573)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-1170581573) | [java]<br>abstract fun [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-1170581573)(): [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html) |