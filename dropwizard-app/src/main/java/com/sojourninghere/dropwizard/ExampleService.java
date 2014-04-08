package com.sojourninghere.dropwizard;

import com.sojourninghere.dropwizard.config.ServiceConfiguration;
import com.sojourninghere.dropwizard.hello.HelloResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class ExampleService extends Service<ServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new ExampleService().run(args);
    }


    @Override
    public void initialize(Bootstrap<ServiceConfiguration> serviceConfigurationBootstrap) {
        serviceConfigurationBootstrap.setName("dropwiard-example");
    }

    @Override
    public void run(ServiceConfiguration serviceConfiguration, Environment environment) throws Exception {
        environment.addResource(new HelloResource(serviceConfiguration.getMessages()));
    }
}
