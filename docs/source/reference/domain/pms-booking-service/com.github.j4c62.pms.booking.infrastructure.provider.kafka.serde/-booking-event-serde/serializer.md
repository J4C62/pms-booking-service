//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde](../index.md)/[BookingEventSerde](index.md)/[serializer](serializer.md)

# serializer

[java]\
open fun [serializer](serializer.md)(): Serializer&lt;[BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)&gt;

Returns a Kafka Serializer for [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md).

#### Return

A serializer that converts `BookingEvent` instances to byte arrays using Jackson.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-03

#### Throws

| | |
|---|---|
| SerializationException | if serialization fails. |