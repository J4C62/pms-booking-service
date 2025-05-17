//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.kafka](../index.md)/[BookingEventStreamConfig](index.md)/[bookingEventSupplier](booking-event-supplier.md)

# bookingEventSupplier

[src]\
open
fun [bookingEventSupplier](booking-event-supplier.md)(): ([BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md))
-&gt; Message&lt;BookingEvent&gt;

Supplier function that transforms
a [BookingEvent](../../com.github.j4c62.pms.booking.domain.aggregate.event/-booking-event/index.md) into a CloudEvents
formatted with appropriate headers.

#### Return

a function that wraps booking events into messages ready for publication

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-14