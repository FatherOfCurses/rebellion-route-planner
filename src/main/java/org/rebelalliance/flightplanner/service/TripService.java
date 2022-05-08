package org.rebelalliance.flightplanner.service;

import org.rebelalliance.flightplanner.model.TripEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface TripService {
    TripEntity Post(TripEntity params);

    List<TripEntity> Get();

    TripEntity Get(UUID id);

    TripEntity Update(TripEntity params, UUID id);

    String Delete(UUID id);
}
