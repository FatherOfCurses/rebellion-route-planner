package org.rebelalliance.flightplanner.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.rebelalliance.flightplanner.model.CargoEntity;
import org.rebelalliance.flightplanner.model.UserEntity;
import org.rebelalliance.flightplanner.model.helper.TestObjectBuilder;
import org.rebelalliance.flightplanner.repositories.CargoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CargoServiceImplTest {

    private CargoRepository cargoRepository;
    private CargoServiceImpl cargoService;
    UUID staticUUID = TestObjectBuilder.returnFixedId();

    @BeforeEach
    void setUp() {
        cargoRepository = Mockito.mock(CargoRepository.class);
        cargoService = new CargoServiceImpl(cargoRepository);

    }

    @Test
    void testCreateCargo() {
        CargoEntity cargo = TestObjectBuilder.createTestCargo();
        when(cargoRepository.save(cargo)).thenReturn(cargo);

        CargoEntity result = cargoService.createCargo(cargo);

        assertNotNull(result);
        verify(cargoRepository, times(1)).save(cargo);
    }

    @Test
    void testGetCargoById() {
        UUID id = staticUUID;
        CargoEntity cargo = TestObjectBuilder.createTestCargo();
        when(cargoRepository.existsById(id)).thenReturn(true);
        when(cargoRepository.getById(id)).thenReturn(cargo);

        CargoEntity result = cargoService.getCargoById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(cargoRepository, times(1)).getById(id);
    }

    @Test
    void testGetAllCargos() {
        // Prepare test data
        List<CargoEntity> cargos = new ArrayList<>();
        cargos.add(new CargoEntity());
        cargos.add(new CargoEntity());

        // Mock repository behavior
        when(cargoRepository.findAll()).thenReturn(cargos);

        // Call the method
        List<CargoEntity> result = cargoService.getAllCargo();

        // Assertions
        assertNotNull(result);
        assertEquals(2, result.size());

        // Verify interactions
        verify(cargoRepository, times(1)).findAll();
    }

    @Test
    void testUpdateCargo_Success() {
        // Prepare test data
        UUID id = staticUUID;
        CargoEntity existingCargo = TestObjectBuilder.createTestCargo();

        CargoEntity updatedCargo = TestObjectBuilder.createTestCargo();
        UserEntity newUser = TestObjectBuilder.createTestUser();
        newUser.setFirstname("Owen");
        updatedCargo.setCustomer(newUser);
        updatedCargo.setContents("Beskar Slag");
        updatedCargo.setMass(78120000);
        updatedCargo.setHazardous(true);
        updatedCargo.setTimesensitive(false);

        // Mock repository behavior
        when(cargoRepository.existsById(id)).thenReturn(true);
        when(cargoRepository.findById(id)).thenReturn(Optional.of(existingCargo));
        when(cargoRepository.save(existingCargo)).thenReturn(existingCargo);

        // Call the method
        CargoEntity result = cargoService.updateCargo(id, updatedCargo);

        // Assertions
        assertNotNull(result);
        assertEquals(staticUUID, result.getId());
        assertEquals(newUser, result.getCustomer());
        assertEquals("Beskar Slag", result.getContents());
        assertEquals(78120000, result.getMass());
        assertEquals(true, result.getHazardous());
        assertEquals(false, result.getTimesensitive());

        // Verify interactions
        verify(cargoRepository, times(1)).findById(id);
        verify(cargoRepository, times(1)).save(existingCargo);
    }

    @Test
    void testUpdateCargo_NotFound() {
        // Prepare test data
        UUID id = staticUUID;
        CargoEntity updatedCargo = new CargoEntity();

        // Mock repository behavior
        when(cargoRepository.existsById(id)).thenReturn(false);
        when(cargoRepository.findById(id)).thenReturn(Optional.empty());

        // Call the method and expect an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cargoService.updateCargo(id, updatedCargo);
        });

        // Assertions
        assertEquals("Cargo not found with ID: " + id, exception.getMessage());

        // Verify interactions
        verify(cargoRepository, times(1)).findById(id);
        verify(cargoRepository, never()).save(any());
    }

    @Test
    void testDeleteCargo() {
        UUID id = staticUUID;
        when(cargoRepository.existsById(id)).thenReturn(true);

        cargoService.deleteCargo(id);

        verify(cargoRepository, times(1)).deleteById(id);
    }
}
