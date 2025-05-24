//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[BytesRules](../index.md)/[Builder](index.md)/[setPrefix](set-prefix.md)

# setPrefix

[java]\
open fun [setPrefix](set-prefix.md)(value: ByteString): [Validate.BytesRules.Builder](index.md)

```kotlin
Prefix specifies that this field must have the specified bytes at the
beginning of the string.

```
`optional bytes prefix = 5;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The prefix to set. |