//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.application.strategy.executor](../index.md)/[BookingCommandExecutor](index.md)

# BookingCommandExecutor

[java]\
@Component

open class [BookingCommandExecutor](index.md)

Central executor that delegates [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md) processing to the appropriate  based on command type. 

This component serves as a dynamic router that selects the correct strategy implementation for the given command, enabling open-closed principle by allowing new strategies to be added without modifying this class. 

It is intended to be used by services such as  to abstract away the logic of finding and executing the correct handler for each command.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-30

## Constructors

| | |
|---|---|
| [BookingCommandExecutor](-booking-command-executor.md) | [java]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [execute](execute.md) | [java]<br>open fun [execute](execute.md)(@NonNullcommand: @NonNull[Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)<br>Executes the given [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md) by delegating to the matching strategy. |