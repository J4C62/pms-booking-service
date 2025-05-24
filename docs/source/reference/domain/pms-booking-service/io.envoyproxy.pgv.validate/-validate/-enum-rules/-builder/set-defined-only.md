//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[EnumRules](../index.md)/[Builder](index.md)/[setDefinedOnly](set-defined-only.md)

# setDefinedOnly

[java]\
open fun [setDefinedOnly](set-defined-only.md)(value: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [Validate.EnumRules.Builder](index.md)

```kotlin
DefinedOnly specifies that this field must be only one of the defined
values for this enum, failing on any undefined value.

```
`optional bool defined_only = 2;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| value | The definedOnly to set. |