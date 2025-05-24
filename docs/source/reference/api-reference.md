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

| Field      | Type   | Description                                                                                |     
|------------|--------|--------------------------------------------------------------------------------------------|
| booking_id | string | ID UUID type of the booking affected by the operation.                                     |     
| status     | string | Status of the booking (e.g., &#34;CONFIRMED&#34;, &#34;CANCELLED&#34;, &#34;UPDATED&#34;). |     

### CancelBookingRequest

Request for cancelling an existing booking.

| Field      | Type   | Description                            |
|------------|--------|----------------------------------------|
| booking_id | string | ID UUID type of the booking to cancel. |
| guest_id   | string | ID of the guest cancel the booking.    |
| reason     | string | Reason for cancelling the booking.     |

### CreateBookingRequest

Request for creating a booking.

| Field       | Type   | Description                                     |  
|-------------|--------|-------------------------------------------------|  
| property_id | string | ID UUID of the property being booked .          |  
| guest_id    | string | ID UUID of the guest making the booking.        |  
| start_date  | string | Start date of the booking in YYYY-MM-DD format. |  
| end_date    | string | End date of the booking in YYYY-MM-DD format.   |  

### UpdateBookingRequest

Request to update the dates of an existing booking.

| Field          | Type   | Description                                  |  
|----------------|--------|----------------------------------------------|  
| booking_id     | string | ID UUID of the booking to update.            |  
| guest_id       | string | ID of the guest cancel the booking.          |
| new_start_date | string | New start date for the booking (YYYY-MM-DD). |  
| new_end_date   | string | New end date for the booking (YYYY-MM-DD).   |  
| updateReason   | string | Reason for updating the booking dates.       |  

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
"property_id": "201fc7e8-aed3-4f8c-8998-acce82783ce2",
"guest_id": "5724287e-ac14-4cb3-9d6f-4a4825e3dd40",
"start_date": "2025-07-01",
"end_date": "2025-07-05"
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
    property_id="201fc7e8-aed3-4f8c-8998-acce82783ce2",
    guest_id="5724287e-ac14-4cb3-9d6f-4a4825e3dd40",
    start_date="2025-07-01",
    end_date="2025-07-05"
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
  property_id: '201fc7e8-aed3-4f8c-8998-acce82783ce2',
  guest_id: '5724287e-ac14-4cb3-9d6f-4a4825e3dd40',
  start_date: '2025-07-01',
  end_date: '2025-07-05'
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
    "booking_id": "f403e84a-7ece-4605-b830-59b303cf0dc4",
    "guest_id: "5724287e-ac14-4cb3-9d6f-4a4825e3dd40",
    "new_start_date": "2025-06-10",
    "new_end_date": "2025-06-12",
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
    booking_id="f403e84a-7ece-4605-b830-59b303cf0dc4",
    guest_id="5724287e-ac14-4cb3-9d6f-4a4825e3dd40",
    new_start_date="2025-06-10",
    new_end_date="2025-06-12",
    update_reason="I want to stay more time"

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
    booking_id: 'f403e84a-7ece-4605-b830-59b303cf0dc4',
    guest_id: '5724287e-ac14-4cb3-9d6f-4a4825e3dd40',
    new_start_date: '2025-06-10',
    new_end_date: '2025-06-12',
    update_reason: 'I want to stay more time'

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
    "booking_id": "f403e84a-7ece-4605-b830-59b303cf0dc4",
    "guest_id": "5724287e-ac14-4cb3-9d6f-4a4825e3dd40",
    "reason": "Fly delayed",
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
    booking_id="f403e84a-7ece-4605-b830-59b303cf0dc4",
    guest_id= "5724287e-ac14-4cb3-9d6f-4a4825e3dd40",
    reason="Fly delayed",

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
    booking_id: 'f403e84a-7ece-4605-b830-59b303cf0dc4',
    guest_id: '5724287e-ac14-4cb3-9d6f-4a4825e3dd40',
    reason: 'Fly delayed',

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

