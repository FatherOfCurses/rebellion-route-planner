package org.rebelalliance.flightplanner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class FlightPlannerApplicationTests {

    @Test
    void contextLoads() {
        // Test to ensure the Spring application context loads without exceptions
        assertDoesNotThrow(() -> {
            FlightPlannerApplication.main(new String[]{});
        });
    }
}
