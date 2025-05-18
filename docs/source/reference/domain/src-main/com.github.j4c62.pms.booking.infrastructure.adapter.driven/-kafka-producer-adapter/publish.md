//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driven](../index.md)/[KafkaProducerAdapter](index.md)/[publish](publish.md)

# publish

[src]\
open fun [publish](publish.md)(
bookingEvent: [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md))

Publishes the given [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) to
Kafka using Spring Cloud Stream.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-18

#### Parameters

src

|              |                                          |
|--------------|------------------------------------------|
| bookingEvent | the event to publish; must not be `null` |