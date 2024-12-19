package org.rebelalliance.flightplanner.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rebelalliance.flightplanner.model.PilotEntity;
import org.rebelalliance.flightplanner.repositories.PilotRepository;
import org.rebelalliance.flightplanner.service.PilotService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PilotServiceImpl implements PilotService {

    private final PilotRepository pilotRepository;

    @Override
    public PilotEntity createPilot(PilotEntity pilot) {
        return pilotRepository.save(pilot);
    }

    @Override
    public PilotEntity getPilotById(UUID id) {
        if (pilotRepository.existsById(id)) {
            return pilotRepository.getById(id);
        } else {
            throw new IllegalArgumentException("Pilot not found with ID: " + id);
        }
    }

    @Override
    public List<PilotEntity> getAllPilots() {
        return pilotRepository.findAll();
    }

    @Override
    public PilotEntity updatePilot(UUID id, PilotEntity pilot) {
        return pilotRepository.findById(id).map(existingPilot -> {
            existingPilot.setUser(pilot.getUser());
            existingPilot.setRating(pilot.getRating());
            existingPilot.setStanding(pilot.getStanding());
            existingPilot.setHomePort(pilot.getHomePort());
            existingPilot.setCurrentPort(pilot.getCurrentPort());
            return pilotRepository.save(existingPilot);
        }).orElseThrow(() -> new IllegalArgumentException("Pilot not found with ID: " + id));
    }

    @Override
    public void deletePilot(UUID id) {
        if (pilotRepository.existsById(id)) {
            pilotRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Pilot not found with ID: " + id);
        }
    }
}
