//[pms-booking-service](../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driven](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [KafkaProducerAdapter](-kafka-producer-adapter/index.md) | [java]<br>@Service<br>open class [KafkaProducerAdapter](-kafka-producer-adapter/index.md) : [BookingEventPublisher](../com.github.j4c62.pms.booking.domain.driven/-booking-event-publisher/index.md)<br>Kafka-based implementation of the [BookingEventPublisher](../com.github.j4c62.pms.booking.domain.driven/-booking-event-publisher/index.md) interface. |
| [KafkaStreamsStoreBooking](-kafka-streams-store-booking/index.md) | [java]<br>@Component<br>open class [KafkaStreamsStoreBooking](-kafka-streams-store-booking/index.md) : [BookingEventStore](../com.github.j4c62.pms.booking.domain.driven/-booking-event-store/index.md)<br>Kafka Streams-based implementation of the [BookingEventStore](../com.github.j4c62.pms.booking.domain.driven/-booking-event-store/index.md) interface. |