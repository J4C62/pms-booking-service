//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[StringRulesOrBuilder](index.md)/[hasStrict](has-strict.md)

# hasStrict

[java]\
abstract fun [hasStrict](has-strict.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

```kotlin
This applies to regexes HTTP_HEADER_NAME and HTTP_HEADER_VALUE to enable
strict header validation.
By default, this is true, and HTTP header validations are RFC-compliant.
Setting to false will enable a looser validations that only disallows
\r\n\0 characters, which can be used to bypass header matching rules.

```
`optional bool strict = 25 [default = true];`

#### Return

Whether the strict field is set.