package org.rebelalliance.flightplanner.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.rebelalliance.flightplanner.model.BookingEntity;
import org.rebelalliance.flightplanner.model.CargoEntity;
import org.rebelalliance.flightplanner.model.RouteEntity;
import org.rebelalliance.flightplanner.model.UserEntity;
import org.rebelalliance.flightplanner.model.helper.TestObjectBuilder;
import org.rebelalliance.flightplanner.repositories.BookingRepository;

import java.util.ArrayList;
import java.util.List;
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
        booking.setId(id);

        when(bookingRepository.existsById(id)).thenReturn(true);
        when(bookingRepository.getById(id)).thenReturn(booking);

        BookingEntity result = bookingService.getBookingById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());

        // Verify interactions
        verify(bookingRepository, times(1)).existsById(id);
        verify(bookingRepository, times(1)).getById(id);
    }

    @Test
    void testGetBookingById_NotFound() {
        // Prepare test data
        UUID id = UUID.randomUUID();

        // Mock repository behavior
        when(bookingRepository.existsById(id)).thenReturn(false);

        // Call the method and expect an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookingService.getBookingById(id);
        });

        // Assertions
        assertEquals("Booking not found with ID: " + id, exception.getMessage());

        // Verify interactions
        verify(bookingRepository, times(1)).existsById(id);
        verify(bookingRepository, never()).getById(any());
    }

    @Test
    void testGetAllBookings() {
        // Prepare test data
        List<BookingEntity> bookings = new ArrayList<>();
        bookings.add(new BookingEntity());
        bookings.add(new BookingEntity());

        // Mock repository behavior
        when(bookingRepository.findAll()).thenReturn(bookings);

        // Call the method
        List<BookingEntity> result = bookingService.getAllBookings();

        // Assertions
        assertNotNull(result);
        assertEquals(2, result.size());

        // Verify interactions
        verify(bookingRepository, times(1)).findAll();
    }

    @Test
    void testUpdateBooking_Success() {
        // Prepare test data
        UUID id = UUID.randomUUID();
        BookingEntity existingBooking = TestObjectBuilder.createTestBooking();
        existingBooking.setStatus("Pending");

        BookingEntity updatedBooking = new BookingEntity();
        RouteEntity updatedRoute = TestObjectBuilder.createTestRoute();
        CargoEntity updatedCargo = TestObjectBuilder.createTestCargo();
        UserEntity updatedUser = TestObjectBuilder.createTestUser();
        updatedBooking.setStatus("Confirmed");
        updatedBooking.setRoute(updatedRoute);
        updatedBooking.setCargo(updatedCargo);
        updatedBooking.setCustomer(updatedUser);
        updatedBooking.setBookingtype("New Type");
        updatedBooking.setDatebooked(new java.sql.Date(System.currentTimeMillis()));

        // Mock repository behavior
        when(bookingRepository.findById(id)).thenReturn(Optional.of(existingBooking));
        when(bookingRepository.save(existingBooking)).thenReturn(existingBooking);

        // Call the method
        BookingEntity result = bookingService.updateBooking(id, updatedBooking);

        // Assertions
        assertNotNull(result);
        assertEquals("Confirmed", result.getStatus());
        assertEquals(updatedRoute, result.getRoute());
        assertEquals(updatedCargo, result.getCargo());
        assertEquals(updatedUser, result.getCustomer());
        assertEquals("New Type", result.getBookingtype());

        // Verify interactions
        verify(bookingRepository, times(1)).findById(id);
        verify(bookingRepository, times(1)).save(existingBooking);
    }

    @Test
    void testUpdateBooking_NotFound() {
        // Prepare test data
        UUID id = UUID.randomUUID();
        BookingEntity updatedBooking = new BookingEntity();

        // Mock repository behavior
        when(bookingRepository.findById(id)).thenReturn(Optional.empty());

        // Call the method and expect an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookingService.updateBooking(id, updatedBooking);
        });

        // Assertions
        assertEquals("Booking not found with ID: " + id, exception.getMessage());

        // Verify interactions
        verify(bookingRepository, times(1)).findById(id);
        verify(bookingRepository, never()).save(any());
    }

    @Test
    void deleteBooking() {
        UUID id = UUID.randomUUID();
        when(bookingRepository.existsById(id)).thenReturn(true);

        bookingService.deleteBooking(id);

        verify(bookingRepository, times(1)).deleteById(id);
    }
}
