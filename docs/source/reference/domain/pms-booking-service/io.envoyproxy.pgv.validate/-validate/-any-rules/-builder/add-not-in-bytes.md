//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[AnyRules](../index.md)/[Builder](index.md)/[addNotInBytes](add-not-in-bytes.md)

# addNotInBytes

[java]\
open fun [addNotInBytes](add-not-in-bytes.md)(value: ByteString): [Validate.AnyRules.Builder](index.md)

```kotlin
NotIn specifies that this field's `type_url` must not be equal to any of
the specified values.

```
`repeated string not_in = 3;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The bytes of the notIn to add. |