package org.rebelalliance.flightplanner.repository;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.rebelalliance.flightplanner.model.Trip;
import org.rebelalliance.flightplanner.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TripRepositoryTest {

    @Autowired
    public TripRepository tripRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveTripTest() {
        Trip trip = Trip.builder()
        .routeId("65df5848-45f4-4972-bc77-b88c3468fa34")
                .shipId("579abec3-1f0e-4b65-a0e1-a549f19e4d2e")
                .pilotId("54b38012-e7ed-4b1c-97af-39b3facb24f7")
                .bookings(Arrays.asList("97124599-19d7-44d0-a97c-ad6ed0d25dc0", "5a12ab6b-2ecd-4b5f-ab08-42b7c78bb30e"))
                .departureScheduled(Date.from(Instant.now()))
                .arrivalScheduled(Date.from(Instant.now()))
                .tripStatus("scheduled")
                .build();

        tripRepository.save(trip);

        Assertions.assertThat(trip.getTripId()).isNotNull();
    }
}


