package eti.query.demonstration.job.control;

import eti.query.demonstration.AbstractPersistenceTest;
import eti.query.demonstration.job.entities.JobDomain;
import eti.query.demonstration.util.DataDomain;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.persistence.EntityManager;
import java.util.List;

@RunWith(JUnit4.class)
public class JobStoreTest extends AbstractPersistenceTest {

    private DataDomain<List<JobDomain>> result;

    private JobStore storage;

    @Override
    protected void setEntityManager(final EntityManager em) {
        storage = new JobStore();
        storage.setEntityManager(em);
    }

    @Test
    public void jpqlFindHistoryJobByJobId() {

        result = storage.jpqlFindHistoryJobByJobId("AC_MGR");
        Assert.assertEquals(1, result.getData().size());

        result = storage.jpqlFindHistoryJobByJobId("AC_ACCOUNT");
        Assert.assertEquals(2, result.getData().size());

        result = storage.jpqlFindHistoryJobByJobId("IT_PROG");
        Assert.assertEquals(1, result.getData().size());

        result = storage.jpqlFindHistoryJobByJobId("ST_CLERK");
        Assert.assertEquals(2, result.getData().size());

    }

    @Test
    public void criteriaFindHistoryJobByJobId() {

        result = storage.criteriaFindHistoryJobByJobId("AC_MGR");
        Assert.assertEquals(1, result.getData().size());

        result = storage.criteriaFindHistoryJobByJobId("AC_ACCOUNT");
        Assert.assertEquals(2, result.getData().size());

        result = storage.criteriaFindHistoryJobByJobId("IT_PROG");
        Assert.assertEquals(1, result.getData().size());

        result = storage.criteriaFindHistoryJobByJobId("ST_CLERK");
        Assert.assertEquals(2, result.getData().size());
    }

    @Test
    public void queryDSLFindHistoryJobByJobId() {

        result = storage.queryDSLFindHistoryJobByJobId("AC_MGR");
        Assert.assertEquals(1, result.getData().size());

        result = storage.queryDSLFindHistoryJobByJobId("AC_ACCOUNT");
        Assert.assertEquals(2, result.getData().size());

        result = storage.queryDSLFindHistoryJobByJobId("IT_PROG");
        Assert.assertEquals(1, result.getData().size());

        result = storage.queryDSLFindHistoryJobByJobId("ST_CLERK");
        Assert.assertEquals(2, result.getData().size());

    }

}
