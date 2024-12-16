package org.rebelalliance.flightplanner.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rebelalliance.flightplanner.model.TripEntity;
import org.rebelalliance.flightplanner.repositories.TripRepository;
import org.rebelalliance.flightplanner.service.TripService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TripServiceImpl implements TripService {

    private TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public TripEntity createTrip(TripEntity params) {
        tripRepository.save(params);
        return params;
    }

    @Override
    public List<TripEntity> getAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public TripEntity getTripById(UUID id) {
        return tripRepository.getById(id);
    }

    @Override
    public TripEntity updateTrip(TripEntity params, UUID id) {
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
    public void deleteTrip(UUID id) {
        tripRepository.deleteById(id);
    }
}
