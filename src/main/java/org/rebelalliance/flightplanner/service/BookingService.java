package org.rebelalliance.flightplanner.service;

import org.rebelalliance.flightplanner.model.BookingEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public
interface BookingService {
    BookingEntity createBooking(BookingEntity booking);

    Optional<BookingEntity> getBookingById(UUID id);

    List<BookingEntity> getAllBookings();

    BookingEntity updateBooking(UUID id, BookingEntity booking);

    void deleteBooking(UUID id);
}
