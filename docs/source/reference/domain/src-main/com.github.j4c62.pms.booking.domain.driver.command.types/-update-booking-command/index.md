//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.driver.command.types](../index.md)/[UpdateBookingCommand](index.md)

# UpdateBookingCommand

interface [UpdateBookingCommand](index.md) : [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md)

Represents a command that modifies an existing .

All update commands must provide
the [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md) of the booking they intend
to modify. These commands are typically translated into domain events that reflect updates to booking data, such as
changes to dates, status, or cancellation.

This interface extends [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md) to support
polymorphic handling of booking update operations.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-27

#### Inheritors

|                                                                        |
|------------------------------------------------------------------------|
| [CancelBookingCommand](../-cancel-booking-command/index.md)            |
| [UpdateBookingDatesCommand](../-update-booking-dates-command/index.md) |

## Functions

| Name                                                                                     | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
|------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [applyTo](../../com.github.j4c62.pms.booking.domain.driver.command/-command/apply-to.md) | [src]<br>abstract fun [applyTo](../../com.github.j4c62.pms.booking.domain.driver.command/-command/apply-to.md)(aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)<br>Applies this command to the given [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md), producing an updated aggregate. |
| [bookingId](booking-id.md)                                                               | [src]<br>abstract fun [bookingId](booking-id.md)(): [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md)<br>Returns the identifier of the booking to be updated.                                                                                                                                                                                                                                                                                                          |