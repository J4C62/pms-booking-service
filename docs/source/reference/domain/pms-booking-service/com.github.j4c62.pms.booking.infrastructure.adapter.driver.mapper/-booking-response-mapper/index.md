//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper](../index.md)/[BookingResponseMapper](index.md)

# BookingResponseMapper

[java]\
interface [BookingResponseMapper](index.md)

Mapper interface for converting domain-level [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md) objects into gRPC `
BookingResponse` messages. 

This mapper is used by the  to translate the result of command executions into the appropriate gRPC response payloads. 

Implemented automatically by MapStruct. Any unmapped properties on either source or target are ignored to allow forward compatibility.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-18

## Functions

| Name | Summary |
|---|---|
| [toResponse](to-response.md) | [java]<br>abstract fun [toResponse](to-response.md)(output: [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)): [BookingResponse](../../com.github.j4c62.pms.booking.infrastructure.provider.grpc/-booking-response/index.md)<br>Converts a [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md) into a gRPC `BookingResponse`. |