//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde](../index.md)/[BookingEventSerde](index.md)

# BookingEventSerde

[java]\
open class [BookingEventSerde](index.md) : Serde&lt;T&gt; 

Custom serializer and deserializer (Serde) for [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) domain events. 

This class uses Jackson to serialize and deserialize booking events based on the `
eventType` field. It supports all known event subtypes such as: `BookingCreatedEvent`, `BookingCancelledEvent`, etc. 

This class is annotated with `@RequiredArgsConstructor`, meaning the  is injected via constructor.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-03

## Constructors

| | |
|---|---|
| [BookingEventSerde](-booking-event-serde.md) | [java]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [close](../-booking-events-serde/index.md#-1953835945%2FFunctions%2F-1170581573) | [java]<br>open fun [close](../-booking-events-serde/index.md#-1953835945%2FFunctions%2F-1170581573)() |
| [configure](../-booking-events-serde/index.md#2083171214%2FFunctions%2F-1170581573) | [java]<br>open fun [configure](../-booking-events-serde/index.md#2083171214%2FFunctions%2F-1170581573)(p: [Map](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/Map.html)&lt;[String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html), out [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;, p1: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)) |
| [deserializer](deserializer.md) | [java]<br>open fun [deserializer](deserializer.md)(): Deserializer&lt;[BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)&gt;<br>Returns a Kafka Deserializer for [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md). |
| [serializer](serializer.md) | [java]<br>open fun [serializer](serializer.md)(): Serializer&lt;[BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)&gt;<br>Returns a Kafka Serializer for [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md). |