package org.rebelalliance.flightplanner.repositories;

import org.junit.Assert;
import org.junit.Test;
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

import java.util.List;
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
        UUID shipId = testShip.getShipId();
        entityManager.persist(testShip);

        ShipEntity expected = shipRepository.getById(shipId);
        assert (expected.getShipId()).equals(shipId);
    }

    @Test
    @Order(2)
    @Rollback(value = true)
    public void updateShipTest() {
        ShipEntity testShip = entityHelper.createShipEntity();
        UUID shipId = testShip.getShipId();
        entityManager.persist(testShip);

        ShipEntity shipToUpdate = shipRepository.getById(shipId);
        shipToUpdate.setShipname("Spirit of Mandalore");
        shipRepository.save(shipToUpdate);
        String actualShipName = shipRepository.getById(shipId).getShipname();
        assert (actualShipName).equals("Spirit of Mandalore");
    }

    @Test
    @Order(3)
    @Rollback(value = true)
    public void deleteShipTest() {
        ShipEntity testShip = entityHelper.createShipEntity();
        entityManager.persist(testShip);
        ShipEntity testShip2 = entityHelper.createShipEntity();
        UUID shipId2 = testShip2.getShipId();
        entityManager.persist(testShip2);

        shipRepository.deleteById(shipId2);
        List<ShipEntity> allShips = shipRepository.findAll();

        Assert.assertEquals(1, allShips.size());
    }
}
