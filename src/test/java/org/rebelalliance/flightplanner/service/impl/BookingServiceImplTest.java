package org.rebelalliance.flightplanner.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.rebelalliance.flightplanner.model.BookingEntity;
import org.rebelalliance.flightplanner.repositories.BookingRepository;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookingServiceImplTest {

    private BookingRepository bookingRepository;
    private BookingServiceImpl bookingService;

    @BeforeEach
    void setUp() {
        bookingRepository = Mockito.mock(BookingRepository.class);
        bookingService = new BookingServiceImpl(bookingRepository);
    }

    @Test
    void createBooking() {
        BookingEntity booking = new BookingEntity();
        when(bookingRepository.save(booking)).thenReturn(booking);

        BookingEntity result = bookingService.createBooking(booking);

        assertNotNull(result);
        verify(bookingRepository, times(1)).save(booking);
    }

    @Test
    void getBookingById() {
        UUID id = UUID.randomUUID();
        BookingEntity booking = new BookingEntity();
        when(bookingRepository.findById(id)).thenReturn(Optional.of(booking));

        Optional<BookingEntity> result = bookingService.getBookingById(id);

        assertTrue(result.isPresent());
        assertEquals(booking, result.get());
        verify(bookingRepository, times(1)).findById(id);
    }

    @Test
    void deleteBooking() {
        UUID id = UUID.randomUUID();
        when(bookingRepository.existsById(id)).thenReturn(true);

        bookingService.deleteBooking(id);

        verify(bookingRepository, times(1)).deleteById(id);
    }
}
