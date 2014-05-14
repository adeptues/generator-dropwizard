package com.hssnet.avservice.config;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by thelmkay on 1/8/14.
 */
public class AVServiceConfig extends Configuration {
    private String defaultName;

    @Valid
    @NotNull
    private String fileSystemRoot;

    @Valid
    @NotNull
    @JsonProperty
    private DatabaseConfiguration database = new DatabaseConfiguration();
    
    @JsonProperty
    private List<FTPConfig> ftpDetails;
    
    

    /**
	 * @return the ftpDetails
	 */
	public List<FTPConfig> getFtpDetails() {
		return ftpDetails;
	}

	/**
	 * @param ftpDetails the ftpDetails to set
	 */
	public void setFtpDetails(List<FTPConfig> ftpDetails) {
		this.ftpDetails = ftpDetails;
	}

	public DatabaseConfiguration getDatabaseConfiguration() {
        return database;
    }

    public void setDatabase(DatabaseConfiguration database) {
        this.database = database;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public String getFileSystemRoot() {
        return fileSystemRoot;
    }

    public void setFileSystemRoot(String fileSystemRoot) {
        this.fileSystemRoot = fileSystemRoot;
    }
}
