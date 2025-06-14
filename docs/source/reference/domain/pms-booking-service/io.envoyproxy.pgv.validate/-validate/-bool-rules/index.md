//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[BoolRules](index.md)

# BoolRules

[java]\
class [BoolRules](index.md) : GeneratedMessageV3, [Validate.BoolRulesOrBuilder](../-bool-rules-or-builder/index.md)```kotlin
BoolRules describes the constraints applied to `bool` values

```
 Protobuf type `validate.BoolRules`

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [java]<br>class [Builder](-builder/index.md) : GeneratedMessageV3.Builder&lt;BuilderT&gt; , [Validate.BoolRulesOrBuilder](../-bool-rules-or-builder/index.md)<br>```kotlin BoolRules describes the constraints applied to `bool` values<br>```  Protobuf type `validate.BoolRules` |

## Properties

| Name | Summary |
|---|---|
| [CONST_FIELD_NUMBER](-c-o-n-s-t_-f-i-e-l-d_-n-u-m-b-e-r.md) | [java]<br>val [CONST_FIELD_NUMBER](-c-o-n-s-t_-f-i-e-l-d_-n-u-m-b-e-r.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 1 |
| [PARSER](-p-a-r-s-e-r.md) | [java]<br>val [~~PARSER~~](-p-a-r-s-e-r.md): Parser&lt;[Validate.BoolRules](index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [java]<br>open fun [equals](equals.md)(obj: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [findInitializationErrors](../-timestamp-rules/index.md#-812419917%2FFunctions%2F-1170581573) | [java]<br>open fun [findInitializationErrors](../-timestamp-rules/index.md#-812419917%2FFunctions%2F-1170581573)(): [List](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/List.html)&lt;[String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html)&gt; |
| [getAllFields](../-timestamp-rules/index.md#-881691077%2FFunctions%2F-1170581573) | [java]<br>open fun [getAllFields](../-timestamp-rules/index.md#-881691077%2FFunctions%2F-1170581573)(): [Map](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/Map.html)&lt;Descriptors.FieldDescriptor, [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; |
| [getConst](get-const.md) | [java]<br>open fun [getConst](get-const.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>```kotlin Const specifies that this field must be exactly the specified value<br>``` `optional bool const = 1;` |
| [getDefaultInstance](get-default-instance.md) | [java]<br>open fun [getDefaultInstance](get-default-instance.md)(): [Validate.BoolRules](index.md) |
| [getDefaultInstanceForType](../-timestamp-rules/-builder/index.md#-889905270%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getDefaultInstanceForType](../-timestamp-rules/-builder/index.md#-889905270%2FFunctions%2F-1170581573)(): MessageLite<br>open fun [getDefaultInstanceForType](get-default-instance-for-type.md)(): [Validate.BoolRules](index.md) |
| [getDescriptor](get-descriptor.md) | [java]<br>fun [getDescriptor](get-descriptor.md)(): Descriptors.Descriptor |
| [getDescriptorForType](../-timestamp-rules/index.md#-339032575%2FFunctions%2F-1170581573) | [java]<br>open fun [getDescriptorForType](../-timestamp-rules/index.md#-339032575%2FFunctions%2F-1170581573)(): Descriptors.Descriptor |
| [getField](../-timestamp-rules/index.md#-1468392733%2FFunctions%2F-1170581573) | [java]<br>open fun [getField](../-timestamp-rules/index.md#-1468392733%2FFunctions%2F-1170581573)(field: Descriptors.FieldDescriptor): [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html) |
| [getInitializationErrorString](../-timestamp-rules/index.md#150260564%2FFunctions%2F-1170581573) | [java]<br>open fun [getInitializationErrorString](../-timestamp-rules/index.md#150260564%2FFunctions%2F-1170581573)(): [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html) |
| [getOneofFieldDescriptor](../-timestamp-rules/index.md#278248706%2FFunctions%2F-1170581573) | [java]<br>open fun [getOneofFieldDescriptor](../-timestamp-rules/index.md#278248706%2FFunctions%2F-1170581573)(oneof: Descriptors.OneofDescriptor): Descriptors.FieldDescriptor |
| [getParserForType](../-timestamp-rules/index.md#778616491%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getParserForType](../-timestamp-rules/index.md#778616491%2FFunctions%2F-1170581573)(): Parser&lt;out Message&gt;<br>abstract fun [getParserForType](../-timestamp-rules/index.md#-723557255%2FFunctions%2F-1170581573)(): Parser&lt;out MessageLite&gt;<br>open fun [getParserForType](get-parser-for-type.md)(): Parser&lt;[Validate.BoolRules](index.md)&gt; |
| [getRepeatedField](../-timestamp-rules/index.md#-574192867%2FFunctions%2F-1170581573) | [java]<br>open fun [getRepeatedField](../-timestamp-rules/index.md#-574192867%2FFunctions%2F-1170581573)(field: Descriptors.FieldDescriptor, index: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html) |
| [getRepeatedFieldCount](../-timestamp-rules/index.md#1483673896%2FFunctions%2F-1170581573) | [java]<br>open fun [getRepeatedFieldCount](../-timestamp-rules/index.md#1483673896%2FFunctions%2F-1170581573)(field: Descriptors.FieldDescriptor): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [getSerializedSize](get-serialized-size.md) | [java]<br>open fun [getSerializedSize](get-serialized-size.md)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [getUnknownFields](../-timestamp-rules/index.md#1599009394%2FFunctions%2F-1170581573) | [java]<br>open fun [getUnknownFields](../-timestamp-rules/index.md#1599009394%2FFunctions%2F-1170581573)(): UnknownFieldSet |
| [hasConst](has-const.md) | [java]<br>open fun [hasConst](has-const.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>```kotlin Const specifies that this field must be exactly the specified value<br>``` `optional bool const = 1;` |
| [hasField](../-timestamp-rules/index.md#1355327007%2FFunctions%2F-1170581573) | [java]<br>open fun [hasField](../-timestamp-rules/index.md#1355327007%2FFunctions%2F-1170581573)(field: Descriptors.FieldDescriptor): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [java]<br>open fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [hasOneof](../-timestamp-rules/index.md#-52289665%2FFunctions%2F-1170581573) | [java]<br>open fun [hasOneof](../-timestamp-rules/index.md#-52289665%2FFunctions%2F-1170581573)(oneof: Descriptors.OneofDescriptor): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [isInitialized](is-initialized.md) | [java]<br>fun [isInitialized](is-initialized.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [newBuilder](new-builder.md) | [java]<br>open fun [newBuilder](new-builder.md)(): [Validate.BoolRules.Builder](-builder/index.md)<br>open fun [newBuilder](new-builder.md)(prototype: [Validate.BoolRules](index.md)): [Validate.BoolRules.Builder](-builder/index.md) |
| [newBuilderForType](new-builder-for-type.md) | [java]<br>open fun [newBuilderForType](new-builder-for-type.md)(): [Validate.BoolRules.Builder](-builder/index.md) |
| [parseDelimitedFrom](parse-delimited-from.md) | [java]<br>open fun [parseDelimitedFrom](parse-delimited-from.md)(input: [InputStream](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/io/InputStream.html)): [Validate.BoolRules](index.md)<br>open fun [parseDelimitedFrom](parse-delimited-from.md)(input: [InputStream](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/io/InputStream.html), extensionRegistry: ExtensionRegistryLite): [Validate.BoolRules](index.md) |
| [parseFrom](parse-from.md) | [java]<br>open fun [parseFrom](parse-from.md)(data: [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[Byte](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-byte/index.html)&gt;): [Validate.BoolRules](index.md)<br>open fun [parseFrom](parse-from.md)(data: ByteString): [Validate.BoolRules](index.md)<br>open fun [parseFrom](parse-from.md)(input: CodedInputStream): [Validate.BoolRules](index.md)<br>open fun [parseFrom](parse-from.md)(input: [InputStream](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/io/InputStream.html)): [Validate.BoolRules](index.md)<br>open fun [parseFrom](parse-from.md)(data: [ByteBuffer](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/nio/ByteBuffer.html)): [Validate.BoolRules](index.md)<br>open fun [parseFrom](parse-from.md)(data: [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[Byte](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-byte/index.html)&gt;, extensionRegistry: ExtensionRegistryLite): [Validate.BoolRules](index.md)<br>open fun [parseFrom](parse-from.md)(data: ByteString, extensionRegistry: ExtensionRegistryLite): [Validate.BoolRules](index.md)<br>open fun [parseFrom](parse-from.md)(input: CodedInputStream, extensionRegistry: ExtensionRegistryLite): [Validate.BoolRules](index.md)<br>open fun [parseFrom](parse-from.md)(input: [InputStream](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/io/InputStream.html), extensionRegistry: ExtensionRegistryLite): [Validate.BoolRules](index.md)<br>open fun [parseFrom](parse-from.md)(data: [ByteBuffer](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/nio/ByteBuffer.html), extensionRegistry: ExtensionRegistryLite): [Validate.BoolRules](index.md) |
| [parser](parser.md) | [java]<br>open fun [parser](parser.md)(): Parser&lt;[Validate.BoolRules](index.md)&gt; |
| [toBuilder](to-builder.md) | [java]<br>open fun [toBuilder](to-builder.md)(): [Validate.BoolRules.Builder](-builder/index.md) |
| [toByteArray](../-timestamp-rules/index.md#-893058881%2FFunctions%2F-1170581573) | [java]<br>open fun [toByteArray](../-timestamp-rules/index.md#-893058881%2FFunctions%2F-1170581573)(): [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[Byte](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-byte/index.html)&gt; |
| [toByteString](../-timestamp-rules/index.md#1590314737%2FFunctions%2F-1170581573) | [java]<br>open fun [toByteString](../-timestamp-rules/index.md#1590314737%2FFunctions%2F-1170581573)(): ByteString |
| [toString](../-timestamp-rules/index.md#-1084302645%2FFunctions%2F-1170581573) | [java]<br>fun [toString](../-timestamp-rules/index.md#-1084302645%2FFunctions%2F-1170581573)(): [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html) |
| [writeDelimitedTo](../-timestamp-rules/index.md#938978067%2FFunctions%2F-1170581573) | [java]<br>open fun [writeDelimitedTo](../-timestamp-rules/index.md#938978067%2FFunctions%2F-1170581573)(output: [OutputStream](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/io/OutputStream.html)) |
| [writeTo](write-to.md) | [java]<br>open fun [writeTo](write-to.md)(output: CodedOutputStream) |