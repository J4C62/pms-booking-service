//[srcMain](../../../index.md)/[com.github.j4c62.pms.booking.infrastructure.adapter.driver.mapper](../index.md)/[BookingResponseMapper](index.md)/[toResponse](to-response.md)

# toResponse

[src]\
abstract fun [toResponse](to-response.md)(
output: [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)):
BookingResponse

Converts a [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md) into a gRPC
`BookingResponse`.

#### Return

the gRPC-compatible response

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-18

#### Parameters

src

|        |                          |
|--------|--------------------------|
| output | the domain output object |