//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[AnyRulesOrBuilder](index.md)/[getNotInBytes](get-not-in-bytes.md)

# getNotInBytes

[java]\
abstract fun [getNotInBytes](get-not-in-bytes.md)(index: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): ByteString

```kotlin
NotIn specifies that this field's `type_url` must not be equal to any of
the specified values.

```
`repeated string not_in = 3;`

#### Return

The bytes of the notIn at the given index.

#### Parameters

java

| | |
|---|---|
| index | The index of the value to return. |