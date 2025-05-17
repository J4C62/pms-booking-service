//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.driven](../index.md)/[BookingEventPublisher](index.md)/[publish](publish.md)

# publish

[src]\
abstract fun [publish](publish.md)(
bookingEvent: [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md))

Publishes the given [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) to
the appropriate channel.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-24

#### Parameters

src

|              |                                               |
|--------------|-----------------------------------------------|
| bookingEvent | the event to be published; must not be `null` |