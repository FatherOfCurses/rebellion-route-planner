package org.rebelalliance.flightplanner.model;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@Table(name = "ship", schema = "public", catalog = "routemapper")
public class ShipEntity {
    @Id
    @Column(name = "ship_id", nullable = false)
    private UUID shipId;
    @Basic
    @Column(name = "shipname", nullable = false, length = -1)
    private String shipname;
    @Basic
    @Column(name = "shiprange", nullable = false)
    private Integer shiprange;
    @Basic
    @Column(name = "shiptype", nullable = false, length = -1)
    private String shiptype;
    @Basic
    @Column(name = "shipsize", nullable = false, length = -1)
    private String shipsize;
    @Basic
    @Column(name = "shipcapacity", nullable = false)
    private Integer shipcapacity;
    @ManyToOne
    private UserEntity shipOwner;

    public ShipEntity(UUID shipId, String shipname, Integer shiprange, String shiptype, String shipsize, Integer shipcapacity, UserEntity shipOwner) {
        this.shipId = shipId;
        this.shipname = shipname;
        this.shiprange = shiprange;
        this.shiptype = shiptype;
        this.shipsize = shipsize;
        this.shipcapacity = shipcapacity;
        this.shipOwner = shipOwner;
    }

    public UUID getShipId() {
        return shipId;
    }

    public void setShipId(UUID shipId) {
        this.shipId = shipId;
    }

    public String getShipname() {
        return shipname;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname;
    }

    public Integer getShiprange() {
        return shiprange;
    }

    public void setShiprange(Integer shiprange) {
        this.shiprange = shiprange;
    }

    public String getShiptype() {
        return shiptype;
    }

    public void setShiptype(String shiptype) {
        this.shiptype = shiptype;
    }

    public String getShipsize() {
        return shipsize;
    }

    public void setShipsize(String shipsize) {
        this.shipsize = shipsize;
    }

    public Integer getShipcapacity() {
        return shipcapacity;
    }

    public void setShipcapacity(Integer shipcapacity) {
        this.shipcapacity = shipcapacity;
    }

    public UserEntity getShipOwner() {
        return shipOwner;
    }

    public void setShipOwner(UserEntity shipOwner) {
        this.shipOwner = shipOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipEntity that = (ShipEntity) o;
        return Objects.equals(getShipId(), that.getShipId()) && Objects.equals(getShipname(), that.getShipname()) && Objects.equals(getShiprange(), that.getShiprange()) && Objects.equals(getShiptype(), that.getShiptype()) && Objects.equals(getShipsize(), that.getShipsize()) && Objects.equals(getShipcapacity(), that.getShipcapacity()) && Objects.equals(getShipOwner(), that.getShipOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShipId(), getShipname(), getShiprange(), getShiptype(), getShipsize(), getShipcapacity(), getShipOwner());
    }
}
