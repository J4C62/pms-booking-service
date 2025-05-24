//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[RepeatedRules](../index.md)/[Builder](index.md)/[getItemsBuilder](get-items-builder.md)

# getItemsBuilder

[java]\
open fun [getItemsBuilder](get-items-builder.md)(): [Validate.FieldRules.Builder](../../-field-rules/-builder/index.md)

```kotlin
Items specifies the constraints to be applied to each item in the field.
Repeated message fields will still execute validation against each item
unless skip is specified here.

```
`optional .validate.FieldRules items = 4;`