package eti.query.demonstration;

import eti.query.demonstration.country.control.CountryResource;
import eti.query.demonstration.department.control.DepartmentResource;
import eti.query.demonstration.job.control.JobResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;


@ApplicationPath("/demo")
public class DemoApplication extends Application {

    /**
     * Set all the classes needed for launching this rest application
     *
     * @return the Set containing the specified classes.
     */
    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(CountryResource.class);
        resources.add(DepartmentResource.class);
        resources.add(JobResource.class);
        return resources;
    }
}