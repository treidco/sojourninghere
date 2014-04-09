package com.sojourninghere.dropwizard;

import com.mongodb.Mongo;
import com.sojourninghere.dropwizard.config.ServiceConfiguration;
import com.sojourninghere.dropwizard.health.MongoHealthCheck;
import com.sojourninghere.dropwizard.hello.HelloResource;
import com.sojourninghere.dropwizard.store.ManagedMongo;
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
        Mongo mongo = new Mongo(serviceConfiguration.getMongo().mongohost, serviceConfiguration.getMongo().mongoport);
        ManagedMongo managedMongo = new ManagedMongo(mongo);

        environment.addHealthCheck(new MongoHealthCheck(mongo));

        environment.addResource(new HelloResource(serviceConfiguration.getMessages()));

    }
}
