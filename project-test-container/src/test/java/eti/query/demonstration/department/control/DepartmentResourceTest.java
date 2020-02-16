package eti.query.demonstration.department.control;

import eti.query.demonstration.ConfigContainerTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class DepartmentResourceTest extends ConfigContainerTest {

    @Test
    public void testGetDepartmentJPQL() {
        Client client = ClientBuilder.newClient();

        String url = getAppServerURLBase().concat("/demo/department/jpql");
        Response response = client.target(url).request(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println(response.getEntity());
    }

    @Test
    public void testGetDepartmentCriteria() {
        Client client = ClientBuilder.newClient();

        String url = getAppServerURLBase().concat("/demo/department/criteria");
        Response response = client.target(url).request(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println(response.getEntity());
    }

    @Test
    public void testGetDepartmentQueryDSL() {
        Client client = ClientBuilder.newClient();

        String url = getAppServerURLBase().concat("/demo/department/dsl");
        Response response = client.target(url).request(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println(response.getEntity());
    }
}
