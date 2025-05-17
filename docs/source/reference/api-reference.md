# API Reference

Complete reference documentation for the PMS Booking Service API

::::::::{tab-set}
:::::::{tab-item} Overview
::::::{card}
:class-header: sd-bg-light sd-bg-dark:dark sd-text-black sd-text-white:dark

**API Overview** \
*The PMS Booking Service API allows you to programmatically access and manage bookings*
^^^^^^
The API is built using gRPC, a high-performance, open-source universal RPC framework. It uses Protocol Buffers (
Protobuf) for message serialization and supports features like bi-directional streaming, strongly typed contracts, and
efficient binary communication. Authentication, request/response structures, and service definitions are managed through
.proto files, and communication occurs over HTTP/2.

### Base URL

`https://localhost:9090/`

::::
:::::
::::::
:::::::

:::::::{tab-item} Authentication
::::::{card} Auth
:class-header: sd-bg-light sd-bg-dark:dark sd-text-black sd-text-white:dark


:::{attention}
Add info about TLS, mTLS, API keys, tokens, or certificates as needed.
:::
️
:::::
:::::
::::::
:::::::

:::::::{tab-item} Endpoints
::::::{card}
:class-header: sd-bg-light sd-bg-dark:dark sd-text-black sd-text-white:dark

**API Endpoints** \
*Complete list of available API endpoints*
^^^^^^^

```{list-table} Remote procedure calls
* - Method 
  - Request
  - Message
  - Description
* - BookingService/CreateBooking	
  - CreateBookingRequest
  - BookingResponse
  - Create a new booking
* - BookingService/CancelBooking
  - CancelBookingRequest
  - BookingResponse
  - Cancel an existing booking
* - BookingService/UpdateBooking
  - UpdateBookingRequest
  - BookingResponse
  - Update the dates of a booking
  
```

### BookingService

BookingService defines RPC operations to create, update and cancel bookings.

| Method Name   | Request Type         | Response Type   | Description                   |  
|---------------|----------------------|-----------------|-------------------------------|  
| CreateBooking | CreateBookingRequest | BookingResponse | Create a new booking          |  
| CancelBooking | CancelBookingRequest | BookingResponse | Cancel an existing booking    |  
| UpdateBooking | UpdateBookingRequest | BookingResponse | Update the dates of a booking |

### BookingResponse

Response containing the result of a booking operation.

