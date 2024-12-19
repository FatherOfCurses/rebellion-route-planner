package org.rebelalliance.flightplanner.service;

import org.rebelalliance.flightplanner.model.BookingEntity;

import java.util.List;
import java.util.UUID;

public interface BookingService {
    BookingEntity createBooking(BookingEntity booking);

    BookingEntity getBookingById(UUID id);

    List<BookingEntity> getAllBookings();

    BookingEntity updateBooking(UUID id, BookingEntity booking);

    void deleteBooking(UUID id);
}
