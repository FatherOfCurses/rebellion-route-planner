package org.rebelalliance.flightplanner.model.helper;

import org.rebelalliance.flightplanner.model.*;

import java.sql.Date;
import java.util.Collections;
import java.util.UUID;

public class TestObjectBuilder {

    public static UserEntity createTestUser() {
        return UserEntity.builder()
                .id(UUID.randomUUID())
                .firstname("Luke")
                .lastname("Skywalker")
                .usertype("")
                .username("luke.skywalker")
                .email("luke@rebellion.org")
                .build();
    }

    public static SpaceportEntity createTestSpaceport() {
        return SpaceportEntity.builder()
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
    }

    public static PilotEntity createTestPilot() {
        PilotEntity pilot = PilotEntity.builder()
                .id(UUID.randomUUID())
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
                .id(UUID.randomUUID())
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
                .shipId(UUID.randomUUID())
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
                .id(UUID.randomUUID())
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
                .id(UUID.randomUUID())
                .route(createTestRoute())
                .cargo(createTestCargo())
                .customer(createTestUser())
                .bookingtype("Standard")
                .datebooked(new Date(System.currentTimeMillis()))
                .status("Final")
                .build();
        booking.getCustomer().setUsertype("passenger");
        return booking;
    }

    public static TripEntity createTestTrip() {
        return TripEntity.builder()
                .id(UUID.randomUUID())
                .routeid(UUID.randomUUID())
                .shipid(UUID.randomUUID())
                .pilotid(UUID.randomUUID())
                .bookings(Collections.emptyList())
                .departurescheduled(new Date(System.currentTimeMillis()))
                .arrivalscheduled(new Date(System.currentTimeMillis() + 360000))
                .departureactual(new Date(System.currentTimeMillis() + 10000))
                .arrivalactual(new Date(System.currentTimeMillis() + 720000))
                .tripstatus("Completed")
                .build();
    }
}
