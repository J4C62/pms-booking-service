#!/bin/bash

 grpcurl -plaintext \
  -d '{
    "bookingId": "29f3f72e-c26a-48c6-80db-f1b6a23bb2aa",
    "newStartDate": "2025-06-10",
    "newEndDate": "2025-06-12",
    "updateReason": "I can not go"
  }' \
  localhost:9090 BookingService/UpdateBooking