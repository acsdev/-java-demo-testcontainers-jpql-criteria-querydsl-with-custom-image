package eti.query.demonstration.country.control;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import eti.query.demonstration.country.entities.CountryEntity;
import eti.query.demonstration.country.entities.dslmodel.QCountryEntity;
import eti.query.demonstration.util.DataDomain;
import org.eclipse.persistence.jpa.JpaQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class CountryStore {

    @PersistenceContext
    private EntityManager entityManager;

    void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public DataDomain<List<CountryEntity>> jpqlFindAll() {
        TypedQuery<CountryEntity> query =
                entityManager.createQuery("SELECT o FROM CountryEntity o", CountryEntity.class);

        List<CountryEntity> data = query.getResultList();
        String sql = query.unwrap(JpaQuery.class).getDatabaseQuery().getSQLString();

        return new DataDomain<>(data, sql);
    }

    public DataDomain<List<CountryEntity>> criteriaFindAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CountryEntity> criteria = builder.createQuery(CountryEntity.class);
        TypedQuery<CountryEntity> query = entityManager.createQuery(criteria);

        List<CountryEntity> data = query.getResultList();
        String sql = query.unwrap(JpaQuery.class).getDatabaseQuery().getSQLString();

        return new DataDomain<>(data, sql);
    }

    public  DataDomain<List<CountryEntity>> queryDSLFindAll() {

        JPAQuery<CountryEntity> query =
                new JPAQueryFactory(this.entityManager).selectFrom(QCountryEntity.countryEntity);

        List<CountryEntity> data = query.fetch();
        String sql = query.createQuery().unwrap(JpaQuery.class).getDatabaseQuery().getSQLString();

        return new DataDomain<>(data, sql);
    }
}
