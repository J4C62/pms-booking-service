//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driver.advice](../index.md)/[GrpcExceptionAdvice](index.md)/[handleException](handle-exception.md)

# handleException

[java]\

@GrpcExceptionHandler(value = [Exception::class](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Exception.html))

open fun [handleException](handle-exception.md)(e: [Exception](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Exception.html)): Status

Handles [Exception](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Exception.html) by returning INTERNAL.

#### Return

a gRPC Status with description and cause

#### Author

Jose Antonio (J4c62)

#### Since

2025-06-24

#### Parameters

java

| | |
|---|---|
| e | the exception thrown during execution |