package org.rebelalliance.flightplanner.repositories;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.rebelalliance.flightplanner.helpers.EntityHelper;
import org.rebelalliance.flightplanner.model.ShipEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShipRepositoryTest {

    EntityHelper entityHelper = new EntityHelper();

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ShipRepository shipRepository;


    @Test
    @Order(1)
    @Rollback(value = true)
    public void saveShipTest() {
        ShipEntity testShip = entityHelper.createShipEntity();
        UUID shipId = testShip.getId();
        try{
            entityManager.persist(testShip);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ShipEntity expected = shipRepository.getById(shipId);
        assert(expected.getId()).equals(shipId);
    }

    @Test
    @Order(2)
    @Rollback(value = true)
    public void updateShipTest() {
        ShipEntity testShip = entityHelper.createShipEntity();
        UUID shipId = testShip.getId();
        entityManager.persist(testShip);

        ShipEntity shipToUpdate = shipRepository.getById(shipId);
        shipToUpdate.setShipname("Spirit of Mandalore");
        shipRepository.save(shipToUpdate);
        String actualShipName = shipRepository.getById(shipId).getShipname();
        assert(actualShipName).equals("Spirit of Mandalore");
    }
}
