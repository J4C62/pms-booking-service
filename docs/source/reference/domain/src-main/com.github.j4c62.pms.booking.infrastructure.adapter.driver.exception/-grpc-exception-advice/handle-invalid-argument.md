//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driver.advice](../index.md)/[GrpcExceptionAdvice](index.md)/[handleInvalidArgument](handle-invalid-argument.md)

# handleInvalidArgument

[src]\
open fun [handleInvalidArgument](handle-invalid-argument.md)(
e: [IllegalArgumentException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalArgumentException.html)):
Status

Handles [IllegalArgumentException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalArgumentException.html) by
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

[src]\
open fun [handleInvalidArgument](handle-invalid-argument.md)(
e: [IllegalStateException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html)): Status

Handles [IllegalStateException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html) by
returning INVALID_ARGUMENT.

#### Return

a gRPC Status with description and cause

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-03

#### Parameters

src

|   |                                       |
|---|---------------------------------------|
| e | the exception thrown during execution |