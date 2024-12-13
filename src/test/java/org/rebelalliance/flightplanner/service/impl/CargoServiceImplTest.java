package org.rebelalliance.flightplanner.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.rebelalliance.flightplanner.model.CargoEntity;
import org.rebelalliance.flightplanner.repositories.CargoRepository;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CargoServiceImplTest {

    private CargoRepository cargoRepository;
    private CargoServiceImpl cargoService;

    @BeforeEach
    void setUp() {
        cargoRepository = Mockito.mock(CargoRepository.class);
        cargoService = new CargoServiceImpl(cargoRepository);
    }

    @Test
    void createCargo() {
        CargoEntity cargo = new CargoEntity();
        when(cargoRepository.save(cargo)).thenReturn(cargo);

        CargoEntity result = cargoService.createCargo(cargo);

        assertNotNull(result);
        verify(cargoRepository, times(1)).save(cargo);
    }

    @Test
    void getCargoById() {
        UUID id = UUID.randomUUID();
        CargoEntity cargo = new CargoEntity();
        when(cargoRepository.findById(id)).thenReturn(Optional.of(cargo));

        Optional<CargoEntity> result = cargoService.getCargoById(id);

        assertTrue(result.isPresent());
        assertEquals(cargo, result.get());
        verify(cargoRepository, times(1)).findById(id);
    }

    @Test
    void deleteCargo() {
        UUID id = UUID.randomUUID();
        when(cargoRepository.existsById(id)).thenReturn(true);

        cargoService.deleteCargo(id);

        verify(cargoRepository, times(1)).deleteById(id);
    }
}
