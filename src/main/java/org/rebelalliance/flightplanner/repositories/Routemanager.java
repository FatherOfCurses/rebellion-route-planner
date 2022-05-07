package org.rebelalliance.flightplanner.repositories;

import org.rebelalliance.flightplanner.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Routemanager extends JpaRepository<Trip, Integer>
{
}
