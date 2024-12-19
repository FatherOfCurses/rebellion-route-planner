package org.rebelalliance.flightplanner.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rebelalliance.flightplanner.model.TripEntity;
import org.rebelalliance.flightplanner.repositories.TripRepository;
import org.rebelalliance.flightplanner.service.TripService;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public TripEntity getTripById(UUID id) {
        if (tripRepository.existsById(id)) {
            return tripRepository.getById(id);
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
            existingTrip.setRouteid(trip.getRouteid());
            existingTrip.setShipid(trip.getShipid());
            existingTrip.setPilotid(trip.getPilotid());
            existingTrip.setBookings(trip.getBookings());
            existingTrip.setDeparturescheduled(trip.getDeparturescheduled());
            existingTrip.setArrivalscheduled(trip.getArrivalscheduled());
            existingTrip.setDepartureactual(trip.getDepartureactual());
            existingTrip.setArrivalactual(trip.getArrivalactual());
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
