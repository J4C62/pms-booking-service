//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driver.advice](../index.md)/[GrpcExceptionAdvice](index.md)

# GrpcExceptionAdvice

[java]\
@GrpcAdvice

open class [GrpcExceptionAdvice](index.md)

Global gRPC exception handler using `@GrpcAdvice`. 

This class maps common Java exceptions to appropriate gRPC io.grpc.Status codes to ensure meaningful error responses are returned to gRPC clients. 

All handled exceptions in this class are mapped to INVALID_ARGUMENT, indicating client-side errors due to invalid or illegal input or state.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-22

## Constructors

| | |
|---|---|
| [GrpcExceptionAdvice](-grpc-exception-advice.md) | [java]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [handleException](handle-exception.md) | [java]<br>@GrpcExceptionHandler(value = [Exception::class](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Exception.html))<br>open fun [handleException](handle-exception.md)(e: [Exception](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Exception.html)): Status<br>Handles [Exception](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Exception.html) by returning INTERNAL. |
| [handleInvalidArgument](handle-invalid-argument.md) | [java]<br>@GrpcExceptionHandler(value = [[IllegalArgumentException::class](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalArgumentException.html), [IllegalStateException::class](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalStateException.html), [NullPointerException::class](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/NullPointerException.html)])<br>open fun [handleInvalidArgument](handle-invalid-argument.md)(e: [RuntimeException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/RuntimeException.html)): Status<br>Handles [IllegalArgumentException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalArgumentException.html)[IllegalStateException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalStateException.html) by returning INVALID_ARGUMENT. |