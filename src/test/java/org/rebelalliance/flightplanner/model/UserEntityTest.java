package org.rebelalliance.flightplanner.model;


import org.junit.jupiter.api.Test;
import org.rebelalliance.flightplanner.model.helper.TestObjectBuilder;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {

    @Test
    void testGettersAndSetters() {
        // Create test data
        UUID id = UUID.randomUUID();
        String firstname = "Luke";
        String lastname = "Skywalker";
        String usertype = "Pilot";
        String username = "luke.skywalker";
        String email = "luke@rebellion.org";

        // Create a UserEntity instance
        UserEntity user = new UserEntity(id, firstname, lastname, usertype, username, email);

        // Assert values using getters
        assertEquals(id, user.getId());
        assertEquals(firstname, user.getFirstname());
        assertEquals(lastname, user.getLastname());
        assertEquals(usertype, user.getUsertype());
        assertEquals(username, user.getUsername());
        assertEquals(email, user.getEmail());
    }

    @Test
    void testBuilder() {
        // Create test data
        UUID id = UUID.randomUUID();
        String firstname = "Luke";
        String lastname = "Skywalker";
        String usertype = "Pilot";
        String username = "luke.skywalker";
        String email = "luke@rebellion.org";

        // Create an instance using the builder
        UserEntity user = TestObjectBuilder.createTestUser();

        // Assert values using getters
        assertEquals(id, user.getId());
        assertEquals(firstname, user.getFirstname());
        assertEquals(lastname, user.getLastname());
        assertEquals(usertype, user.getUsertype());
        assertEquals(username, user.getUsername());
        assertEquals(email, user.getEmail());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two instances with the same data
        UUID id = UUID.randomUUID();
        String firstname = "Han";
        String lastname = "Solo";
        String usertype = "Smuggler";
        String username = "han.solo";
        String email = "han@rebellion.org";

        UserEntity user1 = new UserEntity(id, firstname, lastname, usertype, username, email);
        UserEntity user2 = new UserEntity(id, firstname, lastname, usertype, username, email);

        // Assert equality and hash code
        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());

        // Create a different instance
        UserEntity user3 = new UserEntity(UUID.randomUUID(), firstname, lastname, usertype, "han.solo77", email);

        // Assert inequality
        assertNotEquals(user1, user3);
        assertNotEquals(user1.hashCode(), user3.hashCode());
    }

    @Test
    void testToString() {
        // Create an instance
        UserEntity user = UserEntity.builder()
                .id(UUID.randomUUID())
                .firstname("Yoda")
                .lastname("Master")
                .usertype("Jedi")
                .username("yoda.master")
                .email("yoda@force.org")
                .build();

        // Assert toString contains specific fields
        String result = user.toString();
        assertTrue(result.contains("Yoda"));
        assertTrue(result.contains("Jedi"));
        assertTrue(result.contains("yoda@force.org"));
    }
}
