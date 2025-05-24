//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[UInt32Rules](../index.md)/[Builder](index.md)/[getGte](get-gte.md)

# getGte

[java]\
open fun [getGte](get-gte.md)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)

```kotlin
Gte specifies that this field must be greater than or equal to the
specified value, inclusive. If the value of Gte is larger than a
specified Lt or Lte, the range is reversed.

```
`optional uint32 gte = 5;`

#### Return

The gte.