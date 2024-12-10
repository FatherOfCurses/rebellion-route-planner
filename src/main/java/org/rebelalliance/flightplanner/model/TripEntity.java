package org.rebelalliance.flightplanner.model;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@Table(name = "trip", schema = "public")
public class TripEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = true, nullable = false)
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
    @OneToMany(targetEntity = BookingEntity.class, cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, orphanRemoval = true)
    private List<BookingEntity> bookings;
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

    public TripEntity(UUID id, UUID routeid, UUID shipid, UUID pilotid, List<BookingEntity> bookings, Date departurescheduled, Date arrivalscheduled, Date departureactual, Date arrivalactual, String tripstatus) {
        this.id = id;
        this.routeid = routeid;
        this.shipid = shipid;
        this.pilotid = pilotid;
        this.bookings = bookings;
        this.departurescheduled = departurescheduled;
        this.arrivalscheduled = arrivalscheduled;
        this.departureactual = departureactual;
        this.arrivalactual = arrivalactual;
        this.tripstatus = tripstatus;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRouteid() {
        return routeid;
    }

    public void setRouteid(UUID routeid) {
        this.routeid = routeid;
    }

    public UUID getShipid() {
        return shipid;
    }

    public void setShipid(UUID shipid) {
        this.shipid = shipid;
    }

    public UUID getPilotid() {
        return pilotid;
    }

    public void setPilotid(UUID pilotid) {
        this.pilotid = pilotid;
    }

    public List<BookingEntity> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingEntity> bookings) {
        this.bookings = bookings;
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
        return Objects.equals(getId(), that.getId()) && Objects.equals(getRouteid(), that.getRouteid()) && Objects.equals(getShipid(), that.getShipid()) && Objects.equals(getPilotid(), that.getPilotid()) && Objects.equals(getBookings(), that.getBookings()) && Objects.equals(getDeparturescheduled(), that.getDeparturescheduled()) && Objects.equals(getArrivalscheduled(), that.getArrivalscheduled()) && Objects.equals(getDepartureactual(), that.getDepartureactual()) && Objects.equals(getArrivalactual(), that.getArrivalactual()) && Objects.equals(getTripstatus(), that.getTripstatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRouteid(), getShipid(), getPilotid(), getBookings(), getDeparturescheduled(), getArrivalscheduled(), getDepartureactual(), getArrivalactual(), getTripstatus());
    }
}

