//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[TimestampRules](../index.md)/[Builder](index.md)/[setWithin](set-within.md)

# setWithin

[java]\
open fun [setWithin](set-within.md)(value: Duration): [Validate.TimestampRules.Builder](index.md)

open fun [setWithin](set-within.md)(builderForValue: Duration.Builder): [Validate.TimestampRules.Builder](index.md)

```kotlin
Within specifies that this field must be within this duration of the
current time. This constraint can be used alone or with the LtNow and
GtNow rules.

```
`optional .google.protobuf.Duration within = 9;`