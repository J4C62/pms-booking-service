package com.github.j4c62.pms.booking.application.creation.restorer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import com.github.j4c62.pms.booking.domain.aggregate.vo.BookingEvents;
import com.github.j4c62.pms.booking.shared.config.Fixture;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(Fixture.class)
class BookingAggregateRestorerTest {
  @Autowired
  BookingAggregateRestorer bookingAggregateRestorer;

  @Test
  void givenANullEventsThenThrowNullPointerException() {
    assertThatThrownBy(() -> bookingAggregateRestorer.replay(null))
        .isInstanceOf(NullPointerException.class)
        .message()
        .contains("events is marked non-null but is null");
  }

  @Test
  void givenAnEmptyEventsThenThrowIllegalArgumentException() {
    assertThatThrownBy(() -> bookingAggregateRestorer.replay(new BookingEvents(List.of())))
        .isInstanceOf(IllegalArgumentException.class)
        .message()
        .contains("Event stream is empty");
  }
}
