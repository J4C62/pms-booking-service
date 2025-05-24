//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[SInt64Rules](../index.md)/[Builder](index.md)/[setGt](set-gt.md)

# setGt

[java]\
open fun [setGt](set-gt.md)(value: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)): [Validate.SInt64Rules.Builder](index.md)

```kotlin
Gt specifies that this field must be greater than the specified value,
exclusive. If the value of Gt is larger than a specified Lt or Lte, the
range is reversed.

```
`optional sint64 gt = 4;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The gt to set. |