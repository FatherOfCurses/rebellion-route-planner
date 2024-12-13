package org.rebelalliance.flightplanner.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@EqualsAndHashCode
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
}
