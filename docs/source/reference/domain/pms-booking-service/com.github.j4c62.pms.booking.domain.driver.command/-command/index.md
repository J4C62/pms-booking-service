//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.driver.command](../index.md)/[Command](index.md)

# Command

@[FunctionalInterface](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/FunctionalInterface.html)

interface [Command](index.md)

Represents a command that can be applied to a [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md) to produce a new state. 

A command encapsulates an intention to perform an action or state change in the system, but does not directly execute that change. Instead, it is translated into one or more  instances when applied. 

This interface is a key part of a Command-Event architecture, enabling clear separation between user intent and domain event generation.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-27

#### Inheritors

| |
|---|
| [CreateBookingCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-create-booking-command/index.md) |
| [UpdateBookingCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-update-booking-command/index.md) |

## Functions

| Name | Summary |
|---|---|
| [applyTo](apply-to.md) | [java]<br>abstract fun [applyTo](apply-to.md)(aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)<br>Applies this command to the given [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md), producing an updated aggregate. |