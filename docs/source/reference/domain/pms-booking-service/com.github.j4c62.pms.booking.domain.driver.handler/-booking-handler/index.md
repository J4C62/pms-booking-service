//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.driver.handler](../index.md)/[BookingHandler](index.md)

# BookingHandler

@[FunctionalInterface](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/FunctionalInterface.html)

interface [BookingHandler](index.md)

Central interface for handling [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md) instances that operate on booking aggregates. 

A `BookingHandler` is responsible for delegating incoming commands to the appropriate processing logic (e.g., creation, updates, confirmation, cancellation), and returning the resulting [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md). 

This abstraction enables decoupling between the command invocation layer (e.g., controllers, APIs) and the domain logic that processes each specific command.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-27

#### Inheritors

| |
|---|
| [BookingCommandHandler](../../com.github.j4c62.pms.booking.application.handler/-booking-command-handler/index.md) |

## Functions

| Name | Summary |
|---|---|
| [handle](handle.md) | [java]<br>abstract fun [handle](handle.md)(command: [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)<br>Handles the given [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md) and returns the result of applying it to a booking aggregate. |