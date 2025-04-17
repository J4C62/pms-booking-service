package com.github.j4c62.pms.booking.domain.driver;

import com.github.j4c62.pms.booking.domain.driver.action.BookingCanceller;
import com.github.j4c62.pms.booking.domain.driver.action.BookingCreator;
import com.github.j4c62.pms.booking.domain.driver.action.BookingUpdater;

public interface BookingActions extends BookingCreator, BookingCanceller, BookingUpdater {}
