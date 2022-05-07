package org.rebelalliance.flightplanner.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "route", schema = "public", catalog = "routemapper")
public class RouteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Object id;
    @Basic
    @Column(name = "originid", nullable = false)
    private Object originid;
    @Basic
    @Column(name = "destinationid", nullable = false)
    private Object destinationid;
    @Basic
    @Column(name = "waypointid", nullable = true)
    private Object waypointid;
    @Basic
    @Column(name = "length", nullable = false)
    private Integer length;
    @Basic
    @Column(name = "leglengthminium", nullable = false)
    private Integer leglengthminium;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getOriginid() {
        return originid;
    }

    public void setOriginid(Object originid) {
        this.originid = originid;
    }

    public Object getDestinationid() {
        return destinationid;
    }

    public void setDestinationid(Object destinationid) {
        this.destinationid = destinationid;
    }

    public Object getWaypointid() {
        return waypointid;
    }

    public void setWaypointid(Object waypointid) {
        this.waypointid = waypointid;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getLeglengthminium() {
        return leglengthminium;
    }

    public void setLeglengthminium(Integer leglengthminium) {
        this.leglengthminium = leglengthminium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteEntity that = (RouteEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(originid, that.originid) && Objects.equals(destinationid, that.destinationid) && Objects.equals(waypointid, that.waypointid) && Objects.equals(length, that.length) && Objects.equals(leglengthminium, that.leglengthminium);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originid, destinationid, waypointid, length, leglengthminium);
    }
}
