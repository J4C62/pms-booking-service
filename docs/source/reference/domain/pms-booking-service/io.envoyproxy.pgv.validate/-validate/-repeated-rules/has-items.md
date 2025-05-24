//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[RepeatedRules](index.md)/[hasItems](has-items.md)

# hasItems

[java]\
open fun [hasItems](has-items.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

```kotlin
Items specifies the constraints to be applied to each item in the field.
Repeated message fields will still execute validation against each item
unless skip is specified here.

```
`optional .validate.FieldRules items = 4;`

#### Return

Whether the items field is set.