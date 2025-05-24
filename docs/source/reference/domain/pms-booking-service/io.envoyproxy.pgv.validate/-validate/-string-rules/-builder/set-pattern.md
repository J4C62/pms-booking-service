//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[StringRules](../index.md)/[Builder](index.md)/[setPattern](set-pattern.md)

# setPattern

[java]\
open fun [setPattern](set-pattern.md)(value: [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html)): [Validate.StringRules.Builder](index.md)

```kotlin
Pattern specifies that this field must match against the specified
regular expression (RE2 syntax). The included expression should elide
any delimiters.

```
`optional string pattern = 6;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The pattern to set. |