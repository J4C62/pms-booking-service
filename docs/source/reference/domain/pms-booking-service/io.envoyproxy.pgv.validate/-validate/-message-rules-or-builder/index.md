//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[MessageRulesOrBuilder](index.md)

# MessageRulesOrBuilder

interface [MessageRulesOrBuilder](index.md) : MessageOrBuilder

#### Inheritors

| |
|---|
| [MessageRules](../-message-rules/index.md) |
| [Builder](../-message-rules/-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [findInitializationErrors](../-timestamp-rules-or-builder/index.md#1227463831%2FFunctions%2F-1170581573) | [java]<br>abstract fun [findInitializationErrors](../-timestamp-rules-or-builder/index.md#1227463831%2FFunctions%2F-1170581573)(): [List](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/List.html)&lt;[String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html)&gt; |
| [getAllFields](../-timestamp-rules-or-builder/index.md#-1735213033%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getAllFields](../-timestamp-rules-or-builder/index.md#-1735213033%2FFunctions%2F-1170581573)(): [Map](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/Map.html)&lt;Descriptors.FieldDescriptor, [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; |
| [getDefaultInstanceForType](../-timestamp-rules/-builder/index.md#-889905270%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getDefaultInstanceForType](../-timestamp-rules/-builder/index.md#-889905270%2FFunctions%2F-1170581573)(): MessageLite<br>abstract fun [getDefaultInstanceForType](../-timestamp-rules-or-builder/index.md#1172508988%2FFunctions%2F-1170581573)(): Message |
| [getDescriptorForType](../-timestamp-rules-or-builder/index.md#-2023656483%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getDescriptorForType](../-timestamp-rules-or-builder/index.md#-2023656483%2FFunctions%2F-1170581573)(): Descriptors.Descriptor |
| [getField](../-timestamp-rules-or-builder/index.md#-728711289%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getField](../-timestamp-rules-or-builder/index.md#-728711289%2FFunctions%2F-1170581573)(field: Descriptors.FieldDescriptor): [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html) |
| [getInitializationErrorString](../-timestamp-rules-or-builder/index.md#-106143432%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getInitializationErrorString](../-timestamp-rules-or-builder/index.md#-106143432%2FFunctions%2F-1170581573)(): [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html) |
| [getOneofFieldDescriptor](../-timestamp-rules-or-builder/index.md#1767160798%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getOneofFieldDescriptor](../-timestamp-rules-or-builder/index.md#1767160798%2FFunctions%2F-1170581573)(oneof: Descriptors.OneofDescriptor): Descriptors.FieldDescriptor |
| [getRepeatedField](../-timestamp-rules-or-builder/index.md#1425494465%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getRepeatedField](../-timestamp-rules-or-builder/index.md#1425494465%2FFunctions%2F-1170581573)(field: Descriptors.FieldDescriptor, index: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html) |
| [getRepeatedFieldCount](../-timestamp-rules-or-builder/index.md#-950528252%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getRepeatedFieldCount](../-timestamp-rules-or-builder/index.md#-950528252%2FFunctions%2F-1170581573)(field: Descriptors.FieldDescriptor): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [getRequired](get-required.md) | [java]<br>abstract fun [getRequired](get-required.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>```kotlin Required specifies that this field must be set<br>``` `optional bool required = 2;` |
| [getSkip](get-skip.md) | [java]<br>abstract fun [getSkip](get-skip.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>```kotlin Skip specifies that the validation rules of this field should not be evaluated<br>``` `optional bool skip = 1;` |
| [getUnknownFields](../-timestamp-rules-or-builder/index.md#-1388384690%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getUnknownFields](../-timestamp-rules-or-builder/index.md#-1388384690%2FFunctions%2F-1170581573)(): UnknownFieldSet |
| [hasField](../-timestamp-rules-or-builder/index.md#2095008451%2FFunctions%2F-1170581573) | [java]<br>abstract fun [hasField](../-timestamp-rules-or-builder/index.md#2095008451%2FFunctions%2F-1170581573)(field: Descriptors.FieldDescriptor): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [hasOneof](../-timestamp-rules-or-builder/index.md#687391779%2FFunctions%2F-1170581573) | [java]<br>abstract fun [hasOneof](../-timestamp-rules-or-builder/index.md#687391779%2FFunctions%2F-1170581573)(oneof: Descriptors.OneofDescriptor): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [hasRequired](has-required.md) | [java]<br>abstract fun [hasRequired](has-required.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>```kotlin Required specifies that this field must be set<br>``` `optional bool required = 2;` |
| [hasSkip](has-skip.md) | [java]<br>abstract fun [hasSkip](has-skip.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>```kotlin Skip specifies that the validation rules of this field should not be evaluated<br>``` `optional bool skip = 1;` |
| [isInitialized](../-timestamp-rules-or-builder/index.md#-786502173%2FFunctions%2F-1170581573) | [java]<br>abstract fun [isInitialized](../-timestamp-rules-or-builder/index.md#-786502173%2FFunctions%2F-1170581573)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |