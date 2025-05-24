//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.shared.validator](../index.md)/[ValidatorHelper](index.md)/[requireStartBeforeEnd](require-start-before-end.md)

# requireStartBeforeEnd

[java]\
open fun [requireStartBeforeEnd](require-start-before-end.md)(startDate: [LocalDate](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/time/LocalDate.html), endDate: [LocalDate](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/time/LocalDate.html))

Validates that the start date is before or equal to the end date.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-16

#### Parameters

java

| | |
|---|---|
| startDate | the start date to validate; must not be `null` |
| endDate | the end date to validate; must not be `null` |

#### Throws

| | |
|---|---|
| [IllegalArgumentException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalArgumentException.html) | if `startDate` is after `endDate` |