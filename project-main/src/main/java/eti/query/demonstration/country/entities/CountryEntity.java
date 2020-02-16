package eti.query.demonstration.country.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "COUNTRIES", schema = "HR")
public class CountryEntity {

    @Id
    @Column(name = "COUNTRY_ID")
    private String countryId;

    @Column(name = "COUNTRY_NAME")
    private String countryName;

    @Column(name = "REGION_ID")
    private Long regionId;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, countryName, regionId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CountryEntity that = (CountryEntity) o;
        return Objects.equals(countryId, that.countryId) && Objects.equals(countryName, that.countryName) &&
                Objects.equals(regionId, that.regionId);
    }
}
