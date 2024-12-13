package org.rebelalliance.flightplanner.service;

import org.rebelalliance.flightplanner.model.CargoEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CargoService {
    CargoEntity createCargo(CargoEntity cargo);

    Optional<CargoEntity> getCargoById(UUID id);

    List<CargoEntity> getAllCargo();

    CargoEntity updateCargo(UUID id, CargoEntity cargo);

    void deleteCargo(UUID id);
}
