package org.rebelalliance.flightplanner.repositories;

import org.rebelalliance.flightplanner.model.CargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CargoRepository extends JpaRepository<CargoEntity, UUID> {
}
