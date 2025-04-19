package com.github.j4c62.pms.booking.domain.driver.input;

import java.util.UUID;

public class UpdateBookingInput {
  private UUID bookingId;
  private String newStartDate;
  private String newEndDate;
  private String updateReason;
  private String updateAt;

  public UUID getBookingId() {
    return bookingId;
  }

  public void setBookingId(UUID bookingId) {
    this.bookingId = bookingId;
  }

  public String getNewStartDate() {
    return newStartDate;
  }

  public void setNewStartDate(String newStartDate) {
    this.newStartDate = newStartDate;
  }

  public String getNewEndDate() {
    return newEndDate;
  }

  public void setNewEndDate(String newEndDate) {
    this.newEndDate = newEndDate;
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
