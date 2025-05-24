//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.event](../index.md)/[BookingEvent](index.md)

# BookingEvent

interface [BookingEvent](index.md)

Sealed interface representing a domain event in the Booking context. 

A `BookingEvent` captures a state change or domain action applied to a , such as creation, cancellation, update, or confirmation of a booking. 

Each implementation must provide the logic to apply the event to an aggregate and expose relevant metadata such as the booking ID, event type, and occurrence timestamp. 

This sealed interface restricts permitted event types to: 

- 
   [BookingCreatedEvent](../-booking-created-event/index.md)
- 
   [BookingCancelledEvent](../-booking-cancelled-event/index.md)
- 
   [BookingUpdateEvent](../-booking-update-event/index.md)
- 
   [BookingConfirmedEvent](../-booking-confirmed-event/index.md)

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-23

#### Inheritors

| |
|---|
| [BookingCancelledEvent](../-booking-cancelled-event/index.md) |
| [BookingConfirmedEvent](../-booking-confirmed-event/index.md) |
| [BookingCreatedEvent](../-booking-created-event/index.md) |
| [BookingUpdateEvent](../-booking-update-event/index.md) |

## Functions

| Name | Summary |
|---|---|
| [applyTo](apply-to.md) | [java]<br>abstract fun [applyTo](apply-to.md)(aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)<br>Applies this event to the given [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md), producing an updated state. |
| [bookingId](booking-id.md) | [java]<br>abstract fun [bookingId](booking-id.md)(): [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md)<br>Returns the ID of the booking to which this event relates. |
| [eventType](event-type.md) | [java]<br>abstract fun [eventType](event-type.md)(): [BookingEventType](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-event-type/index.md)<br>Returns the type of this booking event. |
| [occurredAt](occurred-at.md) | [java]<br>abstract fun [occurredAt](occurred-at.md)(): [Instant](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/time/Instant.html)<br>Returns the timestamp when this event occurred. |