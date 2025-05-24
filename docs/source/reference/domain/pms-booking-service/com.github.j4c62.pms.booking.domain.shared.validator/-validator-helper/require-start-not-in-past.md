//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.shared.validator](../index.md)/[ValidatorHelper](index.md)/[requireStartNotInPast](require-start-not-in-past.md)

# requireStartNotInPast

[java]\
open fun [requireStartNotInPast](require-start-not-in-past.md)(startDate: [LocalDate](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/time/LocalDate.html))

Validates that the start date is not in the past relative to the current system date.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-16

#### Parameters

java

| | |
|---|---|
| startDate | the start date to validate; must not be `null` |

#### Throws

| | |
|---|---|
| [IllegalArgumentException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalArgumentException.html) | if `startDate` is before today |