//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[KnownRegex](index.md)

# KnownRegex

[java]\
enum [KnownRegex](index.md) : ProtocolMessageEnum```kotlin
WellKnownRegex contain some well-known patterns.

```
 Protobuf enum `validate.KnownRegex`

## Entries

| | |
|---|---|
| [UNKNOWN](-u-n-k-n-o-w-n/index.md) | [java]<br>[UNKNOWN](-u-n-k-n-o-w-n/index.md)<br>`UNKNOWN = 0;` |
| [HTTP_HEADER_NAME](-h-t-t-p_-h-e-a-d-e-r_-n-a-m-e/index.md) | [java]<br>[HTTP_HEADER_NAME](-h-t-t-p_-h-e-a-d-e-r_-n-a-m-e/index.md) |
| [HTTP_HEADER_VALUE](-h-t-t-p_-h-e-a-d-e-r_-v-a-l-u-e/index.md) | [java]<br>[HTTP_HEADER_VALUE](-h-t-t-p_-h-e-a-d-e-r_-v-a-l-u-e/index.md) |

## Properties

| Name | Summary |
|---|---|
| [HTTP_HEADER_NAME_VALUE](-h-t-t-p_-h-e-a-d-e-r_-n-a-m-e_-v-a-l-u-e.md) | [java]<br>val [HTTP_HEADER_NAME_VALUE](-h-t-t-p_-h-e-a-d-e-r_-n-a-m-e_-v-a-l-u-e.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 1<br>```kotlin HTTP header name as defined by RFC 7230.<br>``` `HTTP_HEADER_NAME = 1;` |
| [HTTP_HEADER_VALUE_VALUE](-h-t-t-p_-h-e-a-d-e-r_-v-a-l-u-e_-v-a-l-u-e.md) | [java]<br>val [HTTP_HEADER_VALUE_VALUE](-h-t-t-p_-h-e-a-d-e-r_-v-a-l-u-e_-v-a-l-u-e.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 2<br>```kotlin HTTP header value as defined by RFC 7230.<br>``` `HTTP_HEADER_VALUE = 2;` |
| [UNKNOWN_VALUE](-u-n-k-n-o-w-n_-v-a-l-u-e.md) | [java]<br>val [UNKNOWN_VALUE](-u-n-k-n-o-w-n_-v-a-l-u-e.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0<br>`UNKNOWN = 0;` |

## Functions

| Name | Summary |
|---|---|
| [forNumber](for-number.md) | [java]<br>open fun [forNumber](for-number.md)(value: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Validate.KnownRegex](index.md) |
| [getDescriptor](get-descriptor.md) | [java]<br>fun [getDescriptor](get-descriptor.md)(): Descriptors.EnumDescriptor |
| [getDescriptorForType](get-descriptor-for-type.md) | [java]<br>fun [getDescriptorForType](get-descriptor-for-type.md)(): Descriptors.EnumDescriptor |
| [getNumber](get-number.md) | [java]<br>fun [getNumber](get-number.md)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [getValueDescriptor](get-value-descriptor.md) | [java]<br>fun [getValueDescriptor](get-value-descriptor.md)(): Descriptors.EnumValueDescriptor |
| [internalGetValueMap](internal-get-value-map.md) | [java]<br>open fun [internalGetValueMap](internal-get-value-map.md)(): Internal.EnumLiteMap&lt;[Validate.KnownRegex](index.md)&gt; |
| [valueOf](value-of.md) | [java]<br>open fun [valueOf](value-of.md)(desc: Descriptors.EnumValueDescriptor): [Validate.KnownRegex](index.md)<br>open fun [~~valueOf~~](value-of.md)(value: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Validate.KnownRegex](index.md)<br>[java]<br>open fun [valueOf](value-of.md)(name: [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html)): [Validate.KnownRegex](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [java]<br>open fun [values](values.md)(): [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[Validate.KnownRegex](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. This method may be used to iterate over the constants. |