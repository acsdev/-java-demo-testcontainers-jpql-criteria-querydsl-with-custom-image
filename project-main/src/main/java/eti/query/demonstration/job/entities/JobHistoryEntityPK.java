package eti.query.demonstration.job.entities;

import eti.query.demonstration.converters.LocalDateTimeAttributeConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class JobHistoryEntityPK implements Serializable {

    @Column(name = "EMPLOYEE_ID")
    private long employeeId;

    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, startDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JobHistoryEntityPK that = (JobHistoryEntityPK) o;
        return employeeId == that.employeeId && Objects.equals(startDate, that.startDate);
    }
}
