//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.driven](../index.md)/[BookingEventPublisher](index.md)

# BookingEventPublisher

@[FunctionalInterface](https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html)

interface [BookingEventPublisher](index.md)

Functional interface responsible for
publishing [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) instances.

Implementations of this interface handle the dispatching of booking-related events to downstream systems, such as
message brokers, event logs, or other services.

This interface is typically used to decouple the domain logic from infrastructure concerns.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-17

#### Inheritors

|                                                                                                                           |
|---------------------------------------------------------------------------------------------------------------------------|
| [KafkaProducerAdapter](../../com.github.j4c62.pms.booking.infrastructure.adapter.driven/-kafka-producer-adapter/index.md) |

## Functions

| Name                  | Summary                                                                                                                                                                                                                                                                                                           |
|-----------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [publish](publish.md) | [src]<br>abstract fun [publish](publish.md)(bookingEvent: [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md))<br>Publishes the given [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) to the appropriate channel. |