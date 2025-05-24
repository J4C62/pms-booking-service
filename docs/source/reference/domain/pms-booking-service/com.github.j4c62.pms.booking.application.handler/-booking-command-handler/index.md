//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.application.handler](../index.md)/[BookingCommandHandler](index.md)

# BookingCommandHandler

[java]\
@Service

open class [BookingCommandHandler](index.md) : [BookingHandler](../../com.github.j4c62.pms.booking.domain.driver.handler/-booking-handler/index.md)

Application service that handles incoming [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md) objects related to bookings. 

This service delegates the actual execution of the command to the , which applies the appropriate strategy based on the command type (e.g., create, update, cancel). 

It acts as an entry point in the application layer for command-based interactions, encapsulating the orchestration of domain logic without exposing implementation details.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-27

## Constructors

| | |
|---|---|
| [BookingCommandHandler](-booking-command-handler.md) | [java]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [handle](handle.md) | [java]<br>open fun [handle](handle.md)(@NonNullcommand: @NonNull[Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)<br>Handles a given [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md) by delegating its execution to the command executor. |