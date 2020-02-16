package eti.query.demonstration.country.control;

import eti.query.demonstration.ConfigContainerTest;
import eti.query.demonstration.util.Util;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CountryResourceTest extends ConfigContainerTest {

    @Test
    public void testGetCountryJPQL() {
        Client client = ClientBuilder.newClient();

        String url = getAppServerURLBase().concat("/demo/country/jpql");
        Response response = client.target(url).request(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println( Util.getJson(response) );
    }

    @Test
    public void testGetCountryCriteria() {
        Client client = ClientBuilder.newClient();

        String url = getAppServerURLBase().concat("/demo/country/criteria");
        Response response = client.target(url).request(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println( Util.getJson(response) );
    }

    @Test
    public void testGetCountryQueryDSL() {
        Client client = ClientBuilder.newClient();

        String url = getAppServerURLBase().concat("/demo/country/dsl");
        Response response = client.target(url).request(MediaType.APPLICATION_JSON).get();

        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println( Util.getJson(response) );
    }
}
