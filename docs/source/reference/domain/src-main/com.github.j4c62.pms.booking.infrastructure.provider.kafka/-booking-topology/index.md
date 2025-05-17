//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.kafka](../index.md)/[BookingTopology](index.md)

# BookingTopology

[src]\
open class [BookingTopology](index.md)

Kafka Streams topology configuration for processing booking events.

This configuration defines the stream processing logic to consume, aggregate, and store booking events keyed
by [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md) in a state store. It also
declares the required SerDes
for [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)
and [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md) to enable Kafka
serialization and deserialization.

The main processing function performs the following steps:

- Filters out null events
- Re-keys the stream by bookingId
- Groups events by bookingId
- Aggregates events
  into [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md)
- Materializes the aggregated results into a Kafka state store
- Converts the aggregated state back into a stream for downstream processing

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-02

## Constructors

|                                         |                        |
|-----------------------------------------|------------------------|
| [BookingTopology](-booking-topology.md) | [src]<br>constructor() |

## Functions

| Name                                              | Summary                                                                                                                                                                                                                                                                                                                                                                                  |
|---------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [bookingEventSerde](booking-event-serde.md)       | [src]<br>open fun [bookingEventSerde](booking-event-serde.md)(objectMapper: ObjectMapper): Serde&lt;BookingEvent&gt;<br>Provides a Serde for [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) using a custom [BookingEventSerde](../../com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde/-booking-event-serde/index.md). |
| [bookingEventsSerde](booking-events-serde.md)     | [src]<br>open fun [bookingEventsSerde](booking-events-serde.md)(): Serde&lt;BookingEvents&gt;<br>Provides a Serde for [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md).                                                                                                                                                                  |
| [processBookingEvents](process-booking-events.md) | [src]<br>open fun [processBookingEvents](process-booking-events.md)(bookingEventSerde: Serde&lt;BookingEvent&gt;, bookingEventsSerde: Serde&lt;BookingEvents&gt;): (KStream&lt;String, BookingEvent&gt;) -&gt; KStream&lt;BookingId, BookingEvents&gt;<br>Defines the Kafka Streams processing function that aggregates booking events by bookingId.                                     |