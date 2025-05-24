//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driven](../index.md)/[KafkaStreamsStoreBooking](index.md)/[getEventsForBooking](get-events-for-booking.md)

# getEventsForBooking

[java]\

@NonNull

open fun [getEventsForBooking](get-events-for-booking.md)(@NonNullbookingId: @NonNull[BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md)): @NonNull[BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md)

Retrieves the list of [com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)s associated with the given [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md) from the Kafka Streams state store.

#### Return

the [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md) associated with the booking, or `null` if not found

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-02

#### Parameters

java

| | |
|---|---|
| bookingId | the identifier of the booking whose events are to be retrieved; must not be `null` |