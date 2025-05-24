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

| |
|---|
| [CreateBookingCommandStrategy](../../com.github.j4c62.pms.booking.application.strategy.types/-create-booking-command-strategy/index.md) |
| [UpdateBookingCommandStrategy](../../com.github.j4c62.pms.booking.application.strategy.types/-update-booking-command-strategy/index.md) |

## Functions

| Name | Summary |
|---|---|
| [execute](execute.md) | [java]<br>abstract fun [execute](execute.md)(command: [T](index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)<br>Executes the command, applying domain logic to produce a [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md). |
| [supports](supports.md) | [java]<br>abstract fun [supports](supports.md)(command: [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Determines whether this strategy is capable of handling the given command. |