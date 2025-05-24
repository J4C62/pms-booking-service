//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[TimestampRules](../index.md)/[Builder](index.md)/[setGtNow](set-gt-now.md)

# setGtNow

[java]\
open fun [setGtNow](set-gt-now.md)(value: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [Validate.TimestampRules.Builder](index.md)

```kotlin
GtNow specifies that this must be greater than the current time. GtNow
can only be used with the Within rule.

```
`optional bool gt_now = 8;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The gtNow to set. |