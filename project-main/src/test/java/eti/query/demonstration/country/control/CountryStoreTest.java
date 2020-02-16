package eti.query.demonstration.country.control;

import eti.query.demonstration.AbstractPersistenceTest;
import eti.query.demonstration.country.entities.CountryEntity;
import eti.query.demonstration.util.DataDomain;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.persistence.EntityManager;
import java.util.List;

@RunWith(JUnit4.class)
public class CountryStoreTest extends AbstractPersistenceTest {

    private CountryStore storage;

    @Override
    protected void setEntityManager(final EntityManager em) {
        storage = new CountryStore();
        storage.setEntityManager(em);
    }

    @Test
    public void testJpqlFindAll() {
        DataDomain<List<CountryEntity>> dataDomain = storage.jpqlFindAll();
        Assert.assertEquals(25, dataDomain.getData().size());
    }

    @Test
    public void testCriteriaFindAll() {
        DataDomain<List<CountryEntity>> dataDomain = storage.criteriaFindAll();
        Assert.assertEquals(25, dataDomain.getData().size());
    }

    @Test
    public void testQueryDSLFindAll() {
        DataDomain<List<CountryEntity>> dataDomain = storage.queryDSLFindAll();
        Assert.assertEquals(25, dataDomain.getData().size());
    }
}
