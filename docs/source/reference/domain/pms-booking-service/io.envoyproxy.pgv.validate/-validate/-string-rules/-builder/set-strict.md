//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[StringRules](../index.md)/[Builder](index.md)/[setStrict](set-strict.md)

# setStrict

[java]\
open fun [setStrict](set-strict.md)(value: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [Validate.StringRules.Builder](index.md)

```kotlin
This applies to regexes HTTP_HEADER_NAME and HTTP_HEADER_VALUE to enable
strict header validation.
By default, this is true, and HTTP header validations are RFC-compliant.
Setting to false will enable a looser validations that only disallows
\r\n\0 characters, which can be used to bypass header matching rules.

```
`optional bool strict = 25 [default = true];`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The strict to set. |