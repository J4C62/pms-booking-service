#!/bin/bash

read -p "Ingrese el Booking ID: " bookingId
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
