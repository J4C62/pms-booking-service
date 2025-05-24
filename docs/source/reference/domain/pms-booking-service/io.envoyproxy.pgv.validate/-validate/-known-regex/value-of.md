//[pms-booking-service](../../../../index.md)/[io.envoyproxy.pgv.validate](../../index.md)/[Validate](../index.md)/[KnownRegex](index.md)/[valueOf](value-of.md)

# valueOf

[java]\
open fun [valueOf](value-of.md)(desc: Descriptors.EnumValueDescriptor): [Validate.KnownRegex](index.md)

[java]\
open fun [valueOf](value-of.md)(name: [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html)): [Validate.KnownRegex](index.md)

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

#### Return

the enum constant with the specified name

#### Throws

| | |
|---|---|
| [IllegalArgumentException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalArgumentException.html) | if this enum type has no constant with the specified name |

[java]\
open fun [~~valueOf~~](value-of.md)(value: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Validate.KnownRegex](index.md)

---

### Deprecated

Use [forNumber](for-number.md) instead.

---

#### Return

The enum associated with the given numeric wire value.

#### Parameters

java

| | |
|---|---|
| value | The numeric wire value of the corresponding enum entry. |