//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[StringRules](../index.md)/[Builder](index.md)/[setAddress](set-address.md)

# setAddress

[java]\
open fun [setAddress](set-address.md)(value: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [Validate.StringRules.Builder](index.md)

```kotlin
Address specifies that the field must be either a valid hostname as
defined by RFC 1034 (which does not support internationalized domain
names or IDNs), or it can be a valid IP (v4 or v6).

```
`bool address = 21;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The address to set. |