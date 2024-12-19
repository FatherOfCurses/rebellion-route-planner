package org.rebelalliance.flightplanner.model.helper;

import org.rebelalliance.flightplanner.model.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

public class TestObjectBuilder {

    public static UUID returnFixedId() {
        return UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
    }

    public static LocalDateTime returnFixedDate() {
        return LocalDateTime.of(2024, 12, 31, 0, 0);
    }

    public static UserEntity createTestUser() {
        return UserEntity.builder()
                .id(returnFixedId())
                .firstname("Luke")
                .lastname("Skywalker")
                .usertype("")
                .username("luke.skywalker")
                .email("luke@rebellion.org")
                .build();
    }

    public static SpaceportEntity createTestSpaceport() {
        return SpaceportEntity.builder()
                .id(returnFixedId())
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
    }

    public static PilotEntity createTestPilot() {
        PilotEntity pilot = PilotEntity.builder()
                .id(returnFixedId())
                .user(createTestUser())
                .rating("A+")
                .standing("Active")
                .homePort(createTestSpaceport())
                .currentPort(createTestSpaceport())
                .build();
        pilot.getUser().setUsertype("pilot");
        return pilot;
    }

    public static CargoEntity createTestCargo() {
        CargoEntity cargo = CargoEntity.builder()
                .id(returnFixedId())
                .customer(createTestUser())
                .contents("Blue Milk")
                .mass(800000)
                .hazardous(false)
                .timesensitive(true)
                .build();
        cargo.getCustomer().setUsertype("customer");
        return cargo;
    }

    public static ShipEntity createTestShip() {
        ShipEntity ship = ShipEntity.builder()
                .shipId(returnFixedId())
                .shipname("Razor Crest")
                .shiprange(47620)
                .shiptype("Corvette")
                .shipsize("Medium")
                .shipcapacity(800000)
                .shipOwner(createTestUser())
                .build();
        ship.getShipOwner().setUsertype("pilot");
        return ship;
    }

    public static RouteEntity createTestRoute() {
        RouteEntity route = RouteEntity.builder()
                .id(returnFixedId())
                .originPort(createTestSpaceport())
                .destinationPort(createTestSpaceport())
                .waypoints(Collections.emptyList())
                .length(57829)
                .leglengthminium(500)
                .build();
        route.getDestinationPort().setSpaceportName("Different Port");
        return route;
    }

    public static BookingEntity createTestBooking() {
        BookingEntity booking = BookingEntity.builder()
                .id(returnFixedId())
                .route(createTestRoute())
                .cargo(createTestCargo())
                .customer(createTestUser())
                .bookingtype("Standard")
                .datebooked(returnFixedDate())
                .status("Final")
                .build();
        booking.getCustomer().setUsertype("passenger");
        return booking;
    }

    public static TripEntity createTestTrip() {
        LocalDateTime departureScheduled = returnFixedDate();
        return TripEntity.builder()
                .id(returnFixedId())
                .routeid(returnFixedId())
                .shipid(returnFixedId())
                .pilotid(returnFixedId())
                .bookings(Collections.emptyList())
                .departurescheduled(departureScheduled)
                .arrivalscheduled(departureScheduled.plusHours(3))
                .departureactual(departureScheduled.plusMinutes(30))
                .arrivalactual(departureScheduled.plusHours(4))
                .tripstatus("Completed")
                .build();
    }
}
