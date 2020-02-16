package eti.query.demonstration.department.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "DEPARTMENTS", schema = "HR")
public class DepartmentEntity {

    @Id
    @Column(name = "DEPARTMENT_ID")
    private long departmentId;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    @Column(name = "MANAGER_ID")
    private Long managerId;

    @Column(name = "LOCATION_ID")
    private Long locationId;

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, departmentName, managerId, locationId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DepartmentEntity that = (DepartmentEntity) o;
        return departmentId == that.departmentId && Objects.equals(departmentName, that.departmentName) &&
                Objects.equals(managerId, that.managerId) && Objects.equals(locationId, that.locationId);
    }
}
