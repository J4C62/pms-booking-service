package com.github.j4c62.pms.booking.domain.driver.input;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;

public record UpdateBookingInput(
    BookingId bookingId, BookingDates bookingDates, String updateReason, String updateAt) {}
