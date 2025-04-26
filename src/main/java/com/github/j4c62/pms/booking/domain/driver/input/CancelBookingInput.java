package com.github.j4c62.pms.booking.domain.driver.input;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;

public record CancelBookingInput(
    BookingId bookingId, String reason, String cancelledBy, String cancelledAt) {}
