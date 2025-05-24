//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.application.strategy.executor](../index.md)/[BookingCommandExecutor](index.md)/[execute](execute.md)

# execute

[java]\
open fun [execute](execute.md)(@NonNullcommand: @NonNull[Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)

Executes the given [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md) by delegating to the matching strategy.

#### Return

The result of the command execution as a [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md).

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-30

#### Parameters

java

| | |
|---|---|
| command | The command to be executed. |

#### Throws

| | |
|---|---|
| [IllegalArgumentException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalArgumentException.html) | if no strategy supports the given command type. |