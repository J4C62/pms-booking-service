//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[StringRulesOrBuilder](index.md)/[hasAddress](has-address.md)

# hasAddress

[java]\
abstract fun [hasAddress](has-address.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

```kotlin
Address specifies that the field must be either a valid hostname as
defined by RFC 1034 (which does not support internationalized domain
names or IDNs), or it can be a valid IP (v4 or v6).

```
`bool address = 21;`

#### Return

Whether the address field is set.