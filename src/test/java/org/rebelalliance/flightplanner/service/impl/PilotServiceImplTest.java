package org.rebelalliance.flightplanner.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.rebelalliance.flightplanner.model.PilotEntity;
import org.rebelalliance.flightplanner.repositories.PilotRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PilotServiceImplTest {
    private PilotRepository pilotRepository;
    private PilotServiceImpl pilotService;

    @BeforeEach
    void setUp() {
        pilotRepository = Mockito.mock(PilotRepository.class);
        pilotService = new PilotServiceImpl(pilotRepository);
    }

    @Test
    void testCreatePilot() {
        PilotEntity pilot = new PilotEntity();
        when(pilotRepository.save(pilot)).thenReturn(pilot);

        PilotEntity result = pilotService.createPilot(pilot);

        assertNotNull(result);
        verify(pilotRepository, times(1)).save(pilot);
    }

    @Test
    void testGetPilotById() {
        UUID id = UUID.randomUUID();
        PilotEntity pilot = new PilotEntity();

        when(pilotRepository.existsById(id)).thenReturn(true);
        when(pilotRepository.findById(id)).thenReturn(Optional.of(pilot));

        PilotEntity result = pilotService.getPilotById(id);

        assertEquals(pilot, result.get());
        verify(pilotRepository, times(1)).findById(id);
    }

    @Test
    void testGetAllPilots() {
        List<PilotEntity> pilots = List.of(new PilotEntity(), new PilotEntity());
        when(pilotRepository.findAll()).thenReturn(pilots);

        List<PilotEntity> result = pilotService.getAllPilots();

        assertEquals(2, result.size());
        verify(pilotRepository, times(1)).findAll();
    }

    @Test
    void testUpdatePilot() {
        // Prepare test data
        UUID id = UUID.randomUUID();

        PilotEntity existingPilot = new PilotEntity();
        existingPilot.setId(id);
        existingPilot.setRating("B");
        existingPilot.setStanding("Good");

        PilotEntity updatedParams = new PilotEntity();
        updatedParams.setId(id);
        updatedParams.setRating("A");
        updatedParams.setStanding("Excellent");

        // Mock repository behavior
        when(pilotRepository.getById(id)).thenReturn(existingPilot);
        when(pilotRepository.existsById(id)).thenReturn(true);
        when(pilotRepository.save(any(PilotEntity.class))).thenReturn(existingPilot);

        // Call the service method
        PilotEntity result = pilotService.updatePilot(id, updatedParams);

        // Assertions
        assertNotNull(result); // Ensure the returned object is not null
        assertEquals("A", result.getRating()); // Validate updated rating
        assertEquals("Excellent", result.getStanding()); // Validate updated standing

        // Verify repository interactions
        verify(pilotRepository, times(1)).getById(id);
        verify(pilotRepository, times(1)).save(existingPilot);
    }

    @Test
    void testUpdatePilotNotFound() {
        UUID id = UUID.randomUUID();
        PilotEntity existingPilot = new PilotEntity();
        existingPilot.setId(id);
        existingPilot.setRating("B");
        existingPilot.setStanding("Good");

        when(pilotRepository.existsById(id)).thenReturn(false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            pilotService.updatePilot(id, existingPilot);
        });

        assertEquals("Pilot not found with ID: " + id, exception.getMessage());
        verify(pilotRepository, times(1)).existsById(id);
        verify(pilotRepository, never()).save(existingPilot);
    }

    @Test
    void testDeletePilot() {
        UUID id = UUID.randomUUID();

        when(pilotRepository.existsById(id)).thenReturn(true);

        pilotService.deletePilot(id);

        verify(pilotRepository, times(1)).deleteById(id);
    }


    @Test
    void testDeletePilotNotFound() {
        UUID id = UUID.randomUUID();

        when(pilotRepository.existsById(id)).thenReturn(false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            pilotService.deletePilot(id);
        });

        assertEquals("Pilot not found with ID: " + id, exception.getMessage());
        verify(pilotRepository, times(1)).existsById(id);
        verify(pilotRepository, never()).deleteById(id);
    }

}
