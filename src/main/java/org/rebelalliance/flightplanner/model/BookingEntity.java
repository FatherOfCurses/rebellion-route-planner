package org.rebelalliance.flightplanner.model;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Builder
@Table(name = "booking", schema = "public", catalog = "routemapper")
@NoArgsConstructor
public class BookingEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @ManyToOne
    TripEntity trip;
    @Basic
    @Column(name = "cargoid", nullable = true)
    private UUID cargoid;
    @Basic
    @Column(name = "customerid", nullable = false)
    private UUID customerid;
    @Basic
    @Column(name = "bookingtype", nullable = false, length = -1)
    private String bookingtype;
    @Basic
    @Column(name = "datebooked", nullable = false)
    private Date datebooked;
    @Basic
    @Column(name = "status", nullable = false, length = -1)
    private String status;

    public BookingEntity(UUID id, TripEntity trip, UUID cargoid, UUID customerid, String bookingtype, Date datebooked, String status) {
        this.id = id;
        this.trip = trip;
        this.cargoid = cargoid;
        this.customerid = customerid;
        this.bookingtype = bookingtype;
        this.datebooked = datebooked;
        this.status = status;
    }

    public Object getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCargoid() {
        return cargoid;
    }

    public void setCargoid(UUID cargoid) {
        this.cargoid = cargoid;
    }

    public UUID getCustomerid() {
        return customerid;
    }

    public void setCustomerid(UUID customerid) {
        this.customerid = customerid;
    }

    public String getBookingtype() {
        return bookingtype;
    }

    public void setBookingtype(String bookingtype) {
        this.bookingtype = bookingtype;
    }

    public Date getDatebooked() {
        return datebooked;
    }

    public void setDatebooked(Date datebooked) {
        this.datebooked = datebooked;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TripEntity getTrip() {
        return trip;
    }

    public void setTrip(TripEntity trip) {
        this.trip = trip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEntity that = (BookingEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTrip(), that.getTrip()) && Objects.equals(getCargoid(), that.getCargoid()) && Objects.equals(getCustomerid(), that.getCustomerid()) && Objects.equals(getBookingtype(), that.getBookingtype()) && Objects.equals(getDatebooked(), that.getDatebooked()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTrip(), getCargoid(), getCustomerid(), getBookingtype(), getDatebooked(), getStatus());
    }
}