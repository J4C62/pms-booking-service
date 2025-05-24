//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[StringRulesOrBuilder](index.md)/[hasPattern](has-pattern.md)

# hasPattern

[java]\
abstract fun [hasPattern](has-pattern.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

```kotlin
Pattern specifies that this field must match against the specified
regular expression (RE2 syntax). The included expression should elide
any delimiters.

```
`optional string pattern = 6;`

#### Return

Whether the pattern field is set.