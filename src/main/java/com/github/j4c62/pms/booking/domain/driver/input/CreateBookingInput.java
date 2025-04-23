package com.github.j4c62.pms.booking.domain.driver.input;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.GuestId;
import com.github.j4c62.pms.booking.domain.aggregate.vo.PropertyId;

public class CreateBookingInput {
  private PropertyId propertyId;
  private GuestId guestId;
  private BookingDates bookingDates;

  public PropertyId getPropertyId() {
    return propertyId;
  }

  public void setPropertyId(PropertyId propertyId) {
    this.propertyId = propertyId;
  }

  public GuestId getGuestId() {
    return guestId;
  }

  public void setGuestId(GuestId guestId) {
    this.guestId = guestId;
  }

  public BookingDates getBookingDates() {
    return bookingDates;
  }

  public void setBookingDates(BookingDates bookingDates) {
    this.bookingDates = bookingDates;
  }
}
