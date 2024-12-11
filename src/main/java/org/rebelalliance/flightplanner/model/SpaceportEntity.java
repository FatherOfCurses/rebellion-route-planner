package org.rebelalliance.flightplanner.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "spaceport", schema = "public")
public class SpaceportEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @OneToMany(targetEntity = UserEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<UserEntity> civilianResidents;

    @OneToMany(targetEntity = UserEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<UserEntity> civilianVisitors;

    @OneToMany(targetEntity = PilotEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<PilotEntity> pilotResidents;

    @OneToMany(targetEntity = PilotEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<PilotEntity> pilotVisitors;

    @Basic
    @Column(name = "portname", nullable = false)
    private String spaceportName;

    @Basic
    @Column(name = "portsize", nullable = false)
    private String spaceportSize;

    @Basic
    @Column(name = "facilities", nullable = false)
    private List<String> facilities;

    @Basic
    @Column(name = "locationX", nullable = false)
    private int locationX;

    @Basic
    @Column(name = "locationY", nullable = false)
    private int locationY;

    @Basic
    @Column(name = "locationZ", nullable = false)
    private int locationZ;

    @Basic
    @Column(name = "status", nullable = false)
    private String status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSpaceportName() {
        return spaceportName;
    }

    public String getSpaceportSize() {
        return spaceportSize;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public int getLocationZ() {
        return locationZ;
    }

    public String getStatus() {
        return status;
    }
}
