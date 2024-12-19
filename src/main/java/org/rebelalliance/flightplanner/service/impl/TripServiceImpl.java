package org.rebelalliance.flightplanner.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rebelalliance.flightplanner.model.TripEntity;
import org.rebelalliance.flightplanner.repositories.TripRepository;
import org.rebelalliance.flightplanner.service.TripService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class TripServiceImpl implements TripService {

    private TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public TripEntity createTrip(TripEntity trip) {
        tripRepository.save(trip);
        return trip;
    }

    @Override
    public Optional<TripEntity> getTripById(UUID id) {
        if (tripRepository.existsById(id)) {
            return tripRepository.findById(id);
        } else {
            throw new IllegalArgumentException("Trip not found with ID: " + id);
        }
    }

    @Override
    public List<TripEntity> getAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public TripEntity updateTrip(UUID id, TripEntity trip) {
        return tripRepository.findById(id).map(existingTrip -> {
            trip.setRouteid(trip.getRouteid());
            trip.setShipid(trip.getShipid());
            trip.setPilotid(trip.getPilotid());
            trip.setBookings(trip.getBookings());
            trip.setDeparturescheduled(trip.getDeparturescheduled());
            trip.setArrivalscheduled(trip.getArrivalscheduled());
            trip.setDepartureactual(trip.getDepartureactual());
            trip.setArrivalactual(trip.getArrivalactual());
            return tripRepository.save(trip);
        }).orElseThrow(() -> new IllegalArgumentException("Trip not found with ID: " + id));
    }

    @Override
    public void deleteTrip(UUID id) {
        if (tripRepository.existsById(id)) {
            tripRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Trip not found with ID: " + id);
        }
    }
}
