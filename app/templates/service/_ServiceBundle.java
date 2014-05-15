package <%=packageName%>.<%=projectName%>service;


import com.yammer.dropwizard.ConfiguredBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;
import org.skife.jdbi.v2.DBI;


public abstract class <%=projectName%>ServiceBundle<T extends Configuration> implements ConfiguredBundle<T>, <%=projectName%>ServiceConfigProvider<T> {

    @Override
    public void initialize(Bootstrap<?> bootstrap) {

    }

    @Override
    public void run(T configuration, Environment environment) throws Exception {
	/*        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, getConfig(configuration).getDatabaseConfiguration(), "postgresql");

        AVDataDAO dao = jdbi.onDemand(AVDataDAO.class);
        AVDataFileInterface avDataFileInterface = new LegacyAVDataFileInterface(getConfig(configuration).getFileSystemRoot());

        environment.addResource(new AVResource(dao, avDataFileInterface, getConfig(configuration).getHttpConfiguration().getRootPath(),getConfig(configuration).getFtpDetails()));
        environment.addHealthCheck(new LegacyAVDataHealthcheck(getConfig(configuration)));*/

    }
}
