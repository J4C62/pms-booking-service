//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.application.handler](../index.md)/[BookingCommandHandler](index.md)/[handle](handle.md)

# handle

[java]\
open fun [handle](handle.md)(@NonNullcommand: @NonNull[Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)

Handles a given [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md) by delegating its execution to the command executor.

#### Return

The [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md) result after applying the command.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-27

#### Parameters

java

| | |
|---|---|
| command | The command to be processed (e.g., create, update, cancel). |

#### Throws

| | |
|---|---|
| [IllegalArgumentException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalArgumentException.html) | if the command type is unsupported. |