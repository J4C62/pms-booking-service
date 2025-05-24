//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[DoubleRules](../index.md)/[Builder](index.md)/[setNotIn](set-not-in.md)

# setNotIn

[java]\
open fun [setNotIn](set-not-in.md)(index: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), value: [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html)): [Validate.DoubleRules.Builder](index.md)

```kotlin
NotIn specifies that this field cannot be equal to one of the specified
values

```
`repeated double not_in = 7;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| index | The index to set the value at. |
| value | The notIn to set. |