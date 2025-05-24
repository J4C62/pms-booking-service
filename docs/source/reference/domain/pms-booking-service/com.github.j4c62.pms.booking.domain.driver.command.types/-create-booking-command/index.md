//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.driver.command.types](../index.md)/[CreateBookingCommand](index.md)

# CreateBookingCommand

class [CreateBookingCommand](index.md) : [Record](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Record.html), [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md)

Command representing the creation of a new booking. 

This command carries the initial data needed to create a booking, including the property, guest, and booking dates. When applied, it produces a  and uses it to initialize a new [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md).

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-17

#### Parameters

java

| | |
|---|---|
| propertyId | The identifier of the property to be booked. |
| guestId | The identifier of the guest making the booking. |
| bookingDates | The dates of the booking (check-in and check-out). |

## Constructors

| | |
|---|---|
| [CreateBookingCommand](-create-booking-command.md) | [java]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [applyTo](apply-to.md) | [java]<br>open fun [applyTo](apply-to.md)(aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)<br>Applies this command by creating and applying a  to initialize a new [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md). |
| [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-1170581573) | [java]<br>abstract fun [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-1170581573)(p: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-1170581573) | [java]<br>abstract fun [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-1170581573)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-1170581573) | [java]<br>abstract fun [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-1170581573)(): [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html) |