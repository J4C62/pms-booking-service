//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[BytesRules](../index.md)/[Builder](index.md)/[setPatternBytes](set-pattern-bytes.md)

# setPatternBytes

[java]\
open fun [setPatternBytes](set-pattern-bytes.md)(value: ByteString): [Validate.BytesRules.Builder](index.md)

```kotlin
Pattern specifies that this field must match against the specified
regular expression (RE2 syntax). The included expression should elide
any delimiters.

```
`optional string pattern = 4;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The bytes for pattern to set. |