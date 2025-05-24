//[pms-booking-service](../../index.md)/[com.github.j4c62.pms.booking.domain.driver.command.types](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [CancelBookingCommand](-cancel-booking-command/index.md) | [java]<br>class [CancelBookingCommand](-cancel-booking-command/index.md) : [Record](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Record.html), [UpdateBookingCommand](-update-booking-command/index.md)<br>Command representing a request to cancel an existing booking. |
| [CreateBookingCommand](-create-booking-command/index.md) | [java]<br>class [CreateBookingCommand](-create-booking-command/index.md) : [Record](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Record.html), [Command](../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md)<br>Command representing the creation of a new booking. |
| [UpdateBookingCommand](-update-booking-command/index.md) | [java]<br>interface [UpdateBookingCommand](-update-booking-command/index.md) : [Command](../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md)<br>Represents a command that modifies an existing . |
| [UpdateBookingDatesCommand](-update-booking-dates-command/index.md) | [java]<br>class [UpdateBookingDatesCommand](-update-booking-dates-command/index.md) : [Record](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Record.html), [UpdateBookingCommand](-update-booking-command/index.md)<br>Command representing an update to the booking dates of an existing booking. |