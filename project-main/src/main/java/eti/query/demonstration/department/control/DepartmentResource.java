package eti.query.demonstration.department.control;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("department")
public class DepartmentResource {

    @Inject
    private DepartmentStore store;

    @GET
    @Path("/jpql")
    public Response getDepartmentJPQL() {
        return Response.ok(store.jpqlFindDepartamentWithManagerLocation()).build();
    }

    @GET
    @Path("/criteria")
    public Response getDepartmentCriteria() {
        return Response.ok(store.criteriaFindDepartamentWithManagerLocation()).build();
    }

    @GET
    @Path("/dsl")
    public Response getDepartmentDSL() {
        return Response.ok(store.queryDSLFindDepartamentWithManagerLocation()).build();
    }
}
