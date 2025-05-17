//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.kafka](../index.md)/[BookingTopology](index.md)/[processBookingEvents](process-booking-events.md)

# processBookingEvents

[src]\
open fun [processBookingEvents](process-booking-events.md)(bookingEventSerde: Serde&lt;BookingEvent&gt;,
bookingEventsSerde: Serde&lt;BookingEvents&gt;): (KStream&lt;String, BookingEvent&gt;) -&gt; KStream&lt;BookingId,
BookingEvents&gt;

Defines the Kafka Streams processing function that aggregates booking events by bookingId.

#### Return

a function transforming an input KStream keyed by String to an output KStream keyed by BookingId with aggregated
BookingEvents

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-14

#### Parameters

src

|                    |                                                                                                                                                       |
|--------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------|
| bookingEventSerde  | Serde for [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) used in deserialization and serialization |
| bookingEventsSerde | Serde for [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md) used for state store serialization         |