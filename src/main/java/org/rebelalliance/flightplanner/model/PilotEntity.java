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
@Table(name = "pilot", schema = "public", catalog = "routemapper")
public class PilotEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false)
    private UUID id;
    @OneToOne
    private UserEntity user;
    @Basic
    @Column(name = "classification", nullable = false, length = -1)
    private String rating;
    @Basic
    @Column(name = "standing", nullable = false, length = -1)
    private String standing;
    @OneToOne
    private SpaceportEntity homePort;
    @OneToOne
    private SpaceportEntity currentPort;
}
