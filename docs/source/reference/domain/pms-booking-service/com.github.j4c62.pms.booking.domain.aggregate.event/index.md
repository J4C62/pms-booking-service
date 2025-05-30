//[pms-booking-service](../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.event](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [BookingCancelledEvent](-booking-cancelled-event/index.md) | [java]<br>class [BookingCancelledEvent](-booking-cancelled-event/index.md) : [Record](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Record.html), [BookingEvent](-booking-event/index.md)<br>Domain event representing the cancellation of a booking. |
| [BookingConfirmedEvent](-booking-confirmed-event/index.md) | [java]<br>class [BookingConfirmedEvent](-booking-confirmed-event/index.md) : [Record](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Record.html), [BookingEvent](-booking-event/index.md)<br>Event representing that a booking has been confirmed. |
| [BookingCreatedEvent](-booking-created-event/index.md) | [java]<br>class [BookingCreatedEvent](-booking-created-event/index.md) : [Record](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Record.html), [BookingEvent](-booking-event/index.md)<br>Domain event representing the creation of a booking. |
| [BookingEvent](-booking-event/index.md) | [java]<br>interface [BookingEvent](-booking-event/index.md)<br>Sealed interface representing a domain event in the Booking context. |
| [BookingUpdateEvent](-booking-update-event/index.md) | [java]<br>class [BookingUpdateEvent](-booking-update-event/index.md) : [Record](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Record.html), [BookingEvent](-booking-event/index.md)<br>Domain event representing an update to the booking dates. |