//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.event](../index.md)/[BookingCreatedEvent](index.md)

# BookingCreatedEvent

class [BookingCreatedEvent](index.md) : [Record](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Record.html), [BookingEvent](../-booking-event/index.md)

Domain event representing the creation of a booking. 

This event is used to initialize a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md) when a new booking is created. It contains all necessary data to represent the initial state of the booking.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-23

#### Parameters

java

| | |
|---|---|
| bookingId | The unique identifier of the booking. |
| propertyId | The identifier of the property associated with the booking. |
| guestId | The identifier of the guest who made the booking. |
| bookingDates | The check-in and check-out dates for the booking. |
| occurredAt | The timestamp indicating when the event occurred. |
| eventType | The type of event, should be `BookingEventType.CREATED`. |

## Constructors

| | |
|---|---|
| [BookingCreatedEvent](-booking-created-event.md) | [java]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [applyTo](apply-to.md) | [java]<br>open fun [applyTo](apply-to.md)(aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)<br>Applies this event to create a new [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md). |
| [bookingId](../-booking-event/booking-id.md) | [java]<br>abstract fun [bookingId](../-booking-event/booking-id.md)(): [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md)<br>Returns the ID of the booking to which this event relates. |
| [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-1170581573) | [java]<br>abstract fun [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-1170581573)(p: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [eventType](../-booking-event/event-type.md) | [java]<br>abstract fun [eventType](../-booking-event/event-type.md)(): [BookingEventType](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-event-type/index.md)<br>Returns the type of this booking event. |
| [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-1170581573) | [java]<br>abstract fun [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-1170581573)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [occurredAt](../-booking-event/occurred-at.md) | [java]<br>abstract fun [occurredAt](../-booking-event/occurred-at.md)(): [Instant](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/time/Instant.html)<br>Returns the timestamp when this event occurred. |
| [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-1170581573) | [java]<br>abstract fun [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-1170581573)(): [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html) |