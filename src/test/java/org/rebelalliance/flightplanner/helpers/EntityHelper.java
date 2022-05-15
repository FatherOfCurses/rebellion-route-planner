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
        UserEntity cargoCustomer = new UserEntity();
        cargoCustomer = UserEntity.builder()
                .id(UUID.randomUUID())
                .firstname("Jabba")
                .lastname("The Hutt")
                .usertype("cargo")
                .username("jabbaH")
                .email("jabba@huttcartel.com")
                .build();
        return cargoCustomer;
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

    public RouteEntity createRoute() {
        return RouteEntity.builder()
                .id(UUID.randomUUID())
                .build();
    }

    public CargoEntity createCargoEntity() {
        return CargoEntity.builder()
                .id(UUID.randomUUID())
                .build();
    }

    public ShipEntity createShipEntity() {
        return ShipEntity.builder()
                .id(UUID.randomUUID())
                .shipcapacity(50000)
                .shipname("Razor Crest")
                .shiprange(782999)
                .shipsize("medium")
                .shiptype("freighter")
                .build();
    }

    public BookingEntity createNookingEntity() {
        return BookingEntity.builder()
                .trip(new TripEntity())
                .bookingtype("passenger")
                .datebooked(Date.valueOf(LocalDate.now()))
                .status("confirmed")
                .build();
    }
}
