package org.rebelalliance.flightplanner.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "trip", schema = "public", catalog = "routemapper")
public class TripEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Type(type="org.hibernate.type.UUIDCharType")
    @Id
    @Column(name = "id")
    private UUID id;
    @Basic
    @Column(name = "routeid")
    private UUID routeid;
    @Basic
    @Column(name = "shipid")
    private UUID shipid;
    @Basic
    @Column(name = "pilotid")
    private UUID pilotid;
    @ElementCollection
    @Column(name = "bookingid")
    private List<UUID> bookingid;
    @Basic
    @Column(name = "departurescheduled")
    private Date departurescheduled;
    @Basic
    @Column(name = "arrivalscheduled")
    private Date arrivalscheduled;
    @Basic
    @Column(name = "departureactual")
    private Date departureactual;
    @Basic
    @Column(name = "arrivalactual")
    private Date arrivalactual;
    @Basic
    @Column(name = "tripstatus")
    private String tripstatus;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getRouteid() {
        return routeid;
    }

    public void setRouteid(Object routeid) {
        this.routeid = routeid;
    }

    public Object getShipid() {
        return shipid;
    }

    public void setShipid(Object shipid) {
        this.shipid = shipid;
    }

    public Object getPilotid() {
        return pilotid;
    }

    public void setPilotid(Object pilotid) {
        this.pilotid = pilotid;
    }

    public Object getBookingid() {
        return bookingid;
    }

    public void setBookingid(Object bookingid) {
        this.bookingid = bookingid;
    }

    public Date getDeparturescheduled() {
        return departurescheduled;
    }

    public void setDeparturescheduled(Date departurescheduled) {
        this.departurescheduled = departurescheduled;
    }

    public Date getArrivalscheduled() {
        return arrivalscheduled;
    }

    public void setArrivalscheduled(Date arrivalscheduled) {
        this.arrivalscheduled = arrivalscheduled;
    }

    public Date getDepartureactual() {
        return departureactual;
    }

    public void setDepartureactual(Date departureactual) {
        this.departureactual = departureactual;
    }

    public Date getArrivalactual() {
        return arrivalactual;
    }

    public void setArrivalactual(Date arrivalactual) {
        this.arrivalactual = arrivalactual;
    }

    public String getTripstatus() {
        return tripstatus;
    }

    public void setTripstatus(String tripstatus) {
        this.tripstatus = tripstatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripEntity that = (TripEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(routeid, that.routeid) && Objects.equals(shipid, that.shipid) && Objects.equals(pilotid, that.pilotid) && Objects.equals(bookingid, that.bookingid) && Objects.equals(departurescheduled, that.departurescheduled) && Objects.equals(arrivalscheduled, that.arrivalscheduled) && Objects.equals(departureactual, that.departureactual) && Objects.equals(arrivalactual, that.arrivalactual) && Objects.equals(tripstatus, that.tripstatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeid, shipid, pilotid, bookingid, departurescheduled, arrivalscheduled, departureactual, arrivalactual, tripstatus);
    }
}
