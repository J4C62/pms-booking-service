//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[DurationRules](../index.md)/[Builder](index.md)/[addIn](add-in.md)

# addIn

[java]\
open fun [addIn](add-in.md)(value: Duration): [Validate.DurationRules.Builder](index.md)

open fun [addIn](add-in.md)(index: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), value: Duration): [Validate.DurationRules.Builder](index.md)

open fun [addIn](add-in.md)(builderForValue: Duration.Builder): [Validate.DurationRules.Builder](index.md)

open fun [addIn](add-in.md)(index: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), builderForValue: Duration.Builder): [Validate.DurationRules.Builder](index.md)

```kotlin
In specifies that this field must be equal to one of the specified
values

```
`repeated .google.protobuf.Duration in = 7;`