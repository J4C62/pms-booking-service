//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[StringRules](../index.md)/[Builder](index.md)/[addAllNotIn](add-all-not-in.md)

# addAllNotIn

[java]\
open fun [addAllNotIn](add-all-not-in.md)(values: [Iterable](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Iterable.html)&lt;[String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html)&gt;): [Validate.StringRules.Builder](index.md)

```kotlin
NotIn specifies that this field cannot be equal to one of the specified
values

```
`repeated string not_in = 11;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| values | The notIn to add. |