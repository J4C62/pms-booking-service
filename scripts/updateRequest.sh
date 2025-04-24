#!/bin/bash

 grpcurl -plaintext \
  -d '{
    "bookingId": "ZDFhYTg4ZjEtY2M5Ni00ZGIyLThmMWItZmEyOGM2ZGJmNjA4",
    "newStartDate": "2025-06-10",
    "newEndDate": "2025-06-12",
    "updateReason": "I can not go"
  }' \
  localhost:9090 BookingService/UpdateBooking