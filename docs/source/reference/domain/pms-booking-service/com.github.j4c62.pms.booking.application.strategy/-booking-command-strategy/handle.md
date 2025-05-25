//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.application.strategy](../index.md)/[BookingCommandStrategy](index.md)/[handle](handle.md)

# handle

[java]\
open fun [handle](handle.md)(command: [T](index.md),
aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md),
dispatcher: [BookingEventDispatcher](../../com.github.j4c62.pms.booking.application.dispatcher/-booking-event-dispatcher/index.md),
outputMapper: [BookingOutputMapper](../../com.github.j4c62.pms.booking.application.creation.mapper/-booking-output-mapper/index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)

Default helper method to apply a command to
a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md), dispatch the
resulting domain events, and map the result to
a [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md).

#### Return

The final output DTO representing the command result.

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-25

#### Parameters

java

|              |                                                                                                                                                       |
|--------------|-------------------------------------------------------------------------------------------------------------------------------------------------------|
| command      | The domain command to apply.                                                                                                                          |
| aggregate    | The aggregate to which the command will be applied.                                                                                                   |
| dispatcher   | The event dispatcher responsible for publishing domain events.                                                                                        |
| outputMapper | The mapper to convert the updated aggregate into a [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md). |