//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.kafka](../index.md)/[BookingTopology](index.md)/[processBookingEvents](process-booking-events.md)

# processBookingEvents

[java]\

@Bean

open fun [processBookingEvents](process-booking-events.md)(bookingEventSerde: Serde&lt;[BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)&gt;, bookingEventsSerde: Serde&lt;[BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md)&gt;): (KStream&lt;[String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html), [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)&gt;) -&gt; KStream&lt;[BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md), [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md)&gt;

Defines the Kafka Streams processing function that aggregates booking events by bookingId.

#### Return

a function transforming an input KStream keyed by String to an output KStream keyed by BookingId with aggregated BookingEvents

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-14

#### Parameters

java

| | |
|---|---|
| bookingEventSerde | Serde for [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) used in deserialization and serialization |
| bookingEventsSerde | Serde for [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md) used for state store serialization |