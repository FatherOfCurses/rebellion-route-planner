package org.rebelalliance.flightplanner.model;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.type.UUIDCharType;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Builder
@Table(name = "user", schema = "public", catalog = "routemapper")
@NoArgsConstructor
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

    public UserEntity(UUID id, String firstname, String lastname, String usertype, String username, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.usertype = usertype;
        this.username = username;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(usertype, that.usertype) && Objects.equals(username, that.username) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, usertype, username, email);
    }
}
