package org.rebelalliance.flightplanner.repository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.rebelalliance.flightplanner.model.BookingEntity;
import org.rebelalliance.flightplanner.model.TripEntity;
import org.rebelalliance.flightplanner.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@Import(RepositoryContextConfiguration.class)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TripRepositoryTest {

    @Autowired
    private TripRepository tripRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveTripTest() {
        BookingEntity booking1 = BookingEntity.builder().build();
        BookingEntity booking2 = BookingEntity.builder().build();
        List<BookingEntity> bookingManifest = new ArrayList<BookingEntity>();
        bookingManifest.add(booking1);
        bookingManifest.add(booking2);
        TripEntity trip = TripEntity.builder()
        .routeid(UUID.fromString("65df5848-45f4-4972-bc77-b88c3468fa34"))
                .shipid(UUID.fromString("579abec3-1f0e-4b65-a0e1-a549f19e4d2e"))
                .pilotid(UUID.fromString("54b38012-e7ed-4b1c-97af-39b3facb24f7"))
                .bookings(bookingManifest)
                .departurescheduled(Date.valueOf(LocalDate.now()))
                .arrivalscheduled(Date.valueOf(LocalDate.now()))
                .tripstatus("scheduled")
                .build();

        tripRepository.saveAll(trip);
        tripRepository.flush();

        Assertions.assertThat(trip.getId()).isNotNull();
    }
}


