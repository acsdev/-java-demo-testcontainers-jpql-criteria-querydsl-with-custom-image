package eti.query.demonstration.department.control;


import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import eti.query.demonstration.department.entities.DepartmentDomain;
import eti.query.demonstration.department.entities.DepartmentEntity;
import eti.query.demonstration.department.entities.dslmodel.QDepartmentEntity;
import eti.query.demonstration.department.entities.metamodel.DepartmentEntity_;
import eti.query.demonstration.employee.entities.EmployeeEntity;
import eti.query.demonstration.employee.entities.dslmodel.QEmployeeEntity;
import eti.query.demonstration.employee.entities.metamodel.EmployeeEntity_;
import eti.query.demonstration.location.entities.LocationEntity;
import eti.query.demonstration.location.entities.dslmodel.QLocationEntity;
import eti.query.demonstration.location.entities.metamodel.LocationEntity_;
import eti.query.demonstration.util.DataDomain;
import org.eclipse.persistence.jpa.JpaQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DepartmentStore {

    @PersistenceContext
    private EntityManager entityManager;

    void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public DataDomain<List<DepartmentDomain>> jpqlFindDepartamentWithManagerLocation() {
        StringBuffer jpql = new StringBuffer();
        jpql.append("      SELECT new eti.query.demonstration.department.entities");
        jpql.append(".DepartmentDomain(o.departmentName, e.firstName, l.streetAddress) ");
        jpql.append("        FROM DepartmentEntity o ");
        jpql.append("  INNER JOIN EmployeeEntity e ON e.employeeId = o.managerId ");
        jpql.append("  INNER JOIN LocationEntity l ON l.locationId = o.locationId ");

        TypedQuery<DepartmentDomain> query = entityManager.createQuery(jpql.toString(), DepartmentDomain.class);
        List<DepartmentDomain> data = query.getResultList();
        String sql = query.unwrap(JpaQuery.class).getDatabaseQuery().getSQLString();

        return new DataDomain<>(data, sql);
    }

    public DataDomain<List<DepartmentDomain>> criteriaFindDepartamentWithManagerLocation() {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DepartmentDomain> criteria = builder.createQuery(DepartmentDomain.class);
        Root<DepartmentEntity> department = criteria.from(DepartmentEntity.class);
        Root<EmployeeEntity> employee = criteria.from(EmployeeEntity.class);
        Root<LocationEntity> location = criteria.from(LocationEntity.class);

        criteria.select(builder.construct(DepartmentDomain.class,
            department.get(DepartmentEntity_.departmentName),
            employee.get(EmployeeEntity_.firstName),
            location.get(LocationEntity_.streetAddress)));

        criteria.where(
                builder.equal(department.get(DepartmentEntity_.managerId), employee.get(EmployeeEntity_.employeeId)),
                builder.equal(department.get(DepartmentEntity_.locationId), location.get(LocationEntity_.locationId)));

        TypedQuery<DepartmentDomain> query = entityManager.createQuery(criteria);
        List<DepartmentDomain> data = query.getResultList();
        String sql = query.unwrap(JpaQuery.class).getDatabaseQuery().getSQLString();

        return new DataDomain<>(data, sql);
    }

    public DataDomain<List<DepartmentDomain>> queryDSLFindDepartamentWithManagerLocation() {

        QDepartmentEntity department = QDepartmentEntity.departmentEntity;
        QEmployeeEntity employee = QEmployeeEntity.employeeEntity;
        QLocationEntity location = QLocationEntity.locationEntity;

        JPAQuery<DepartmentDomain> query = new JPAQueryFactory(this.entityManager)
                .select(Projections.bean(DepartmentDomain.class, department.departmentName, employee.firstName, location.streetAddress))
                .from(department)
                .innerJoin(employee)
                .on(employee.employeeId.eq(department.managerId))
                .innerJoin(location)
                .on(location.locationId.eq(department.locationId));

        List<DepartmentDomain> data = query.fetch();
        String sql = query.createQuery().unwrap(JpaQuery.class).getDatabaseQuery().getSQLString();

        return new DataDomain<>(data, sql);

    }
}
