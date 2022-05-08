package org.rebelalliance.flightplanner.repositories;

import org.rebelalliance.flightplanner.model.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TripRepository extends JpaRepository<TripEntity, Long>
{
    TripEntity findOneByUuid(UUID uuid);
    TripEntity saveAll(TripEntity params);
    void deleteOneByUuid(UUID uuid);
}
