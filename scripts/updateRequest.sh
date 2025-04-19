#!/bin/bash

 grpcurl -plaintext \
  -d '{
    "bookingId": "acd4a50d-a3e9-4858-9ad8-98495405441a",
    "newStartDate": "2025-06-10",
    "newEndDate": "2025-06-12",
    "updateReason": "I can not go"
  }' \
  localhost:9090 BookingService/UpdateBooking