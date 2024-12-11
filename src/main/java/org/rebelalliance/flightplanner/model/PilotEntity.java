package org.rebelalliance.flightplanner.model;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
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

    public PilotEntity(UUID id, UserEntity user, String rating, String standing, SpaceportEntity homePort, SpaceportEntity currentPort) {
        this.id = id;
        this.user = user;
        this.rating = rating;
        this.standing = standing;
        this.homePort = homePort;
        this.currentPort = currentPort;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStanding() {
        return standing;
    }

    public void setStanding(String standing) {
        this.standing = standing;
    }

    public SpaceportEntity getHomePort() {
        return homePort;
    }

    public void setHomePort(SpaceportEntity homePort) {
        this.homePort = homePort;
    }

    public SpaceportEntity getCurrentPort() {
        return currentPort;
    }

    public void setCurrentPort(SpaceportEntity currentPort) {
        this.currentPort = currentPort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PilotEntity that = (PilotEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getUser(), that.getUser()) && Objects.equals(getRating(), that.getRating()) && Objects.equals(getStanding(), that.getStanding()) && Objects.equals(getHomePort(), that.getHomePort()) && Objects.equals(getCurrentPort(), that.getCurrentPort());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getRating(), getStanding(), getHomePort(), getCurrentPort());
    }
}
