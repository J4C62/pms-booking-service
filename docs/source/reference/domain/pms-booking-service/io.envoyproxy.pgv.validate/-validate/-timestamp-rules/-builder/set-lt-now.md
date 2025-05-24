//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[TimestampRules](../index.md)/[Builder](index.md)/[setLtNow](set-lt-now.md)

# setLtNow

[java]\
open fun [setLtNow](set-lt-now.md)(value: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [Validate.TimestampRules.Builder](index.md)

```kotlin
LtNow specifies that this must be less than the current time. LtNow
can only be used with the Within rule.

```
`optional bool lt_now = 7;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The ltNow to set. |