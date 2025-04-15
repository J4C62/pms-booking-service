package com.github.j4c62.pms.booking.interfaces.grpc;

import com.github.j4c62.pms.booking.application.service.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingGrpcController {
  private final BookingService service;

  public BookingGrpcController(BookingService service) {
    this.service = service;
  }
}
