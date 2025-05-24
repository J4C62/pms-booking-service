//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[DoubleRules](../index.md)/[Builder](index.md)/[setGt](set-gt.md)

# setGt

[java]\
open fun [setGt](set-gt.md)(value: [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html)): [Validate.DoubleRules.Builder](index.md)

```kotlin
Gt specifies that this field must be greater than the specified value,
exclusive. If the value of Gt is larger than a specified Lt or Lte, the
range is reversed.

```
`optional double gt = 4;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The gt to set. |