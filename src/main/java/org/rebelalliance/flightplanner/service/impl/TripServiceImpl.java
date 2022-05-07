package org.rebelalliance.flightplanner.service.impl;

import org.rebelalliance.flightplanner.model.Trip;
import org.rebelalliance.flightplanner.repositories.TripRepository;
import org.rebelalliance.flightplanner.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Override
    public Trip Post(Trip params) {
        tripRepository.save(params);
        return params;
    }

    @Override
    public List<Trip> Get() {
        return tripRepository.findAll();
    }

    @Override
    public Trip Get(UUID id) {
        return tripRepository.findOneByUuid(id);
    }

    @Override
    public Trip Update(Trip params, UUID id) {
        Trip trip = tripRepository.findOneByUuid(id);
        trip.setRouteId(params.getRouteId());
        trip.setShipId(params.getShipId());
        trip.setPilotId(params.getPilotId());
        trip.setBookings(params.getBookings());
        trip.setDepartureScheduled(params.getDepartureScheduled());
        trip.setArrivalScheduled(params.getArrivalScheduled());
        trip.setDepartureActual(params.getDepartureActual());
        trip.setArrivalActual(params.getArrivalActual());
        return tripRepository.save(trip);
    }

    @Override
    public String Delete(UUID id) {
        tripRepository.deleteOneByUuid(id);
        return "Trip(" + id + ")" + " has been deleted";
    }
}
