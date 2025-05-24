//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[AnyRules](../index.md)/[Builder](index.md)/[setNotIn](set-not-in.md)

# setNotIn

[java]\
open fun [setNotIn](set-not-in.md)(index: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), value: [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html)): [Validate.AnyRules.Builder](index.md)

```kotlin
NotIn specifies that this field's `type_url` must not be equal to any of
the specified values.

```
`repeated string not_in = 3;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| index | The index to set the value at. |
| value | The notIn to set. |