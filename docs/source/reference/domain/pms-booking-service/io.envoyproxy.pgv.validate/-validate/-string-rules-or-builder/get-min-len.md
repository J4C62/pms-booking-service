//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[StringRulesOrBuilder](index.md)/[getMinLen](get-min-len.md)

# getMinLen

[java]\
abstract fun [getMinLen](get-min-len.md)(): [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)

```kotlin
MinLen specifies that this field must be the specified number of
characters (Unicode code points) at a minimum. Note that the number of
characters may differ from the number of bytes in the string.

```
`optional uint64 min_len = 2;`

#### Return

The minLen.