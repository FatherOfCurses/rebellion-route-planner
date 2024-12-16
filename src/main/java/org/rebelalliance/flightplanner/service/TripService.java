package org.rebelalliance.flightplanner.service;

import org.rebelalliance.flightplanner.model.TripEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface TripService {
    TripEntity createTrip(TripEntity params);

    List<TripEntity> getAllTrips();

    TripEntity getTripById(UUID id);

    TripEntity updateTrip(TripEntity params, UUID id);

    void deleteTrip(UUID id);
}
