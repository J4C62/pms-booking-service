//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driver.exception](../index.md)/[GrpcExceptionAdvice](index.md)/[handleInvalidArgument](handle-invalid-argument.md)

# handleInvalidArgument

[java]\

@GrpcExceptionHandler(
value = [IllegalArgumentException::class](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalArgumentException.html))

open fun [handleInvalidArgument](handle-invalid-argument.md)(
e: [IllegalArgumentException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalArgumentException.html)):
Status

Handles [IllegalArgumentException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalArgumentException.html)
by returning INVALID_ARGUMENT.

#### Return

a gRPC Status with description and cause

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-22

#### Parameters

java

|   |                                       |
|---|---------------------------------------|
| e | the exception thrown during execution |

[java]\

@GrpcExceptionHandler(
value = [IllegalStateException::class](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalStateException.html))

open fun [handleInvalidArgument](handle-invalid-argument.md)(
e: [IllegalStateException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalStateException.html)):
Status

Handles [IllegalStateException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalStateException.html)
by returning INVALID_ARGUMENT.

#### Return

a gRPC Status with description and cause

#### Author

Jose Antonio (J4c62)

#### Since

2025-05-03

#### Parameters

java

|   |                                       |
|---|---------------------------------------|
| e | the exception thrown during execution |