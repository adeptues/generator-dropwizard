package <%=packageName%>.<%=projectName%>service;

import com.hssnet.avservice.config.AVServiceConfigProvider;
import com.hssnet.avservice.db.AVDataDAO;
import com.hssnet.avservice.healthcheck.LegacyAVDataHealthcheck;
import com.hssnet.avservice.resources.*;
import com.yammer.dropwizard.ConfiguredBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;
import org.skife.jdbi.v2.DBI;

/**
 * Created by chris on 23/01/14.
 */
public abstract class <%=ProjectName%>ServiceBundle<T extends Configuration> implements ConfiguredBundle<T>, AVServiceConfigProvider<T> {

    @Override
    public void initialize(Bootstrap<?> bootstrap) {

    }

    @Override
    public void run(T configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, getConfig(configuration).getDatabaseConfiguration(), "postgresql");

        AVDataDAO dao = jdbi.onDemand(AVDataDAO.class);
        AVDataFileInterface avDataFileInterface = new LegacyAVDataFileInterface(getConfig(configuration).getFileSystemRoot());

        environment.addResource(new AVResource(dao, avDataFileInterface, getConfig(configuration).getHttpConfiguration().getRootPath(),getConfig(configuration).getFtpDetails()));
        environment.addHealthCheck(new LegacyAVDataHealthcheck(getConfig(configuration)));

    }
}
