//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[StringRules](../index.md)/[Builder](index.md)/[setMaxLen](set-max-len.md)

# setMaxLen

[java]\
open fun [setMaxLen](set-max-len.md)(value: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)): [Validate.StringRules.Builder](index.md)

```kotlin
MaxLen specifies that this field must be the specified number of
characters (Unicode code points) at a maximum. Note that the number of
characters may differ from the number of bytes in the string.

```
`optional uint64 max_len = 3;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The maxLen to set. |