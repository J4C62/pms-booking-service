//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.driver.command](../index.md)/[Command](index.md)/[applyTo](apply-to.md)

# applyTo

[src]\
abstract fun [applyTo](apply-to.md)(
aggregate: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)

Applies this command to the
given [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md), producing an
updated aggregate. The result reflects the state after the corresponding has been applied.

#### Return

the new [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md) representing
the updated state

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-27

#### Parameters

src

|           |                                                                                    |
|-----------|------------------------------------------------------------------------------------|
| aggregate | the current aggregate to apply the command to; may be `null` for creation commands |