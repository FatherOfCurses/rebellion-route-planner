package org.rebelalliance.flightplanner.helpers;

import org.rebelalliance.flightplanner.model.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EntityHelper {

    List<UserEntity> portResidents = bulkCreateUsers(50);
    List<UserEntity> portVisitors = bulkCreateUsers(40);
    List<PilotEntity> homePilots = bulkCreatePilots(50);
    List<PilotEntity> visitingPilots = bulkCreatePilots(30);

    public List<UserEntity> bulkCreateUsers(int numberOfUsers) {
        List<UserEntity> userList = new ArrayList<UserEntity>();
        for (int i = 0; i < numberOfUsers; i++) {
            UserEntity newUser = new UserEntity();
            userList.add(newUser);
        }
        return userList;
    }

    public List<PilotEntity> bulkCreatePilots(int numberOfPilots) {
        List<PilotEntity> pilotList = new ArrayList<PilotEntity>();
        for (int i = 0; i < numberOfPilots; i++) {
            PilotEntity newPilot = new PilotEntity();
            pilotList.add(newPilot);
        }
        return pilotList;
    }

    public UserEntity createCargoCustomer() {
        return UserEntity.builder()
                .id(UUID.randomUUID())
                .firstname("Jabba")
                .lastname("The Hutt")
                .usertype("cargo")
                .username("jabbaH")
                .email("jabba@huttcartel.com")
                .build();
    }

    public UserEntity createShipOwner() {
        return UserEntity.builder()
                .id(UUID.randomUUID())
                .firstname("Lando")
                .lastname("Calrissian")
                .usertype("owner")
                .username("colt45")
                .email("sabbacpro@bespin.com")
                .build();
    }

    public UserEntity createPassenger() {
        return UserEntity.builder()
                .id(UUID.randomUUID())
                .firstname("Obi-Wan")
                .lastname("Kenobi")
                .usertype("passenger")
                .username("benK")
                .email("obiwankenobi@jediorder.org")
                .build();
    }

    public SpaceportEntity createSpaceport() {
        List<String> facilities = new ArrayList<String>();
        facilities.add("fuel");
        facilities.add("freighter repair");
        facilities.add("passenger lounge");
        return SpaceportEntity.builder()
                .id(UUID.randomUUID())
                .civilianResidents(portResidents)
                .civilianVisitors(portVisitors)
                .pilotResidents(homePilots)
                .pilotVisitors(visitingPilots)
                .spaceportName("Mos Eisley")
                .spaceportSize("medium")
                .facilities(facilities)
                .locationX(27)
                .locationY(99)
                .locationZ(11)
                .status("SECURE")
                .build();
    }

    public RouteEntity createRouteEntity() {
        SpaceportEntity mosEisley = createSpaceport();
        SpaceportEntity alderaan = createSpaceport();
        SpaceportEntity bamboozle = createSpaceport();
        List<SpaceportEntity> waypoints = new ArrayList<>();
        waypoints.add(bamboozle);
        return RouteEntity.builder()
                .id(UUID.randomUUID())
                .originPort(mosEisley)
                .destinationPort(alderaan)
                .waypoints(waypoints)
                .length(283772)
                .leglengthminium(23892)
                .build();
    }

    public ShipEntity createShipEntity() {
        UserEntity shipOwner = createShipOwner();
        return ShipEntity.builder()
                .shipId(UUID.randomUUID())
                .shipcapacity(50000)
                .shipname("Razor Crest")
                .shiprange(782999)
                .shipsize("medium")
                .shiptype("freighter")
                .shipOwner(shipOwner)
                .build();
    }

    public BookingEntity createPassengerBookingEntity() {
        return BookingEntity.builder()
                .id(UUID.randomUUID())
                .route(createRouteEntity())
                .bookingtype("passenger")
                .datebooked(Date.valueOf(LocalDate.now()))
                .status("confirmed")
                .build();
    }

    public BookingEntity createPCargpBookingEntity() {
        return BookingEntity.builder()
                .id(UUID.randomUUID())
                .route(createRouteEntity())
                .bookingtype("cargo")
                .datebooked(Date.valueOf(LocalDate.now()))
                .status("confirmed")
                .build();
    }

    public PilotEntity createPilotEntity() {
        UserEntity pilotUser = UserEntity.builder()
                .id(UUID.randomUUID())
                .firstname("Han")
                .lastname("Solo")
                .usertype("pilot")
                .username("kesselRunner")
                .email("hansolo@corellian.com")
                .build();
        return PilotEntity.builder()
                .id(UUID.randomUUID())
                .user(pilotUser)
                .rating("freight")
                .standing("valid")
                .homePort(createSpaceport())
                .currentPort(createSpaceport())
                .build();

    }

    public TripEntity createTripEntity() {
        RouteEntity route = createRouteEntity();
        ShipEntity ship = createShipEntity();
        PilotEntity pilot = createPilotEntity();
        BookingEntity booking1 = createPassengerBookingEntity();
        BookingEntity booking2 = createPCargpBookingEntity();
        List<BookingEntity> bookingManifest = new ArrayList<BookingEntity>();
        bookingManifest.add(booking1);
        bookingManifest.add(booking2);

        return TripEntity.builder()
                .routeid(route.getId())
                .shipid(ship.getShipId())
                .pilotid(pilot.getId())
                .bookings(bookingManifest)
                .departurescheduled(Date.valueOf(LocalDate.now()))
                .arrivalscheduled(Date.valueOf(LocalDate.now()))
                .tripstatus("scheduled")
                .build();
    }
}
