//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.application.strategy.types](../index.md)/[UpdateBookingCommandStrategy](index.md)

# UpdateBookingCommandStrategy

[java]\
@Component

open class [UpdateBookingCommandStrategy](index.md) : [BookingCommandStrategy](../../com.github.j4c62.pms.booking.application.strategy/-booking-command-strategy/index.md)&lt;[T](../../com.github.j4c62.pms.booking.application.strategy/-booking-command-strategy/index.md)&gt; 

Command strategy for handling updates to existing bookings. 

This class implements the [BookingCommandStrategy](../../com.github.j4c62.pms.booking.application.strategy/-booking-command-strategy/index.md) interface specifically for  types. It is responsible for loading the current aggregate state, applying the command to produce a new state (and domain events), publishing those events, and mapping the updated state to an output DTO. 

This component is typically used as part of a command handling framework or service layer that delegates execution based on the command type.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-30

## Constructors

| | |
|---|---|
| [UpdateBookingCommandStrategy](-update-booking-command-strategy.md) | [java]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [execute](execute.md) | [java]<br>open fun [execute](execute.md)(command: [UpdateBookingCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-update-booking-command/index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)<br>Executes the update command by. |
| [supports](supports.md) | [java]<br>open fun [supports](supports.md)(command: [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Indicates whether this strategy supports the given command. |