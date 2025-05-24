//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[StringRules](../index.md)/[Builder](index.md)/[clearMaxLen](clear-max-len.md)

# clearMaxLen

[java]\
open fun [clearMaxLen](clear-max-len.md)(): [Validate.StringRules.Builder](index.md)

```kotlin
MaxLen specifies that this field must be the specified number of
characters (Unicode code points) at a maximum. Note that the number of
characters may differ from the number of bytes in the string.

```
`optional uint64 max_len = 3;`

#### Return

This builder for chaining.