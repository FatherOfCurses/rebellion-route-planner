package org.rebelalliance.flightplanner.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "cargo", schema = "public")
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
}
