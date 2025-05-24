//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.domain.shared.validator](../index.md)/[ValidatorHelper](index.md)

# ValidatorHelper

[java]\
class [ValidatorHelper](index.md)

Utility class providing domain-specific validation methods for booking date constraints. 

This class enforces invariants related to `LocalDate` usage within booking operations, such as ensuring start dates are not in the past and that they precede end dates. 

This is a static utility class and cannot be instantiated.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-16

## Functions

| Name | Summary |
|---|---|
| [requireStartBeforeEnd](require-start-before-end.md) | [java]<br>open fun [requireStartBeforeEnd](require-start-before-end.md)(startDate: [LocalDate](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/time/LocalDate.html), endDate: [LocalDate](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/time/LocalDate.html))<br>Validates that the start date is before or equal to the end date. |
| [requireStartNotInPast](require-start-not-in-past.md) | [java]<br>open fun [requireStartNotInPast](require-start-not-in-past.md)(startDate: [LocalDate](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/time/LocalDate.html))<br>Validates that the start date is not in the past relative to the current system date. |