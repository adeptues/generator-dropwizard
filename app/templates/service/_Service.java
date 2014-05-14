package <%=packageName%>.<%=projectName%>service;

import java.util.List;
import com.hssnet.avservice.resources.*;
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
public class <%=projectName%>Service extends Service<AVServiceConfig>{
    protected Logger logger = LoggerFactory.getLogger(AVService.class);
    public static void main(String [] args) throws Exception {
        new  <%=projectName%>Service().run(args);
    }
    @Override
    public void initialize(Bootstrap<AVServiceConfig> bootstrap) {

    }

    @Override
    public void run(AVServiceConfig config, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, config.getDatabaseConfiguration(), "postgresql");

        //MyDAO dao = jdbi.onDemand(MyDAO.class);
        //        AVResource resource = new AVResource(dao, avDataFileInterface, serverRootPath.replace("*",""),ftpDetails);

        environment.addResource(resource);
    }
}
