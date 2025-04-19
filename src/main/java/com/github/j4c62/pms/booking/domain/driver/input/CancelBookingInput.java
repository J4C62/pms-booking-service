package com.github.j4c62.pms.booking.domain.driver.input;

import java.util.UUID;

public class CancelBookingInput {
  private UUID bookingId;
  private String reason;
  private String cancelledBy;
  private String cancelledAt;

  public UUID getBookingId() {
    return bookingId;
  }

  public void setBookingId(UUID bookingId) {
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

  public String getCancelledAt() {
    return cancelledAt;
  }

  public void setCancelledAt(String cancelledAt) {
    this.cancelledAt = cancelledAt;
  }
}
