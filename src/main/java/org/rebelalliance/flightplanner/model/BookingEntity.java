package org.rebelalliance.flightplanner.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "booking", schema = "public")
public class BookingEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @ManyToOne
    private RouteEntity route;
    @ManyToOne
    private CargoEntity cargo;
    @OneToOne
    private UserEntity customer;
    @Basic
    @Column(name = "bookingtype", nullable = false, length = -1)
    private String bookingtype;
    @Basic
    @Column(name = "datebooked", nullable = false)
    private Date datebooked;
    @Basic
    @Column(name = "status", nullable = false, length = -1)
    private String status;
}