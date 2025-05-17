//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.event](../index.md)/[BookingConfirmedEvent](index.md)

# BookingConfirmedEvent

class [BookingConfirmedEvent](index.md) : [Record](https://docs.oracle.com/javase/8/docs/api/java/lang/Record.html), [BookingEvent](../-booking-event/index.md)

Event representing that a booking has been confirmed.

This event is applied to
a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md) to transition its
status to confirmed.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-23

#### Parameters

src

|            |                                                                                                                                                                                      |
|------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| bookingId  | the unique identifier of the booking                                                                                                                                                 |
| eventType  | the type of booking event, expected to be [BOOKING_CONFIRMED](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-event-type/-b-o-o-k-i-n-g_-c-o-n-f-i-r-m-e-d/index.md) |
| occurredAt | the timestamp when the event occurred                                                                                                                                                |

## Constructors

|                                                      |                        |
|------------------------------------------------------|------------------------|
| [BookingConfirmedEvent](-booking-confirmed-event.md) | [src]<br>constructor() |

## Functions

| Name                                                                                                                            | Summary                                                                                                                                                                                                                                                                                                                                                                                                                           |
|---------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [applyTo](apply-to.md)                                                                                                          | [src]<br>open fun [applyTo](apply-to.md)(aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)<br>Applies this event to the given [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md), producing an updated state. |
| [bookingId](../-booking-event/booking-id.md)                                                                                    | [src]<br>abstract fun [bookingId](../-booking-event/booking-id.md)(): [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md)<br>Returns the ID of the booking to which this event relates.                                                                                                                                                                                                      |
| [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-748457715)  | [src]<br>abstract fun [equals](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#-1797860926%2FFunctions%2F-748457715)(p: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)                                                                                                         |
| [eventType](../-booking-event/event-type.md)                                                                                    | [src]<br>abstract fun [eventType](../-booking-event/event-type.md)(): [BookingEventType](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-event-type/index.md)<br>Returns the type of this booking event.                                                                                                                                                                                                          |
| [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-748457715) | [src]<br>abstract fun [hashCode](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1761002009%2FFunctions%2F-748457715)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)                                                                                                                                                                                              |
| [occurredAt](../-booking-event/occurred-at.md)                                                                                  | [src]<br>abstract fun [occurredAt](../-booking-event/occurred-at.md)(): [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html)<br>Returns the timestamp when this event occurred.                                                                                                                                                                                                                            |
| [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-748457715) | [src]<br>abstract fun [toString](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md#1582835944%2FFunctions%2F-748457715)(): [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)                                                                                                                                                                                                |