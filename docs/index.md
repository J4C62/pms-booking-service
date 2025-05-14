---
title: "Booking Service"
author: "Jose Antonio"
date: 2025-05-14
---

# Start here

```{admonition} What is this service?
:class: tip
This service manages **hotel bookings** and interacts with other services such as availability (`pms-availability`) and billing (`pms-billing`).
````

```{contents}
---
depth: 2
local: true
---
```

---

#  How-To Guides

## Create a Booking

```{dropdown} Step-by-step to create a booking
1. The user provides the dates, guest ID, and property ID.
2. The system checks availability.
3. The booking is created in either "PENDING" or "CONFIRMED" status, depending on the payment flow.

**CreateBookingRequest**

| Field      | Type   | Description                |
|------------|--------|----------------------------|
| propertyId | string | ID of the property         |
| guestId    | string | ID of the guest            |
| startDate  | string | Start date (YYYY-MM-DD)    |
| endDate    | string | End date (YYYY-MM-DD)      |
```

## Update a Booking

```{dropdown} How to update a booking
1. The user selects the booking to update.
2. Provides new dates and a reason for the update.
3. The system updates the booking if availability allows it.

**UpdateBookingRequest**

| Field        | Type   | Description                        |
|--------------|--------|------------------------------------|
| bookingId    | string | ID of the booking                  |
| newStartDate | string | New start date                     |
| newEndDate   | string | New end date                       |
| updateReason | string | Reason for the update              |
```

## Cancel a Booking

```{dropdown} How to cancel a booking
1. The user or an external service requests cancellation.
2. The reason and initiator are recorded.
3. A cancellation event is emitted.

**CancelBookingRequest**

| Field       | Type   | Description                                |
|-------------|--------|--------------------------------------------|
| bookingId   | string | ID of the booking to cancel                |
| reason      | string | Reason for cancellation                    |
| cancelledBy | string | User or service initiating the cancellation|
| cancelledAt | string | ISO 8601 timestamp of the cancellation     |
```

## Confirm a Booking

```{dropdown} Automatic confirmation
A booking is automatically set to "CONFIRMED" status once payment is approved by `pms-billing`.
```

---

#  Technical Reference

## gRPC API - BookingService

```{list-table}
:header-rows: 1

* - Method
  - Request
  - Response
  - Description
* - CreateBooking
  - CreateBookingRequest
  - BookingResponse
  - Create a new booking
* - UpdateBooking
  - UpdateBookingRequest
  - BookingResponse
  - Update an existing booking
* - CancelBooking
  - CancelBookingRequest
  - BookingResponse
  - Cancel a booking
```

### BookingResponse

```{list-table}
:header-rows: 1

* - Field
  - Type
  - Description
* - bookingId
  - string
  - ID of the booking
* - status
  - string
  - Status ("PENDING", "CONFIRMED", "CANCELLED")
```

### CreateBookingRequest

```{list-table}
:header-rows: 1

* - Field
  - Type
  - Description
* - propertyId
  - string
  - ID of the property
* - guestId
  - string
  - ID of the guest
* - startDate
  - string
  - Start date
* - endDate
  - string
  - End date
```

### UpdateBookingRequest

```{list-table}
:header-rows: 1

* - Field
  - Type
  - Description
* - bookingId
  - string
  - ID of the booking
* - newStartDate
  - string
  - New start date
* - newEndDate
  - string
  - New end date
* - updateReason
  - string
  - Reason for the update
```

### CancelBookingRequest

```{list-table}
:header-rows: 1

* - Field
  - Type
  - Description
* - bookingId
  - string
  - ID of the booking to cancel
* - reason
  - string
  - Reason for cancellation
* - cancelledBy
  - string
  - User or service cancelling
* - cancelledAt
  - string
  - ISO 8601 timestamp
```

---

# Explanation

## System Architecture

```{note}
The service uses an **event-driven architecture** powered by **Kafka** and **Kafka Streams** as its source of truth.
```

```{important}
Every change in a booking's state is modeled as an **immutable event** and published for other microservices to consume.
```

### Key Components

* **gRPC**: API communication layer between services.
* **Kafka**: Publishes domain events on the `booking-events` topic.
* **Kafka Streams**: Maintains state consistency without a traditional database.
* **Immutability**: Each booking state is represented as a new event.

---

#  Tutorials

```{admonition} Coming Soon
:class: warning
Step-by-step tutorials for real-world scenarios will be added soon, such as:
- Integrating with the availability system (`pms-availability`)
- Automatic cancellation workflows
- Billing flows linked to bookings
```

```

