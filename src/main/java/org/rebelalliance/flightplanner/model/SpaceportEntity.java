package org.rebelalliance.flightplanner.model;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.buf.StringUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Builder
@Table(name = "spaceport", schema = "public", catalog = "routemapper")
@NoArgsConstructor

public class SpaceportEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @OneToMany(targetEntity = UserEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<UserEntity> civilianResidents;
    @OneToMany(targetEntity = UserEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<UserEntity> civilianVisitors;
    @OneToMany(targetEntity = PilotEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<PilotEntity> pilotResidents;
    @OneToMany(targetEntity = PilotEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<PilotEntity> pilotVisitors;
    @Basic
    @Column(name="portname", nullable = false)
    private String spaceportName;
    @Basic
    @Column(name="portsize", nullable = false)
    private String spaceportSize;
    @Basic
    @Column(name="facilities", nullable = false)
    @Convert(converter = ListToStringConverter.class)
    private List<String> facilities;
    @Basic
    @Column(name="locationX", nullable = false)
    private int locationX;
    @Basic
    @Column(name="locationY", nullable = false)
    private int locationY;
    @Basic
    @Column(name="locationZ", nullable = false)
    private int locationZ;
    @Basic
    @Column(name="status", nullable = false)
    private String status;

    public SpaceportEntity(UUID id, List<UserEntity> civilianResidents, List<UserEntity> civilianVisitors, List<PilotEntity> pilotResidents, List<PilotEntity> pilotVisitors, String spaceportName, String spaceportSize, List<String> facilities, int locationX, int locationY, int locationZ, String status) {
        this.id = id;
        this.civilianResidents = civilianResidents;
        this.civilianVisitors = civilianVisitors;
        this.pilotResidents = pilotResidents;
        this.pilotVisitors = pilotVisitors;
        this.spaceportName = spaceportName;
        this.spaceportSize = spaceportSize;
        this.facilities = facilities;
        this.locationX = locationX;
        this.locationY = locationY;
        this.locationZ = locationZ;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<UserEntity> getCivilianResidents() {
        return civilianResidents;
    }

    public void setCivilianResidents(List<UserEntity> civilianResidents) {
        this.civilianResidents = civilianResidents;
    }

    public List<UserEntity> getCivilianVisitors() {
        return civilianVisitors;
    }

    public void setCivilianVisitors(List<UserEntity> civilianVisitors) {
        this.civilianVisitors = civilianVisitors;
    }

    public List<PilotEntity> getPilotResidents() {
        return pilotResidents;
    }

    public void setPilotResidents(List<PilotEntity> pilotResidents) {
        this.pilotResidents = pilotResidents;
    }

    public List<PilotEntity> getPilotVisitors() {
        return pilotVisitors;
    }

    public void setPilotVisitors(List<PilotEntity> pilotVisitors) {
        this.pilotVisitors = pilotVisitors;
    }

    public String getSpaceportName() {
        return spaceportName;
    }

    public void setSpaceportName(String spaceportName) {
        this.spaceportName = spaceportName;
    }

    public String getSpaceportSize() {
        return spaceportSize;
    }

    public void setSpaceportSize(String spaceportSize) {
        this.spaceportSize = spaceportSize;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public int getLocationZ() {
        return locationZ;
    }

    public void setLocationZ(int locationZ) {
        this.locationZ = locationZ;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceportEntity that = (SpaceportEntity) o;
        return getLocationX() == that.getLocationX() && getLocationY() == that.getLocationY() && getLocationZ() == that.getLocationZ() && Objects.equals(getId(), that.getId()) && Objects.equals(getCivilianResidents(), that.getCivilianResidents()) && Objects.equals(getCivilianVisitors(), that.getCivilianVisitors()) && Objects.equals(getPilotResidents(), that.getPilotResidents()) && Objects.equals(getPilotVisitors(), that.getPilotVisitors()) && Objects.equals(getSpaceportName(), that.getSpaceportName()) && Objects.equals(getSpaceportSize(), that.getSpaceportSize()) && Objects.equals(getFacilities(), that.getFacilities()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCivilianResidents(), getCivilianVisitors(), getPilotResidents(), getPilotVisitors(), getSpaceportName(), getSpaceportSize(), getFacilities(), getLocationX(), getLocationY(), getLocationZ(), getStatus());
    }

    @Converter
    public static class ListToStringConverter implements AttributeConverter<List<String>, String> {

        @Override
        public String convertToDatabaseColumn(List<String> attribute) {
            if (attribute == null || attribute.isEmpty()) {
                return "";
            }
            return StringUtils.join(attribute, ',');
        }

        @Override
        public List<String> convertToEntityAttribute(String dbData) {
            if (dbData == null || dbData.trim().length() == 0) {
                return new ArrayList<String>();
            }

            String[] data = dbData.split(",");
            return Arrays.asList(data);
        }
    }
}
