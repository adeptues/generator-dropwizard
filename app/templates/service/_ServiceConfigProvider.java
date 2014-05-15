package <%=packageName%>.<%=projectName%>service;

import com.yammer.dropwizard.config.Configuration;


public interface <%=projectName%>ServiceConfigProvider<T extends Configuration> {

    public <%=projectName%>ServiceConfig getConfig(T config);
}
