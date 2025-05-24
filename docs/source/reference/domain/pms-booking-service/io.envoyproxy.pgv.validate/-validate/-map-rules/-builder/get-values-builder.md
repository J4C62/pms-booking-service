//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[MapRules](../index.md)/[Builder](index.md)/[getValuesBuilder](get-values-builder.md)

# getValuesBuilder

[java]\
open fun [getValuesBuilder](get-values-builder.md)(): [Validate.FieldRules.Builder](../../-field-rules/-builder/index.md)

```kotlin
Values specifies the constraints to be applied to the value of each key
in the field. Message values will still have their validations evaluated
unless skip is specified here.

```
`optional .validate.FieldRules values = 5;`