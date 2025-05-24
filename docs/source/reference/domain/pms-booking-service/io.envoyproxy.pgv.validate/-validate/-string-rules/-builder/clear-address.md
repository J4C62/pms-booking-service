//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[StringRules](../index.md)/[Builder](index.md)/[clearAddress](clear-address.md)

# clearAddress

[java]\
open fun [clearAddress](clear-address.md)(): [Validate.StringRules.Builder](index.md)

```kotlin
Address specifies that the field must be either a valid hostname as
defined by RFC 1034 (which does not support internationalized domain
names or IDNs), or it can be a valid IP (v4 or v6).

```
`bool address = 21;`

#### Return

This builder for chaining.