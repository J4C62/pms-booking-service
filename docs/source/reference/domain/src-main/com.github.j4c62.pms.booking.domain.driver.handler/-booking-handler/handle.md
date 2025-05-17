//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.driver.handler](../index.md)/[BookingHandler](index.md)/[handle](handle.md)

# handle

[src]\
abstract fun [handle](handle.md)(
command: [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)

Handles the given [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md) and returns the
result of applying it to a booking aggregate.

#### Return

the output resulting from applying the command

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-27

#### Parameters

src

|         |                                           |
|---------|-------------------------------------------|
| command | the command to handle; must not be `null` |

#### Throws

|                                                                                                               |                                      |
|---------------------------------------------------------------------------------------------------------------|--------------------------------------|
| [IllegalArgumentException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalArgumentException.html) | if the command type is not supported |