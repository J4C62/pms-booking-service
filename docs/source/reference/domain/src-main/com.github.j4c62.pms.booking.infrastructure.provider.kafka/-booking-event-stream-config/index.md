//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.kafka](../index.md)/[BookingEventStreamConfig](index.md)

# BookingEventStreamConfig

[src]\
open class [BookingEventStreamConfig](index.md)

Spring configuration class for configuring the booking event stream.

Defines a Spring Cloud Stream [Function](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)
bean that converts [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)
instances into CloudEvents-compliant Message objects with the necessary headers for event-driven communication.

This configuration enables integration with messaging middleware, ensuring that booking events are published with
standard CloudEvents metadata, such as event ID, type, source, spec version, and timestamp.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-14

## Constructors

|                                                             |                        |
|-------------------------------------------------------------|------------------------|
| [BookingEventStreamConfig](-booking-event-stream-config.md) | [src]<br>constructor() |

## Functions

| Name                                              | Summary                                                                                                                                                                                                                                                                                                                                                                                                       |
|---------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [bookingEventSupplier](booking-event-supplier.md) | [src]<br>open fun [bookingEventSupplier](booking-event-supplier.md)(): ([BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md)) -&gt; Message&lt;BookingEvent&gt;<br>Supplier function that transforms a [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) into a CloudEvents formatted  with appropriate headers. |