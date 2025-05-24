//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[TimestampRulesOrBuilder](index.md)/[hasWithin](has-within.md)

# hasWithin

[java]\
abstract fun [hasWithin](has-within.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

```kotlin
Within specifies that this field must be within this duration of the
current time. This constraint can be used alone or with the LtNow and
GtNow rules.

```
`optional .google.protobuf.Duration within = 9;`

#### Return

Whether the within field is set.