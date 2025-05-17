//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.driver.output](../index.md)/[BookingOutput](index.md)

# BookingOutput

class [BookingOutput](index.md) : [Record](https://docs.oracle.com/javase/8/docs/api/java/lang/Record.html)

Represents the result of executing a on a .

This output is returned by command handlers to expose key information about the booking's state after applying a
command, typically including the booking's unique identifier and its current status.

This DTO is intended for use at application or API boundaries and does not expose internal domain logic.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-18

#### Parameters

src

|           |                                                                         |
|-----------|-------------------------------------------------------------------------|
| bookingId | the unique identifier of the booking                                    |
| status    | the current status of the booking (e.g., PENDING, CONFIRMED, CANCELLED) |

## Constructors

|                                     |                        |
|-------------------------------------|------------------------|
| [BookingOutput](-booking-output.md) | [src]<br>constructor() |

## Functions

| Name                                                                                                                            | Summary                                                                                                                                                                                                                                                                                                                   |
|---------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-748457715)  | [src]<br>abstract fun [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-748457715)(p: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-748457715) | [src]<br>abstract fun [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-748457715)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)                                                                                      |
| [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-748457715) | [src]<br>abstract fun [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-748457715)(): [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)                                                                                        |