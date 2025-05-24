//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[SFixed64Rules](../index.md)/[Builder](index.md)/[setNotIn](set-not-in.md)

# setNotIn

[java]\
open fun [setNotIn](set-not-in.md)(index: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), value: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)): [Validate.SFixed64Rules.Builder](index.md)

```kotlin
NotIn specifies that this field cannot be equal to one of the specified
values

```
`repeated sfixed64 not_in = 7;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| index | The index to set the value at. |
| value | The notIn to set. |