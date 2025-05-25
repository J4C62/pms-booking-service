//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde](../index.md)/[BookingEventsSerde](index.md)

# BookingEventsSerde

[java]\
open class [BookingEventsSerde](index.md) : Serde&lt;T&gt; 

Custom Serde implementation for serializing and deserializing [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md). 

This serde uses a Jackson ObjectMapper configured with the Java Time module to handle JSON serialization of the list of [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) instances contained within a  object. It delegates the serialization and deserialization of individual  instances to [BookingEventSerde](../-booking-event-serde/index.md). 

Serialization converts the `BookingEvents` into a JSON array of events, while deserialization reconstructs a `BookingEvents` instance from a JSON array.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-02

## Constructors

| | |
|---|---|
| [BookingEventsSerde](-booking-events-serde.md) | [java]<br>constructor()<br>Constructs a new `BookingEventsSerde` with default Jackson ObjectMapper configuration. |

## Functions

| Name                                                                               | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
|------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [close](../-booking-event-serde/index.md#-1953835945%2FFunctions%2F-1170581573)    | [java]<br>open fun [close](../-booking-event-serde/index.md#-1953835945%2FFunctions%2F-1170581573)()                                                                                                                                                                                                                                                                                                                                                                           |
| [configure](../-booking-event-serde/index.md#2083171214%2FFunctions%2F-1170581573) | [java]<br>open fun [configure](../-booking-event-serde/index.md#2083171214%2FFunctions%2F-1170581573)(p: [Map](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/Map.html)&lt;[String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html), out [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;, p1: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)) |
| [deserializer](deserializer.md)                                                    | [java]<br>open fun [deserializer](deserializer.md)(): Deserializer&lt;[BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md)&gt;<br>Provides a deserializer for [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md) which reads a JSON array of booking events and reconstructs the `BookingEvents` instance.                                                                           |
| [serializer](serializer.md)                                                        | [java]<br>open fun [serializer](serializer.md)(): Serializer&lt;[BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md)&gt;<br>Provides a serializer for [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md) which serializes the contained list of booking events to JSON bytes.                                                                                                        |