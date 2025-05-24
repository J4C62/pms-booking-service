//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[StringRules](../index.md)/[Builder](index.md)/[setNotContainsBytes](set-not-contains-bytes.md)

# setNotContainsBytes

[java]\
open fun [setNotContainsBytes](set-not-contains-bytes.md)(value: ByteString): [Validate.StringRules.Builder](index.md)

```kotlin
NotContains specifies that this field cannot have the specified substring
anywhere in the string.

```
`optional string not_contains = 23;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The bytes for notContains to set. |