//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driven](../index.md)/[KafkaProducerAdapter](index.md)

# KafkaProducerAdapter

[java]\
@Service

open class [KafkaProducerAdapter](index.md) : [BookingEventPublisher](../../com.github.j4c62.pms.booking.domain.driven/-booking-event-publisher/index.md)

Kafka-based implementation of the [BookingEventPublisher](../../com.github.j4c62.pms.booking.domain.driven/-booking-event-publisher/index.md) interface. 

This service is responsible for publishing [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) instances to a Kafka topic via Spring Cloud Stream's StreamBridge. It decouples domain logic from messaging infrastructure. 

The event is sent to the output binding named `bookingEventSupplier-out-0`.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-18

## Constructors

| | |
|---|---|
| [KafkaProducerAdapter](-kafka-producer-adapter.md) | [java]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [publish](publish.md) | [java]<br>open fun [publish](publish.md)(@NonNullbookingEvent: @NonNull[BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md))<br>Publishes the given [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) to Kafka using Spring Cloud Stream. |