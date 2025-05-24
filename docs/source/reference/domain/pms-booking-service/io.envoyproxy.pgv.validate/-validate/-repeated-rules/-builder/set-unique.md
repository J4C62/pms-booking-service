//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[RepeatedRules](../index.md)/[Builder](index.md)/[setUnique](set-unique.md)

# setUnique

[java]\
open fun [setUnique](set-unique.md)(value: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [Validate.RepeatedRules.Builder](index.md)

```kotlin
Unique specifies that all elements in this field must be unique. This
constraint is only applicable to scalar and enum types (messages are not
supported).

```
`optional bool unique = 3;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The unique to set. |