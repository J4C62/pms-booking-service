//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[TimestampRules](../index.md)/[Builder](index.md)/[clearLtNow](clear-lt-now.md)

# clearLtNow

[java]\
open fun [clearLtNow](clear-lt-now.md)(): [Validate.TimestampRules.Builder](index.md)

```kotlin
LtNow specifies that this must be less than the current time. LtNow
can only be used with the Within rule.

```
`optional bool lt_now = 7;`

#### Return

This builder for chaining.