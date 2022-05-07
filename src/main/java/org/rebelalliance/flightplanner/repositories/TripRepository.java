package org.rebelalliance.flightplanner.repositories;

import org.rebelalliance.flightplanner.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TripRepository extends JpaRepository<Trip, Long>
{
    Trip findOneByUuid(UUID uuid);
    void deleteOneByUuid(UUID uuid);
}
