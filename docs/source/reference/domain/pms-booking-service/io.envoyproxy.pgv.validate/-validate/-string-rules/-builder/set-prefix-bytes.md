//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[StringRules](../index.md)/[Builder](index.md)/[setPrefixBytes](set-prefix-bytes.md)

# setPrefixBytes

[java]\
open fun [setPrefixBytes](set-prefix-bytes.md)(value: ByteString): [Validate.StringRules.Builder](index.md)

```kotlin
Prefix specifies that this field must have the specified substring at
the beginning of the string.

```
`optional string prefix = 7;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The bytes for prefix to set. |