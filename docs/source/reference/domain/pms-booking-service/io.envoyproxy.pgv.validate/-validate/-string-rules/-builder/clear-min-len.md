//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[StringRules](../index.md)/[Builder](index.md)/[clearMinLen](clear-min-len.md)

# clearMinLen

[java]\
open fun [clearMinLen](clear-min-len.md)(): [Validate.StringRules.Builder](index.md)

```kotlin
MinLen specifies that this field must be the specified number of
characters (Unicode code points) at a minimum. Note that the number of
characters may differ from the number of bytes in the string.

```
`optional uint64 min_len = 2;`

#### Return

This builder for chaining.