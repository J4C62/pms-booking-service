//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.vo](../index.md)/[BookingEvents](index.md)

# BookingEvents

class [BookingEvents](index.md) : [Record](https://docs.oracle.com/javase/8/docs/api/java/lang/Record.html)

Value object that encapsulates a sequence of domain events related to a booking.

This class provides operations for appending new events, creating empty or immutable event lists, and replaying events
on a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md) to reconstruct
its state.

The event list is treated as immutable and is defensively copied on creation to ensure integrity.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-23

#### Parameters

src

|        |                                                                                                                                   |
|--------|-----------------------------------------------------------------------------------------------------------------------------------|
| events | An immutable list of [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) instances. |

## Constructors

|                                     |                                                                                                                                                                                                                                                                                                        |
|-------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [BookingEvents](-booking-events.md) | [src]<br>constructor(events: [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)&gt;)<br>Canonical constructor that ensures the events list is never null and always immutable. |

## Functions

| Name                                                                                                                            | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
|---------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [append](append.md)                                                                                                             | [src]<br>open fun [append](append.md)(event: [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)): [BookingEvents](index.md)<br>Returns a new `BookingEvents` with the given event appended to the current list.                                                                                                                                                                                                                       |
| [empty](empty.md)                                                                                                               | [src]<br>open fun [empty](empty.md)(): [BookingEvents](index.md)<br>Returns an empty `BookingEvents` instance.                                                                                                                                                                                                                                                                                                                                                                       |
| [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-748457715)  | [src]<br>abstract fun [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-748457715)(p: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)                                                                                                                                                            |
| [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-748457715) | [src]<br>abstract fun [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-748457715)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)                                                                                                                                                                                                                                                 |
| [of](of.md)                                                                                                                     | [src]<br>open fun [of](of.md)(events: [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)&gt;): [BookingEvents](index.md)<br>Creates a new `BookingEvents` instance from a given list of events.                                                                                                                                                              |
| [replayOn](replay-on.md)                                                                                                        | [src]<br>open fun [replayOn](replay-on.md)(base: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)<br>Applies each event in the current list to the given [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md), replaying them sequentially to produce a new aggregate state. |
| [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-748457715) | [src]<br>abstract fun [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-748457715)(): [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)                                                                                                                                                                                                                                                   |