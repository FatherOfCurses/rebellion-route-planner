package org.rebelalliance.flightplanner.repositories;

import org.rebelalliance.flightplanner.model.PilotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PilotRepository extends JpaRepository<PilotEntity, UUID> {
}
