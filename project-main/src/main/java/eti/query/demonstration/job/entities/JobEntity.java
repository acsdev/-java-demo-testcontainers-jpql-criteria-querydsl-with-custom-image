
package eti.query.demonstration.job.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "JOBS", schema = "HR")
public class JobEntity {

    @Id
    @Column(name = "JOB_ID")
    private String jobId;

    @Column(name = "JOB_TITLE")
    private String jobTitle;

    @Column(name = "MIN_SALARY")
    private Long minSalary;

    @Column(name = "MAX_SALARY")
    private Long maxSalary;

    @OneToMany
    @JoinColumn(name = "JOB_ID")
    private List<JobHistoryEntity> jobHistoryEntityList;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Long getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    public Long getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Long maxSalary) {
        this.maxSalary = maxSalary;
    }

    public List<JobHistoryEntity> getJobHistoryEntityList() {
        return jobHistoryEntityList;
    }

    public void setJobHistoryEntityList(List<JobHistoryEntity> jobHistoryEntityList) {
        this.jobHistoryEntityList = jobHistoryEntityList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, jobTitle, minSalary, maxSalary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JobEntity that = (JobEntity) o;
        return Objects.equals(jobId, that.jobId) && Objects.equals(jobTitle, that.jobTitle) &&
                Objects.equals(minSalary, that.minSalary) && Objects.equals(maxSalary, that.maxSalary);
    }
}
