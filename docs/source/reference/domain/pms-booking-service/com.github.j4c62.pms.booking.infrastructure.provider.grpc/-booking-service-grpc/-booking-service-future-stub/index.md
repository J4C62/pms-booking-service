//[pms-booking-service](../../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.provider.grpc](../../index.md)/[BookingServiceGrpc](../index.md)/[BookingServiceFutureStub](index.md)

# BookingServiceFutureStub

[java]\
class [BookingServiceFutureStub](index.md) : AbstractFutureStub&lt;S&gt; 

A stub to allow clients to do ListenableFuture-style rpc calls to service BookingService. 

```kotlin

BookingService defines RPC operations to create, update and cancel bookings.

```

## Properties

| Name | Summary |
|---|---|
| [callOptions](index.md#1161172963%2FProperties%2F-1170581573) | [java]<br>val [callOptions](index.md#1161172963%2FProperties%2F-1170581573): CallOptions |
| [channel](index.md#-1460774496%2FProperties%2F-1170581573) | [java]<br>val [channel](index.md#-1460774496%2FProperties%2F-1170581573): Channel |

## Functions

| Name | Summary |
|---|---|
| [cancelBooking](cancel-booking.md) | [java]<br>open fun [cancelBooking](cancel-booking.md)(request: [CancelBookingRequest](../../-cancel-booking-request/index.md)): ListenableFuture&lt;[BookingResponse](../../-booking-response/index.md)&gt; |
| [createBooking](create-booking.md) | [java]<br>open fun [createBooking](create-booking.md)(request: [CreateBookingRequest](../../-create-booking-request/index.md)): ListenableFuture&lt;[BookingResponse](../../-booking-response/index.md)&gt; |
| [newStub](index.md#-1768140982%2FFunctions%2F-1170581573) | [java]<br>open fun &lt;[T](index.md#-1768140982%2FFunctions%2F-1170581573) : AbstractStub&lt;[T](index.md#-1768140982%2FFunctions%2F-1170581573)&gt;?&gt; [newStub](index.md#-1768140982%2FFunctions%2F-1170581573)(p: AbstractStub.StubFactory&lt;[T](index.md#-1768140982%2FFunctions%2F-1170581573)&gt;, p1: Channel): [T](index.md#-1768140982%2FFunctions%2F-1170581573) |
| [updateBooking](update-booking.md) | [java]<br>open fun [updateBooking](update-booking.md)(request: [UpdateBookingRequest](../../-update-booking-request/index.md)): ListenableFuture&lt;[BookingResponse](../../-booking-response/index.md)&gt; |
| [withCallCredentials](index.md#-1294232735%2FFunctions%2F-1170581573) | [java]<br>fun [withCallCredentials](index.md#-1294232735%2FFunctions%2F-1170581573)(p: CallCredentials): S |
| [withChannel](index.md#1557089985%2FFunctions%2F-1170581573) | [java]<br>fun [withChannel](index.md#1557089985%2FFunctions%2F-1170581573)(p: Channel): S |
| [withCompression](index.md#-843793794%2FFunctions%2F-1170581573) | [java]<br>fun [withCompression](index.md#-843793794%2FFunctions%2F-1170581573)(p: [String](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html)): S |
| [withDeadline](index.md#1423577849%2FFunctions%2F-1170581573) | [java]<br>fun [withDeadline](index.md#1423577849%2FFunctions%2F-1170581573)(p: Deadline): S |
| [withDeadlineAfter](index.md#1521015588%2FFunctions%2F-1170581573) | [java]<br>fun [withDeadlineAfter](index.md#1521015588%2FFunctions%2F-1170581573)(p: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), p1: [TimeUnit](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/concurrent/TimeUnit.html)): S |
| [withExecutor](index.md#1204550138%2FFunctions%2F-1170581573) | [java]<br>fun [withExecutor](index.md#1204550138%2FFunctions%2F-1170581573)(p: [Executor](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/concurrent/Executor.html)): S |
| [withInterceptors](index.md#532964903%2FFunctions%2F-1170581573) | [java]<br>fun [withInterceptors](index.md#532964903%2FFunctions%2F-1170581573)(p: [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;ClientInterceptor&gt;): S |
| [withMaxInboundMessageSize](index.md#1309462429%2FFunctions%2F-1170581573) | [java]<br>fun [withMaxInboundMessageSize](index.md#1309462429%2FFunctions%2F-1170581573)(p: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): S |
| [withMaxOutboundMessageSize](index.md#-455319018%2FFunctions%2F-1170581573) | [java]<br>fun [withMaxOutboundMessageSize](index.md#-455319018%2FFunctions%2F-1170581573)(p: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): S |
| [withOnReadyThreshold](index.md#865100489%2FFunctions%2F-1170581573) | [java]<br>fun [withOnReadyThreshold](index.md#865100489%2FFunctions%2F-1170581573)(p: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): S |
| [withOption](index.md#1975717102%2FFunctions%2F-1170581573) | [java]<br>fun &lt;[T](index.md#1975717102%2FFunctions%2F-1170581573)&gt; [withOption](index.md#1975717102%2FFunctions%2F-1170581573)(p: CallOptions.Key&lt;[T](index.md#1975717102%2FFunctions%2F-1170581573)&gt;, p1: [T](index.md#1975717102%2FFunctions%2F-1170581573)): S |
| [withWaitForReady](index.md#-383345726%2FFunctions%2F-1170581573) | [java]<br>fun [withWaitForReady](index.md#-383345726%2FFunctions%2F-1170581573)(): S |