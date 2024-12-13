package org.rebelalliance.flightplanner.model;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class RouteEntityTest {

    @Test
    void testGettersAndSetters() {
        // Mock dependencies
        UUID mockId = UUID.randomUUID();
        SpaceportEntity mockOriginPort = mock(SpaceportEntity.class);
        SpaceportEntity mockDestinationPort = mock(SpaceportEntity.class);
        List<SpaceportEntity> mockWaypoints = Collections.emptyList();
        Integer length = 1000;
        Integer leglengthminium = 200;

        // Create a RouteEntity instance
        RouteEntity route = new RouteEntity(mockId, mockOriginPort, mockDestinationPort, mockWaypoints, length, leglengthminium);

        // Assert values using getters
        assertEquals(mockId, route.getId());
        assertEquals(mockOriginPort, route.getOriginPort());
        assertEquals(mockDestinationPort, route.getDestinationPort());
        assertEquals(mockWaypoints, route.getWaypoints());
        assertEquals(length, route.getLength());
        assertEquals(leglengthminium, route.getLeglengthminium());
    }

    @Test
    void testBuilder() {
        // Mock dependencies
        UUID mockId = UUID.randomUUID();
        SpaceportEntity mockOriginPort = mock(SpaceportEntity.class);
        SpaceportEntity mockDestinationPort = mock(SpaceportEntity.class);
        List<SpaceportEntity> mockWaypoints = Collections.emptyList();
        Integer length = 1500;
        Integer leglengthminium = 300;

        // Create an instance using the builder
        RouteEntity route = RouteEntity.builder()
                .id(mockId)
                .originPort(mockOriginPort)
                .destinationPort(mockDestinationPort)
                .waypoints(mockWaypoints)
                .length(length)
                .leglengthminium(leglengthminium)
                .build();

        // Assert values using getters
        assertEquals(mockId, route.getId());
        assertEquals(mockOriginPort, route.getOriginPort());
        assertEquals(mockDestinationPort, route.getDestinationPort());
        assertEquals(mockWaypoints, route.getWaypoints());
        assertEquals(length, route.getLength());
        assertEquals(leglengthminium, route.getLeglengthminium());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two instances with the same data
        UUID mockId = UUID.randomUUID();
        SpaceportEntity mockOriginPort = mock(SpaceportEntity.class);
        SpaceportEntity mockDestinationPort = mock(SpaceportEntity.class);
        List<SpaceportEntity> mockWaypoints = Collections.emptyList();
        Integer length = 1000;
        Integer leglengthminium = 200;

        RouteEntity route1 = new RouteEntity(mockId, mockOriginPort, mockDestinationPort, mockWaypoints, length, leglengthminium);
        RouteEntity route2 = new RouteEntity(mockId, mockOriginPort, mockDestinationPort, mockWaypoints, length, leglengthminium);

        // Assert equality and hash code
        assertEquals(route1, route2);
        assertEquals(route1.hashCode(), route2.hashCode());

        // Create a different instance
        RouteEntity route3 = new RouteEntity(UUID.randomUUID(), mockOriginPort, mockDestinationPort, mockWaypoints, 500, 100);

        // Assert inequality
        assertNotEquals(route1, route3);
        assertNotEquals(route1.hashCode(), route3.hashCode());
    }

    @Test
    void testToString() {
        // Create an instance
        RouteEntity route = RouteEntity.builder()
                .id(UUID.randomUUID())
                .length(2000)
                .leglengthminium(400)
                .build();

        // Assert toString contains specific fields
        String result = route.toString();
        assertTrue(result.contains("2000"));
        assertTrue(result.contains("400"));
    }
}

