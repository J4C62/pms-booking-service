#!/bin/bash


propertyId=$(uuidgen | tr -d '-' | xxd -r -p | base64)
guestId=$(uuidgen | tr -d '-' | xxd -r -p | base64)

startDate=$(date -d "2025-06-01" '+%Y-%m-%d')
endDate=$(date -d "2025-06-07" '+%Y-%m-%d')

grpcurl -plaintext \
  -d "{
    \"propertyId\": \"$propertyId\",
    \"guestId\": \"$guestId\",
    \"startDate\": \"$startDate\",
    \"endDate\": \"$endDate\"
  }" \
  localhost:9090 BookingService/CreateBooking
