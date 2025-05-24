//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.application.strategy.types](../index.md)/[CreateBookingCommandStrategy](index.md)

# CreateBookingCommandStrategy

[java]\
@Component

open class [CreateBookingCommandStrategy](index.md) : [BookingCommandStrategy](../../com.github.j4c62.pms.booking.application.strategy/-booking-command-strategy/index.md)&lt;[T](../../com.github.j4c62.pms.booking.application.strategy/-booking-command-strategy/index.md)&gt; 

Strategy for handling [CreateBookingCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-create-booking-command/index.md) operations. 

This class implements the logic required to create a new booking from the input command. It maps the command to a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md), applies domain logic via the command itself, publishes the resulting domain event, and transforms the updated aggregate into an output DTO. 

This strategy is automatically selected by the  when a `
CreateBookingCommand` is received.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-30

## Constructors

| | |
|---|---|
| [CreateBookingCommandStrategy](-create-booking-command-strategy.md) | [java]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [execute](execute.md) | [java]<br>open fun [execute](execute.md)(command: [CreateBookingCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-create-booking-command/index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)<br>Executes the creation of a booking. |
| [supports](supports.md) | [java]<br>open fun [supports](supports.md)(command: [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Checks if this strategy supports the given command. |