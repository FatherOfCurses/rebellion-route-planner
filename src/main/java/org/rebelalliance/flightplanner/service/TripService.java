package org.rebelalliance.flightplanner.service;

import org.rebelalliance.flightplanner.model.TripEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TripService {
    TripEntity createTrip(TripEntity params);

    Optional<TripEntity> getTripById(UUID id);

    List<TripEntity> getAllTrips();

    TripEntity updateTrip(UUID id, TripEntity trip);

    void deleteTrip(UUID id);
}
