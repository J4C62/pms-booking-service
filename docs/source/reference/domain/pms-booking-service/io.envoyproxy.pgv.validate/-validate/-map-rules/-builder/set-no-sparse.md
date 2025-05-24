//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[MapRules](../index.md)/[Builder](index.md)/[setNoSparse](set-no-sparse.md)

# setNoSparse

[java]\
open fun [setNoSparse](set-no-sparse.md)(value: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [Validate.MapRules.Builder](index.md)

```kotlin
NoSparse specifies values in this field cannot be unset. This only
applies to map's with message value types.

```
`optional bool no_sparse = 3;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The noSparse to set. |