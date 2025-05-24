//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[Int32Rules](../index.md)/[Builder](index.md)/[setGte](set-gte.md)

# setGte

[java]\
open fun [setGte](set-gte.md)(value: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Validate.Int32Rules.Builder](index.md)

```kotlin
Gte specifies that this field must be greater than or equal to the
specified value, inclusive. If the value of Gte is larger than a
specified Lt or Lte, the range is reversed.

```
`optional int32 gte = 5;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The gte to set. |