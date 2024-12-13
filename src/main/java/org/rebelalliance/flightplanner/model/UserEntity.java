package org.rebelalliance.flightplanner.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "user", schema = "public", catalog = "routemapper")
public class UserEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Basic
    @Column(name = "firstname", nullable = false, length = -1)
    private String firstname;
    @Basic
    @Column(name = "lastname", nullable = false, length = -1)
    private String lastname;
    @Basic
    @Column(name = "usertype", nullable = false, length = -1)
    private String usertype;
    @Basic
    @Column(name = "username", nullable = false, length = -1)
    private String username;
    @Basic
    @Column(name = "email", nullable = false, length = -1)
    private String email;

}
