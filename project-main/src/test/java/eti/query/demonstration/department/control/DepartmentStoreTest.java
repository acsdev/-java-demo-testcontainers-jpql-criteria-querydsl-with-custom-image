package eti.query.demonstration.department.control;

import eti.query.demonstration.AbstractPersistenceTest;
import eti.query.demonstration.department.entities.DepartmentDomain;
import eti.query.demonstration.util.DataDomain;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.persistence.EntityManager;
import java.util.List;

@RunWith(JUnit4.class)
public class DepartmentStoreTest extends AbstractPersistenceTest {

    private DepartmentStore storage;

    @Override
    protected void setEntityManager(final EntityManager em) {
        storage = new DepartmentStore();
        storage.setEntityManager(em);
    }

    @Test
    public void testJpqlFindDepartamentWithManagerLocation() {
        DataDomain<List<DepartmentDomain>> dataDomain = storage.jpqlFindDepartamentWithManagerLocation();
        Assert.assertEquals(11, dataDomain.getData().size());
    }

    @Test
    public void criteriaFindDepartamentWithManagerLocation() {
        DataDomain<List<DepartmentDomain>> dataDomain = storage.criteriaFindDepartamentWithManagerLocation();
        Assert.assertEquals(11,  dataDomain.getData().size());

    }

    @Test
    public void queryDSLFindDepartamentWithManagerLocation() {
        DataDomain<List<DepartmentDomain>> dataDomain = storage.queryDSLFindDepartamentWithManagerLocation();
        Assert.assertEquals(11,dataDomain.getData().size());
    }
}
