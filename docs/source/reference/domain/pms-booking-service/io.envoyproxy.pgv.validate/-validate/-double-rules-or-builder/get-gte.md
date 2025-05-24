//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[DoubleRulesOrBuilder](index.md)/[getGte](get-gte.md)

# getGte

[java]\
abstract fun [getGte](get-gte.md)(): [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html)

```kotlin
Gte specifies that this field must be greater than or equal to the
specified value, inclusive. If the value of Gte is larger than a
specified Lt or Lte, the range is reversed.

```
`optional double gte = 5;`

#### Return

The gte.