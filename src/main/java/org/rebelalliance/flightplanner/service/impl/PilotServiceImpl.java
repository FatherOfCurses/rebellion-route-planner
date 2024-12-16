package org.rebelalliance.flightplanner.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rebelalliance.flightplanner.model.PilotEntity;
import org.rebelalliance.flightplanner.repositories.PilotRepository;
import org.rebelalliance.flightplanner.service.PilotService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PilotServiceImpl implements PilotService {

    private final PilotRepository pilotRepository;

    @Override
    public PilotEntity createPilot(PilotEntity pilot) {
        return pilotRepository.save(pilot);
    }

    @Override
    public Optional<PilotEntity> getPilotById(UUID id) {
        if (pilotRepository.existsById(id)) {
            return pilotRepository.findById(id);
        } else {
            throw new IllegalArgumentException("Pilot not found with ID: " + id);
        }
    }

    @Override
    public List<PilotEntity> getAllPilots() {
        return pilotRepository.findAll();
    }

    @Override
    public PilotEntity updatePilot(UUID id, PilotEntity params) {
        if (pilotRepository.existsById(id)) {
            PilotEntity pilot = pilotRepository.getById(id);
            pilot.setId(params.getId());
            pilot.setUser(params.getUser());
            pilot.setRating(params.getRating());
            pilot.setStanding(params.getStanding());
            pilot.setHomePort(params.getHomePort());
            pilot.setCurrentPort(params.getCurrentPort());
            return pilotRepository.save(pilot);
        } else {
            throw new IllegalArgumentException("Pilot not found with ID: " + id);
        }

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
