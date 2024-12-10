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
@Table(name = "booking", schema = "public")
@NoArgsConstructor
public class BookingEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @ManyToOne
    private RouteEntity route;
    @ManyToOne
    private CargoEntity cargo;
    @OneToOne
    private UserEntity customer;
    @Basic
    @Column(name = "bookingtype", nullable = false, length = -1)
    private String bookingtype;
    @Basic
    @Column(name = "datebooked", nullable = false)
    private Date datebooked;
    @Basic
    @Column(name = "status", nullable = false, length = -1)
    private String status;

    public BookingEntity(UUID id, RouteEntity route, CargoEntity cargo, UserEntity customer, String bookingtype, Date datebooked, String status) {
        this.id = id;
        this.route = route;
        this.cargo = cargo;
        this.customer = customer;
        this.bookingtype = bookingtype;
        this.datebooked = datebooked;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = route;
    }

    public CargoEntity getCargo() {
        return cargo;
    }

    public void setCargo(CargoEntity cargo) {
        this.cargo = cargo;
    }

    public UserEntity getCustomer() {
        return customer;
    }

    public void setCustomer(UserEntity customer) {
        this.customer = customer;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEntity that = (BookingEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getRoute(), that.getRoute()) && Objects.equals(getCargo(), that.getCargo()) && Objects.equals(getCustomer(), that.getCustomer()) && Objects.equals(getBookingtype(), that.getBookingtype()) && Objects.equals(getDatebooked(), that.getDatebooked()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRoute(), getCargo(), getCustomer(), getBookingtype(), getDatebooked(), getStatus());
    }
}