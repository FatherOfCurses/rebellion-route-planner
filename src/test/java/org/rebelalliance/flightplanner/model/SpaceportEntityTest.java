package org.rebelalliance.flightplanner.model;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SpaceportEntityTest {

    @Test
    void testGettersAndSetters() {

        // Create SpaceportEntity instance
        SpaceportEntity spaceport = SpaceportEntity.builder()
                .id(UUID.randomUUID())
                .spaceportName("Port A")
                .spaceportSize("Large")
                .locationX(100)
                .locationY(200)
                .locationZ(300)
                .status("Operational")
                .civilianResidents(Collections.emptyList())
                .civilianVisitors(Collections.emptyList())
                .pilotResidents(Collections.emptyList())
                .pilotVisitors(Collections.emptyList())
                .facilities(Collections.emptyList())
                .build();


        // Assert values

        assertEquals("Galactic Hub", spaceport.getSpaceportName());
        assertEquals("Large", spaceport.getSpaceportSize());
        assertEquals(100, spaceport.getLocationX());
        assertEquals(200, spaceport.getLocationY());
        assertEquals(300, spaceport.getLocationZ());
        assertEquals("Operational", spaceport.getStatus());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        SpaceportEntity spaceport1 = SpaceportEntity.builder()
                .id(UUID.randomUUID())
                .civilianResidents(null)
                .civilianVisitors(null)
                .pilotResidents(null)
                .pilotVisitors(null)
                .spaceportName("Port A")
                .spaceportSize("Small")
                .facilities(null)
                .locationX(0)
                .locationY(0)
                .locationZ(0)
                .status("Active")
                .build();

        SpaceportEntity spaceport2 = SpaceportEntity.builder()
                .id(UUID.randomUUID())
                .civilianResidents(null)
                .civilianVisitors(null)
                .pilotResidents(null)
                .pilotVisitors(null)
                .spaceportName("Port A")
                .spaceportSize("Small")
                .facilities(null)
                .locationX(0)
                .locationY(0)
                .locationZ(0)
                .status("Active")
                .build();

        SpaceportEntity spaceport3 = SpaceportEntity.builder()
                .id(UUID.randomUUID())
                .civilianResidents(null)
                .civilianVisitors(null)
                .pilotResidents(null)
                .pilotVisitors(null)
                .spaceportName("Port B")
                .spaceportSize("Large")
                .facilities(null)
                .locationX(1)
                .locationY(1)
                .locationZ(1)
                .status("Inactive")
                .build();

        assertEquals(spaceport1, spaceport2);
        assertNotEquals(spaceport1, spaceport3);

        assertEquals(spaceport1.hashCode(), spaceport2.hashCode());
        assertNotEquals(spaceport1.hashCode(), spaceport3.hashCode());
    }

    @Test
    void testBuilder() {
        UUID id = UUID.randomUUID();

        SpaceportEntity spaceport = SpaceportEntity.builder()
                .id(id)
                .spaceportName("Galactic Hub")
                .spaceportSize("Medium")
                .locationX(50)
                .locationY(75)
                .locationZ(100)
                .status("Under Construction")
                .build();

        assertEquals(id, spaceport.getId());
        assertEquals("Galactic Hub", spaceport.getSpaceportName());
        assertEquals("Medium", spaceport.getSpaceportSize());
        assertEquals(50, spaceport.getLocationX());
        assertEquals(75, spaceport.getLocationY());
        assertEquals(100, spaceport.getLocationZ());
        assertEquals("Under Construction", spaceport.getStatus());
    }
}
