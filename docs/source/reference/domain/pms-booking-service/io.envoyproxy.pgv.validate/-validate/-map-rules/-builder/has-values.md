//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[MapRules](../index.md)/[Builder](index.md)/[hasValues](has-values.md)

# hasValues

[java]\
open fun [hasValues](has-values.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

```kotlin
Values specifies the constraints to be applied to the value of each key
in the field. Message values will still have their validations evaluated
unless skip is specified here.

```
`optional .validate.FieldRules values = 5;`

#### Return

Whether the values field is set.