package com.github.j4c62.pms.booking.domain.driver.input;

public class UpdateBookingInput {
  private String bookingId;
  private String newStartDate;
  private String newEndDate;
  private String updateReason;

  public String getBookingId() {
    return bookingId;
  }

  public void setBookingId(String bookingId) {
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
}
