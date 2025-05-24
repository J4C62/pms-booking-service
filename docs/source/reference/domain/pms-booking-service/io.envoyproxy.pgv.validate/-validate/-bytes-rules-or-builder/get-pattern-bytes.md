//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[BytesRulesOrBuilder](index.md)/[getPatternBytes](get-pattern-bytes.md)

# getPatternBytes

[java]\
abstract fun [getPatternBytes](get-pattern-bytes.md)(): ByteString

```kotlin
Pattern specifies that this field must match against the specified
regular expression (RE2 syntax). The included expression should elide
any delimiters.

```
`optional string pattern = 4;`

#### Return

The bytes for pattern.