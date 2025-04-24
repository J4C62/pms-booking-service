package com.github.j4c62.pms.booking.domain.driver.input;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingDates;
import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingId;

public class UpdateBookingInput {
  private BookingId bookingId;
  private BookingDates bookingDates;
  private String updateReason;
  private String updateAt;

  public BookingId getBookingId() {
    return bookingId;
  }

  public void setBookingId(BookingId bookingId) {
    this.bookingId = bookingId;
  }

  public BookingDates getBookingDates() {
    return bookingDates;
  }

  public void setBookingDates(BookingDates bookingDates) {
    this.bookingDates = bookingDates;
  }

  public String getUpdateReason() {
    return updateReason;
  }

  public void setUpdateReason(String updateReason) {
    this.updateReason = updateReason;
  }

  public String getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(String updateAt) {
    this.updateAt = updateAt;
  }
}
