package com.hssnet.avservice.config;

import com.yammer.dropwizard.config.Configuration;

/**
 * Created by chris on 23/01/14.
 */
public interface AVServiceConfigProvider<T extends Configuration> {

    public AVServiceConfig getConfig(T config);
}
