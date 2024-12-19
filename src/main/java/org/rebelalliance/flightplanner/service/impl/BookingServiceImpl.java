package org.rebelalliance.flightplanner.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rebelalliance.flightplanner.model.BookingEntity;
import org.rebelalliance.flightplanner.repositories.BookingRepository;
import org.rebelalliance.flightplanner.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingEntity createBooking(BookingEntity booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public BookingEntity getBookingById(UUID id) {
        if (bookingRepository.existsById(id)) {
            return bookingRepository.getById(id);
        } else {
            throw new IllegalArgumentException("Booking not found with ID: " + id);
        }
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
