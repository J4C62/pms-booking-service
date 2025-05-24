//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[StringRules](../index.md)/[Builder](index.md)/[setHostname](set-hostname.md)

# setHostname

[java]\
open fun [setHostname](set-hostname.md)(value: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [Validate.StringRules.Builder](index.md)

```kotlin
Hostname specifies that the field must be a valid hostname as
defined by RFC 1034. This constraint does not support
internationalized domain names (IDNs).

```
`bool hostname = 13;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The hostname to set. |