| Field     | Type   | Description                                                                                |     
|-----------|--------|--------------------------------------------------------------------------------------------|
| bookingId | string | ID UUID type of the booking affected by the operation.                                     |     
| status    | string | Status of the booking (e.g., &#34;CONFIRMED&#34;, &#34;CANCELLED&#34;, &#34;UPDATED&#34;). |     

### CancelBookingRequest

Request for cancelling an existing booking.

| Field       | Type   | Description                                                                        |
|-------------|--------|------------------------------------------------------------------------------------|
| bookingId   | string | ID UUID type of the booking to cancel.                                             |
| reason      | string | Reason for cancelling the booking.                                                 |
| cancelledBy | string | Identifier of the user or service initiating the cancellation.                     |
| cancelledAt | string | ISO 8601 timestamp of when the booking was cancelled (e.g., 2025-05-14T10:00:00Z). |

### CreateBookingRequest

Request for creating a booking.

| Field      | Type   | Description                                     |  
|------------|--------|-------------------------------------------------|  
| propertyId | string | ID UUID of the property being booked .          |  
| guestId    | string | ID UUID of the guest making the booking.        |  
| startDate  | string | Start date of the booking in YYYY-MM-DD format. |  
| endDate    | string | End date of the booking in YYYY-MM-DD format.   |  

### UpdateBookingRequest

Request to update the dates of an existing booking.

| Field        | Type   | Description                                  |  
|--------------|--------|----------------------------------------------|  
| bookingId    | string | ID UUID of the booking to update.            |  
| newStartDate | string | New start date for the booking (YYYY-MM-DD). |  
| newEndDate   | string | New end date for the booking (YYYY-MM-DD).   |  
| updateReason | string | Reason for updating the booking dates.       |  

::::::
:::::::

:::::::{tab-item} Example
::::::{card}
:class-header: sd-bg-light sd-bg-dark:dark sd-text-black sd-text-white:dark


**API Examples**  \
*Code examples for common API operations*
^^^^^^^

## Create a Booking

# Example: Create a booking using gRPC CLI or client stub

::::{tab-set}
:::{tab-item} gpCurl

```sh
grpcurl -d '{
"propertyId": "201fc7e8-aed3-4f8c-8998-acce82783ce2",
"guestId": "5724287e-ac14-4cb3-9d6f-4a4825e3dd40",
"startDate": "2025-07-01",
"endDate": "2025-07-05"
}' -plaintext localhost:9090 BookingService/CreateBooking

```

:::
:::{tab-item} Python

```python
import grpc
import booking_pb2
import booking_pb2_grpc

channel = grpc.insecure_channel("localhost:9090")
stub = booking_pb2_grpc.BookingServiceStub(channel)

request = booking_pb2.CreateBookingRequest(
    propertyId="201fc7e8-aed3-4f8c-8998-acce82783ce2",
    guestId="5724287e-ac14-4cb3-9d6f-4a4825e3dd40",
    startDate="2025-07-01",
    endDate="2025-07-05"
)

response = stub.CreateBooking(request)
print(response)
```

:::
:::{tab-item} JavaScript

```js
const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');

const packageDef = protoLoader.loadSync('booking.proto');
const bookingProto = grpc.loadPackageDefinition(packageDef).BookingService;

const client = new bookingProto('localhost:9090', grpc.credentials.createInsecure());

client.CreateBooking({
  propertyId: '201fc7e8-aed3-4f8c-8998-acce82783ce2',
  guestId: '5724287e-ac14-4cb3-9d6f-4a4825e3dd40',
  startDate: '2025-07-01',
  endDate: '2025-07-05'
}, (err, response) => {
  if (err) console.error(err);
  else console.log(response);
});

```

:::
::::

## Update a Booking

# Example: Update the dates of a booking by Booking Id using gRPC CLI or client stub

::::{tab-set}
:::{tab-item} gpCurl

```sh
grpcurl -plaintext \
  -d '{
    "bookingId": "f403e84a-7ece-4605-b830-59b303cf0dc4",
    "newStartDate": "2025-06-10",
    "newEndDate": "2025-06-12",
    "updateReason": "I want to stay more time"
  }' \
  localhost:9090 BookingService/UpdateBooking


```

:::
:::{tab-item} Python

```python
import grpc
import booking_pb2
import booking_pb2_grpc

channel = grpc.insecure_channel("localhost:9090")
stub = booking_pb2_grpc.BookingServiceStub(channel)

request = booking_pb2.UpdateBookingRequest(
    bookingId="f403e84a-7ece-4605-b830-59b303cf0dc4",
    newStartDate="2025-06-10",
    newEndDate="2025-06-12",
    updateReason="I want to stay more time"

)

response = stub.UpdateBookingRequest(request)
print(response)
```

:::
:::{tab-item} JavaScript

```js
const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');

const packageDef = protoLoader.loadSync('booking.proto');
const bookingProto = grpc.loadPackageDefinition(packageDef).BookingService;

const client = new bookingProto('localhost:9090', grpc.credentials.createInsecure());

client.UpdateBooking({
    bookingId: 'f403e84a-7ece-4605-b830-59b303cf0dc4',
    newStartDate: '2025-06-10',
    newEndDate: '2025-06-12',
    updateReason: 'I want to stay more time'

}, (err, response) => {
  if (err) console.error(err);
  else console.log(response);
});

```

:::
::::
::::

## Cancel a Booking

# Example: Cancel a booking by Booking Id using gRPC CLI or client stub

::::{tab-set}
:::{tab-item} gpCurl

```sh
grpcurl -plaintext \
  -d '{
    "bookingId": "f403e84a-7ece-4605-b830-59b303cf0dc4",
    "reason": "Fly delayed",
    "cancelledBy": "Jhon Doe",
    "cancelledAt": "2025-05-17"
  }' \
  localhost:9090 BookingService/CancelBooking


```

:::
:::{tab-item} Python

```python
import grpc
import booking_pb2
import booking_pb2_grpc

channel = grpc.insecure_channel("localhost:9090")
stub = booking_pb2_grpc.BookingServiceStub(channel)

request = booking_pb2.CancelBookingRequest(
    bookingId="f403e84a-7ece-4605-b830-59b303cf0dc4",
    reason="Fly delayed",
    cancelledBy="Jhon Doe",
    cancelledAt="2025-05-17"

)

response = stub.CancelBookingRequest(request)
print(response)
```

:::
:::{tab-item} JavaScript

```js
const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');

const packageDef = protoLoader.loadSync('booking.proto');
const bookingProto = grpc.loadPackageDefinition(packageDef).BookingService;

const client = new bookingProto('localhost:9090', grpc.credentials.createInsecure());

client.CancelBooking({
    bookingId: 'f403e84a-7ece-4605-b830-59b303cf0dc4',
    reason: 'Fly delayed',
    cancelledBy: 'Jhon Doe',
    cancelledAt: '2025-05-17'

}, (err, response) => {
  if (err) console.error(err);
  else console.log(response);
});

```

:::
::::

::::::
:::::::

::::::::

::::::
:::::::

::::::::

