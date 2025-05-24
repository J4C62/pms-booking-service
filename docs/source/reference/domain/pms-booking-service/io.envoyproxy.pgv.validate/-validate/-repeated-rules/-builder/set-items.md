//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[RepeatedRules](../index.md)/[Builder](index.md)/[setItems](set-items.md)

# setItems

[java]\
open fun [setItems](set-items.md)(value: [Validate.FieldRules](../../-field-rules/index.md)): [Validate.RepeatedRules.Builder](index.md)

open fun [setItems](set-items.md)(builderForValue: [Validate.FieldRules.Builder](../../-field-rules/-builder/index.md)): [Validate.RepeatedRules.Builder](index.md)

```kotlin
Items specifies the constraints to be applied to each item in the field.
Repeated message fields will still execute validation against each item
unless skip is specified here.

```
`optional .validate.FieldRules items = 4;`