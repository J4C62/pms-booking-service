package com.github.j4c62.pms.booking.application.handler;

import static com.github.j4c62.pms.booking.domain.model.BookingStatus.CANCELLED;

import com.github.j4c62.pms.booking.application.creation.mapper.BookingEventMapper;
import com.github.j4c62.pms.booking.domain.driver.action.BookingCanceller;
import com.github.j4c62.pms.booking.domain.driver.input.CancelBookingInput;
import com.github.j4c62.pms.booking.domain.driver.output.BookingOutput;
import com.github.j4c62.pms.booking.domain.gateway.BookingEventPublisher;
import com.github.j4c62.pms.booking.domain.gateway.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class CancelBookingCommandHandler extends AbstractBookingCommandHandler
    implements BookingCanceller {

  public CancelBookingCommandHandler(
      BookingRepository bookingRepository,
      BookingEventPublisher eventPublisher,
      BookingEventMapper eventMapper) {
    super(bookingRepository, eventPublisher, eventMapper);
  }

  @Override
  public BookingOutput cancel(CancelBookingInput cancelBookingInput) {
    int affectedRows = bookingRepository.updateCanceledBooking(cancelBookingInput.getBookingId());
    assertAffectedRows(cancelBookingInput.getBookingId(), affectedRows, "cancelled");
    eventPublisher.publishBookingCancelled(eventMapper.toBookingCancelledEvent(cancelBookingInput));
    return new BookingOutput(cancelBookingInput.getBookingId(), CANCELLED);
  }
}
