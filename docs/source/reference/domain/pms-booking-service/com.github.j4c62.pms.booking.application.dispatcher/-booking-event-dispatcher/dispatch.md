//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.application.dispatcher](../index.md)/[BookingEventDispatcher](index.md)/[dispatch](dispatch.md)

# dispatch

[java]\
open fun [dispatch](dispatch.md)(
aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md))

Dispatches all domain events emitted by the
given [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md).

This method extracts the events collected by the aggregate during a command execution and publishes each of them via the
injected [BookingEventPublisher](../../com.github.j4c62.pms.booking.domain.driven/-booking-event-publisher/index.md).

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-25

#### Parameters

java

|           |                                                             |
|-----------|-------------------------------------------------------------|
| aggregate | The booking aggregate containing domain events to dispatch. |

#### Throws

|                                                                                                                          |                                             |
|--------------------------------------------------------------------------------------------------------------------------|---------------------------------------------|
| [NullPointerException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/NullPointerException.html) | if `aggregate` or its event list is `null`. |