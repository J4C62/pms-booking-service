//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driven](../index.md)/[KafkaStreamsStoreBooking](index.md)

# KafkaStreamsStoreBooking

[src]\
open
class [KafkaStreamsStoreBooking](index.md) : [BookingEventStore](../../com.github.j4c62.pms.booking.domain.driven/-booking-event-store/index.md)

Kafka Streams-based implementation of
the [BookingEventStore](../../com.github.j4c62.pms.booking.domain.driven/-booking-event-store/index.md) interface.

This component retrieves
stored [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md) for a
specific [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md) from a Kafka Streams
state store using the InteractiveQueryService.

The store name is configurable via the property `application.booking.kafka.store-name 
 `.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-02

## Constructors

|                                                             |                        |
|-------------------------------------------------------------|------------------------|
| [KafkaStreamsStoreBooking](-kafka-streams-store-booking.md) | [src]<br>constructor() |

## Functions

| Name                                             | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
|--------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [getEventsForBooking](get-events-for-booking.md) | [src]<br>open fun [getEventsForBooking](get-events-for-booking.md)(bookingId: [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md)): [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md)<br>Retrieves the list of [com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)s associated with the given [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md) from the Kafka Streams state store. |