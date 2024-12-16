package org.rebelalliance.flightplanner.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "trip", schema = "public")
public class TripEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = true, nullable = false)
    private UUID id;
    @Basic
    @Column(name = "routeid")
    private UUID routeid;
    @Basic
    @Column(name = "shipid")
    private UUID shipid;
    @Basic
    @Column(name = "pilotid")
    private UUID pilotid;
    @OneToMany(targetEntity = BookingEntity.class, cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, orphanRemoval = true)
    private List<BookingEntity> bookings;
    @Basic
    @Column(name = "departurescheduled")
    private Date departurescheduled;
    @Basic
    @Column(name = "arrivalscheduled")
    private Date arrivalscheduled;
    @Basic
    @Column(name = "departureactual")
    private Date departureactual;
    @Basic
    @Column(name = "arrivalactual")
    private Date arrivalactual;
    @Basic
    @Column(name = "tripstatus")
    private String tripstatus;

}

