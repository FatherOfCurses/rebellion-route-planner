package org.rebelalliance.flightplanner.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ship", schema = "public", catalog = "routemapper")
public class ShipEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Object id;
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

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipEntity that = (ShipEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(shipname, that.shipname) && Objects.equals(shiprange, that.shiprange) && Objects.equals(shiptype, that.shiptype) && Objects.equals(shipsize, that.shipsize) && Objects.equals(shipcapacity, that.shipcapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shipname, shiprange, shiptype, shipsize, shipcapacity);
    }
}
