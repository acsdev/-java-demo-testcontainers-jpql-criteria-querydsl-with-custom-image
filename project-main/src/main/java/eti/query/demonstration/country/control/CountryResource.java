package eti.query.demonstration.country.control;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("country")
public class CountryResource {

    @Inject
    private CountryStore store;

    @GET
    @Path("/jpql")
    public Response getCountryJPQL() {
        return Response.ok(store.jpqlFindAll()).build();
    }

    @GET
    @Path("/criteria")
    public Response getCountryCriteria() {
        return Response.ok(store.criteriaFindAll()).build();
    }

    @GET
    @Path("/dsl")
    public Response getCountryDSL() {
        return Response.ok(store.queryDSLFindAll()).build();
    }
}