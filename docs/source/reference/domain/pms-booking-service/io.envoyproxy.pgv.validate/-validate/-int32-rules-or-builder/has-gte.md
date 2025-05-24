//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[Int32RulesOrBuilder](index.md)/[hasGte](has-gte.md)

# hasGte

[java]\
abstract fun [hasGte](has-gte.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

```kotlin
Gte specifies that this field must be greater than or equal to the
specified value, inclusive. If the value of Gte is larger than a
specified Lt or Lte, the range is reversed.

```
`optional int32 gte = 5;`

#### Return

Whether the gte field is set.