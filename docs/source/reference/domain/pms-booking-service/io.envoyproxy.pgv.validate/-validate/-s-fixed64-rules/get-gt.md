//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[SFixed64Rules](index.md)/[getGt](get-gt.md)

# getGt

[java]\
open fun [getGt](get-gt.md)(): [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)

```kotlin
Gt specifies that this field must be greater than the specified value,
exclusive. If the value of Gt is larger than a specified Lt or Lte, the
range is reversed.

```
`optional sfixed64 gt = 4;`

#### Return

The gt.