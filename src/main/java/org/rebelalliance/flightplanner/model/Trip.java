package org.rebelalliance.flightplanner.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    UUID tripId;
    String routeId;
    String shipId;
    String pilotId;
    @ElementCollection
    List<String> bookings;
    Date departureScheduled;
    Date arrivalScheduled;
    Date departureActual;
    Date arrivalActual;

    public UUID getTripId() {
        return tripId;
    }

    public void setTripId(UUID tripId) {
        this.tripId = tripId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getShipId() {
        return shipId;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    public String getPilotId() {
        return pilotId;
    }

    public void setPilotId(String pilotId) {
        this.pilotId = pilotId;
    }

    public List<String> getBookings() {
        return bookings;
    }

    public void setBookings(List<String> bookings) {
        this.bookings = bookings;
    }

    public Date getDepartureScheduled() {
        return departureScheduled;
    }

    public void setDepartureScheduled(Date departureScheduled) {
        this.departureScheduled = departureScheduled;
    }

    public Date getArrivalScheduled() {
        return arrivalScheduled;
    }

    public void setArrivalScheduled(Date arrivalScheduled) {
        this.arrivalScheduled = arrivalScheduled;
    }

    public Date getDepartureActual() {
        return departureActual;
    }

    public void setDepartureActual(Date departureActual) {
        this.departureActual = departureActual;
    }

    public Date getArrivalActual() {
        return arrivalActual;
    }

    public void setArrivalActual(Date arrivalActual) {
        this.arrivalActual = arrivalActual;
    }
}
