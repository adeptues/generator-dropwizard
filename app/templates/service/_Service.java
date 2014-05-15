package <%=packageName%>.<%=projectName%>service;

import java.util.List;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by thelmkay on 1/8/14.
 */
public class <%=projectName%>Service extends Service<<%=projectName%>ServiceConfig>{
    protected Logger logger = LoggerFactory.getLogger( <%=projectName%>Service.class);
    public static void main(String [] args) throws Exception {
        new  <%=projectName%>Service().run(args);
    }
    @Override
    public void initialize(Bootstrap<<%=projectName%>ServiceConfig> bootstrap) {

    }

    @Override
    public void run(<%=projectName%>ServiceConfig config, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, config.getDatabaseConfiguration(), "postgresql");

        //MyDAO dao = jdbi.onDemand(MyDAO.class);
        
	<%=projectName%>Resource resource = new <%=projectName%>Resource();

	environment.addResource(resource);
    }
}
