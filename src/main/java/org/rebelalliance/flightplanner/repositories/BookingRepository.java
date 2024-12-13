package org.rebelalliance.flightplanner.repositories;

import org.rebelalliance.flightplanner.model.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<BookingEntity, UUID> {
}
