package org.rebelalliance.flightplanner.repositories;

import org.rebelalliance.flightplanner.model.ShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShipRepository extends JpaRepository<ShipEntity, UUID> {
}
