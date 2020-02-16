package eti.query.demonstration.job.entities;

import java.time.LocalDateTime;

public class JobDomain {

    private String title;

    private String department;

    private String employee;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    /**
     *  To Work with DSL
     */
    public JobDomain() {
    }

    /**
     *  To Work with JPQL and Criteria
     *
     * @param title
     * @param department
     * @param employee
     * @param startDate
     * @param endDate
     */
    public JobDomain(String title, String department, String employee, LocalDateTime startDate, LocalDateTime endDate) {
        this.title = title;
        this.department = department;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
