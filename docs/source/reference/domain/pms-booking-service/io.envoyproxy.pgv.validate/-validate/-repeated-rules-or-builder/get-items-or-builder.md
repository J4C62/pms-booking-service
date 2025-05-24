//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[RepeatedRulesOrBuilder](index.md)/[getItemsOrBuilder](get-items-or-builder.md)

# getItemsOrBuilder

[java]\
abstract fun [getItemsOrBuilder](get-items-or-builder.md)(): [Validate.FieldRulesOrBuilder](../-field-rules-or-builder/index.md)

```kotlin
Items specifies the constraints to be applied to each item in the field.
Repeated message fields will still execute validation against each item
unless skip is specified here.

```
`optional .validate.FieldRules items = 4;`