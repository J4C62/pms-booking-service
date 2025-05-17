//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.kafka.serde](../index.md)/[BookingEventsSerde](index.md)/[deserializer](deserializer.md)

# deserializer

[src]\
open fun [deserializer](deserializer.md)(): Deserializer&lt;BookingEvents&gt;

Provides a deserializer
for [BookingEvents](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-events/index.md) which reads a JSON
array of booking events and reconstructs the `BookingEvents` instance.

#### Return

a Deserializer for BookingEvents

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-02