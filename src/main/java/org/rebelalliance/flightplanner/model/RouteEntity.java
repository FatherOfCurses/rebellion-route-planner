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
@Builder
@Data
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "route", schema = "public", catalog = "routemapper")
public class RouteEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false)
    private UUID id;
    @OneToOne(targetEntity = SpaceportEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private SpaceportEntity originPort;
    @OneToOne(targetEntity = SpaceportEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
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

}
