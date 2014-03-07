package com.sojourninghere.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

class HelloWorldConfiguration extends Configuration {

    @NotEmpty
    @JsonProperty
    private String template;

    @JsonProperty
    @NotEmpty
    private String defaultName;

    public String getTemplate(){
        return template;
    }

    public String getDefaultName(){
        return defaultName;
    }
}
