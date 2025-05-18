//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.application.strategy.executor](../index.md)/[BookingCommandExecutor](index.md)/[execute](execute.md)

# execute

[src]\
open fun [execute](execute.md)(
command: [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)

Executes the given [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md) by delegating
to the matching strategy.

#### Return

The result of the command execution as
a [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md).

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-30

#### Parameters

src

|         |                             |
|---------|-----------------------------|
| command | The command to be executed. |

#### Throws

|                                                                                                               |                                                 |
|---------------------------------------------------------------------------------------------------------------|-------------------------------------------------|
| [IllegalArgumentException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalArgumentException.html) | if no strategy supports the given command type. |