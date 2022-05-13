package org.rebelalliance.flightplanner.helpers;

import org.rebelalliance.flightplanner.model.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EntityHelper {

    List<UserEntity> portResidents = bulkCreateUsers(50);
    List<UserEntity> portVisitors = bulkCreateUsers(40);
    List<PilotEntity> homePilots = bulkCreatePilots(50);
    List<PilotEntity> visitingPilots = bulkCreatePilots(30);

    public List<UserEntity> bulkCreateUsers(int numberOfUsers) {
        List<UserEntity> userList = null;
        for (int i = 0; i < numberOfUsers; i++) {
            userList = new ArrayList<UserEntity>();
            UserEntity newUser = new UserEntity();
            userList.add(newUser);
        }
        return userList;
    }

    public List<PilotEntity> bulkCreatePilots(int numberOfPilots) {
        List<PilotEntity> pilotList = null;
        for (int i = 0; i < numberOfPilots; i++) {
            pilotList = new ArrayList<PilotEntity>();
            PilotEntity newPilot = new PilotEntity();
            pilotList.add(newPilot);
        }
        return pilotList;
    }

    public UserEntity createCargoCustomer() {
        UserEntity cargoCustomer = new UserEntity();
        cargoCustomer = UserEntity.builder()
                .firstname("Jabba")
                .lastname("The Hutt")
                .usertype("cargo")
                .username("jabbaH")
                .email("jabba@huttcartel.com")
                .build();
        return cargoCustomer;
    }

    public UserEntity createPassenger() {
        UserEntity passenger = new UserEntity();
        passenger = UserEntity.builder()
                .firstname("Obi-Wan")
                .lastname("Kenobi")
                .usertype("passenger")
                .username("benK")
                .email("obiwankenobi@jediorder.org")
                .build();
        return passenger;
    }

    public SpaceportEntity createSpaceport() {
        List<String> facilities = new ArrayList<String>();
        facilities.add("fuel");
        facilities.add("freighter repair");
        facilities.add("passenger lounge");
        SpaceportEntity departurePort = new SpaceportEntity();
        departurePort = SpaceportEntity.builder()
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
        return departurePort;
    }

    public RouteEntity createRoute() {
        RouteEntity route = new RouteEntity();
        route = RouteEntity.builder()
                .build();
        return route;
    }

    public CargoEntity createCargoEntity() {
        return new CargoEntity().builder().build();
    }

    public ShipEntity createShipEntity() {
        ShipEntity ship = new ShipEntity();
        ship = ShipEntity.builder()
                .shipcapacity(50000)
                .shipname("Razor Crest")
                .shiprange(782999)
                .shipsize("medium")
                .shiptype("freighter")
                .build();
        return ship;
    }

    public BookingEntity createNookingEntity() {
        BookingEntity booking = new BookingEntity();
        booking = BookingEntity.builder()
                .trip(new TripEntity())
                .bookingtype("passenger")
                .datebooked(Date.valueOf(LocalDate.now()))
                .status("confirmed")
                .build();
        return booking;
    }
}
