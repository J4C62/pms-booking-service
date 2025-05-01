package com.github.j4c62.pms.booking.domain.aggregate.snapshot;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingStatus;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;

public record BookingSnapshot(
    BookingId bookingId,
    PropertyId propertyId,
    GuestId guestId,
    BookingDates bookingDates,
    BookingStatus status) {}
