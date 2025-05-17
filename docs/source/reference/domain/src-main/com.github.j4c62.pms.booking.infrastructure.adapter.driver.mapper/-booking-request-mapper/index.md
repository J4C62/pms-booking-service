//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper](../index.md)/[BookingRequestMapper](index.md)

# BookingRequestMapper

[src]\
interface [BookingRequestMapper](index.md)

Mapper interface for converting incoming gRPC booking requests into domain-level command objects.

Used by to map incoming Protobuf messages into `CreateBookingCommand`, `CancelBookingCommand`, and `
UpdateBookingDatesCommand`, which are handled by the core domain layer.

This interface is implemented automatically by MapStruct. It also includes custom mapping logic for domain value objects
such
as [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md), [PropertyId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-property-id/index.md), [GuestId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-guest-id/index.md),
and [BookingDates](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-dates/index.md).

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-18

## Functions

| Name                                    | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
|-----------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [mapBookingDates](map-booking-dates.md) | [src]<br>open fun [mapBookingDates](map-booking-dates.md)(startDate: [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), endDate: [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)): [BookingDates](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-dates/index.md)<br>Creates a [BookingDates](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-dates/index.md) value object from string inputs. |
| [mapBookingId](map-booking-id.md)       | [src]<br>open fun [mapBookingId](map-booking-id.md)(id: [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)): [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md)<br>Converts a string UUID to a [BookingId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-booking-id/index.md).                                                                                                                            |
| [mapGuestId](map-guest-id.md)           | [src]<br>open fun [mapGuestId](map-guest-id.md)(id: [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)): [GuestId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-guest-id/index.md)<br>Converts a string UUID to a [GuestId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-guest-id/index.md).                                                                                                                                        |
| [mapPropertyId](map-property-id.md)     | [src]<br>open fun [mapPropertyId](map-property-id.md)(id: [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)): [PropertyId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-property-id/index.md)<br>Converts a string UUID to a [PropertyId](../../com.github.j4c62.pms.booking.domain.aggregate.vo/-property-id/index.md).                                                                                                                      |
| [toCancelInput](to-cancel-input.md)     | [src]<br>abstract fun [toCancelInput](to-cancel-input.md)(request: CancelBookingRequest): [CancelBookingCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-cancel-booking-command/index.md)<br>Maps a gRPC `CancelBookingRequest` to a `CancelBookingCommand`.                                                                                                                                                                                             |
| [toCreateInput](to-create-input.md)     | [src]<br>abstract fun [toCreateInput](to-create-input.md)(request: CreateBookingRequest): [CreateBookingCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-create-booking-command/index.md)<br>Maps a gRPC `CreateBookingRequest` to a `CreateBookingCommand`.                                                                                                                                                                                             |
| [toLocalDate](to-local-date.md)         | [src]<br>open fun [toLocalDate](to-local-date.md)(date: [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)): [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)<br>Parses a [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html) from a string.                                                                                                                                                   |
| [toUpdateInput](to-update-input.md)     | [src]<br>abstract fun [toUpdateInput](to-update-input.md)(request: UpdateBookingRequest): [UpdateBookingDatesCommand](../../com.github.j4c62.pms.booking.domain.driver.command.types/-update-booking-dates-command/index.md)<br>Maps a gRPC `UpdateBookingRequest` to an `UpdateBookingDatesCommand`.                                                                                                                                                                            |