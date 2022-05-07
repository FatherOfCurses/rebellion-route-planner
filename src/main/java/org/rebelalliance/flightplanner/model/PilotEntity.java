package org.rebelalliance.flightplanner.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pilot", schema = "public", catalog = "routemapper")
public class PilotEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Object id;
    @Basic
    @Column(name = "userid", nullable = false)
    private Object userid;
    @Basic
    @Column(name = "classification", nullable = false, length = -1)
    private String classification;
    @Basic
    @Column(name = "standing", nullable = false, length = -1)
    private String standing;
    @Basic
    @Column(name = "baseportid", nullable = false)
    private Object baseportid;
    @Basic
    @Column(name = "currentportid", nullable = true)
    private Object currentportid;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getUserid() {
        return userid;
    }

    public void setUserid(Object userid) {
        this.userid = userid;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getStanding() {
        return standing;
    }

    public void setStanding(String standing) {
        this.standing = standing;
    }

    public Object getBaseportid() {
        return baseportid;
    }

    public void setBaseportid(Object baseportid) {
        this.baseportid = baseportid;
    }

    public Object getCurrentportid() {
        return currentportid;
    }

    public void setCurrentportid(Object currentportid) {
        this.currentportid = currentportid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PilotEntity that = (PilotEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(userid, that.userid) && Objects.equals(classification, that.classification) && Objects.equals(standing, that.standing) && Objects.equals(baseportid, that.baseportid) && Objects.equals(currentportid, that.currentportid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, classification, standing, baseportid, currentportid);
    }
}
