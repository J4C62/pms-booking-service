//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.domain.shared.validator](../index.md)/[ValidatorHelper](index.md)/[requireStartNotInPast](require-start-not-in-past.md)

# requireStartNotInPast

[src]\
open fun [requireStartNotInPast](require-start-not-in-past.md)(
startDate: [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html))

Validates that the start date is not in the past relative to the current system date.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-16

#### Parameters

src

|           |                                                |
|-----------|------------------------------------------------|
| startDate | the start date to validate; must not be `null` |

#### Throws

|                                                                                                               |                                |
|---------------------------------------------------------------------------------------------------------------|--------------------------------|
| [IllegalArgumentException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalArgumentException.html) | if `startDate` is before today |