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
@Table(name = "cargo", schema = "public", catalog = "routemapper")
public class CargoEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @OneToOne
    UserEntity customer;
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

    public CargoEntity(UUID id, UserEntity customer, String contents, Integer mass, Boolean hazardous, Boolean timesensitive) {
        this.id = id;
        this.customer = customer;
        this.contents = contents;
        this.mass = mass;
        this.hazardous = hazardous;
        this.timesensitive = timesensitive;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserEntity getCustomer() {
        return customer;
    }

    public void setCustomer(UserEntity customer) {
        this.customer = customer;
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
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCustomer(), that.getCustomer()) && Objects.equals(getContents(), that.getContents()) && Objects.equals(getMass(), that.getMass()) && Objects.equals(getHazardous(), that.getHazardous()) && Objects.equals(getTimesensitive(), that.getTimesensitive());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomer(), getContents(), getMass(), getHazardous(), getTimesensitive());
    }
}
