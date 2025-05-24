//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[DurationRules](../index.md)/[Builder](index.md)/[addNotIn](add-not-in.md)

# addNotIn

[java]\
open fun [addNotIn](add-not-in.md)(value: Duration): [Validate.DurationRules.Builder](index.md)

open fun [addNotIn](add-not-in.md)(index: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), value: Duration): [Validate.DurationRules.Builder](index.md)

open fun [addNotIn](add-not-in.md)(builderForValue: Duration.Builder): [Validate.DurationRules.Builder](index.md)

open fun [addNotIn](add-not-in.md)(index: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), builderForValue: Duration.Builder): [Validate.DurationRules.Builder](index.md)

```kotlin
NotIn specifies that this field cannot be equal to one of the specified
values

```
`repeated .google.protobuf.Duration not_in = 8;`