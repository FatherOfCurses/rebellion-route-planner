package org.rebelalliance.flightplanner.service.impl;

import org.rebelalliance.flightplanner.model.TripEntity;
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
    public TripEntity Post(TripEntity params) {
        tripRepository .save(params);
        return params;
    }

    @Override
    public List<TripEntity> Get() {
        return tripRepository.findAll();
    }

    @Override
    public TripEntity Get(UUID id) {
        return tripRepository.getById(id);
    }

    @Override
    public TripEntity Update(TripEntity params, UUID id) {
        TripEntity trip = tripRepository.getById(id);
        trip.setRouteid(params.getRouteid());
        trip.setShipid(params.getShipid());
        trip.setPilotid(params.getPilotid());
        trip.setBookings(params.getBookings());
        trip.setDeparturescheduled(params.getDeparturescheduled());
        trip.setArrivalscheduled(params.getArrivalscheduled());
        trip.setDepartureactual(params.getDepartureactual());
        trip.setArrivalactual(params.getArrivalactual());
        return tripRepository.save(trip);
    }

    @Override
    public String Delete(UUID id) {
        tripRepository.deleteById(id);
        return "Trip(" + id + ")" + " has been deleted";
    }
}
