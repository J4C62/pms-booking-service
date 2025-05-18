//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.aggregate.vo](../index.md)/[BookingEvents](index.md)/[replayOn](replay-on.md)

# replayOn

[src]\
open fun [replayOn](replay-on.md)(
base: [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)): [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md)

Applies each event in the current list to the
given [BookingAggregate](../../com.github.j4c62.pms.booking.domain.aggregate/-booking-aggregate/index.md), replaying
them sequentially to produce a new aggregate state.

#### Return

The updated aggregate after all events have been applied.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-23

#### Parameters

src

|      |                                                            |
|------|------------------------------------------------------------|
| base | The initial aggregate to which the events will be applied. |