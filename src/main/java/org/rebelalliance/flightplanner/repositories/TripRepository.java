package org.rebelalliance.flightplanner.repositories;

import org.rebelalliance.flightplanner.model.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TripRepository extends JpaRepository<TripEntity, UUID>
{
}
