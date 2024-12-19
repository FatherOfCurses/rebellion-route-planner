package org.rebelalliance.flightplanner.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rebelalliance.flightplanner.model.CargoEntity;
import org.rebelalliance.flightplanner.repositories.CargoRepository;
import org.rebelalliance.flightplanner.service.CargoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CargoServiceImpl implements CargoService {

    private final CargoRepository cargoRepository;

    @Override
    public CargoEntity createCargo(CargoEntity cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public CargoEntity getCargoById(UUID id) {
        if (cargoRepository.existsById(id)) {
            return cargoRepository.getById(id);
        } else {
            throw new IllegalArgumentException("Cargo not found with ID: " + id);
        }
    }

    @Override
    public List<CargoEntity> getAllCargo() {
        return cargoRepository.findAll();
    }

    @Override
    public CargoEntity updateCargo(UUID id, CargoEntity cargo) {
        return cargoRepository.findById(id).map(existingCargo -> {
            existingCargo.setCustomer(cargo.getCustomer());
            existingCargo.setContents(cargo.getContents());
            existingCargo.setMass(cargo.getMass());
            existingCargo.setHazardous(cargo.getHazardous());
            existingCargo.setTimesensitive(cargo.getTimesensitive());
            return cargoRepository.save(existingCargo);
        }).orElseThrow(() -> new IllegalArgumentException("Cargo not found with ID: " + id));
    }

    @Override
    public void deleteCargo(UUID id) {
        if (cargoRepository.existsById(id)) {
            cargoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Cargo not found with ID: " + id);
        }
    }
}
