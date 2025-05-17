//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.driven](../index.md)/[BookingEventStore](index.md)

# BookingEventStore

@[FunctionalInterface](https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html)

interface [BookingEventStore](index.md)

Functional interface representing a read-only event store for booking-related events.

Provides access to the historical list of instances associated with a
specific [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md). This is typically
used to reconstruct the current state of a `
BookingAggregate` by replaying its event history.

This interface abstracts away the underlying storage mechanism, allowing different implementations (e.g., in-memory,
database, event log) to be used interchangeably.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-04

#### Inheritors

|                                                                                                                                    |
|------------------------------------------------------------------------------------------------------------------------------------|
| [KafkaStreamsStoreBooking](../../com.github.j4c62.pms.booking.infrastructure.adapter.driven/-kafka-streams-store-booking/index.md) |

## Functions

| Name                                             | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
|--------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [getEventsForBooking](get-events-for-booking.md) | [src]<br>abstract fun [getEventsForBooking](get-events-for-booking.md)(bookingId: [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md)): [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md)<br>Retrieves all [com.github.j4c62.pms.booking.domain.aggregate.event.BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) instances associated with the given [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md). |