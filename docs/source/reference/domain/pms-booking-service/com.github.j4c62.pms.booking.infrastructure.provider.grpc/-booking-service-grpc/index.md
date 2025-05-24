//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.grpc](../index.md)/[BookingServiceGrpc](index.md)

# BookingServiceGrpc

[java]\
class [BookingServiceGrpc](index.md)```kotlin

BookingService defines RPC operations to create, update and cancel bookings.

```

## Types

| Name | Summary |
|---|---|
| [AsyncService](-async-service/index.md) | [java]<br>interface [AsyncService](-async-service/index.md)<br>```kotlin<br>BookingService defines RPC operations to create, update and cancel bookings.<br>``` |
| [BookingServiceBlockingStub](-booking-service-blocking-stub/index.md) | [java]<br>class [BookingServiceBlockingStub](-booking-service-blocking-stub/index.md) : AbstractBlockingStub&lt;S&gt; <br>A stub to allow clients to do limited synchronous rpc calls to service BookingService. |
| [BookingServiceBlockingV2Stub](-booking-service-blocking-v2-stub/index.md) | [java]<br>class [BookingServiceBlockingV2Stub](-booking-service-blocking-v2-stub/index.md) : AbstractBlockingStub&lt;S&gt; <br>A stub to allow clients to do synchronous rpc calls to service BookingService. |
| [BookingServiceFutureStub](-booking-service-future-stub/index.md) | [java]<br>class [BookingServiceFutureStub](-booking-service-future-stub/index.md) : AbstractFutureStub&lt;S&gt; <br>A stub to allow clients to do ListenableFuture-style rpc calls to service BookingService. |
| [BookingServiceImplBase](-booking-service-impl-base/index.md) | [java]<br>abstract class [BookingServiceImplBase](-booking-service-impl-base/index.md) : BindableService, [BookingServiceGrpc.AsyncService](-async-service/index.md)<br>Base class for the server implementation of the service BookingService. |
| [BookingServiceStub](-booking-service-stub/index.md) | [java]<br>class [BookingServiceStub](-booking-service-stub/index.md) : AbstractAsyncStub&lt;S&gt; <br>A stub to allow clients to do asynchronous rpc calls to service BookingService. |

## Properties

| Name | Summary |
|---|---|
| [SERVICE_NAME](-s-e-r-v-i-c-e_-n-a-m-e.md) | [java]<br>val [SERVICE_NAME](-s-e-r-v-i-c-e_-n-a-m-e.md): [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html) = &quot;BookingService&quot; |
| [serviceDescriptor](service-descriptor.md) | [java]<br>open val [serviceDescriptor](service-descriptor.md): ServiceDescriptor |

## Functions

| Name | Summary |
|---|---|
| [bindService](bind-service.md) | [java]<br>fun [bindService](bind-service.md)(service: [BookingServiceGrpc.AsyncService](-async-service/index.md)): ServerServiceDefinition |
| [getCancelBookingMethod](get-cancel-booking-method.md) | [java]<br>open fun [getCancelBookingMethod](get-cancel-booking-method.md)(): MethodDescriptor&lt;[CancelBookingRequest](../-cancel-booking-request/index.md), [BookingResponse](../-booking-response/index.md)&gt; |
| [getCreateBookingMethod](get-create-booking-method.md) | [java]<br>open fun [getCreateBookingMethod](get-create-booking-method.md)(): MethodDescriptor&lt;[CreateBookingRequest](../-create-booking-request/index.md), [BookingResponse](../-booking-response/index.md)&gt; |
| [getUpdateBookingMethod](get-update-booking-method.md) | [java]<br>open fun [getUpdateBookingMethod](get-update-booking-method.md)(): MethodDescriptor&lt;[UpdateBookingRequest](../-update-booking-request/index.md), [BookingResponse](../-booking-response/index.md)&gt; |
| [newBlockingStub](new-blocking-stub.md) | [java]<br>open fun [newBlockingStub](new-blocking-stub.md)(channel: Channel): [BookingServiceGrpc.BookingServiceBlockingStub](-booking-service-blocking-stub/index.md)<br>Creates a new blocking-style stub that supports unary and streaming output calls on the service |
| [newBlockingV2Stub](new-blocking-v2-stub.md) | [java]<br>open fun [newBlockingV2Stub](new-blocking-v2-stub.md)(channel: Channel): [BookingServiceGrpc.BookingServiceBlockingV2Stub](-booking-service-blocking-v2-stub/index.md)<br>Creates a new blocking-style stub that supports all types of calls on the service |
| [newFutureStub](new-future-stub.md) | [java]<br>open fun [newFutureStub](new-future-stub.md)(channel: Channel): [BookingServiceGrpc.BookingServiceFutureStub](-booking-service-future-stub/index.md)<br>Creates a new ListenableFuture-style stub that supports unary calls on the service |
| [newStub](new-stub.md) | [java]<br>open fun [newStub](new-stub.md)(channel: Channel): [BookingServiceGrpc.BookingServiceStub](-booking-service-stub/index.md)<br>Creates a new async stub that supports all call types for the service |