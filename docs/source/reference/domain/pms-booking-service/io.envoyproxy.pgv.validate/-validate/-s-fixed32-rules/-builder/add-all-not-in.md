//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[SFixed32Rules](../index.md)/[Builder](index.md)/[addAllNotIn](add-all-not-in.md)

# addAllNotIn

[java]\
open fun [addAllNotIn](add-all-not-in.md)(values: [Iterable](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Iterable.html)&lt;out [Integer](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Integer.html)&gt;): [Validate.SFixed32Rules.Builder](index.md)

```kotlin
NotIn specifies that this field cannot be equal to one of the specified
values

```
`repeated sfixed32 not_in = 7;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| values | The notIn to add. |