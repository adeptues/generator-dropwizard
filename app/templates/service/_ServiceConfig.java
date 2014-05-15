package <%=packageName%>.<%=projectName%>service;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by thelmkay on 1/8/14.
 */
public class <%=projectName%>ServiceConfig extends Configuration {
    private String defaultName;

    @Valid
    @NotNull
    @JsonProperty
    private DatabaseConfiguration database = new DatabaseConfiguration();
    
    
    


	public DatabaseConfiguration getDatabaseConfiguration() {
        return database;
    }

    public void setDatabase(DatabaseConfiguration database) {
        this.database = database;
    }

    public String getDefaultName() {
        return defaultName;
    }


}
