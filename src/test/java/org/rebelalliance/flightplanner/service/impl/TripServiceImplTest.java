package org.rebelalliance.flightplanner.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.rebelalliance.flightplanner.model.TripEntity;
import org.rebelalliance.flightplanner.model.helper.TestObjectBuilder;
import org.rebelalliance.flightplanner.repositories.TripRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TripServiceImplTest {

    private TripRepository tripRepository;
    private TripServiceImpl tripService;

    LocalDateTime departureTime = TestObjectBuilder.returnFixedDate();
    UUID tripId = TestObjectBuilder.returnFixedId();

    @BeforeEach
    void setUp() {
        tripRepository = Mockito.mock(TripRepository.class);
        tripService = new TripServiceImpl(tripRepository);
    }

    @Test
    void testCreateTrip() {
        TripEntity trip = TestObjectBuilder.createTestTrip();
        when(tripRepository.save(trip)).thenReturn(trip);

        TripEntity result = tripService.createTrip(trip);

        assertNotNull(result);
        verify(tripRepository, times(1)).save(trip);
    }

    @Test
    void testGetTripById() {
        UUID id = tripId;
        TripEntity trip = TestObjectBuilder.createTestTrip();

        when(tripRepository.existsById(id)).thenReturn(true);
        when(tripRepository.getById(id)).thenReturn(trip);

        TripEntity result = tripService.getTripById(id);

        assertNotNull(result);
        assertEquals(trip, result);
        verify(tripRepository, times(1)).getById(id);
    }

    @Test
    void testGetAllTrips() {
        List<TripEntity> trips = List.of(TestObjectBuilder.createTestTrip(), TestObjectBuilder.createTestTrip());
        when(tripRepository.findAll()).thenReturn(trips);

        List<TripEntity> result = tripService.getAllTrips();

        assertEquals(2, result.size());
        verify(tripRepository, times(1)).findAll();
    }

    @Test
    void testUpdateTrip_Success() {
        // Prepare test data
        UUID id = tripId;
        TripEntity existingTrip = TestObjectBuilder.createTestTrip();

        TripEntity updatedTrip = TestObjectBuilder.createTestTrip();
        updatedTrip.setRouteid(id);
        updatedTrip.setShipid(id);
        updatedTrip.setPilotid(id);
        updatedTrip.setBookings(Collections.emptyList());
        updatedTrip.setDeparturescheduled(departureTime);
        updatedTrip.setArrivalscheduled(departureTime.plusHours(3));
        updatedTrip.setArrivalactual(departureTime.plusMinutes(30));
        updatedTrip.setDepartureactual(departureTime.plusHours(4));

        when(tripRepository.findById(id)).thenReturn(Optional.of(existingTrip));
        when(tripRepository.save(existingTrip)).thenReturn(existingTrip);

        // Call the method
        TripEntity result = tripService.updateTrip(id, updatedTrip);

        // Assertions
        assertNotNull(result);
        assertEquals(updatedTrip.getRouteid(), result.getRouteid());
        assertEquals(updatedTrip.getShipid(), result.getShipid());
        assertEquals(updatedTrip.getDeparturescheduled(), result.getDeparturescheduled());
        assertEquals(updatedTrip.getArrivalscheduled(), result.getArrivalscheduled());

        // Verify interactions
        verify(tripRepository, times(1)).findById(id);
        verify(tripRepository, times(1)).save(existingTrip);
    }

    @Test
    void testUpdateTrip_TripNotFound() {
        // Prepare test data
        UUID id = tripId;
        TripEntity updatedTrip = TestObjectBuilder.createTestTrip();

        when(tripRepository.existsById(id)).thenReturn(false);

        // Call the method and expect an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tripService.updateTrip(id, updatedTrip);
        });

        // Assertions
        assertEquals("Trip not found with ID: " + id, exception.getMessage());

        // Verify interactions
        verify(tripRepository, times(1)).findById(id);
        verify(tripRepository, never()).getById(any());
        verify(tripRepository, never()).save(any());
    }

    @Test
    void deleteTrip() {
        UUID id = tripId;

        when(tripRepository.existsById(id)).thenReturn(true);
        tripService.deleteTrip(id);

        verify(tripRepository, times(1)).deleteById(id);
    }

    @Test
    void testDeleteTripNotFound() {
        UUID id = tripId;

        when(tripRepository.existsById(id)).thenReturn(false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tripService.deleteTrip(id);
        });

        assertEquals("Trip not found with ID: " + id, exception.getMessage());
        verify(tripRepository, times(1)).existsById(id);
        verify(tripRepository, never()).deleteById(id);
    }
}

