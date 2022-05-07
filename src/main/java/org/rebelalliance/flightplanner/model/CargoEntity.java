package org.rebelalliance.flightplanner.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cargo", schema = "public", catalog = "routemapper")
public class CargoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Object id;
    @Basic
    @Column(name = "contents", nullable = false, length = -1)
    private String contents;
    @Basic
    @Column(name = "mass", nullable = false)
    private Integer mass;
    @Basic
    @Column(name = "hazardous", nullable = false)
    private Boolean hazardous;
    @Basic
    @Column(name = "timesensitive", nullable = false)
    private Boolean timesensitive;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Integer getMass() {
        return mass;
    }

    public void setMass(Integer mass) {
        this.mass = mass;
    }

    public Boolean getHazardous() {
        return hazardous;
    }

    public void setHazardous(Boolean hazardous) {
        this.hazardous = hazardous;
    }

    public Boolean getTimesensitive() {
        return timesensitive;
    }

    public void setTimesensitive(Boolean timesensitive) {
        this.timesensitive = timesensitive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoEntity that = (CargoEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(contents, that.contents) && Objects.equals(mass, that.mass) && Objects.equals(hazardous, that.hazardous) && Objects.equals(timesensitive, that.timesensitive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contents, mass, hazardous, timesensitive);
    }
}
