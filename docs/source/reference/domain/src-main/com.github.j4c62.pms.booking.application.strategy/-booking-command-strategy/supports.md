//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.application.strategy](../index.md)/[BookingCommandStrategy](index.md)/[supports](supports.md)

# supports

[src]\
abstract fun [supports](supports.md)(
command: [Command](../../com.github.j4c62.pms.booking.domain.driver.command/-command/index.md)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

Determines whether this strategy is capable of handling the given command.

#### Return

`true` if the strategy supports this command; `false` otherwise.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-30

#### Parameters

src

|         |                          |
|---------|--------------------------|
| command | The command to evaluate. |