//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[SInt32Rules](index.md)/[hasGte](has-gte.md)

# hasGte

[java]\
open fun [hasGte](has-gte.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

```kotlin
Gte specifies that this field must be greater than or equal to the
specified value, inclusive. If the value of Gte is larger than a
specified Lt or Lte, the range is reversed.

```
`optional sint32 gte = 5;`

#### Return

Whether the gte field is set.