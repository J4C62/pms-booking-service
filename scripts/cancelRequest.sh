#!/bin/bash

read -p "Ingrese el Booking ID: " bookingIdB64
bookingId=$(echo "$bookingIdB64" | base64 --decode)

cancelledAt=$(date +"%Y-%m-%d")

read -p "Ingrese el motivo de la cancelación: " reason

cancelledBy="J4ck"

grpcurl -plaintext \
  -d '{
    "bookingId": "'"$bookingId"'",
    "reason": "'"$reason"'",
    "cancelledBy": "'"$cancelledBy"'",
    "cancelledAt": "'"$cancelledAt"'"
  }' \
  localhost:9090 BookingService/CancelBooking
