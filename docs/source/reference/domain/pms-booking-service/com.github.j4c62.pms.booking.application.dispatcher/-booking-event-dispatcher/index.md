//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.application.dispatcher](../index.md)/[BookingEventDispatcher](index.md)

# BookingEventDispatcher

[java]\
@Component

class [BookingEventDispatcher](index.md) : [Record](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Record.html)

Component responsible for dispatching domain events produced by
a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md).

This class acts as a coordination point between the domain and infrastructure layers, extracting domain events from the
aggregate and forwarding them to the for asynchronous processing or integration with external systems.

Typically invoked after a command has been executed and the aggregate has emitted one or more domain events.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-25

## Constructors

|                                                        |                         |
|--------------------------------------------------------|-------------------------|
| [BookingEventDispatcher](-booking-event-dispatcher.md) | [java]<br>constructor() |

## Functions

| Name                                                                                                                             | Summary                                                                                                                                                                                                                                                                                                                     |
|----------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [dispatch](dispatch.md)                                                                                                          | [java]<br>open fun [dispatch](dispatch.md)(aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md))<br>Dispatches all domain events emitted by the given [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md).        |
| [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-1170581573)  | [java]<br>abstract fun [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-1170581573)(p: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-1170581573) | [java]<br>abstract fun [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-1170581573)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)                                                                                      |
| [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-1170581573) | [java]<br>abstract fun [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-1170581573)(): [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html)                                                                     |