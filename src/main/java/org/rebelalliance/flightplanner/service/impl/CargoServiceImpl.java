package org.rebelalliance.flightplanner.service.impl;

import org.rebelalliance.flightplanner.model.CargoEntity;
import org.rebelalliance.flightplanner.repositories.CargoRepository;
import org.rebelalliance.flightplanner.service.CargoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CargoServiceImpl implements CargoService {

    private final CargoRepository cargoRepository;

    public CargoServiceImpl(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public CargoEntity createCargo(CargoEntity cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public Optional<CargoEntity> getCargoById(UUID id) {
        return cargoRepository.findById(id);
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
