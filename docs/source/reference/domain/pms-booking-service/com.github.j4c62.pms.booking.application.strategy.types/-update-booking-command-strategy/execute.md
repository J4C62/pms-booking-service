//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.application.strategy.types](../index.md)/[UpdateBookingCommandStrategy](index.md)/[execute](execute.md)

# execute

[java]\
open fun [execute](execute.md)(command: [UpdateBookingCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-update-booking-command/index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)

Executes the update command by. 

- Loading the event stream for the booking
- Restoring the current aggregate state
- Applying the command to mutate the aggregate
- Publishing the resulting domain events
- Mapping the updated aggregate to a [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md) DTO

#### Return

The output representation of the updated booking.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-30

#### Parameters

java

| | |
|---|---|
| command | The command to execute. |