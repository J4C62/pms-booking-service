//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[SFixed64Rules](../index.md)/[Builder](index.md)/[clearGt](clear-gt.md)

# clearGt

[java]\
open fun [clearGt](clear-gt.md)(): [Validate.SFixed64Rules.Builder](index.md)

```kotlin
Gt specifies that this field must be greater than the specified value,
exclusive. If the value of Gt is larger than a specified Lt or Lte, the
range is reversed.

```
`optional sfixed64 gt = 4;`

#### Return

This builder for chaining.