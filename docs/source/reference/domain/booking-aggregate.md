# BookingAggregate

*Represents the aggregate root for a booking in the domain model*

This class encapsulates the state and behavior of a booking, including operations such as creation, confirmation,
cancellation, and date updates. It is designed to be restored from a sequence of domain events (event sourcing pattern).

```{list-table} Parameters for BookingAggregate
* - Param
  - Description
* - bookingId
  - The unique identifier of the booking.
* - propertyId
  - The identifier of the property being booked.
* - guestId
  - The identifier of the guest who made the booking.
* - bookingDates
  - The dates associated with the booking (check-in, check-out).
* - status
  - The current status of the booking (e.g., PENDING, CONFIRMED, CANCELLED).
* - bookingEvents
  - The list of domain events related to the booking.
````

**Author:** Jose Antonio (J4c62)
**Version:** 1.0.0
**Since:** 2025-04-23

---

## Methods

### `restoreFrom(events)`

Reconstructs a `BookingAggregate` from a list of domain events.

```{list-table} restoreFrom
* - Param
  - Description
* - events
  - The list of events from which to restore the aggregate.
```

**Returns:** `BookingAggregate`
**Throws:**

* `IllegalArgumentException` if the event list is empty.
* `IllegalStateException` if the first event is not a `BookingCreatedEvent`.
  **Since:** 2025-05-03

---

### `cancel()`

Cancels the booking.

```{list-table} cancel
* - Returns
  - A new `BookingAggregate` with updated status and cancellation event.
* - Throws
  - `IllegalStateException` if the booking is already cancelled.
```

**Since:** 2025-04-23

---

### `confirm()`

Confirms the booking.

```{list-table} confirm
* - Returns
  - A new `BookingAggregate` with updated status and confirmation event.
* - Throws
  - `IllegalStateException` if the booking has already been cancelled.
```

**Since:** 2025-05-10

---

### `updateDates(newDates)`

Updates the booking dates.

```{list-table} updateDates
* - Param
  - Description
* - newDates
  - The new dates for the booking.
* - Returns
  - A new `BookingAggregate` with updated dates and event.
* - Throws
  - `IllegalStateException` if the booking is cancelled or the dates have not changed.
```

**Since:** 2025-04-23

