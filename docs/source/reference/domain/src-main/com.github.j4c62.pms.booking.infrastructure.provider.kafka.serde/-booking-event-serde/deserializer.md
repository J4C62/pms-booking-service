//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde](../index.md)/[BookingEventSerde](index.md)/[deserializer](deserializer.md)

# deserializer

[src]\
open fun [deserializer](deserializer.md)(): Deserializer&lt;BookingEvent&gt;

Returns a Kafka Deserializer
for [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md).

The deserializer reads the `eventType` field from the JSON and uses it to determine the specific subtype of
`BookingEvent` to instantiate.

#### Return

A deserializer that reads byte arrays and produces `BookingEvent` instances.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-03

#### Throws

|                        |                                                    |
|------------------------|----------------------------------------------------|
| SerializationException | if deserialization fails or event type is unknown. |