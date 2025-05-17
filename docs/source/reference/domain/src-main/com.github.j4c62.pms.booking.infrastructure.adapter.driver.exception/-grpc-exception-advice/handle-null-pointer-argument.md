//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driver.exception](../index.md)/[GrpcExceptionAdvice](index.md)/[handleNullPointerArgument](handle-null-pointer-argument.md)

# handleNullPointerArgument

[src]\
open fun [handleNullPointerArgument](handle-null-pointer-argument.md)(
e: [NullPointerException](https://docs.oracle.com/javase/8/docs/api/java/lang/NullPointerException.html)): Status

Handles [NullPointerException](https://docs.oracle.com/javase/8/docs/api/java/lang/NullPointerException.html) by
returning INVALID_ARGUMENT.

#### Return

a gRPC Status with description and cause

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-22

#### Parameters

src

|   |                                       |
|---|---------------------------------------|
| e | the exception thrown during execution |