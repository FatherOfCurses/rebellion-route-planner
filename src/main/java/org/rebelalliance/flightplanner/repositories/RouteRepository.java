package org.rebelalliance.flightplanner.repositories;

import org.rebelalliance.flightplanner.model.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RouteRepository extends JpaRepository<RouteEntity, UUID> {
}
