package eti.query.demonstration.job.entities;


import eti.query.demonstration.converters.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "JOB_HISTORY", schema = "HR")
public class JobHistoryEntity {

    @EmbeddedId
    private JobHistoryEntityPK pk;

    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "JOB_ID")
    private String jobId;

    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

    public JobHistoryEntityPK getPk() {
        return pk;
    }

    public void setPk(JobHistoryEntityPK pk) {
        this.pk = pk;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, endDate, jobId, departmentId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JobHistoryEntity that = (JobHistoryEntity) o;
        return Objects.equals(pk, ((JobHistoryEntity) o).pk) &&
                Objects.equals(endDate, that.endDate) && Objects.equals(jobId, that.jobId) &&
                Objects.equals(departmentId, that.departmentId);
    }
}
