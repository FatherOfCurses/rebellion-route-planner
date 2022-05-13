package org.rebelalliance.flightplanner.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class ShipEntityTest {

    private ShipEntity shipEntityUnderTest;

    @BeforeEach
    void setUp() {
        shipEntityUnderTest = new ShipEntity(UUID.fromString("1c230c46-cf08-4070-99f3-9199f79f72e5"), "shipname", 0,
                "shiptype", "shipsize", 0);
    }

    @Test
    void testEquals() {
        assertThat(shipEntityUnderTest.equals("o")).isTrue();
    }

    @Test
    void testHashCode() {
        assertThat(shipEntityUnderTest.hashCode()).isEqualTo(0);
    }
}
