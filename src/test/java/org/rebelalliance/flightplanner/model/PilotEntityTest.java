package org.rebelalliance.flightplanner.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PilotEntityTest {

    @Test
    void testGettersAndSetters() {
        // Mock dependencies
        UUID mockId = UUID.randomUUID();
        UserEntity mockUser = mock(UserEntity.class);
        SpaceportEntity mockHomePort = mock(SpaceportEntity.class);
        SpaceportEntity mockCurrentPort = mock(SpaceportEntity.class);
        String rating = "A+";
        String standing = "Excellent";

        // Create an instance
        PilotEntity pilot = new PilotEntity(mockId, mockUser, rating, standing, mockHomePort, mockCurrentPort);

        // Assert values using getters
        assertEquals(mockId, pilot.getId());
        assertEquals(mockUser, pilot.getUser());
        assertEquals(rating, pilot.getRating());
        assertEquals(standing, pilot.getStanding());
        assertEquals(mockHomePort, pilot.getHomePort());
        assertEquals(mockCurrentPort, pilot.getCurrentPort());
    }

    @Test
    void testBuilder() {
        // Mock dependencies
        UUID mockId = UUID.randomUUID();
        UserEntity mockUser = mock(UserEntity.class);
        SpaceportEntity mockHomePort = mock(SpaceportEntity.class);
        SpaceportEntity mockCurrentPort = mock(SpaceportEntity.class);
        String rating = "B";
        String standing = "Good";

        // Create an instance using the builder
        PilotEntity pilot = PilotEntity.builder()
                .id(mockId)
                .user(mockUser)
                .rating(rating)
                .standing(standing)
                .homePort(mockHomePort)
                .currentPort(mockCurrentPort)
                .build();

        // Assert values using getters
        assertEquals(mockId, pilot.getId());
        assertEquals(mockUser, pilot.getUser());
        assertEquals(rating, pilot.getRating());
        assertEquals(standing, pilot.getStanding());
        assertEquals(mockHomePort, pilot.getHomePort());
        assertEquals(mockCurrentPort, pilot.getCurrentPort());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two instances with the same data
        UUID mockId = UUID.randomUUID();
        UserEntity mockUser = mock(UserEntity.class);
        SpaceportEntity mockHomePort = mock(SpaceportEntity.class);
        SpaceportEntity mockCurrentPort = mock(SpaceportEntity.class);
        String rating = "A+";
        String standing = "Excellent";

        PilotEntity pilot1 = new PilotEntity(mockId, mockUser, rating, standing, mockHomePort, mockCurrentPort);
        PilotEntity pilot2 = new PilotEntity(mockId, mockUser, rating, standing, mockHomePort, mockCurrentPort);

        // Assert equality and hash code
        assertEquals(pilot1, pilot2);
        assertEquals(pilot1.hashCode(), pilot2.hashCode());

        // Create a different instance
        PilotEntity pilot3 = new PilotEntity(UUID.randomUUID(), mockUser, "B", "Good", mockHomePort, mockCurrentPort);

        // Assert inequality
        assertNotEquals(pilot1, pilot3);
        assertNotEquals(pilot1.hashCode(), pilot3.hashCode());
    }

    @Test
    void testToString() {
        // Create an instance
        PilotEntity pilot = PilotEntity.builder()
                .id(UUID.randomUUID())
                .rating("A")
                .standing("Excellent")
                .build();

        // Assert toString contains specific fields
        String result = pilot.toString();
        assertTrue(result.contains("A"));
        assertTrue(result.contains("Excellent"));
    }
}

