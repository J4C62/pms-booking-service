#!/bin/bash
read -p "Ingrese el Booking ID (base64): " bookingIdB64
bookingId=$(echo "$bookingIdB64" | base64 --decode)

grpcurl -plaintext \
  -d '{
    "bookingId": "'"$bookingId"'",
    "newStartDate": "2025-06-10",
    "newEndDate": "2025-06-12",
    "updateReason": "I can not go"
  }' \
  localhost:9090 BookingService/UpdateBooking
