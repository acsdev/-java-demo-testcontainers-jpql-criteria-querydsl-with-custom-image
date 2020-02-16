package eti.query.demonstration;

import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.TimeZone;

/**
 * Provides an entityManger for testing purposes
 */
public abstract class AbstractPersistenceTest {

    private EntityManager em;
    private EntityTransaction tx;

    /**
     * Initialize the entity manager
     */
    private void initalizeEm() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnitTEST");
        this.em = emf.createEntityManager();
        this.tx = this.em.getTransaction();
    }

    @Before
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        this.initalizeEm();

        setEntityManager(getEntityManager());

        CriteriaUtil.configMetaModel(getEntityManager());

        if (!this.tx.isActive()) {
            this.tx.begin();
        }
    }

    protected abstract void setEntityManager(EntityManager em);

    @After
    public void tearDown() {
        if (this.tx.isActive()) {
            this.tx.rollback();
        }
    }

    protected EntityManager getEntityManager() {
        return em;
    }

}
