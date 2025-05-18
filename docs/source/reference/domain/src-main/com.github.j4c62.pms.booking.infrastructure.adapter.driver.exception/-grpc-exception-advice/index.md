//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driver.exception](../index.md)/[GrpcExceptionAdvice](index.md)

# GrpcExceptionAdvice

[src]\
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

|                                                  |                        |
|--------------------------------------------------|------------------------|
| [GrpcExceptionAdvice](-grpc-exception-advice.md) | [src]<br>constructor() |

## Functions

| Name                                                         | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
|--------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [handleInvalidArgument](handle-invalid-argument.md)          | [src]<br>open fun [handleInvalidArgument](handle-invalid-argument.md)(e: [IllegalArgumentException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalArgumentException.html)): Status<br>Handles [IllegalArgumentException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalArgumentException.html) by returning INVALID_ARGUMENT.<br>[src]<br>open fun [handleInvalidArgument](handle-invalid-argument.md)(e: [IllegalStateException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html)): Status<br>Handles [IllegalStateException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html) by returning INVALID_ARGUMENT. |
| [handleNullPointerArgument](handle-null-pointer-argument.md) | [src]<br>open fun [handleNullPointerArgument](handle-null-pointer-argument.md)(e: [NullPointerException](https://docs.oracle.com/javase/8/docs/api/java/lang/NullPointerException.html)): Status<br>Handles [NullPointerException](https://docs.oracle.com/javase/8/docs/api/java/lang/NullPointerException.html) by returning INVALID_ARGUMENT.                                                                                                                                                                                                                                                                                                                                                       |