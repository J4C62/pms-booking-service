//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde](../index.md)/[BookingEventsSerde](index.md)

# BookingEventsSerde

[src]\
open class [BookingEventsSerde](index.md)

Custom Serde implementation for serializing and
deserializing [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md).

This serde uses a Jackson ObjectMapper configured with the Java Time module to handle JSON serialization of the list
of [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) instances contained
within a object. It delegates the serialization and deserialization of individual instances
to [BookingEventSerde](../-booking-event-serde/index.md).

Serialization converts the `BookingEvents` into a JSON array of events, while deserialization reconstructs a
`BookingEvents` instance from a JSON array.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-02

## Constructors

|                                                |                                                                                                                  |
|------------------------------------------------|------------------------------------------------------------------------------------------------------------------|
| [BookingEventsSerde](-booking-events-serde.md) | [src]<br>constructor()<br>Constructs a new `BookingEventsSerde` with default Jackson ObjectMapper configuration. |

## Functions

| Name                            | Summary                                                                                                                                                                                                                                                                                                          |
|---------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [deserializer](deserializer.md) | [src]<br>open fun [deserializer](deserializer.md)(): Deserializer&lt;BookingEvents&gt;<br>Provides a deserializer for [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md) which reads a JSON array of booking events and reconstructs the `BookingEvents` instance. |
| [serializer](serializer.md)     | [src]<br>open fun [serializer](serializer.md)(): Serializer&lt;BookingEvents&gt;<br>Provides a serializer for [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md) which serializes the contained list of booking events to JSON bytes.                              |