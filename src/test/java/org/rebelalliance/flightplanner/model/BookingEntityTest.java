package org.rebelalliance.flightplanner.model;

import org.junit.jupiter.api.Test;
import org.rebelalliance.flightplanner.model.helper.TestObjectBuilder;

import java.sql.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BookingEntityTest {

    UUID staticUUID = TestObjectBuilder.returnFixedId();
    Date staticDate = TestObjectBuilder.returnFixedDate();


    @Test
    void testGettersAndSetters() {
        // Mock dependencies
        UUID mockId = staticUUID;
        RouteEntity mockRoute = mock(RouteEntity.class);
        CargoEntity mockCargo = mock(CargoEntity.class);
        UserEntity mockCustomer = mock(UserEntity.class);
        String bookingType = "VIP";
        Date dateBooked = new Date(System.currentTimeMillis());
        String status = "Confirmed";

        // Create a BookingEntity instance
        BookingEntity booking = new BookingEntity(mockId, mockRoute, mockCargo, mockCustomer, bookingType, dateBooked, status);

        // Assert values using getters
        assertEquals(mockId, booking.getId());
        assertEquals(mockRoute, booking.getRoute());
        assertEquals(mockCargo, booking.getCargo());
        assertEquals(mockCustomer, booking.getCustomer());
        assertEquals(bookingType, booking.getBookingtype());
        assertEquals(dateBooked, booking.getDatebooked());
        assertEquals(status, booking.getStatus());
    }

    @Test
    void testBuilder() {
        // Mock dependencies
        UUID mockId = staticUUID;
        RouteEntity mockRoute = TestObjectBuilder.createTestRoute();
        CargoEntity mockCargo = TestObjectBuilder.createTestCargo();
        UserEntity mockCustomer = TestObjectBuilder.createTestUser();
        mockCustomer.setUsertype("passenger");
        String bookingType = "Standard";
        Date dateBooked = staticDate;
        String status = "Final";

        // Create an instance using the builder
        BookingEntity booking = TestObjectBuilder.createTestBooking();

        // Assert values using getters
        assertEquals(mockId, booking.getId());
        assertEquals(mockRoute, booking.getRoute());
        assertEquals(mockCargo, booking.getCargo());
        assertEquals(mockCustomer, booking.getCustomer());
        assertEquals(bookingType, booking.getBookingtype());
        assertEquals(dateBooked, booking.getDatebooked());
        assertEquals(status, booking.getStatus());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two instances with the same data
        UUID mockId = UUID.randomUUID();
        RouteEntity mockRoute = mock(RouteEntity.class);
        CargoEntity mockCargo = mock(CargoEntity.class);
        UserEntity mockCustomer = mock(UserEntity.class);
        String bookingType = "Cargo";
        Date dateBooked = new Date(System.currentTimeMillis());
        String status = "Completed";

        BookingEntity booking1 = new BookingEntity(mockId, mockRoute, mockCargo, mockCustomer, bookingType, dateBooked, status);
        BookingEntity booking2 = new BookingEntity(mockId, mockRoute, mockCargo, mockCustomer, bookingType, dateBooked, status);

        // Assert equality
        assertEquals(booking1, booking2);
        assertEquals(booking1.hashCode(), booking2.hashCode());

        // Create a different instance
        BookingEntity booking3 = new BookingEntity(UUID.randomUUID(), mockRoute, mockCargo, mockCustomer, bookingType, dateBooked, status);

        // Assert inequality
        assertNotEquals(booking1, booking3);
        assertNotEquals(booking1.hashCode(), booking3.hashCode());
    }

    @Test
    void testToString() {
        // Create an instance
        BookingEntity booking = BookingEntity.builder()
                .id(UUID.randomUUID())
                .bookingtype("Economy")
                .status("Processing")
                .build();

        // Assert toString contains specific fields
        String result = booking.toString();
        assertTrue(result.contains("Economy"));
        assertTrue(result.contains("Processing"));
    }
}

