//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driver.exception](../index.md)/[GrpcExceptionAdvice](index.md)

# GrpcExceptionAdvice

[java]\
@GrpcAdvice

open class [GrpcExceptionAdvice](index.md)

Global gRPC exception handler using `@GrpcAdvice`.

This class maps common Java exceptions to appropriate gRPC io.grpc.Status codes to ensure meaningful error responses are
returned to gRPC clients.

All handled exceptions in this class are mapped to INVALID_ARGUMENT, indicating client-side errors due to invalid or
illegal input or state.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-22

## Constructors

|                                                  |                         |
|--------------------------------------------------|-------------------------|
| [GrpcExceptionAdvice](-grpc-exception-advice.md) | [java]<br>constructor() |

## Functions

| Name                                                         | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
|--------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [handleInvalidArgument](handle-invalid-argument.md)          | [java]<br>@GrpcExceptionHandler(value = [IllegalArgumentException::class](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalArgumentException.html))<br>open fun [handleInvalidArgument](handle-invalid-argument.md)(e: [IllegalArgumentException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalArgumentException.html)): Status<br>Handles [IllegalArgumentException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalArgumentException.html) by returning INVALID_ARGUMENT.<br>[java]<br>@GrpcExceptionHandler(value = [IllegalStateException::class](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalStateException.html))<br>open fun [handleInvalidArgument](handle-invalid-argument.md)(e: [IllegalStateException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalStateException.html)): Status<br>Handles [IllegalStateException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalStateException.html) by returning INVALID_ARGUMENT. |
| [handleNullPointerArgument](handle-null-pointer-argument.md) | [java]<br>@GrpcExceptionHandler(value = [NullPointerException::class](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/NullPointerException.html))<br>open fun [handleNullPointerArgument](handle-null-pointer-argument.md)(e: [NullPointerException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/NullPointerException.html)): Status<br>Handles [NullPointerException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/NullPointerException.html) by returning INVALID_ARGUMENT.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |