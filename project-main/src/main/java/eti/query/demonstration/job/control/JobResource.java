package eti.query.demonstration.job.control;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("job")
public class JobResource {

    @Inject
    private JobStore store;

    @GET
    @Path("/jpql/{id}")
    public Response getJobJPQL(@NotNull @PathParam("id") String id) {
        return Response.ok(store.jpqlFindHistoryJobByJobId(id)).build();
    }

    @GET
    @Path("/criteria/{id}")
    public Response getJobCriteria(@NotNull @PathParam("id") String id) {
        return Response.ok(store.criteriaFindHistoryJobByJobId(id)).build();
    }

    @GET
    @Path("/dsl/{id}")
    public Response getJobDSL(@NotNull @PathParam("id") String id) {
        return Response.ok(store.queryDSLFindHistoryJobByJobId(id)).build();
    }
}
