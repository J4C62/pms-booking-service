//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[MapRulesOrBuilder](index.md)/[getValues](get-values.md)

# getValues

[java]\
abstract fun [getValues](get-values.md)(): [Validate.FieldRules](../-field-rules/index.md)

```kotlin
Values specifies the constraints to be applied to the value of each key
in the field. Message values will still have their validations evaluated
unless skip is specified here.

```
`optional .validate.FieldRules values = 5;`

#### Return

The values.