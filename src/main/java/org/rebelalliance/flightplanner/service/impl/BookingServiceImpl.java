package org.rebelalliance.flightplanner.service.impl;

import org.rebelalliance.flightplanner.model.BookingEntity;
import org.rebelalliance.flightplanner.repositories.BookingRepository;
import org.rebelalliance.flightplanner.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingEntity createBooking(BookingEntity booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<BookingEntity> getBookingById(UUID id) {
        return bookingRepository.findById(id);
    }

    @Override
    public List<BookingEntity> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public BookingEntity updateBooking(UUID id, BookingEntity booking) {
        return bookingRepository.findById(id).map(existingBooking -> {
            existingBooking.setRoute(booking.getRoute());
            existingBooking.setCargo(booking.getCargo());
            existingBooking.setCustomer(booking.getCustomer());
            existingBooking.setBookingtype(booking.getBookingtype());
            existingBooking.setDatebooked(booking.getDatebooked());
            existingBooking.setStatus(booking.getStatus());
            return bookingRepository.save(existingBooking);
        }).orElseThrow(() -> new IllegalArgumentException("Booking not found with ID: " + id));
    }

    @Override
    public void deleteBooking(UUID id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Booking not found with ID: " + id);
        }
    }
}
