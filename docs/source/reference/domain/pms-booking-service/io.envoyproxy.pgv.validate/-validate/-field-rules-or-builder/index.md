//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[FieldRulesOrBuilder](index.md)

# FieldRulesOrBuilder

interface [FieldRulesOrBuilder](index.md) : MessageOrBuilder

#### Inheritors

| |
|---|
| [FieldRules](../-field-rules/index.md) |
| [Builder](../-field-rules/-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [findInitializationErrors](../-timestamp-rules-or-builder/index.md#1227463831%2FFunctions%2F-1170581573) | [java]<br>abstract fun [findInitializationErrors](../-timestamp-rules-or-builder/index.md#1227463831%2FFunctions%2F-1170581573)(): [List](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/List.html)&lt;[String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html)&gt; |
| [getAllFields](../-timestamp-rules-or-builder/index.md#-1735213033%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getAllFields](../-timestamp-rules-or-builder/index.md#-1735213033%2FFunctions%2F-1170581573)(): [Map](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/Map.html)&lt;Descriptors.FieldDescriptor, [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; |
| [getAny](get-any.md) | [java]<br>abstract fun [getAny](get-any.md)(): [Validate.AnyRules](../-any-rules/index.md)<br>```kotlin Well-Known Field Types<br>``` `.validate.AnyRules any = 20;` |
| [getAnyOrBuilder](get-any-or-builder.md) | [java]<br>abstract fun [getAnyOrBuilder](get-any-or-builder.md)(): [Validate.AnyRulesOrBuilder](../-any-rules-or-builder/index.md)<br>```kotlin Well-Known Field Types<br>``` `.validate.AnyRules any = 20;` |
| [getBool](get-bool.md) | [java]<br>abstract fun [getBool](get-bool.md)(): [Validate.BoolRules](../-bool-rules/index.md)<br>`.validate.BoolRules bool = 13;` |
| [getBoolOrBuilder](get-bool-or-builder.md) | [java]<br>abstract fun [getBoolOrBuilder](get-bool-or-builder.md)(): [Validate.BoolRulesOrBuilder](../-bool-rules-or-builder/index.md)<br>`.validate.BoolRules bool = 13;` |
| [getBytes](get-bytes.md) | [java]<br>abstract fun [getBytes](get-bytes.md)(): [Validate.BytesRules](../-bytes-rules/index.md)<br>`.validate.BytesRules bytes = 15;` |
| [getBytesOrBuilder](get-bytes-or-builder.md) | [java]<br>abstract fun [getBytesOrBuilder](get-bytes-or-builder.md)(): [Validate.BytesRulesOrBuilder](../-bytes-rules-or-builder/index.md)<br>`.validate.BytesRules bytes = 15;` |
| [getDefaultInstanceForType](../-timestamp-rules/-builder/index.md#-889905270%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getDefaultInstanceForType](../-timestamp-rules/-builder/index.md#-889905270%2FFunctions%2F-1170581573)(): MessageLite<br>abstract fun [getDefaultInstanceForType](../-timestamp-rules-or-builder/index.md#1172508988%2FFunctions%2F-1170581573)(): Message |
| [getDescriptorForType](../-timestamp-rules-or-builder/index.md#-2023656483%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getDescriptorForType](../-timestamp-rules-or-builder/index.md#-2023656483%2FFunctions%2F-1170581573)(): Descriptors.Descriptor |
| [getDouble](get-double.md) | [java]<br>abstract fun [getDouble](get-double.md)(): [Validate.DoubleRules](../-double-rules/index.md)<br>`.validate.DoubleRules double = 2;` |
| [getDoubleOrBuilder](get-double-or-builder.md) | [java]<br>abstract fun [getDoubleOrBuilder](get-double-or-builder.md)(): [Validate.DoubleRulesOrBuilder](../-double-rules-or-builder/index.md)<br>`.validate.DoubleRules double = 2;` |
| [getDuration](get-duration.md) | [java]<br>abstract fun [getDuration](get-duration.md)(): [Validate.DurationRules](../-duration-rules/index.md)<br>`.validate.DurationRules duration = 21;` |
| [getDurationOrBuilder](get-duration-or-builder.md) | [java]<br>abstract fun [getDurationOrBuilder](get-duration-or-builder.md)(): [Validate.DurationRulesOrBuilder](../-duration-rules-or-builder/index.md)<br>`.validate.DurationRules duration = 21;` |
| [getEnum](get-enum.md) | [java]<br>abstract fun [getEnum](get-enum.md)(): [Validate.EnumRules](../-enum-rules/index.md)<br>```kotlin Complex Field Types<br>``` `.validate.EnumRules enum = 16;` |
| [getEnumOrBuilder](get-enum-or-builder.md) | [java]<br>abstract fun [getEnumOrBuilder](get-enum-or-builder.md)(): [Validate.EnumRulesOrBuilder](../-enum-rules-or-builder/index.md)<br>```kotlin Complex Field Types<br>``` `.validate.EnumRules enum = 16;` |
| [getField](../-timestamp-rules-or-builder/index.md#-728711289%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getField](../-timestamp-rules-or-builder/index.md#-728711289%2FFunctions%2F-1170581573)(field: Descriptors.FieldDescriptor): [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html) |
| [getFixed32](get-fixed32.md) | [java]<br>abstract fun [getFixed32](get-fixed32.md)(): [Validate.Fixed32Rules](../-fixed32-rules/index.md)<br>`.validate.Fixed32Rules fixed32 = 9;` |
| [getFixed32OrBuilder](get-fixed32-or-builder.md) | [java]<br>abstract fun [getFixed32OrBuilder](get-fixed32-or-builder.md)(): [Validate.Fixed32RulesOrBuilder](../-fixed32-rules-or-builder/index.md)<br>`.validate.Fixed32Rules fixed32 = 9;` |
| [getFixed64](get-fixed64.md) | [java]<br>abstract fun [getFixed64](get-fixed64.md)(): [Validate.Fixed64Rules](../-fixed64-rules/index.md)<br>`.validate.Fixed64Rules fixed64 = 10;` |
| [getFixed64OrBuilder](get-fixed64-or-builder.md) | [java]<br>abstract fun [getFixed64OrBuilder](get-fixed64-or-builder.md)(): [Validate.Fixed64RulesOrBuilder](../-fixed64-rules-or-builder/index.md)<br>`.validate.Fixed64Rules fixed64 = 10;` |
| [getFloat](get-float.md) | [java]<br>abstract fun [getFloat](get-float.md)(): [Validate.FloatRules](../-float-rules/index.md)<br>```kotlin Scalar Field Types<br>``` `.validate.FloatRules float = 1;` |
| [getFloatOrBuilder](get-float-or-builder.md) | [java]<br>abstract fun [getFloatOrBuilder](get-float-or-builder.md)(): [Validate.FloatRulesOrBuilder](../-float-rules-or-builder/index.md)<br>```kotlin Scalar Field Types<br>``` `.validate.FloatRules float = 1;` |
| [getInitializationErrorString](../-timestamp-rules-or-builder/index.md#-106143432%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getInitializationErrorString](../-timestamp-rules-or-builder/index.md#-106143432%2FFunctions%2F-1170581573)(): [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html) |
| [getInt32](get-int32.md) | [java]<br>abstract fun [getInt32](get-int32.md)(): [Validate.Int32Rules](../-int32-rules/index.md)<br>`.validate.Int32Rules int32 = 3;` |
| [getInt32OrBuilder](get-int32-or-builder.md) | [java]<br>abstract fun [getInt32OrBuilder](get-int32-or-builder.md)(): [Validate.Int32RulesOrBuilder](../-int32-rules-or-builder/index.md)<br>`.validate.Int32Rules int32 = 3;` |
| [getInt64](get-int64.md) | [java]<br>abstract fun [getInt64](get-int64.md)(): [Validate.Int64Rules](../-int64-rules/index.md)<br>`.validate.Int64Rules int64 = 4;` |
| [getInt64OrBuilder](get-int64-or-builder.md) | [java]<br>abstract fun [getInt64OrBuilder](get-int64-or-builder.md)(): [Validate.Int64RulesOrBuilder](../-int64-rules-or-builder/index.md)<br>`.validate.Int64Rules int64 = 4;` |
| [getMap](get-map.md) | [java]<br>abstract fun [getMap](get-map.md)(): [Validate.MapRules](../-map-rules/index.md)<br>`.validate.MapRules map = 19;` |
| [getMapOrBuilder](get-map-or-builder.md) | [java]<br>abstract fun [getMapOrBuilder](get-map-or-builder.md)(): [Validate.MapRulesOrBuilder](../-map-rules-or-builder/index.md)<br>`.validate.MapRules map = 19;` |
| [getMessage](get-message.md) | [java]<br>abstract fun [getMessage](get-message.md)(): [Validate.MessageRules](../-message-rules/index.md)<br>`optional .validate.MessageRules message = 17;` |
| [getMessageOrBuilder](get-message-or-builder.md) | [java]<br>abstract fun [getMessageOrBuilder](get-message-or-builder.md)(): [Validate.MessageRulesOrBuilder](../-message-rules-or-builder/index.md)<br>`optional .validate.MessageRules message = 17;` |
| [getOneofFieldDescriptor](../-timestamp-rules-or-builder/index.md#1767160798%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getOneofFieldDescriptor](../-timestamp-rules-or-builder/index.md#1767160798%2FFunctions%2F-1170581573)(oneof: Descriptors.OneofDescriptor): Descriptors.FieldDescriptor |
| [getRepeated](get-repeated.md) | [java]<br>abstract fun [getRepeated](get-repeated.md)(): [Validate.RepeatedRules](../-repeated-rules/index.md)<br>`.validate.RepeatedRules repeated = 18;` |
| [getRepeatedField](../-timestamp-rules-or-builder/index.md#1425494465%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getRepeatedField](../-timestamp-rules-or-builder/index.md#1425494465%2FFunctions%2F-1170581573)(field: Descriptors.FieldDescriptor, index: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html) |
| [getRepeatedFieldCount](../-timestamp-rules-or-builder/index.md#-950528252%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getRepeatedFieldCount](../-timestamp-rules-or-builder/index.md#-950528252%2FFunctions%2F-1170581573)(field: Descriptors.FieldDescriptor): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [getRepeatedOrBuilder](get-repeated-or-builder.md) | [java]<br>abstract fun [getRepeatedOrBuilder](get-repeated-or-builder.md)(): [Validate.RepeatedRulesOrBuilder](../-repeated-rules-or-builder/index.md)<br>`.validate.RepeatedRules repeated = 18;` |
| [getSfixed32](get-sfixed32.md) | [java]<br>abstract fun [getSfixed32](get-sfixed32.md)(): [Validate.SFixed32Rules](../-s-fixed32-rules/index.md)<br>`.validate.SFixed32Rules sfixed32 = 11;` |
| [getSfixed32OrBuilder](get-sfixed32-or-builder.md) | [java]<br>abstract fun [getSfixed32OrBuilder](get-sfixed32-or-builder.md)(): [Validate.SFixed32RulesOrBuilder](../-s-fixed32-rules-or-builder/index.md)<br>`.validate.SFixed32Rules sfixed32 = 11;` |
| [getSfixed64](get-sfixed64.md) | [java]<br>abstract fun [getSfixed64](get-sfixed64.md)(): [Validate.SFixed64Rules](../-s-fixed64-rules/index.md)<br>`.validate.SFixed64Rules sfixed64 = 12;` |
| [getSfixed64OrBuilder](get-sfixed64-or-builder.md) | [java]<br>abstract fun [getSfixed64OrBuilder](get-sfixed64-or-builder.md)(): [Validate.SFixed64RulesOrBuilder](../-s-fixed64-rules-or-builder/index.md)<br>`.validate.SFixed64Rules sfixed64 = 12;` |
| [getSint32](get-sint32.md) | [java]<br>abstract fun [getSint32](get-sint32.md)(): [Validate.SInt32Rules](../-s-int32-rules/index.md)<br>`.validate.SInt32Rules sint32 = 7;` |
| [getSint32OrBuilder](get-sint32-or-builder.md) | [java]<br>abstract fun [getSint32OrBuilder](get-sint32-or-builder.md)(): [Validate.SInt32RulesOrBuilder](../-s-int32-rules-or-builder/index.md)<br>`.validate.SInt32Rules sint32 = 7;` |
| [getSint64](get-sint64.md) | [java]<br>abstract fun [getSint64](get-sint64.md)(): [Validate.SInt64Rules](../-s-int64-rules/index.md)<br>`.validate.SInt64Rules sint64 = 8;` |
| [getSint64OrBuilder](get-sint64-or-builder.md) | [java]<br>abstract fun [getSint64OrBuilder](get-sint64-or-builder.md)(): [Validate.SInt64RulesOrBuilder](../-s-int64-rules-or-builder/index.md)<br>`.validate.SInt64Rules sint64 = 8;` |
| [getString](get-string.md) | [java]<br>abstract fun [getString](get-string.md)(): [Validate.StringRules](../-string-rules/index.md)<br>`.validate.StringRules string = 14;` |
| [getStringOrBuilder](get-string-or-builder.md) | [java]<br>abstract fun [getStringOrBuilder](get-string-or-builder.md)(): [Validate.StringRulesOrBuilder](../-string-rules-or-builder/index.md)<br>`.validate.StringRules string = 14;` |
| [getTimestamp](get-timestamp.md) | [java]<br>abstract fun [getTimestamp](get-timestamp.md)(): [Validate.TimestampRules](../-timestamp-rules/index.md)<br>`.validate.TimestampRules timestamp = 22;` |
| [getTimestampOrBuilder](get-timestamp-or-builder.md) | [java]<br>abstract fun [getTimestampOrBuilder](get-timestamp-or-builder.md)(): [Validate.TimestampRulesOrBuilder](../-timestamp-rules-or-builder/index.md)<br>`.validate.TimestampRules timestamp = 22;` |
| [getTypeCase](get-type-case.md) | [java]<br>abstract fun [getTypeCase](get-type-case.md)(): [Validate.FieldRules.TypeCase](../-field-rules/-type-case/index.md) |
| [getUint32](get-uint32.md) | [java]<br>abstract fun [getUint32](get-uint32.md)(): [Validate.UInt32Rules](../-u-int32-rules/index.md)<br>`.validate.UInt32Rules uint32 = 5;` |
| [getUint32OrBuilder](get-uint32-or-builder.md) | [java]<br>abstract fun [getUint32OrBuilder](get-uint32-or-builder.md)(): [Validate.UInt32RulesOrBuilder](../-u-int32-rules-or-builder/index.md)<br>`.validate.UInt32Rules uint32 = 5;` |
| [getUint64](get-uint64.md) | [java]<br>abstract fun [getUint64](get-uint64.md)(): [Validate.UInt64Rules](../-u-int64-rules/index.md)<br>`.validate.UInt64Rules uint64 = 6;` |
| [getUint64OrBuilder](get-uint64-or-builder.md) | [java]<br>abstract fun [getUint64OrBuilder](get-uint64-or-builder.md)(): [Validate.UInt64RulesOrBuilder](../-u-int64-rules-or-builder/index.md)<br>`.validate.UInt64Rules uint64 = 6;` |
| [getUnknownFields](../-timestamp-rules-or-builder/index.md#-1388384690%2FFunctions%2F-1170581573) | [java]<br>abstract fun [getUnknownFields](../-timestamp-rules-or-builder/index.md#-1388384690%2FFunctions%2F-1170581573)(): UnknownFieldSet |
| [hasAny](has-any.md) | [java]<br>abstract fun [hasAny](has-any.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>```kotlin Well-Known Field Types<br>``` `.validate.AnyRules any = 20;` |
| [hasBool](has-bool.md) | [java]<br>abstract fun [hasBool](has-bool.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.BoolRules bool = 13;` |
| [hasBytes](has-bytes.md) | [java]<br>abstract fun [hasBytes](has-bytes.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.BytesRules bytes = 15;` |
| [hasDouble](has-double.md) | [java]<br>abstract fun [hasDouble](has-double.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.DoubleRules double = 2;` |
| [hasDuration](has-duration.md) | [java]<br>abstract fun [hasDuration](has-duration.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.DurationRules duration = 21;` |
| [hasEnum](has-enum.md) | [java]<br>abstract fun [hasEnum](has-enum.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>```kotlin Complex Field Types<br>``` `.validate.EnumRules enum = 16;` |
| [hasField](../-timestamp-rules-or-builder/index.md#2095008451%2FFunctions%2F-1170581573) | [java]<br>abstract fun [hasField](../-timestamp-rules-or-builder/index.md#2095008451%2FFunctions%2F-1170581573)(field: Descriptors.FieldDescriptor): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [hasFixed32](has-fixed32.md) | [java]<br>abstract fun [hasFixed32](has-fixed32.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.Fixed32Rules fixed32 = 9;` |
| [hasFixed64](has-fixed64.md) | [java]<br>abstract fun [hasFixed64](has-fixed64.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.Fixed64Rules fixed64 = 10;` |
| [hasFloat](has-float.md) | [java]<br>abstract fun [hasFloat](has-float.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>```kotlin Scalar Field Types<br>``` `.validate.FloatRules float = 1;` |
| [hasInt32](has-int32.md) | [java]<br>abstract fun [hasInt32](has-int32.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.Int32Rules int32 = 3;` |
| [hasInt64](has-int64.md) | [java]<br>abstract fun [hasInt64](has-int64.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.Int64Rules int64 = 4;` |
| [hasMap](has-map.md) | [java]<br>abstract fun [hasMap](has-map.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.MapRules map = 19;` |
| [hasMessage](has-message.md) | [java]<br>abstract fun [hasMessage](has-message.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`optional .validate.MessageRules message = 17;` |
| [hasOneof](../-timestamp-rules-or-builder/index.md#687391779%2FFunctions%2F-1170581573) | [java]<br>abstract fun [hasOneof](../-timestamp-rules-or-builder/index.md#687391779%2FFunctions%2F-1170581573)(oneof: Descriptors.OneofDescriptor): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [hasRepeated](has-repeated.md) | [java]<br>abstract fun [hasRepeated](has-repeated.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.RepeatedRules repeated = 18;` |
| [hasSfixed32](has-sfixed32.md) | [java]<br>abstract fun [hasSfixed32](has-sfixed32.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.SFixed32Rules sfixed32 = 11;` |
| [hasSfixed64](has-sfixed64.md) | [java]<br>abstract fun [hasSfixed64](has-sfixed64.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.SFixed64Rules sfixed64 = 12;` |
| [hasSint32](has-sint32.md) | [java]<br>abstract fun [hasSint32](has-sint32.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.SInt32Rules sint32 = 7;` |
| [hasSint64](has-sint64.md) | [java]<br>abstract fun [hasSint64](has-sint64.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.SInt64Rules sint64 = 8;` |
| [hasString](has-string.md) | [java]<br>abstract fun [hasString](has-string.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.StringRules string = 14;` |
| [hasTimestamp](has-timestamp.md) | [java]<br>abstract fun [hasTimestamp](has-timestamp.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.TimestampRules timestamp = 22;` |
| [hasUint32](has-uint32.md) | [java]<br>abstract fun [hasUint32](has-uint32.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.UInt32Rules uint32 = 5;` |
| [hasUint64](has-uint64.md) | [java]<br>abstract fun [hasUint64](has-uint64.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>`.validate.UInt64Rules uint64 = 6;` |
| [isInitialized](../-timestamp-rules-or-builder/index.md#-786502173%2FFunctions%2F-1170581573) | [java]<br>abstract fun [isInitialized](../-timestamp-rules-or-builder/index.md#-786502173%2FFunctions%2F-1170581573)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |