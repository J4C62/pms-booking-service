//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[StringRules](../index.md)/[Builder](index.md)/[setMinLen](set-min-len.md)

# setMinLen

[java]\
open fun [setMinLen](set-min-len.md)(value: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)): [Validate.StringRules.Builder](index.md)

```kotlin
MinLen specifies that this field must be the specified number of
characters (Unicode code points) at a minimum. Note that the number of
characters may differ from the number of bytes in the string.

```
`optional uint64 min_len = 2;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The minLen to set. |