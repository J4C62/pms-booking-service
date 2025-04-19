package com.github.j4c62.pms.booking.domain.driver.input;

public class CancelBookingInput {
  private String bookingId;
  private String reason;
  private String cancelledBy;

  public String getBookingId() {
    return bookingId;
  }

  public void setBookingId(String bookingId) {
    this.bookingId = bookingId;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getCancelledBy() {
    return cancelledBy;
  }

  public void setCancelledBy(String cancelledBy) {
    this.cancelledBy = cancelledBy;
  }
}
