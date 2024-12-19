package org.rebelalliance.flightplanner.model;

import org.junit.jupiter.api.Test;
import org.rebelalliance.flightplanner.model.helper.TestObjectBuilder;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TripEntityTest {

    LocalDateTime departureTime = TestObjectBuilder.returnFixedDate();
    UUID testId = TestObjectBuilder.returnFixedId();

    @Test
    void testGettersAndSetters() {
        // Mock dependencies
        UUID id = testId;
        UUID routeId = testId;
        UUID shipId = testId;
        UUID pilotId = testId;
        List<BookingEntity> bookings = Collections.emptyList();
        LocalDateTime departureScheduled = departureTime;
        LocalDateTime arrivalScheduled = departureTime.plusHours(3);
        LocalDateTime departureActual = departureTime.plusMinutes(30);
        LocalDateTime arrivalActual = departureTime.plusHours(4);
        String tripStatus = "Scheduled";

        // Create a TripEntity instance
        TripEntity trip = new TripEntity(
                id, routeId, shipId, pilotId, bookings, departureScheduled, arrivalScheduled,
                departureActual, arrivalActual, tripStatus
        );

        // Assert values using getters
        assertEquals(id, trip.getId());
        assertEquals(routeId, trip.getRouteid());
        assertEquals(shipId, trip.getShipid());
        assertEquals(pilotId, trip.getPilotid());
        assertEquals(bookings, trip.getBookings());
        assertEquals(departureScheduled, trip.getDeparturescheduled());
        assertEquals(arrivalScheduled, trip.getArrivalscheduled());
        assertEquals(departureActual, trip.getDepartureactual());
        assertEquals(arrivalActual, trip.getArrivalactual());
        assertEquals(tripStatus, trip.getTripstatus());
    }

    @Test
    void testBuilder() {
        // Mock dependencies
        UUID id = testId;
        UUID routeId = testId;
        UUID shipId = testId;
        UUID pilotId = testId;
        List<BookingEntity> bookings = Collections.emptyList();
        LocalDateTime departureScheduled = departureTime;
        LocalDateTime arrivalScheduled = departureTime.plusHours(3);
        LocalDateTime departureActual = departureTime.plusMinutes(30);
        LocalDateTime arrivalActual = departureTime.plusHours(4);
        String tripStatus = "Completed";

        // Create an instance using the builder
        TripEntity trip = TestObjectBuilder.createTestTrip();

        // Assert values using getters
        assertEquals(id, trip.getId());
        assertEquals(routeId, trip.getRouteid());
        assertEquals(shipId, trip.getShipid());
        assertEquals(pilotId, trip.getPilotid());
        assertEquals(bookings, trip.getBookings());
        assertEquals(departureScheduled, trip.getDeparturescheduled());
        assertEquals(arrivalScheduled, trip.getArrivalscheduled());
        assertEquals(departureActual, trip.getDepartureactual());
        assertEquals(arrivalActual, trip.getArrivalactual());
        assertEquals(tripStatus, trip.getTripstatus());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two instances with the same data
        UUID id = testId;
        UUID routeId = testId;
        UUID shipId = testId;
        UUID pilotId = testId;
        List<BookingEntity> bookings = Collections.emptyList();
        LocalDateTime departureScheduled = departureTime;
        LocalDateTime arrivalScheduled = departureTime.plusHours(3);
        LocalDateTime departureActual = departureTime.plusMinutes(30);
        LocalDateTime arrivalActual = departureTime.plusHours(4);
        String tripStatus = "Active";

        TripEntity trip1 = new TripEntity(id, routeId, shipId, pilotId, bookings, departureScheduled, arrivalScheduled, departureActual, arrivalActual, tripStatus);
        TripEntity trip2 = new TripEntity(id, routeId, shipId, pilotId, bookings, departureScheduled, arrivalScheduled, departureActual, arrivalActual, tripStatus);

        // Assert equality and hash code
        assertEquals(trip1, trip2);
        assertEquals(trip1.hashCode(), trip2.hashCode());

        // Create a different instance
        TripEntity trip3 = new TripEntity(testId, routeId, shipId, pilotId, bookings, departureScheduled, arrivalScheduled, departureActual, arrivalActual, "Canceled");

        // Assert inequality
        assertNotEquals(trip1, trip3);
        assertNotEquals(trip1.hashCode(), trip3.hashCode());
    }

    @Test
    void testToString() {
        // Create an instance
        TripEntity trip = TripEntity.builder()
                .id(testId)
                .tripstatus("In Progress")
                .build();

        // Assert toString contains specific fields
        String result = trip.toString();
        assertTrue(result.contains("In Progress"));
    }
}

