package com.sojourninghere.dropwizard.store;

import com.mongodb.Mongo;
import com.yammer.dropwizard.lifecycle.Managed;

public class ManagedMongo implements Managed {

    private Mongo mongo;

    public ManagedMongo(Mongo mongo) {
        this.mongo = mongo;
    }

    @Override
    public void start() throws Exception {
    }

    @Override
    public void stop() throws Exception {
        mongo.close();
    }
}
