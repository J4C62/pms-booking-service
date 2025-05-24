//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[StringRules](index.md)/[getMaxLen](get-max-len.md)

# getMaxLen

[java]\
open fun [getMaxLen](get-max-len.md)(): [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)

```kotlin
MaxLen specifies that this field must be the specified number of
characters (Unicode code points) at a maximum. Note that the number of
characters may differ from the number of bytes in the string.

```
`optional uint64 max_len = 3;`

#### Return

The maxLen.