package eti.query.demonstration.job.control;

import eti.query.demonstration.ConfigContainerTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class JobResourceTest extends ConfigContainerTest {

    @Test
    public void testFindHistoryJobByJobIdJPQL() {

        Client client = ClientBuilder.newClient();

        String url = getAppServerURLBase().concat("/demo/job/jpql/AC_MGR");

        Response response = client.target(url).request(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println(response.getEntity());

    }

    @Test
    public void testFindHistoryJobByJobIdCriteria() {

        Client client = ClientBuilder.newClient();

        String url = getAppServerURLBase().concat("/demo/job/criteria/AC_MGR");

        Response response = client.target(url).request(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println(response.getEntity());

    }

    @Test
    public void testFindHistoryJobByJobIdQueryDSL() {

        Client client = ClientBuilder.newClient();

        String url = getAppServerURLBase().concat("/demo/job/dsl/AC_MGR");

        Response response = client.target(url).request(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println(response.getEntity());

    }
}
