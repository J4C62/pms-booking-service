//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.vo](../index.md)/[BookingId](index.md)

# BookingId

class [BookingId](index.md) : [Record](https://docs.oracle.com/javase/8/docs/api/java/lang/Record.html)

Value object representing the unique identifier of a booking.

This class wraps a [UUID](https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html) and enforces non-nullability at
construction time.

Used throughout the domain model to uniquely reference a `BookingAggregate`.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-23

#### Parameters

src

|       |                                              |
|-------|----------------------------------------------|
| value | The UUID that uniquely identifies a booking. |

## Constructors

|                             |                                                                                                                                                                              |
|-----------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [BookingId](-booking-id.md) | [src]<br>constructor(value: [UUID](https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html))<br>Constructs a new `BookingId` instance, ensuring the value is not null. |

## Functions

| Name                                                                                                                            | Summary                                                                                                                                                                                                                                                                                                                   |
|---------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-748457715)  | [src]<br>abstract fun [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-748457715)(p: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-748457715) | [src]<br>abstract fun [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-748457715)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)                                                                                      |
| [of](of.md)                                                                                                                     | [src]<br>open fun [of](of.md)(value: [UUID](https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html)): [BookingId](index.md)<br>Factory method for creating a `BookingId` from a given UUID.                                                                                                                        |
| [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-748457715) | [src]<br>abstract fun [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-748457715)(): [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)                                                                                        |