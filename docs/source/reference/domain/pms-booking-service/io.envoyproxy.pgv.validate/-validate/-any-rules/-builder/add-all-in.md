//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[AnyRules](../index.md)/[Builder](index.md)/[addAllIn](add-all-in.md)

# addAllIn

[java]\
open fun [addAllIn](add-all-in.md)(values: [Iterable](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Iterable.html)&lt;[String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html)&gt;): [Validate.AnyRules.Builder](index.md)

```kotlin
In specifies that this field's `type_url` must be equal to one of the
specified values.

```
`repeated string in = 2;`

#### Return

This builder for chaining.

#### Parameters

java

| | |
|---|---|
| values | The in to add. |