//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[AnyRules](../index.md)/[Builder](index.md)/[setIn](set-in.md)

# setIn

[java]\
open fun [setIn](set-in.md)(index: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), value: [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html)): [Validate.AnyRules.Builder](index.md)

```kotlin
In specifies that this field's `type_url` must be equal to one of the
specified values.

```
`repeated string in = 2;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| index | The index to set the value at. |
| value | The in to set. |