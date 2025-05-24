//[pms-booking-service](../../../../../index.md)/[io.envoyproxy.pgv.validate](../../../index.md)/[Validate](../../index.md)/[FieldRules](../index.md)/[TypeCase](index.md)

# TypeCase

[java]\
enum [TypeCase](index.md) : Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum

## Entries

| | |
|---|---|
| [FLOAT](-f-l-o-a-t/index.md) | [java]<br>[FLOAT](-f-l-o-a-t/index.md) |
| [DOUBLE](-d-o-u-b-l-e/index.md) | [java]<br>[DOUBLE](-d-o-u-b-l-e/index.md) |
| [INT32](-i-n-t32/index.md) | [java]<br>[INT32](-i-n-t32/index.md) |
| [INT64](-i-n-t64/index.md) | [java]<br>[INT64](-i-n-t64/index.md) |
| [UINT32](-u-i-n-t32/index.md) | [java]<br>[UINT32](-u-i-n-t32/index.md) |
| [UINT64](-u-i-n-t64/index.md) | [java]<br>[UINT64](-u-i-n-t64/index.md) |
| [SINT32](-s-i-n-t32/index.md) | [java]<br>[SINT32](-s-i-n-t32/index.md) |
| [SINT64](-s-i-n-t64/index.md) | [java]<br>[SINT64](-s-i-n-t64/index.md) |
| [FIXED32](-f-i-x-e-d32/index.md) | [java]<br>[FIXED32](-f-i-x-e-d32/index.md) |
| [FIXED64](-f-i-x-e-d64/index.md) | [java]<br>[FIXED64](-f-i-x-e-d64/index.md) |
| [SFIXED32](-s-f-i-x-e-d32/index.md) | [java]<br>[SFIXED32](-s-f-i-x-e-d32/index.md) |
| [SFIXED64](-s-f-i-x-e-d64/index.md) | [java]<br>[SFIXED64](-s-f-i-x-e-d64/index.md) |
| [BOOL](-b-o-o-l/index.md) | [java]<br>[BOOL](-b-o-o-l/index.md) |
| [STRING](-s-t-r-i-n-g/index.md) | [java]<br>[STRING](-s-t-r-i-n-g/index.md) |
| [BYTES](-b-y-t-e-s/index.md) | [java]<br>[BYTES](-b-y-t-e-s/index.md) |
| [ENUM](-e-n-u-m/index.md) | [java]<br>[ENUM](-e-n-u-m/index.md) |
| [REPEATED](-r-e-p-e-a-t-e-d/index.md) | [java]<br>[REPEATED](-r-e-p-e-a-t-e-d/index.md) |
| [MAP](-m-a-p/index.md) | [java]<br>[MAP](-m-a-p/index.md) |
| [ANY](-a-n-y/index.md) | [java]<br>[ANY](-a-n-y/index.md) |
| [DURATION](-d-u-r-a-t-i-o-n/index.md) | [java]<br>[DURATION](-d-u-r-a-t-i-o-n/index.md) |
| [TIMESTAMP](-t-i-m-e-s-t-a-m-p/index.md) | [java]<br>[TIMESTAMP](-t-i-m-e-s-t-a-m-p/index.md) |
| [TYPE_NOT_SET](-t-y-p-e_-n-o-t_-s-e-t/index.md) | [java]<br>[TYPE_NOT_SET](-t-y-p-e_-n-o-t_-s-e-t/index.md) |

## Functions

| Name | Summary |
|---|---|
| [forNumber](for-number.md) | [java]<br>open fun [forNumber](for-number.md)(value: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Validate.FieldRules.TypeCase](index.md) |
| [getNumber](get-number.md) | [java]<br>open fun [getNumber](get-number.md)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [valueOf](value-of.md) | [java]<br>open fun [~~valueOf~~](value-of.md)(value: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Validate.FieldRules.TypeCase](index.md)<br>[java]<br>open fun [valueOf](value-of.md)(name: [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html)): [Validate.FieldRules.TypeCase](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [java]<br>open fun [values](values.md)(): [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[Validate.FieldRules.TypeCase](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. This method may be used to iterate over the constants. |