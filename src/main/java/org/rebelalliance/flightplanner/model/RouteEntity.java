package org.rebelalliance.flightplanner.model;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@Table(name = "route", schema = "public", catalog = "routemapper")
public class RouteEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false)
    private UUID id;
    @OneToOne
    private SpaceportEntity originPort;
    @OneToOne
    private SpaceportEntity destinationPort;
    @OneToMany(targetEntity = SpaceportEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @Column(name = "waypointid", nullable = true)
    private List<SpaceportEntity> waypoints;
    @Basic
    @Column(name = "length", nullable = false)
    private Integer length;
    @Basic
    @Column(name = "leglengthminium", nullable = false)
    private Integer leglengthminium;

    public RouteEntity(UUID id, SpaceportEntity originPort, SpaceportEntity destinationPort, List<SpaceportEntity> waypoints, Integer length, Integer leglengthminium) {
        this.id = id;
        this.originPort = originPort;
        this.destinationPort = destinationPort;
        this.waypoints = waypoints;
        this.length = length;
        this.leglengthminium = leglengthminium;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SpaceportEntity getOriginPort() {
        return originPort;
    }

    public void setOriginPort(SpaceportEntity originPort) {
        this.originPort = originPort;
    }

    public SpaceportEntity getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(SpaceportEntity destinationPort) {
        this.destinationPort = destinationPort;
    }

    public List<SpaceportEntity> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<SpaceportEntity> waypoints) {
        this.waypoints = waypoints;
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
        return Objects.equals(getId(), that.getId()) && Objects.equals(getOriginPort(), that.getOriginPort()) && Objects.equals(getDestinationPort(), that.getDestinationPort()) && Objects.equals(getWaypoints(), that.getWaypoints()) && Objects.equals(getLength(), that.getLength()) && Objects.equals(getLeglengthminium(), that.getLeglengthminium());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOriginPort(), getDestinationPort(), getWaypoints(), getLength(), getLeglengthminium());
    }
}
