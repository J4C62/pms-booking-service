//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[MapRules](../index.md)/[Builder](index.md)/[mergeValues](merge-values.md)

# mergeValues

[java]\
open fun [mergeValues](merge-values.md)(value: [Validate.FieldRules](../../-field-rules/index.md)): [Validate.MapRules.Builder](index.md)

```kotlin
Values specifies the constraints to be applied to the value of each key
in the field. Message values will still have their validations evaluated
unless skip is specified here.

```
`optional .validate.FieldRules values = 5;`