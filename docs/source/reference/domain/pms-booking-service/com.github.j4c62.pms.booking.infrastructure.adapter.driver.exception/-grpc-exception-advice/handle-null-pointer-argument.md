//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driver.exception](../index.md)/[GrpcExceptionAdvice](index.md)/[handleNullPointerArgument](handle-null-pointer-argument.md)

# handleNullPointerArgument

[java]\

@GrpcExceptionHandler(
value = [NullPointerException::class](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/NullPointerException.html))

open fun [handleNullPointerArgument](handle-null-pointer-argument.md)(
e: [NullPointerException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/NullPointerException.html)):
Status

Handles [NullPointerException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/NullPointerException.html)
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