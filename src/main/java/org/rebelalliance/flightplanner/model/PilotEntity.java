package org.rebelalliance.flightplanner.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "pilot", schema = "public")
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
    @ManyToOne
    private SpaceportEntity homePort;
    @ManyToOne
    private SpaceportEntity currentPort;
}
