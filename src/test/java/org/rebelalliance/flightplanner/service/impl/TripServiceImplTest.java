package org.rebelalliance.flightplanner.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.rebelalliance.flightplanner.model.TripEntity;
import org.rebelalliance.flightplanner.repositories.TripRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TripServiceImplTest {

    private TripRepository tripRepository;
    private TripServiceImpl tripService;

    @BeforeEach
    void setUp() {
        tripRepository = Mockito.mock(TripRepository.class);
        tripService = new TripServiceImpl(tripRepository);
    }

    @Test
    void testCreateTrip() {
        TripEntity trip = new TripEntity();
        when(tripRepository.save(trip)).thenReturn(trip);

        TripEntity result = tripService.createTrip(trip);

        assertNotNull(result);
        verify(tripRepository, times(1)).save(trip);
    }

    @Test
    void testGetTripById() {
        UUID id = UUID.randomUUID();
        TripEntity trip = new TripEntity();

        when(tripRepository.existsById(id)).thenReturn(true);
        when(tripRepository.getById(id)).thenReturn(trip);

        Optional<TripEntity> result = tripService.getTripById(id);

        assertNotNull(result);
        assertEquals(trip, result);
        verify(tripRepository, times(1)).getById(id);
    }

    @Test
    void testGetAllTrips() {
        List<TripEntity> trips = List.of(new TripEntity(), new TripEntity());
        when(tripRepository.findAll()).thenReturn(trips);

        List<TripEntity> result = tripService.getAllTrips();

        assertEquals(2, result.size());
        verify(tripRepository, times(1)).findAll();
    }

    @Test
    void testUpdateTrip_Success() {
        // Prepare test data
        UUID id = UUID.randomUUID();
        TripEntity existingTrip = new TripEntity();
        existingTrip.setRouteid(UUID.randomUUID());

        TripEntity params = new TripEntity();
        params.setRouteid(UUID.randomUUID());
        params.setShipid(UUID.randomUUID());
        params.setDeparturescheduled(new java.sql.Date(System.currentTimeMillis()));
        params.setArrivalscheduled(new java.sql.Date(System.currentTimeMillis() + 3600000));

        when(tripRepository.existsById(id)).thenReturn(true);
        when(tripRepository.getById(id)).thenReturn(existingTrip);
        when(tripRepository.save(existingTrip)).thenReturn(existingTrip);

        // Call the method
        TripEntity result = tripService.updateTrip(id, params);

        // Assertions
        assertNotNull(result);
        assertEquals(params.getRouteid(), result.getRouteid());
        assertEquals(params.getShipid(), result.getShipid());
        assertEquals(params.getDeparturescheduled(), result.getDeparturescheduled());
        assertEquals(params.getArrivalscheduled(), result.getArrivalscheduled());

        // Verify interactions
        verify(tripRepository, times(1)).existsById(id);
        verify(tripRepository, times(1)).getById(id);
        verify(tripRepository, times(1)).save(existingTrip);
    }

    @Test
    void testUpdateTrip_TripNotFound() {
        // Prepare test data
        UUID id = UUID.randomUUID();
        TripEntity params = new TripEntity();

        when(tripRepository.existsById(id)).thenReturn(false);

        // Call the method and expect an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tripService.updateTrip(id, params);
        });

        // Assertions
        assertEquals("Trip not found with ID: " + id, exception.getMessage());

        // Verify interactions
        verify(tripRepository, times(1)).existsById(id);
        verify(tripRepository, never()).getById(any());
        verify(tripRepository, never()).save(any());
    }

    @Test
    void deleteTrip() {
        UUID id = UUID.randomUUID();

        when(tripRepository.existsById(id)).thenReturn(true);
        tripService.deleteTrip(id);

        verify(tripRepository, times(1)).deleteById(id);
    }

    @Test
    void testDeleteTripNotFound() {
        UUID id = UUID.randomUUID();

        when(tripRepository.existsById(id)).thenReturn(false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tripService.deleteTrip(id);
        });

        assertEquals("Trip not found with ID: " + id, exception.getMessage());
        verify(tripRepository, times(1)).existsById(id);
        verify(tripRepository, never()).deleteById(id);
    }
}

