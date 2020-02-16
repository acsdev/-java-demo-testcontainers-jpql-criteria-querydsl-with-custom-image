package eti.query.demonstration.department.entities;

import java.util.Objects;

public class DepartmentDomain {

    private String department;

    private String manager;

    private String location;

    public DepartmentDomain() {

    }

    public DepartmentDomain(String department, String manager, String location) {
        this.department = department;
        this.manager = manager;
        this.location = location;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DepartmentDomain that = (DepartmentDomain) o;
        return Objects.equals(department, that.department) && Objects.equals(manager, that.manager) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department, manager, location);
    }
}
