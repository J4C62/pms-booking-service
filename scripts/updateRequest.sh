#!/bin/bash

 grpcurl -plaintext \
  -d '{
    "bookingId": "e283414a-18f5-4cd8-8bd3-759c83493dfe",
    "newStartDate": "2025-06-10",
    "newEndDate": "2025-06-12",
    "updateReason": "I can not go"
  }' \
  localhost:9090 BookingService/UpdateBooking