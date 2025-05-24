//[pms-booking-service](../../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.grpc](../../index.md)/[BookingServiceGrpc](../index.md)/[BookingServiceBlockingV2Stub](index.md)

# BookingServiceBlockingV2Stub

[java]\
class [BookingServiceBlockingV2Stub](index.md) : AbstractBlockingStub&lt;S&gt; 

A stub to allow clients to do synchronous rpc calls to service BookingService. 

```kotlin

BookingService defines RPC operations to create, update and cancel bookings.

```

## Properties

| Name | Summary |
|---|---|
| [callOptions](../-booking-service-future-stub/index.md#1161172963%2FProperties%2F-1170581573) | [java]<br>val [callOptions](../-booking-service-future-stub/index.md#1161172963%2FProperties%2F-1170581573): CallOptions |
| [channel](../-booking-service-future-stub/index.md#-1460774496%2FProperties%2F-1170581573) | [java]<br>val [channel](../-booking-service-future-stub/index.md#-1460774496%2FProperties%2F-1170581573): Channel |

## Functions

| Name | Summary |
|---|---|
| [cancelBooking](cancel-booking.md) | [java]<br>open fun [cancelBooking](cancel-booking.md)(request: [CancelBookingRequest](../../-cancel-booking-request/index.md)): [BookingResponse](../../-booking-response/index.md) |
| [createBooking](create-booking.md) | [java]<br>open fun [createBooking](create-booking.md)(request: [CreateBookingRequest](../../-create-booking-request/index.md)): [BookingResponse](../../-booking-response/index.md) |
| [newStub](../-booking-service-blocking-stub/index.md#-282926888%2FFunctions%2F-1170581573) | [java]<br>open fun &lt;[T](../-booking-service-blocking-stub/index.md#-282926888%2FFunctions%2F-1170581573) : AbstractStub&lt;[T](../-booking-service-blocking-stub/index.md#-282926888%2FFunctions%2F-1170581573)&gt;?&gt; [newStub](../-booking-service-blocking-stub/index.md#-282926888%2FFunctions%2F-1170581573)(p: AbstractStub.StubFactory&lt;[T](../-booking-service-blocking-stub/index.md#-282926888%2FFunctions%2F-1170581573)&gt;, p1: Channel): [T](../-booking-service-blocking-stub/index.md#-282926888%2FFunctions%2F-1170581573) |
| [updateBooking](update-booking.md) | [java]<br>open fun [updateBooking](update-booking.md)(request: [UpdateBookingRequest](../../-update-booking-request/index.md)): [BookingResponse](../../-booking-response/index.md) |
| [withCallCredentials](../-booking-service-future-stub/index.md#-1294232735%2FFunctions%2F-1170581573) | [java]<br>fun [withCallCredentials](../-booking-service-future-stub/index.md#-1294232735%2FFunctions%2F-1170581573)(p: CallCredentials): S |
| [withChannel](../-booking-service-future-stub/index.md#1557089985%2FFunctions%2F-1170581573) | [java]<br>fun [withChannel](../-booking-service-future-stub/index.md#1557089985%2FFunctions%2F-1170581573)(p: Channel): S |
| [withCompression](../-booking-service-future-stub/index.md#-843793794%2FFunctions%2F-1170581573) | [java]<br>fun [withCompression](../-booking-service-future-stub/index.md#-843793794%2FFunctions%2F-1170581573)(p: [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html)): S |
| [withDeadline](../-booking-service-future-stub/index.md#1423577849%2FFunctions%2F-1170581573) | [java]<br>fun [withDeadline](../-booking-service-future-stub/index.md#1423577849%2FFunctions%2F-1170581573)(p: Deadline): S |
| [withDeadlineAfter](../-booking-service-future-stub/index.md#1521015588%2FFunctions%2F-1170581573) | [java]<br>fun [withDeadlineAfter](../-booking-service-future-stub/index.md#1521015588%2FFunctions%2F-1170581573)(p: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), p1: [TimeUnit](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/concurrent/TimeUnit.html)): S |
| [withExecutor](../-booking-service-future-stub/index.md#1204550138%2FFunctions%2F-1170581573) | [java]<br>fun [withExecutor](../-booking-service-future-stub/index.md#1204550138%2FFunctions%2F-1170581573)(p: [Executor](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/concurrent/Executor.html)): S |
| [withInterceptors](../-booking-service-future-stub/index.md#532964903%2FFunctions%2F-1170581573) | [java]<br>fun [withInterceptors](../-booking-service-future-stub/index.md#532964903%2FFunctions%2F-1170581573)(p: [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;ClientInterceptor&gt;): S |
| [withMaxInboundMessageSize](../-booking-service-future-stub/index.md#1309462429%2FFunctions%2F-1170581573) | [java]<br>fun [withMaxInboundMessageSize](../-booking-service-future-stub/index.md#1309462429%2FFunctions%2F-1170581573)(p: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): S |
| [withMaxOutboundMessageSize](../-booking-service-future-stub/index.md#-455319018%2FFunctions%2F-1170581573) | [java]<br>fun [withMaxOutboundMessageSize](../-booking-service-future-stub/index.md#-455319018%2FFunctions%2F-1170581573)(p: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): S |
| [withOnReadyThreshold](../-booking-service-future-stub/index.md#865100489%2FFunctions%2F-1170581573) | [java]<br>fun [withOnReadyThreshold](../-booking-service-future-stub/index.md#865100489%2FFunctions%2F-1170581573)(p: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): S |
| [withOption](../-booking-service-future-stub/index.md#1975717102%2FFunctions%2F-1170581573) | [java]<br>fun &lt;[T](../-booking-service-future-stub/index.md#1975717102%2FFunctions%2F-1170581573)&gt; [withOption](../-booking-service-future-stub/index.md#1975717102%2FFunctions%2F-1170581573)(p: CallOptions.Key&lt;[T](../-booking-service-future-stub/index.md#1975717102%2FFunctions%2F-1170581573)&gt;, p1: [T](../-booking-service-future-stub/index.md#1975717102%2FFunctions%2F-1170581573)): S |
| [withWaitForReady](../-booking-service-future-stub/index.md#-383345726%2FFunctions%2F-1170581573) | [java]<br>fun [withWaitForReady](../-booking-service-future-stub/index.md#-383345726%2FFunctions%2F-1170581573)(): S |