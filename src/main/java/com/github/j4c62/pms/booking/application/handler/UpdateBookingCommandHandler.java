package com.github.j4c62.pms.booking.application.handler;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingEventMapper;
import com.github.j4c62.pms.booking.domain.driver.action.BookingUpdater;
import com.github.j4c62.pms.booking.domain.driver.input.UpdateBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import com.github.j4c62.pms.booking.domain.model.BookingStatus;
import org.springframework.stereotype.Service;

@Service
public class UpdateBookingCommandHandler extends AbstractBookingCommandHandler
    implements BookingUpdater {

  public UpdateBookingCommandHandler(
      BookingRepository bookingRepository,
      BookingEventPublisher eventPublisher,
      BookingEventMapper eventMapper) {
    super(bookingRepository, eventPublisher, eventMapper);
  }

  @Override
  public BookingOutput update(UpdateBookingInput updateBookingInput) {
    var affectedRows = getAffectedRows(updateBookingInput);
    assertAffectedRows(updateBookingInput.getBookingId(), affectedRows, "updated");
    eventPublisher.publishBookingUpdated(eventMapper.toBookingUpdated(updateBookingInput));
    return new BookingOutput(updateBookingInput.getBookingId(), BookingStatus.PENDING);
  }

  private int getAffectedRows(UpdateBookingInput updateBookingInput) {
    return bookingRepository.updateBookingDates(
        updateBookingInput.getBookingId(),
        updateBookingInput.getNewStartDate(),
        updateBookingInput.getNewEndDate());
  }
}
