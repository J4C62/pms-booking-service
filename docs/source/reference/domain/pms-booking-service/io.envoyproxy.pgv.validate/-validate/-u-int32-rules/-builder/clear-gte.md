//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[UInt32Rules](../index.md)/[Builder](index.md)/[clearGte](clear-gte.md)

# clearGte

[java]\
open fun [clearGte](clear-gte.md)(): [Validate.UInt32Rules.Builder](index.md)

```kotlin
Gte specifies that this field must be greater than or equal to the
specified value, inclusive. If the value of Gte is larger than a
specified Lt or Lte, the range is reversed.

```
`optional uint32 gte = 5;`

#### Return

This builder for chaining.