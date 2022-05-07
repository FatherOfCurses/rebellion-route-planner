package org.rebelalliance.flightplanner.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "trip")
@Builder
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="org.hibernate.type.UUIDCharType")
    UUID tripId;

    @Column(name= "routeid", nullable = false)
    String routeId;

    @Column(name = "shipid", nullable = false)
    String shipId;

    @Column(name = "pilotid", nullable = false)
    String pilotId;

    @ElementCollection(name = "bookingid", nullable = false)
    List<String> bookings;

    @Column(name = "departurescheduled", nullable = false)
    Date departureScheduled;

    @Column(name = "arrivalscheduled", nullable = false)
    Date arrivalScheduled;

    @Column(name = "departureactual", nullable = true)
    Date departureActual;

    @Column(name = "arrivalactual", nullable = true)
    Date arrivalActual;

    @Column(name = "tripstatus", nullable = false)
    String tripStatus;

    private Trip(UUID tripId, String routeId, String shipId, String pilotId, List<String> bookings, Date departureScheduled, Date arrivalScheduled, Date departureActual, Date arrivalActual, String tripStatus) {
        this.tripId = tripId;
        this.routeId = routeId;
        this.shipId = shipId;
        this.pilotId = pilotId;
        this.bookings = bookings;
        this.departureScheduled = departureScheduled;
        this.arrivalScheduled = arrivalScheduled;
        this.departureActual = departureActual;
        this.arrivalActual = arrivalActual;
        this.tripStatus = tripStatus;
    }

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

    public String getTripStatus() {return tripStatus;}

    public void setTripStatus(String tripStatus) {this.tripStatus = tripStatus;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Trip trip = (Trip) o;
        return tripId != null && Objects.equals(tripId, trip.tripId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
