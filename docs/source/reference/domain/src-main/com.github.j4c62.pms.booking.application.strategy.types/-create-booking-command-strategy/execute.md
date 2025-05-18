//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.application.strategy.types](../index.md)/[CreateBookingCommandStrategy](index.md)/[execute](execute.md)

# execute

[src]\
open fun [execute](execute.md)(
command: [CreateBookingCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-create-booking-command/index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)

Executes the creation of a booking.

- Maps the command to a
  new [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md) using the
  mapper.
- Applies the command's logic to the aggregate.
- Publishes the generated booking event(s).
- Returns the result as
  a [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md).

#### Return

A DTO representing the newly created booking.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-30

#### Parameters

src

|         |                               |
|---------|-------------------------------|
| command | The booking creation command. |