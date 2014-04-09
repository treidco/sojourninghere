package com.sojourninghere.dropwizard.config;

import com.yammer.dropwizard.config.Configuration;

import javax.validation.Valid;

public class ServiceConfiguration extends Configuration {

    @Valid
    private MessagesConfiguration messages;

    @Valid
    private MongoConfiguration mongo;

    public MessagesConfiguration getMessages() {
        return messages;
    }

    public void setMessages(MessagesConfiguration messages) {
        this.messages = messages;
    }

    public MongoConfiguration getMongo() {
        return mongo;
    }

    public void setMongo(MongoConfiguration mongo) {
        this.mongo = mongo;
    }
}
