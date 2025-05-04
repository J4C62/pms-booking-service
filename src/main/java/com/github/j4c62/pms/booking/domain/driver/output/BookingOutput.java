package com.github.j4c62.pms.booking.domain.driver.output;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus;

public record BookingOutput(BookingId bookingId, BookingStatus status) {}
