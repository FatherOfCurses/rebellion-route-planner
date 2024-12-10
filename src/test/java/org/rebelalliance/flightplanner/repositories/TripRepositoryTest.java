package org.rebelalliance.flightplanner.repositories;
import org.rebelalliance.flightplanner.helpers.EntityHelper;
import org.rebelalliance.flightplanner.model.*;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TripRepositoryTest {

    EntityHelper entityHelper = new EntityHelper();

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TripRepository tripRepository;



    @Test
    @Order(1)
    @Rollback(value = true)
    public void saveTripTest() {
        TripEntity expectedTrip = entityHelper.createTripEntity();
        expectedTrip.setId(UUID.fromString("6ebc7fb8-f2b4-4730-aca0-3511ba44d4de"));
        entityManager.persist(expectedTrip);
        TripEntity expected = tripRepository.getById(UUID.fromString("6ebc7fb8-f2b4-4730-aca0-3511ba44d4de"));

        assert(expectedTrip.getId()).equals(expected.getId());
    }
}


