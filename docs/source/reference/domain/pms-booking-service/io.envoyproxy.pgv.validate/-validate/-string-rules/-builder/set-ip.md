//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[StringRules](../index.md)/[Builder](index.md)/[setIp](set-ip.md)

# setIp

[java]\
open fun [setIp](set-ip.md)(value: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [Validate.StringRules.Builder](index.md)

```kotlin
Ip specifies that the field must be a valid IP (v4 or v6) address.
Valid IPv6 addresses should not include surrounding square brackets.

```
`bool ip = 14;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The ip to set. |