package org.rebelalliance.flightplanner.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ShipEntityTest {

    @Test
    void testGettersAndSetters() {
        // Mock dependencies
        UUID mockShipId = UUID.randomUUID();
        String shipname = "Millennium Falcon";
        Integer shiprange = 1000;
        String shiptype = "Freighter";
        String shipsize = "Medium";
        Integer shipcapacity = 200;
        UserEntity mockShipOwner = mock(UserEntity.class);

        // Create a ShipEntity instance
        ShipEntity ship = new ShipEntity(mockShipId, shipname, shiprange, shiptype, shipsize, shipcapacity, mockShipOwner);

        // Assert values using getters
        assertEquals(mockShipId, ship.getShipId());
        assertEquals(shipname, ship.getShipname());
        assertEquals(shiprange, ship.getShiprange());
        assertEquals(shiptype, ship.getShiptype());
        assertEquals(shipsize, ship.getShipsize());
        assertEquals(shipcapacity, ship.getShipcapacity());
        assertEquals(mockShipOwner, ship.getShipOwner());
    }

    @Test
    void testBuilder() {
        // Mock dependencies
        UUID mockShipId = UUID.randomUUID();
        String shipname = "X-Wing";
        Integer shiprange = 2000;
        String shiptype = "Fighter";
        String shipsize = "Small";
        Integer shipcapacity = 1;
        UserEntity mockShipOwner = mock(UserEntity.class);

        // Create an instance using the builder
        ShipEntity ship = ShipEntity.builder()
                .shipId(mockShipId)
                .shipname(shipname)
                .shiprange(shiprange)
                .shiptype(shiptype)
                .shipsize(shipsize)
                .shipcapacity(shipcapacity)
                .shipOwner(mockShipOwner)
                .build();

        // Assert values using getters
        assertEquals(mockShipId, ship.getShipId());
        assertEquals(shipname, ship.getShipname());
        assertEquals(shiprange, ship.getShiprange());
        assertEquals(shiptype, ship.getShiptype());
        assertEquals(shipsize, ship.getShipsize());
        assertEquals(shipcapacity, ship.getShipcapacity());
        assertEquals(mockShipOwner, ship.getShipOwner());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two instances with the same data
        UUID mockShipId = UUID.randomUUID();
        String shipname = "Y-Wing";
        Integer shiprange = 1500;
        String shiptype = "Bomber";
        String shipsize = "Large";
        Integer shipcapacity = 4;
        UserEntity mockShipOwner = mock(UserEntity.class);

        ShipEntity ship1 = new ShipEntity(mockShipId, shipname, shiprange, shiptype, shipsize, shipcapacity, mockShipOwner);
        ShipEntity ship2 = new ShipEntity(mockShipId, shipname, shiprange, shiptype, shipsize, shipcapacity, mockShipOwner);

        // Assert equality and hash code
        assertEquals(ship1, ship2);
        assertEquals(ship1.hashCode(), ship2.hashCode());

        // Create a different instance
        ShipEntity ship3 = new ShipEntity(UUID.randomUUID(), "Different Ship", 500, "Transport", "Extra Large", 100, mockShipOwner);

        // Assert inequality
        assertNotEquals(ship1, ship3);
        assertNotEquals(ship1.hashCode(), ship3.hashCode());
    }

    @Test
    void testToString() {
        // Create an instance
        ShipEntity ship = ShipEntity.builder()
                .shipId(UUID.randomUUID())
                .shipname("Star Destroyer")
                .shiprange(5000)
                .build();

        // Assert toString contains specific fields
        String result = ship.toString();
        assertTrue(result.contains("Star Destroyer"));
        assertTrue(result.contains("5000"));
    }
}

