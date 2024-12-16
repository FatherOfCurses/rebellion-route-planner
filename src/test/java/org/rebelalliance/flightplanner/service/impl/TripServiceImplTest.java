package org.rebelalliance.flightplanner.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.rebelalliance.flightplanner.model.TripEntity;
import org.rebelalliance.flightplanner.repositories.TripRepository;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    void createTrip() {
        TripEntity trip = new TripEntity();
        when(tripRepository.save(trip)).thenReturn(trip);

        TripEntity result = tripService.createTrip(trip);

        assertNotNull(result);
        verify(tripRepository, times(1)).save(trip);
    }

    @Test
    void getTripById() {
        UUID id = UUID.randomUUID();
        TripEntity trip = new TripEntity();
        when(tripRepository.getById(id)).thenReturn(trip);

        TripEntity result = tripService.getTripById(id);

        assertNotNull(result);
        assertEquals(trip, result);
        verify(tripRepository, times(1)).getById(id);
    }

    @Test
    void deleteTrip() {
        UUID id = UUID.randomUUID();

        tripService.deleteTrip(id);

        verify(tripRepository, times(1)).deleteById(id);
    }
}

