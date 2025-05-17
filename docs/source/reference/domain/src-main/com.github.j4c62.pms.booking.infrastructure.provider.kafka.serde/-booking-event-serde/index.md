//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde](../index.md)/[BookingEventSerde](index.md)

# BookingEventSerde

[src]\
open class [BookingEventSerde](index.md)

Custom serializer and deserializer (Serde)
for [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) domain events.

This class uses Jackson to serialize and deserialize booking events based on the `
eventType` field. It supports all known event subtypes such as: `BookingCreatedEvent`, `BookingCancelledEvent`, etc.

This class is annotated with `@RequiredArgsConstructor`, meaning the is injected via constructor.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-03

## Constructors

|                                              |                        |
|----------------------------------------------|------------------------|
| [BookingEventSerde](-booking-event-serde.md) | [src]<br>constructor() |

## Functions

| Name                            | Summary                                                                                                                                                                                                                      |
|---------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [deserializer](deserializer.md) | [src]<br>open fun [deserializer](deserializer.md)(): Deserializer&lt;BookingEvent&gt;<br>Returns a Kafka Deserializer for [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md). |
| [serializer](serializer.md)     | [src]<br>open fun [serializer](serializer.md)(): Serializer&lt;BookingEvent&gt;<br>Returns a Kafka Serializer for [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md).         |