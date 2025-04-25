#!/bin/bash

 grpcurl -plaintext \
  -d '{
    "bookingId": "35c426f1-eb41-4de0-bf61-a760cff2c48e",
    "newStartDate": "2025-06-10",
    "newEndDate": "2025-06-12",
    "updateReason": "I can not go"
  }' \
  localhost:9090 BookingService/UpdateBooking