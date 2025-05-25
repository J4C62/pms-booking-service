//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.application.strategy](../index.md)/[BookingCommandStrategy](index.md)

# BookingCommandStrategy

interface [BookingCommandStrategy](index.md)&lt;[T](index.md) : [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md)?&gt;

Strategy interface for handling specific types of [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md) operations within the booking domain. 

Implementations of this interface encapsulate the logic to handle a particular type of command (e.g., create, cancel, update booking), allowing for clean separation of concerns and open extension for new command types.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-30

#### Parameters

java

| | |
|---|---|
| &lt;T&gt; | The specific type of command this strategy handles. |

#### Inheritors

|                                                                              |
|------------------------------------------------------------------------------|
| [UpdateBookingCommandStrategy](../-update-booking-command-strategy/index.md) |
| [CreateBookingCommandStrategy](../-create-booking-command-strategy/index.md) |

## Functions

| Name                    | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
|-------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [execute](execute.md)   | [java]<br>abstract fun [execute](execute.md)(command: [T](index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)<br>Executes the command, applying domain logic to produce a [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md).                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| [handle](handle.md)     | [java]<br>open fun [handle](handle.md)(command: [T](index.md), aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md), dispatcher: [BookingEventDispatcher](../../com.github.j4c62.pms.booking.application.dispatcher/-booking-event-dispatcher/index.md), outputMapper: [BookingOutputMapper](../../com.github.j4c62.pms.booking.application.creation.mapper/-booking-output-mapper/index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)<br>Default helper method to apply a command to a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md), dispatch the resulting domain events, and map the result to a [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md). |
| [supports](supports.md) | [java]<br>abstract fun [supports](supports.md)(command: [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Determines whether this strategy is capable of handling the given command.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |