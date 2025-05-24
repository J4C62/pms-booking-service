//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[FloatRules](../index.md)/[Builder](index.md)/[setGte](set-gte.md)

# setGte

[java]\
open fun [setGte](set-gte.md)(value: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)): [Validate.FloatRules.Builder](index.md)

```kotlin
Gte specifies that this field must be greater than or equal to the
specified value, inclusive. If the value of Gte is larger than a
specified Lt or Lte, the range is reversed.

```
`optional float gte = 5;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The gte to set. |