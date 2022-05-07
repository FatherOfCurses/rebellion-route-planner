package org.rebelalliance.flightplanner.service;

import org.rebelalliance.flightplanner.model.Trip;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface TripService {
    Trip Post(Trip params);

    List<Trip> Get();

    Trip Get(UUID id);

    Trip Update(Trip params, UUID id);

    String Delete(UUID id);
}
