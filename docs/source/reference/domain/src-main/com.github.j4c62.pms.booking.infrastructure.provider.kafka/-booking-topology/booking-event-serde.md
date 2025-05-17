//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.kafka](../index.md)/[BookingTopology](index.md)/[bookingEventSerde](booking-event-serde.md)

# bookingEventSerde

[src]\
open fun [bookingEventSerde](booking-event-serde.md)(objectMapper: ObjectMapper): Serde&lt;BookingEvent&gt;

Provides a Serde for [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)
using a
custom [BookingEventSerde](../../com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde/-booking-event-serde/index.md).

#### Return

a Serde for BookingEvent

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-14

#### Parameters

src

|              |                                                   |
|--------------|---------------------------------------------------|
| objectMapper | the Jackson ObjectMapper to use for serialization |