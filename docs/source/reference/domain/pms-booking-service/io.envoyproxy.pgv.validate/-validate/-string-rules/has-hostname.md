//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[StringRules](index.md)/[hasHostname](has-hostname.md)

# hasHostname

[java]\
open fun [hasHostname](has-hostname.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

```kotlin
Hostname specifies that the field must be a valid hostname as
defined by RFC 1034. This constraint does not support
internationalized domain names (IDNs).

```
`bool hostname = 13;`

#### Return

Whether the hostname field is set.