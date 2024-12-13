package org.rebelalliance.flightplanner.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CargoEntityTest {

    @Test
    void testGettersAndSetters() {
        // Mock dependencies
        UUID mockId = UUID.randomUUID();
        UserEntity mockCustomer = mock(UserEntity.class);
        String contents = "Fuel Cells";
        Integer mass = 1000;
        Boolean hazardous = true;
        Boolean timesensitive = false;

        // Create a CargoEntity instance
        CargoEntity cargo = new CargoEntity(mockId, mockCustomer, contents, mass, hazardous, timesensitive);

        // Assert values using getters
        assertEquals(mockId, cargo.getId());
        assertEquals(mockCustomer, cargo.getCustomer());
        assertEquals(contents, cargo.getContents());
        assertEquals(mass, cargo.getMass());
        assertEquals(hazardous, cargo.getHazardous());
        assertEquals(timesensitive, cargo.getTimesensitive());
    }

    @Test
    void testBuilder() {
        // Mock dependencies
        UUID mockId = UUID.randomUUID();
        UserEntity mockCustomer = mock(UserEntity.class);
        String contents = "Medical Supplies";
        Integer mass = 500;
        Boolean hazardous = false;
        Boolean timesensitive = true;

        // Create an instance using the builder
        CargoEntity cargo = CargoEntity.builder()
                .id(mockId)
                .customer(mockCustomer)
                .contents(contents)
                .mass(mass)
                .hazardous(hazardous)
                .timesensitive(timesensitive)
                .build();

        // Assert values using getters
        assertEquals(mockId, cargo.getId());
        assertEquals(mockCustomer, cargo.getCustomer());
        assertEquals(contents, cargo.getContents());
        assertEquals(mass, cargo.getMass());
        assertEquals(hazardous, cargo.getHazardous());
        assertEquals(timesensitive, cargo.getTimesensitive());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two instances with the same data
        UUID mockId = UUID.randomUUID();
        UserEntity mockCustomer = mock(UserEntity.class);
        String contents = "Food Supplies";
        Integer mass = 200;
        Boolean hazardous = false;
        Boolean timesensitive = true;

        CargoEntity cargo1 = new CargoEntity(mockId, mockCustomer, contents, mass, hazardous, timesensitive);
        CargoEntity cargo2 = new CargoEntity(mockId, mockCustomer, contents, mass, hazardous, timesensitive);

        // Assert equality and hash code
        assertEquals(cargo1, cargo2);
        assertEquals(cargo1.hashCode(), cargo2.hashCode());

        // Create a different instance
        CargoEntity cargo3 = new CargoEntity(UUID.randomUUID(), mockCustomer, "Different Contents", 300, true, false);

        // Assert inequality
        assertNotEquals(cargo1, cargo3);
        assertNotEquals(cargo1.hashCode(), cargo3.hashCode());
    }

    @Test
    void testToString() {
        // Create an instance
        CargoEntity cargo = CargoEntity.builder()
                .id(UUID.randomUUID())
                .contents("Electronics")
                .hazardous(false)
                .build();

        // Assert toString contains specific fields
        String result = cargo.toString();
        assertTrue(result.contains("Electronics"));
        assertTrue(result.contains("false"));
    }
}

