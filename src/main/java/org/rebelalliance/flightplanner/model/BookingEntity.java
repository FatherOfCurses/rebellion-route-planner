package org.rebelalliance.flightplanner.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "booking", schema = "public", catalog = "routemapper")
public class BookingEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Object id;
    @Basic
    @Column(name = "cargoid", nullable = true)
    private Object cargoid;
    @Basic
    @Column(name = "customerid", nullable = false)
    private Object customerid;
    @Basic
    @Column(name = "bookingtype", nullable = false, length = -1)
    private String bookingtype;
    @Basic
    @Column(name = "datebooked", nullable = false)
    private Date datebooked;
    @Basic
    @Column(name = "status", nullable = false, length = -1)
    private String status;
    @Basic
    @Column(name = "tripid", nullable = false)
    private Object tripid;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getCargoid() {
        return cargoid;
    }

    public void setCargoid(Object cargoid) {
        this.cargoid = cargoid;
    }

    public Object getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Object customerid) {
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

    public Object getTripid() {
        return tripid;
    }

    public void setTripid(Object tripid) {
        this.tripid = tripid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEntity that = (BookingEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(cargoid, that.cargoid) && Objects.equals(customerid, that.customerid) && Objects.equals(bookingtype, that.bookingtype) && Objects.equals(datebooked, that.datebooked) && Objects.equals(status, that.status) && Objects.equals(tripid, that.tripid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cargoid, customerid, bookingtype, datebooked, status, tripid);
    }
}
