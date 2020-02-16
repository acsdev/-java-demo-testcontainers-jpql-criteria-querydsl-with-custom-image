package eti.query.demonstration.region.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "REGIONS", schema = "HR")
public class RegionEntity {

    @Id
    @Column(name = "REGION_ID")
    private long regionId;

    @Column(name = "REGION_NAME")
    private String regionName;

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }


    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionId, regionName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RegionEntity that = (RegionEntity) o;
        return regionId == that.regionId && Objects.equals(regionName, that.regionName);
    }
}
