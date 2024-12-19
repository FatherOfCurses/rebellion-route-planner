package org.rebelalliance.flightplanner.service;

import org.rebelalliance.flightplanner.model.PilotEntity;

import java.util.List;
import java.util.UUID;

public interface PilotService {
    PilotEntity createPilot(PilotEntity pilot);

    PilotEntity getPilotById(UUID id);

    List<PilotEntity> getAllPilots();

    PilotEntity updatePilot(UUID id, PilotEntity pilot);

    void deletePilot(UUID id);
}
