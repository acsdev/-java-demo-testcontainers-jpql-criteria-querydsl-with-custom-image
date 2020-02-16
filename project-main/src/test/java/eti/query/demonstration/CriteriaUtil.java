package eti.query.demonstration;

import eti.query.demonstration.country.entities.CountryEntity;
import eti.query.demonstration.country.entities.metamodel.CountryEntity_;
import eti.query.demonstration.department.entities.DepartmentEntity;
import eti.query.demonstration.department.entities.metamodel.DepartmentEntity_;
import eti.query.demonstration.employee.entities.EmployeeEntity;
import eti.query.demonstration.employee.entities.metamodel.EmployeeEntity_;
import eti.query.demonstration.job.entities.JobEntity;
import eti.query.demonstration.job.entities.JobHistoryEntity;
import eti.query.demonstration.job.entities.JobHistoryEntityPK;
import eti.query.demonstration.job.entities.metamodel.JobEntity_;
import eti.query.demonstration.job.entities.metamodel.JobHistoryEntityPK_;
import eti.query.demonstration.job.entities.metamodel.JobHistoryEntity_;
import eti.query.demonstration.location.entities.LocationEntity;
import eti.query.demonstration.location.entities.metamodel.LocationEntity_;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.*;
import java.time.LocalDateTime;

public class CriteriaUtil {

    public static void configMetaModel(EntityManager em) {
        Metamodel metamodel = em.getMetamodel();

        configCountryEntity( metamodel );
        configDepartmentEntity( metamodel );
        configLocationEntity( metamodel );
        configEmployeeEntity( metamodel );
        configJobEntity( metamodel );
    }

    public static void configCountryEntity(Metamodel metamodel) {
        EntityType<CountryEntity> entity = metamodel.entity(CountryEntity.class);

        CountryEntity_.countryId = getSingularField(entity, String.class, "countryId");
        CountryEntity_.countryName = getSingularField( entity, String.class, "countryName");
        CountryEntity_.regionId = getSingularField(entity, Long.class, "regionId");
    }

    public static void configDepartmentEntity(Metamodel metamodel) {
        EntityType<DepartmentEntity> entity = metamodel.entity(DepartmentEntity.class);
        DepartmentEntity_.departmentId = getSingularField(entity, Long.class, "departmentId");
        DepartmentEntity_.departmentName = getSingularField(entity, String.class, "departmentName");
        DepartmentEntity_.locationId = getSingularField(entity, Long.class, "locationId");
        DepartmentEntity_.managerId = getSingularField(entity, Long.class, "managerId");
    }

    public static void configLocationEntity(Metamodel metamodel) {
        EntityType<LocationEntity> entity = metamodel.entity(LocationEntity.class);
        LocationEntity_.locationId = getSingularField(entity, Long.class, "locationId");
        LocationEntity_.streetAddress = getSingularField(entity, String.class, "streetAddress");
    }

    public static void configEmployeeEntity(Metamodel metamodel) {
        EntityType<EmployeeEntity> entity = metamodel.entity(EmployeeEntity.class);
        EmployeeEntity_.employeeId = getSingularField(entity, Long.class, "employeeId");
        EmployeeEntity_.firstName = getSingularField(entity, String.class, "firstName");
    }

    public static void configJobEntity(Metamodel metamodel) {
        EntityType<JobEntity> entity = metamodel.entity(JobEntity.class);
        EntityType<JobHistoryEntity> entityHistory = metamodel.entity(JobHistoryEntity.class);
        EmbeddableType<JobHistoryEntityPK> entityHistoryPK = metamodel.embeddable(JobHistoryEntityPK.class);

        JobEntity_.jobId = getSingularField(entity, String.class, "jobId");
        JobEntity_.jobTitle = getSingularField(entity, String.class, "jobTitle");
        JobEntity_.minSalary = getSingularField(entity, Long.class, "minSalary");
        JobEntity_.maxSalary = getSingularField(entity, Long.class, "maxSalary");

        JobEntity_.jobHistoryEntityList = getListField(entity, JobHistoryEntity.class, "jobHistoryEntityList");

        JobHistoryEntity_.pk = getSingularField(entityHistory, JobHistoryEntityPK.class, "pk");
        JobHistoryEntity_.jobId= getSingularField(entityHistory, String.class, "jobId");
        JobHistoryEntity_.departmentId = getSingularField(entityHistory, Long.class, "departmentId");
        JobHistoryEntity_.endDate = getSingularField(entityHistory, LocalDateTime.class, "endDate");

        JobHistoryEntityPK_.employeeId = getSingularField(entityHistoryPK, Long.class, "employeeId");
        JobHistoryEntityPK_.startDate = getSingularField(entityHistoryPK, LocalDateTime.class, "startDate");

    }

    private static <E, F> SingularAttribute<E, F> getSingularField(ManagedType<E> entityType,
                                                                   Class<F> fieldType,
                                                                   String fieldName) {
        //noinspection unchecked
        return (SingularAttribute<E, F>) entityType.getDeclaredSingularAttribute(fieldName);
    }

    private static <E, F> ListAttribute<E, F> getListField(ManagedType<E> entityType,
                                                                   Class<F> fieldType,
                                                                   String fieldName) {
        //noinspection unchecked
        return (ListAttribute<E, F>) entityType.getDeclaredList(fieldName);
    }


}
