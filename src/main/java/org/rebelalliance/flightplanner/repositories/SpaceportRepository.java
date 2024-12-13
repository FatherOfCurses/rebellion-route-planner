package org.rebelalliance.flightplanner.repositories;

import org.rebelalliance.flightplanner.model.SpaceportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpaceportRepository extends JpaRepository<SpaceportEntity, UUID> {
}
