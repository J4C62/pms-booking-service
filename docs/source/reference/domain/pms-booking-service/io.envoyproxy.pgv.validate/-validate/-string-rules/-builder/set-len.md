//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[StringRules](../index.md)/[Builder](index.md)/[setLen](set-len.md)

# setLen

[java]\
open fun [setLen](set-len.md)(value: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)): [Validate.StringRules.Builder](index.md)

```kotlin
Len specifies that this field must be the specified number of
characters (Unicode code points). Note that the number of
characters may differ from the number of bytes in the string.

```
`optional uint64 len = 19;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The len to set. |