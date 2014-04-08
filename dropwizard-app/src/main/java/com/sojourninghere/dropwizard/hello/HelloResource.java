package com.sojourninghere.dropwizard.hello;

import com.sojourninghere.dropwizard.config.MessagesConfiguration;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloResource {

    private MessagesConfiguration conf;

    public HelloResource(MessagesConfiguration conf){
        this.conf = conf;
    }

    @GET
    public String sayHello(){
        return conf.getHello();
    }

}
